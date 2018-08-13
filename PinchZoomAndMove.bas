Type=Class
Version=5.2
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region Library Attributes
	#Event: Click
	#Event: LongClick
	#Event: Change
#End Region

'Class Name: PinchZoomAndMove
'Author: Dominex
'Version: 1.45
'B4A Version Used: 3.00
'Last Modified: 08/12/2013
'-------------------------
'Class module
Private Sub Class_Globals
	Private G As Gestures
	Private Parent As Panel
	Private Touch As List
	Private X0,Y0,X1,Y1,Hypotenuse,Product,posTouchX,posTouchY,OrigW,OrigH As Int
	Private vZoom,vZoomStart,vZoomMin,vZoomMax,vIncrease,ZoomMinSet,ZoomMaxSet As Float
	Private vCanMove,SingleClick,vBringToFront,vCanZoom,vLimitBorder,vLimitArea As Boolean
	Private MovingTouch As Int = 20dip
	Private vTag,vModule As Object
	Private TimerLC As Timer
	Private obj As View
	Private vEventName As String
	Private TimePress As Long
	Type TouchData (X As Int,Y As Int,Tag As Object)
	Private vTouchData As TouchData
	Type LayoutData (Left As Int,Top As Int,Width As Int,Height As Int,Tag As Object)
	Private LayoutChange As LayoutData
End Sub

'Initialize the View.
'<i>Target</i> - View on which to apply the PinchZoomAndMove.
'<i>NameEvent</i> - name of the event.
'<i>ZoomMin</i> - minimum Zoom (eg. 0.5 = 50%).
'<i>ZoomMax</i> - maximum Zoom (eg. 3 = 300%).
'<i>Increase</i> - factor of increase / decrease during the Pinch Zoom.
'<i>Tag</i> - is the Tags View.
'<i>BringToFront</i> - if True active the BringToFront.
'<i>Module</i> - must be Me.
Public Sub Initialize (Target As View,NameEvent As String,Tag As Object,ZoomMin As Float,ZoomMax As Float,Increase As Float,BringToFront As Boolean,Module As Object)
	Touch.Initialize
	obj = Target
	vModule = Module
	ZoomMinSet = ZoomMin
	ZoomMaxSet = ZoomMax
	SetOriginalSize
	vIncrease = Increase
	vCanMove = True
	vCanZoom = True
	vEventName = NameEvent
	vTag = Tag
	vTouchData.Initialize
	vBringToFront = BringToFront
	TimerLC.Initialize("TimerLC",500)
	G.SetOnTouchListener(obj,"Touch_Gestures")
End Sub

Private Sub SetOriginalSize
	OrigH = obj.Height
	OrigW = obj.Width
	vZoom = OrigW
	vZoomStart = vZoom
	vZoomMin = vZoom*ZoomMinSet
	vZoomMax = vZoom*ZoomMaxSet
End Sub

#Region LimitArea
'Gets or sets then value of LimitArea.
'If True, the edges of the View will remain within its Parent.
'If the View has dimensions inferior the Parent, will be automatically increased.
'The zoom 100% is equal to the new size of the View.
Public Sub setLimitArea (Option As Boolean)
	vLimitArea = Option
	vLimitBorder = False
	Parent = GetParent(obj)
	If LimitAreaSize Then
		SetOriginalSize
		vZoomMin = obj.Width
		obj.Left = Parent.Width/2-obj.Width/2
		obj.top = Parent.Height/2-obj.Height/2
	Else
		obj.Left = Max(Min(obj.Left,0),Parent.Width-obj.Width)
		obj.Top = Max(Min(obj.Top,0),Parent.Height-obj.Height)
	End If
End Sub
Public Sub getLimitArea As Boolean
	Return vLimitArea
End Sub
Private Sub LimitAreaSize As Boolean
	Dim Resize As Boolean
	Do While obj.Width<Parent.Width Or obj.Height<Parent.Height
		Resize = True
		If obj.Width < Parent.Width Then
			obj.Width = Parent.Width
			obj.Height = OrigH/OrigW*obj.Width
		Else If obj.Height < Parent.Height Then
			obj.Height = Parent.Height
			obj.Width = OrigW/OrigH*obj.Height
		End If
	Loop
	Return Resize
End Sub
#End Region

#Region LimtBorder
'Gets or sets the LimitBorder.
'If it is true, the View will not come out from the edges of its parent.
'If the View Is larger than the Parent, will be automatically reduced.
'The 100% zoom Is equal To the new size of the View.
Public Sub setLimitBorder (Option As Boolean)
	vLimitBorder = Option
	vLimitArea = False
	Parent = GetParent(obj)
	If LimitBorderSize Then
		SetOriginalSize
		vZoomMax = obj.Width
		obj.Left = Parent.Width/2-obj.Width/2
		obj.top = Parent.Height/2-obj.Height/2
	Else
		obj.Left = Min(Max(obj.Left,0),Parent.Width-obj.Width)
		obj.Top = Min(Max(obj.Top,0),Parent.Height-obj.Height)
	End If
End Sub
Public Sub getLimitBorder As Boolean
	Return vLimitBorder
End Sub
Private Sub LimitBorderSize As Boolean
	Dim Resize As Boolean
	Do While obj.Width>Parent.Width OR obj.Height>Parent.Height
		Resize = True
		If obj.Width > Parent.Width Then
			obj.Width = Parent.Width
			obj.Height = OrigH/OrigW*obj.Width
		Else If obj.Height > Parent.Height Then
			obj.Height = Parent.Height
			obj.Width = OrigW/OrigH*obj.Height
		End If
	Loop
	Return Resize
End Sub
#End Region

#Region CanZoom
'Gets or sets whether the View may zoom or not.
'True if the View can Zoom.
Public Sub setCanZoom (Option As Boolean)
	vCanZoom = Option
End Sub
Public Sub getCanZoom As Boolean
	Return vCanZoom
End Sub
#End Region

#Region CanMove
'Gets or sets whether the View may translare or not.
'True if the View can translate.
Public Sub setCanMove (Option As Boolean)
	vCanMove = Option
End Sub
Public Sub getCanMove As Boolean
	Return vCanMove
End Sub
#End Region

#Region Zoom
'Gets or sets the Zoom in percentage (eg. 100 = 100%).
Public Sub getZoom As Float
	Return 100/vZoomStart*vZoom
End Sub
Public Sub setZoom (Zoom As Float)
	ZoomView (Zoom/100*vZoomStart,obj.Width/2,obj.Height/2)
	vZoom = vZoomStart/100*Zoom
End Sub
#End Region

Private Sub GetParent(v As View) As View
    Dim r As Reflector
    r.Target = v
    Return r.RunMethod("getParent")
End Sub

Private Sub TimerLC_Tick
	TimerLC.Enabled = False
	If SubExists(vModule,vEventName&"_LongClick") AND SingleClick Then
		vTouchData.Tag = vTag
		CallSub2(vModule,vEventName&"_LongClick",vTouchData)
		SingleClick = False
	End If
End Sub

Private Sub Touch_Gestures(View As Object, PointerID As Int, Action As Int, X As Float, Y As Float) As Boolean
	Dim conta,xTemp,yTemp,Hypo,NewZoom As Int
	Select Action
		Case G.ACTION_DOWN
			Touch.Add(PointerID)
			SingleClick = True
			If vBringToFront Then obj.BringToFront
			TimePress = DateTime.Now
			'---Stores the position of View---
			X0 = X+obj.Left
			Y0 = Y+obj.Top
			X1 = obj.Left
			Y1 = obj.Top
			'---Stores the position for LongClick---
			vTouchData.X = X
			vTouchData.Y = Y
			TimerLC.Enabled = True
		Case G.ACTION_POINTER_DOWN
			Touch.Add(PointerID)
			If Touch.Size = 2 Then 
				xTemp = G.GetX(Touch.Get(0))-G.GetX(Touch.Get(1))
				yTemp = G.GetY(Touch.Get(0))-G.GetY(Touch.Get(1))
				Hypotenuse = Sqrt(Power(xTemp,2)+Power(yTemp,2))/Density
			End If
			SingleClick = False
		Case G.ACTION_MOVE
			'---clears the first slight movement to the first pressure---
			If DateTime.Now-TimePress < 100 Then
				X0 = X+obj.Left
				Y0 = Y+obj.Top
				X1 = obj.Left
				Y1 = obj.Top
			End If
			If Touch.Size = 1 Then
				'---Move View---
				If vCanMove Then
					xTemp = X1+G.GetX(Touch.Get(0))+obj.Left-X0
					yTemp = Y1+G.GetY(Touch.Get(0))+obj.Top-Y0
					If vLimitBorder Then
						xTemp = Min(Max(xTemp,0),Parent.Width-obj.Width)
						yTemp = Min(Max(yTemp,0),Parent.Height-obj.Height)
					Else If vLimitArea Then
						xTemp = Max(Min(xTemp,0),Parent.Width-obj.Width)
						yTemp = Max(Min(yTemp,0),Parent.Height-obj.Height)
					End If
					obj.Left = xTemp
					obj.Top = yTemp
				End If
				If Abs(vTouchData.X-X) > MovingTouch OR Abs(vTouchData.Y-Y) > MovingTouch Then TimerLC.Enabled = False
				ChangeSizeOrPosition
			Else If Touch.Size = 2 AND vCanZoom Then
				'---Pinch Zoom---
				xTemp = G.GetX(Touch.Get(0))-G.GetX(Touch.Get(1))
				yTemp = G.GetY(Touch.Get(0))-G.GetY(Touch.Get(1))
				Hypo = Sqrt(Power(xTemp,2)+Power(yTemp,2))/Density
				Product = (Hypo-Hypotenuse)*vIncrease
				NewZoom = vZoom+Product
				NewZoom = Min(NewZoom,vZoomMax)
				NewZoom = Max(NewZoom,vZoomMin)
				posTouchX = Min(G.GetX(Touch.Get(0)),G.GetX(Touch.Get(1)))+Abs(xTemp/2)
				posTouchY = Min(G.GetY(Touch.Get(0)),G.GetY(Touch.Get(1)))+Abs(yTemp/2)
				ZoomView (NewZoom,posTouchX,posTouchY) 'Show the new zoom
			End If
		Case G.ACTION_POINTER_UP
			'---Removes touches are no longer present on the screen---
			For conta = 0 To Touch.Size-1
				If Touch.Get(conta) = PointerID Then
					Touch.RemoveAt(conta)
					Exit
				End If
			Next
			If Touch.Size = 1 Then
				X0 = G.GetX(Touch.Get(0))+obj.Left
				Y0 = G.GetY(Touch.Get(0))+obj.Top
				X1 = obj.Left
				Y1 = obj.Top
				'---Save the size of View---
				vZoom = vZoom+Product
				vZoom = Min(vZoom,vZoomMax)
				vZoom = Max(vZoom,vZoomMin)
			End If
		Case G.ACTION_UP
			Touch.Clear
			TimerLC.Enabled = False
			If Abs(X+obj.Left-X0) < MovingTouch AND Abs(Y+obj.Top-Y0) < MovingTouch AND SingleClick Then
				If SubExists(vModule,vEventName&"_Click") Then
					vTouchData.Tag = vTag
					CallSub2(vModule,vEventName&"_Click",vTouchData)
				End If
			End If
	End Select
	Return True
End Sub

Private Sub ZoomView (NewZoom As Int,posX As Int,posY As Int)
	Dim Width,Height As Int
	Width = NewZoom
	Height = OrigH/OrigW*Width
	If vLimitBorder Then
		If LimitBorderSize Then vZoomMax = obj.Width
	Else If vLimitArea Then
		If LimitAreaSize Then vZoomMin = obj.Width
	End If
	Dim Left,Top As Int
	Left = obj.Left+posX-(posX/obj.Width*Width)
	Top = obj.Top+posY-(posY/obj.Height*Height)
	If vLimitBorder Then
		Left = Min(Max(Left,0),Parent.Width-obj.Width)
		Top = Min(Max(Top,0),Parent.Height-obj.Height)
	Else If vLimitArea Then
		Left = Max(Min(Left,0),Parent.Width-obj.Width)
		Top = Max(Min(Top,0),Parent.Height-obj.Height)
	End If
	obj.SetLayout(Left,Top,Width,Height)
	ChangeSizeOrPosition
End Sub

Private Sub ChangeSizeOrPosition
	If SubExists(vModule,vEventName&"_Change") Then
		LayoutChange.Left = obj.Left
		LayoutChange.Top = obj.Top
		LayoutChange.Width = obj.Width
		LayoutChange.Height = obj.Height
		LayoutChange.Tag = vTag
		CallSub2(vModule,vEventName&"_Change",LayoutChange)
	End If
End Sub