package com.serogen.minesweeper.pro;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class pinchzoomandmove extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.serogen.minesweeper.pro.pinchzoomandmove");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            if (BA.isShellModeRuntimeCheck(ba)) {
			    ba.raiseEvent2(null, true, "CREATE", true, "com.serogen.minesweeper.pro.pinchzoomandmove",
                    ba);
                return;
		    }
        }
        ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.agraham.gestures.Gestures _g = null;
public anywheresoftware.b4a.objects.PanelWrapper _parent = null;
public anywheresoftware.b4a.objects.collections.List _touch = null;
public int _x0 = 0;
public int _y0 = 0;
public int _x1 = 0;
public int _y1 = 0;
public int _hypotenuse = 0;
public int _product = 0;
public int _postouchx = 0;
public int _postouchy = 0;
public int _origw = 0;
public int _origh = 0;
public float _vzoom = 0f;
public float _vzoomstart = 0f;
public float _vzoommin = 0f;
public float _vzoommax = 0f;
public float _vincrease = 0f;
public float _zoomminset = 0f;
public float _zoommaxset = 0f;
public boolean _vcanmove = false;
public boolean _singleclick = false;
public boolean _vbringtofront = false;
public boolean _vcanzoom = false;
public boolean _vlimitborder = false;
public boolean _vlimitarea = false;
public int _movingtouch = 0;
public Object _vtag = null;
public Object _vmodule = null;
public anywheresoftware.b4a.objects.Timer _timerlc = null;
public anywheresoftware.b4a.objects.ConcreteViewWrapper _obj = null;
public String _veventname = "";
public long _timepress = 0L;
public dominex.example.pinchzoomandmove._touchdata _vtouchdata = null;
public dominex.example.pinchzoomandmove._layoutdata _layoutchange = null;
public com.serogen.minesweeper.pro.main _main = null;
public com.serogen.minesweeper.pro.starter _starter = null;
public static class _touchdata{
public boolean IsInitialized;
public int X;
public int Y;
public Object Tag;
public void Initialize() {
IsInitialized = true;
X = 0;
Y = 0;
Tag = new Object();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _layoutdata{
public boolean IsInitialized;
public int Left;
public int Top;
public int Width;
public int Height;
public Object Tag;
public void Initialize() {
IsInitialized = true;
Left = 0;
Top = 0;
Width = 0;
Height = 0;
Tag = new Object();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _changesizeorposition() throws Exception{
 //BA.debugLineNum = 310;BA.debugLine="Private Sub ChangeSizeOrPosition";
 //BA.debugLineNum = 311;BA.debugLine="If SubExists(vModule,vEventName&\"_Change\") Then";
if (__c.SubExists(ba,_vmodule,_veventname+"_Change")) { 
 //BA.debugLineNum = 312;BA.debugLine="LayoutChange.Left = obj.Left";
_layoutchange.Left = _obj.getLeft();
 //BA.debugLineNum = 313;BA.debugLine="LayoutChange.Top = obj.Top";
_layoutchange.Top = _obj.getTop();
 //BA.debugLineNum = 314;BA.debugLine="LayoutChange.Width = obj.Width";
_layoutchange.Width = _obj.getWidth();
 //BA.debugLineNum = 315;BA.debugLine="LayoutChange.Height = obj.Height";
_layoutchange.Height = _obj.getHeight();
 //BA.debugLineNum = 316;BA.debugLine="LayoutChange.Tag = vTag";
_layoutchange.Tag = _vtag;
 //BA.debugLineNum = 317;BA.debugLine="CallSub2(vModule,vEventName&\"_Change\",LayoutChan";
__c.CallSubNew2(ba,_vmodule,_veventname+"_Change",(Object)(_layoutchange));
 };
 //BA.debugLineNum = 319;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private G As Gestures";
_g = new anywheresoftware.b4a.agraham.gestures.Gestures();
 //BA.debugLineNum = 16;BA.debugLine="Private Parent As Panel";
_parent = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private Touch As List";
_touch = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 18;BA.debugLine="Private X0,Y0,X1,Y1,Hypotenuse,Product,posTouchX,";
_x0 = 0;
_y0 = 0;
_x1 = 0;
_y1 = 0;
_hypotenuse = 0;
_product = 0;
_postouchx = 0;
_postouchy = 0;
_origw = 0;
_origh = 0;
 //BA.debugLineNum = 19;BA.debugLine="Private vZoom,vZoomStart,vZoomMin,vZoomMax,vIncre";
_vzoom = 0f;
_vzoomstart = 0f;
_vzoommin = 0f;
_vzoommax = 0f;
_vincrease = 0f;
_zoomminset = 0f;
_zoommaxset = 0f;
 //BA.debugLineNum = 20;BA.debugLine="Private vCanMove,SingleClick,vBringToFront,vCanZo";
_vcanmove = false;
_singleclick = false;
_vbringtofront = false;
_vcanzoom = false;
_vlimitborder = false;
_vlimitarea = false;
 //BA.debugLineNum = 21;BA.debugLine="Private MovingTouch As Int = 20dip";
_movingtouch = __c.DipToCurrent((int) (20));
 //BA.debugLineNum = 22;BA.debugLine="Private vTag,vModule As Object";
_vtag = new Object();
_vmodule = new Object();
 //BA.debugLineNum = 23;BA.debugLine="Private TimerLC As Timer";
_timerlc = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 24;BA.debugLine="Private obj As View";
_obj = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private vEventName As String";
_veventname = "";
 //BA.debugLineNum = 26;BA.debugLine="Private TimePress As Long";
_timepress = 0L;
 //BA.debugLineNum = 27;BA.debugLine="Type TouchData (X As Int,Y As Int,Tag As Object)";
;
 //BA.debugLineNum = 28;BA.debugLine="Private vTouchData As TouchData";
_vtouchdata = new dominex.example.pinchzoomandmove._touchdata();
 //BA.debugLineNum = 29;BA.debugLine="Type LayoutData (Left As Int,Top As Int,Width As";
;
 //BA.debugLineNum = 30;BA.debugLine="Private LayoutChange As LayoutData";
_layoutchange = new dominex.example.pinchzoomandmove._layoutdata();
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public boolean  _getcanmove() throws Exception{
 //BA.debugLineNum = 162;BA.debugLine="Public Sub getCanMove As Boolean";
 //BA.debugLineNum = 163;BA.debugLine="Return vCanMove";
if (true) return _vcanmove;
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
return false;
}
public boolean  _getcanzoom() throws Exception{
 //BA.debugLineNum = 151;BA.debugLine="Public Sub getCanZoom As Boolean";
 //BA.debugLineNum = 152;BA.debugLine="Return vCanZoom";
if (true) return _vcanzoom;
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return false;
}
public boolean  _getlimitarea() throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="Public Sub getLimitArea As Boolean";
 //BA.debugLineNum = 89;BA.debugLine="Return vLimitArea";
if (true) return _vlimitarea;
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return false;
}
public boolean  _getlimitborder() throws Exception{
 //BA.debugLineNum = 126;BA.debugLine="Public Sub getLimitBorder As Boolean";
 //BA.debugLineNum = 127;BA.debugLine="Return vLimitBorder";
if (true) return _vlimitborder;
 //BA.debugLineNum = 128;BA.debugLine="End Sub";
return false;
}
public anywheresoftware.b4a.objects.ConcreteViewWrapper  _getparent(anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
 //BA.debugLineNum = 178;BA.debugLine="Private Sub GetParent(v As View) As View";
 //BA.debugLineNum = 179;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 180;BA.debugLine="r.Target = v";
_r.Target = (Object)(_v.getObject());
 //BA.debugLineNum = 181;BA.debugLine="Return r.RunMethod(\"getParent\")";
if (true) return (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_r.RunMethod("getParent")));
 //BA.debugLineNum = 182;BA.debugLine="End Sub";
return null;
}
public float  _getzoom() throws Exception{
 //BA.debugLineNum = 169;BA.debugLine="Public Sub getZoom As Float";
 //BA.debugLineNum = 170;BA.debugLine="Return 100/vZoomStart*vZoom";
if (true) return (float) (100/(double)_vzoomstart*_vzoom);
 //BA.debugLineNum = 171;BA.debugLine="End Sub";
return 0f;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _target,String _nameevent,Object _tag,float _zoommin,float _zoommax,float _increase,boolean _bringtofront,Object _module) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 42;BA.debugLine="Public Sub Initialize (Target As View,NameEvent As";
 //BA.debugLineNum = 43;BA.debugLine="Touch.Initialize";
_touch.Initialize();
 //BA.debugLineNum = 44;BA.debugLine="obj = Target";
_obj = _target;
 //BA.debugLineNum = 45;BA.debugLine="vModule = Module";
_vmodule = _module;
 //BA.debugLineNum = 46;BA.debugLine="ZoomMinSet = ZoomMin";
_zoomminset = _zoommin;
 //BA.debugLineNum = 47;BA.debugLine="ZoomMaxSet = ZoomMax";
_zoommaxset = _zoommax;
 //BA.debugLineNum = 48;BA.debugLine="SetOriginalSize";
_setoriginalsize();
 //BA.debugLineNum = 49;BA.debugLine="vIncrease = Increase";
_vincrease = _increase;
 //BA.debugLineNum = 50;BA.debugLine="vCanMove = True";
_vcanmove = __c.True;
 //BA.debugLineNum = 51;BA.debugLine="vCanZoom = True";
_vcanzoom = __c.True;
 //BA.debugLineNum = 52;BA.debugLine="vEventName = NameEvent";
_veventname = _nameevent;
 //BA.debugLineNum = 53;BA.debugLine="vTag = Tag";
_vtag = _tag;
 //BA.debugLineNum = 54;BA.debugLine="vTouchData.Initialize";
_vtouchdata.Initialize();
 //BA.debugLineNum = 55;BA.debugLine="vBringToFront = BringToFront";
_vbringtofront = _bringtofront;
 //BA.debugLineNum = 56;BA.debugLine="TimerLC.Initialize(\"TimerLC\",500)";
_timerlc.Initialize(ba,"TimerLC",(long) (500));
 //BA.debugLineNum = 57;BA.debugLine="G.SetOnTouchListener(obj,\"Touch_Gestures\")";
_g.SetOnTouchListener(ba,(android.view.View)(_obj.getObject()),"Touch_Gestures");
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public boolean  _limitareasize() throws Exception{
boolean _resize = false;
 //BA.debugLineNum = 91;BA.debugLine="Private Sub LimitAreaSize As Boolean";
 //BA.debugLineNum = 92;BA.debugLine="Dim Resize As Boolean";
_resize = false;
 //BA.debugLineNum = 93;BA.debugLine="Do While obj.Width<Parent.Width Or obj.Height<Par";
while (_obj.getWidth()<_parent.getWidth() || _obj.getHeight()<_parent.getHeight()) {
 //BA.debugLineNum = 94;BA.debugLine="Resize = True";
_resize = __c.True;
 //BA.debugLineNum = 95;BA.debugLine="If obj.Width < Parent.Width Then";
if (_obj.getWidth()<_parent.getWidth()) { 
 //BA.debugLineNum = 96;BA.debugLine="obj.Width = Parent.Width";
_obj.setWidth(_parent.getWidth());
 //BA.debugLineNum = 97;BA.debugLine="obj.Height = OrigH/OrigW*obj.Width";
_obj.setHeight((int) (_origh/(double)_origw*_obj.getWidth()));
 }else if(_obj.getHeight()<_parent.getHeight()) { 
 //BA.debugLineNum = 99;BA.debugLine="obj.Height = Parent.Height";
_obj.setHeight(_parent.getHeight());
 //BA.debugLineNum = 100;BA.debugLine="obj.Width = OrigW/OrigH*obj.Height";
_obj.setWidth((int) (_origw/(double)_origh*_obj.getHeight()));
 };
 }
;
 //BA.debugLineNum = 103;BA.debugLine="Return Resize";
if (true) return _resize;
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
return false;
}
public boolean  _limitbordersize() throws Exception{
boolean _resize = false;
 //BA.debugLineNum = 129;BA.debugLine="Private Sub LimitBorderSize As Boolean";
 //BA.debugLineNum = 130;BA.debugLine="Dim Resize As Boolean";
_resize = false;
 //BA.debugLineNum = 131;BA.debugLine="Do While obj.Width>Parent.Width OR obj.Height>Par";
while (_obj.getWidth()>_parent.getWidth() || _obj.getHeight()>_parent.getHeight()) {
 //BA.debugLineNum = 132;BA.debugLine="Resize = True";
_resize = __c.True;
 //BA.debugLineNum = 133;BA.debugLine="If obj.Width > Parent.Width Then";
if (_obj.getWidth()>_parent.getWidth()) { 
 //BA.debugLineNum = 134;BA.debugLine="obj.Width = Parent.Width";
_obj.setWidth(_parent.getWidth());
 //BA.debugLineNum = 135;BA.debugLine="obj.Height = OrigH/OrigW*obj.Width";
_obj.setHeight((int) (_origh/(double)_origw*_obj.getWidth()));
 }else if(_obj.getHeight()>_parent.getHeight()) { 
 //BA.debugLineNum = 137;BA.debugLine="obj.Height = Parent.Height";
_obj.setHeight(_parent.getHeight());
 //BA.debugLineNum = 138;BA.debugLine="obj.Width = OrigW/OrigH*obj.Height";
_obj.setWidth((int) (_origw/(double)_origh*_obj.getHeight()));
 };
 }
;
 //BA.debugLineNum = 141;BA.debugLine="Return Resize";
if (true) return _resize;
 //BA.debugLineNum = 142;BA.debugLine="End Sub";
return false;
}
public String  _setcanmove(boolean _option) throws Exception{
 //BA.debugLineNum = 159;BA.debugLine="Public Sub setCanMove (Option As Boolean)";
 //BA.debugLineNum = 160;BA.debugLine="vCanMove = Option";
_vcanmove = _option;
 //BA.debugLineNum = 161;BA.debugLine="End Sub";
return "";
}
public String  _setcanzoom(boolean _option) throws Exception{
 //BA.debugLineNum = 148;BA.debugLine="Public Sub setCanZoom (Option As Boolean)";
 //BA.debugLineNum = 149;BA.debugLine="vCanZoom = Option";
_vcanzoom = _option;
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return "";
}
public String  _setlimitarea(boolean _option) throws Exception{
 //BA.debugLineNum = 74;BA.debugLine="Public Sub setLimitArea (Option As Boolean)";
 //BA.debugLineNum = 75;BA.debugLine="vLimitArea = Option";
_vlimitarea = _option;
 //BA.debugLineNum = 76;BA.debugLine="vLimitBorder = False";
_vlimitborder = __c.False;
 //BA.debugLineNum = 77;BA.debugLine="Parent = GetParent(obj)";
_parent.setObject((android.view.ViewGroup)(_getparent(_obj).getObject()));
 //BA.debugLineNum = 78;BA.debugLine="If LimitAreaSize Then";
if (_limitareasize()) { 
 //BA.debugLineNum = 79;BA.debugLine="SetOriginalSize";
_setoriginalsize();
 //BA.debugLineNum = 80;BA.debugLine="vZoomMin = obj.Width";
_vzoommin = (float) (_obj.getWidth());
 //BA.debugLineNum = 81;BA.debugLine="obj.Left = Parent.Width/2-obj.Width/2";
_obj.setLeft((int) (_parent.getWidth()/(double)2-_obj.getWidth()/(double)2));
 //BA.debugLineNum = 82;BA.debugLine="obj.top = Parent.Height/2-obj.Height/2";
_obj.setTop((int) (_parent.getHeight()/(double)2-_obj.getHeight()/(double)2));
 }else {
 //BA.debugLineNum = 84;BA.debugLine="obj.Left = Max(Min(obj.Left,0),Parent.Width-obj.";
_obj.setLeft((int) (__c.Max(__c.Min(_obj.getLeft(),0),_parent.getWidth()-_obj.getWidth())));
 //BA.debugLineNum = 85;BA.debugLine="obj.Top = Max(Min(obj.Top,0),Parent.Height-obj.H";
_obj.setTop((int) (__c.Max(__c.Min(_obj.getTop(),0),_parent.getHeight()-_obj.getHeight())));
 };
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public String  _setlimitborder(boolean _option) throws Exception{
 //BA.debugLineNum = 112;BA.debugLine="Public Sub setLimitBorder (Option As Boolean)";
 //BA.debugLineNum = 113;BA.debugLine="vLimitBorder = Option";
_vlimitborder = _option;
 //BA.debugLineNum = 114;BA.debugLine="vLimitArea = False";
_vlimitarea = __c.False;
 //BA.debugLineNum = 115;BA.debugLine="Parent = GetParent(obj)";
_parent.setObject((android.view.ViewGroup)(_getparent(_obj).getObject()));
 //BA.debugLineNum = 116;BA.debugLine="If LimitBorderSize Then";
if (_limitbordersize()) { 
 //BA.debugLineNum = 117;BA.debugLine="SetOriginalSize";
_setoriginalsize();
 //BA.debugLineNum = 118;BA.debugLine="vZoomMax = obj.Width";
_vzoommax = (float) (_obj.getWidth());
 //BA.debugLineNum = 119;BA.debugLine="obj.Left = Parent.Width/2-obj.Width/2";
_obj.setLeft((int) (_parent.getWidth()/(double)2-_obj.getWidth()/(double)2));
 //BA.debugLineNum = 120;BA.debugLine="obj.top = Parent.Height/2-obj.Height/2";
_obj.setTop((int) (_parent.getHeight()/(double)2-_obj.getHeight()/(double)2));
 }else {
 //BA.debugLineNum = 122;BA.debugLine="obj.Left = Min(Max(obj.Left,0),Parent.Width-obj.";
_obj.setLeft((int) (__c.Min(__c.Max(_obj.getLeft(),0),_parent.getWidth()-_obj.getWidth())));
 //BA.debugLineNum = 123;BA.debugLine="obj.Top = Min(Max(obj.Top,0),Parent.Height-obj.H";
_obj.setTop((int) (__c.Min(__c.Max(_obj.getTop(),0),_parent.getHeight()-_obj.getHeight())));
 };
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return "";
}
public String  _setoriginalsize() throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Private Sub SetOriginalSize";
 //BA.debugLineNum = 61;BA.debugLine="OrigH = obj.Height";
_origh = _obj.getHeight();
 //BA.debugLineNum = 62;BA.debugLine="OrigW = obj.Width";
_origw = _obj.getWidth();
 //BA.debugLineNum = 63;BA.debugLine="vZoom = OrigW";
_vzoom = (float) (_origw);
 //BA.debugLineNum = 64;BA.debugLine="vZoomStart = vZoom";
_vzoomstart = _vzoom;
 //BA.debugLineNum = 65;BA.debugLine="vZoomMin = vZoom*ZoomMinSet";
_vzoommin = (float) (_vzoom*_zoomminset);
 //BA.debugLineNum = 66;BA.debugLine="vZoomMax = vZoom*ZoomMaxSet";
_vzoommax = (float) (_vzoom*_zoommaxset);
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public String  _setzoom(float _zoom) throws Exception{
 //BA.debugLineNum = 172;BA.debugLine="Public Sub setZoom (Zoom As Float)";
 //BA.debugLineNum = 173;BA.debugLine="ZoomView (Zoom/100*vZoomStart,obj.Width/2,obj.Hei";
_zoomview((int) (_zoom/(double)100*_vzoomstart),(int) (_obj.getWidth()/(double)2),(int) (_obj.getHeight()/(double)2));
 //BA.debugLineNum = 174;BA.debugLine="vZoom = vZoomStart/100*Zoom";
_vzoom = (float) (_vzoomstart/(double)100*_zoom);
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public String  _timerlc_tick() throws Exception{
 //BA.debugLineNum = 184;BA.debugLine="Private Sub TimerLC_Tick";
 //BA.debugLineNum = 185;BA.debugLine="TimerLC.Enabled = False";
_timerlc.setEnabled(__c.False);
 //BA.debugLineNum = 186;BA.debugLine="If SubExists(vModule,vEventName&\"_LongClick\") AND";
if (__c.SubExists(ba,_vmodule,_veventname+"_LongClick") && _singleclick) { 
 //BA.debugLineNum = 187;BA.debugLine="vTouchData.Tag = vTag";
_vtouchdata.Tag = _vtag;
 //BA.debugLineNum = 188;BA.debugLine="CallSub2(vModule,vEventName&\"_LongClick\",vTouchD";
__c.CallSubNew2(ba,_vmodule,_veventname+"_LongClick",(Object)(_vtouchdata));
 //BA.debugLineNum = 189;BA.debugLine="SingleClick = False";
_singleclick = __c.False;
 };
 //BA.debugLineNum = 191;BA.debugLine="End Sub";
return "";
}
public boolean  _touch_gestures(Object _view,int _pointerid,int _action,float _x,float _y) throws Exception{
int _conta = 0;
int _xtemp = 0;
int _ytemp = 0;
int _hypo = 0;
int _newzoom = 0;
 //BA.debugLineNum = 193;BA.debugLine="Private Sub Touch_Gestures(View As Object, Pointer";
 //BA.debugLineNum = 194;BA.debugLine="Dim conta,xTemp,yTemp,Hypo,NewZoom As Int";
_conta = 0;
_xtemp = 0;
_ytemp = 0;
_hypo = 0;
_newzoom = 0;
 //BA.debugLineNum = 195;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,_g.ACTION_DOWN,_g.ACTION_POINTER_DOWN,_g.ACTION_MOVE,_g.ACTION_POINTER_UP,_g.ACTION_UP)) {
case 0:
 //BA.debugLineNum = 197;BA.debugLine="Touch.Add(PointerID)";
_touch.Add((Object)(_pointerid));
 //BA.debugLineNum = 198;BA.debugLine="SingleClick = True";
_singleclick = __c.True;
 //BA.debugLineNum = 199;BA.debugLine="If vBringToFront Then obj.BringToFront";
if (_vbringtofront) { 
_obj.BringToFront();};
 //BA.debugLineNum = 200;BA.debugLine="TimePress = DateTime.Now";
_timepress = __c.DateTime.getNow();
 //BA.debugLineNum = 202;BA.debugLine="X0 = X+obj.Left";
_x0 = (int) (_x+_obj.getLeft());
 //BA.debugLineNum = 203;BA.debugLine="Y0 = Y+obj.Top";
_y0 = (int) (_y+_obj.getTop());
 //BA.debugLineNum = 204;BA.debugLine="X1 = obj.Left";
_x1 = _obj.getLeft();
 //BA.debugLineNum = 205;BA.debugLine="Y1 = obj.Top";
_y1 = _obj.getTop();
 //BA.debugLineNum = 207;BA.debugLine="vTouchData.X = X";
_vtouchdata.X = (int) (_x);
 //BA.debugLineNum = 208;BA.debugLine="vTouchData.Y = Y";
_vtouchdata.Y = (int) (_y);
 //BA.debugLineNum = 209;BA.debugLine="TimerLC.Enabled = True";
_timerlc.setEnabled(__c.True);
 break;
case 1:
 //BA.debugLineNum = 211;BA.debugLine="Touch.Add(PointerID)";
_touch.Add((Object)(_pointerid));
 //BA.debugLineNum = 212;BA.debugLine="If Touch.Size = 2 Then";
if (_touch.getSize()==2) { 
 //BA.debugLineNum = 213;BA.debugLine="xTemp = G.GetX(Touch.Get(0))-G.GetX(Touch.Get(";
_xtemp = (int) (_g.GetX((int)(BA.ObjectToNumber(_touch.Get((int) (0)))))-_g.GetX((int)(BA.ObjectToNumber(_touch.Get((int) (1))))));
 //BA.debugLineNum = 214;BA.debugLine="yTemp = G.GetY(Touch.Get(0))-G.GetY(Touch.Get(";
_ytemp = (int) (_g.GetY((int)(BA.ObjectToNumber(_touch.Get((int) (0)))))-_g.GetY((int)(BA.ObjectToNumber(_touch.Get((int) (1))))));
 //BA.debugLineNum = 215;BA.debugLine="Hypotenuse = Sqrt(Power(xTemp,2)+Power(yTemp,2";
_hypotenuse = (int) (__c.Sqrt(__c.Power(_xtemp,2)+__c.Power(_ytemp,2))/(double)__c.Density);
 };
 //BA.debugLineNum = 217;BA.debugLine="SingleClick = False";
_singleclick = __c.False;
 break;
case 2:
 //BA.debugLineNum = 220;BA.debugLine="If DateTime.Now-TimePress < 100 Then";
if (__c.DateTime.getNow()-_timepress<100) { 
 //BA.debugLineNum = 221;BA.debugLine="X0 = X+obj.Left";
_x0 = (int) (_x+_obj.getLeft());
 //BA.debugLineNum = 222;BA.debugLine="Y0 = Y+obj.Top";
_y0 = (int) (_y+_obj.getTop());
 //BA.debugLineNum = 223;BA.debugLine="X1 = obj.Left";
_x1 = _obj.getLeft();
 //BA.debugLineNum = 224;BA.debugLine="Y1 = obj.Top";
_y1 = _obj.getTop();
 };
 //BA.debugLineNum = 226;BA.debugLine="If Touch.Size = 1 Then";
if (_touch.getSize()==1) { 
 //BA.debugLineNum = 228;BA.debugLine="If vCanMove Then";
if (_vcanmove) { 
 //BA.debugLineNum = 229;BA.debugLine="xTemp = X1+G.GetX(Touch.Get(0))+obj.Left-X0";
_xtemp = (int) (_x1+_g.GetX((int)(BA.ObjectToNumber(_touch.Get((int) (0)))))+_obj.getLeft()-_x0);
 //BA.debugLineNum = 230;BA.debugLine="yTemp = Y1+G.GetY(Touch.Get(0))+obj.Top-Y0";
_ytemp = (int) (_y1+_g.GetY((int)(BA.ObjectToNumber(_touch.Get((int) (0)))))+_obj.getTop()-_y0);
 //BA.debugLineNum = 231;BA.debugLine="If vLimitBorder Then";
if (_vlimitborder) { 
 //BA.debugLineNum = 232;BA.debugLine="xTemp = Min(Max(xTemp,0),Parent.Width-obj.Wi";
_xtemp = (int) (__c.Min(__c.Max(_xtemp,0),_parent.getWidth()-_obj.getWidth()));
 //BA.debugLineNum = 233;BA.debugLine="yTemp = Min(Max(yTemp,0),Parent.Height-obj.H";
_ytemp = (int) (__c.Min(__c.Max(_ytemp,0),_parent.getHeight()-_obj.getHeight()));
 }else if(_vlimitarea) { 
 //BA.debugLineNum = 235;BA.debugLine="xTemp = Max(Min(xTemp,0),Parent.Width-obj.Wi";
_xtemp = (int) (__c.Max(__c.Min(_xtemp,0),_parent.getWidth()-_obj.getWidth()));
 //BA.debugLineNum = 236;BA.debugLine="yTemp = Max(Min(yTemp,0),Parent.Height-obj.H";
_ytemp = (int) (__c.Max(__c.Min(_ytemp,0),_parent.getHeight()-_obj.getHeight()));
 };
 //BA.debugLineNum = 238;BA.debugLine="obj.Left = xTemp";
_obj.setLeft(_xtemp);
 //BA.debugLineNum = 239;BA.debugLine="obj.Top = yTemp";
_obj.setTop(_ytemp);
 };
 //BA.debugLineNum = 241;BA.debugLine="If Abs(vTouchData.X-X) > MovingTouch OR Abs(vT";
if (__c.Abs(_vtouchdata.X-_x)>_movingtouch || __c.Abs(_vtouchdata.Y-_y)>_movingtouch) { 
_timerlc.setEnabled(__c.False);};
 //BA.debugLineNum = 242;BA.debugLine="ChangeSizeOrPosition";
_changesizeorposition();
 }else if(_touch.getSize()==2 && _vcanzoom) { 
 //BA.debugLineNum = 245;BA.debugLine="xTemp = G.GetX(Touch.Get(0))-G.GetX(Touch.Get(";
_xtemp = (int) (_g.GetX((int)(BA.ObjectToNumber(_touch.Get((int) (0)))))-_g.GetX((int)(BA.ObjectToNumber(_touch.Get((int) (1))))));
 //BA.debugLineNum = 246;BA.debugLine="yTemp = G.GetY(Touch.Get(0))-G.GetY(Touch.Get(";
_ytemp = (int) (_g.GetY((int)(BA.ObjectToNumber(_touch.Get((int) (0)))))-_g.GetY((int)(BA.ObjectToNumber(_touch.Get((int) (1))))));
 //BA.debugLineNum = 247;BA.debugLine="Hypo = Sqrt(Power(xTemp,2)+Power(yTemp,2))/Den";
_hypo = (int) (__c.Sqrt(__c.Power(_xtemp,2)+__c.Power(_ytemp,2))/(double)__c.Density);
 //BA.debugLineNum = 248;BA.debugLine="Product = (Hypo-Hypotenuse)*vIncrease";
_product = (int) ((_hypo-_hypotenuse)*_vincrease);
 //BA.debugLineNum = 249;BA.debugLine="NewZoom = vZoom+Product";
_newzoom = (int) (_vzoom+_product);
 //BA.debugLineNum = 250;BA.debugLine="NewZoom = Min(NewZoom,vZoomMax)";
_newzoom = (int) (__c.Min(_newzoom,_vzoommax));
 //BA.debugLineNum = 251;BA.debugLine="NewZoom = Max(NewZoom,vZoomMin)";
_newzoom = (int) (__c.Max(_newzoom,_vzoommin));
 //BA.debugLineNum = 252;BA.debugLine="posTouchX = Min(G.GetX(Touch.Get(0)),G.GetX(To";
_postouchx = (int) (__c.Min(_g.GetX((int)(BA.ObjectToNumber(_touch.Get((int) (0))))),_g.GetX((int)(BA.ObjectToNumber(_touch.Get((int) (1))))))+__c.Abs(_xtemp/(double)2));
 //BA.debugLineNum = 253;BA.debugLine="posTouchY = Min(G.GetY(Touch.Get(0)),G.GetY(To";
_postouchy = (int) (__c.Min(_g.GetY((int)(BA.ObjectToNumber(_touch.Get((int) (0))))),_g.GetY((int)(BA.ObjectToNumber(_touch.Get((int) (1))))))+__c.Abs(_ytemp/(double)2));
 //BA.debugLineNum = 254;BA.debugLine="ZoomView (NewZoom,posTouchX,posTouchY) 'Show t";
_zoomview(_newzoom,_postouchx,_postouchy);
 };
 break;
case 3:
 //BA.debugLineNum = 258;BA.debugLine="For conta = 0 To Touch.Size-1";
{
final int step196 = 1;
final int limit196 = (int) (_touch.getSize()-1);
for (_conta = (int) (0); (step196 > 0 && _conta <= limit196) || (step196 < 0 && _conta >= limit196); _conta = ((int)(0 + _conta + step196))) {
 //BA.debugLineNum = 259;BA.debugLine="If Touch.Get(conta) = PointerID Then";
if ((_touch.Get(_conta)).equals((Object)(_pointerid))) { 
 //BA.debugLineNum = 260;BA.debugLine="Touch.RemoveAt(conta)";
_touch.RemoveAt(_conta);
 //BA.debugLineNum = 261;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 264;BA.debugLine="If Touch.Size = 1 Then";
if (_touch.getSize()==1) { 
 //BA.debugLineNum = 265;BA.debugLine="X0 = G.GetX(Touch.Get(0))+obj.Left";
_x0 = (int) (_g.GetX((int)(BA.ObjectToNumber(_touch.Get((int) (0)))))+_obj.getLeft());
 //BA.debugLineNum = 266;BA.debugLine="Y0 = G.GetY(Touch.Get(0))+obj.Top";
_y0 = (int) (_g.GetY((int)(BA.ObjectToNumber(_touch.Get((int) (0)))))+_obj.getTop());
 //BA.debugLineNum = 267;BA.debugLine="X1 = obj.Left";
_x1 = _obj.getLeft();
 //BA.debugLineNum = 268;BA.debugLine="Y1 = obj.Top";
_y1 = _obj.getTop();
 //BA.debugLineNum = 270;BA.debugLine="vZoom = vZoom+Product";
_vzoom = (float) (_vzoom+_product);
 //BA.debugLineNum = 271;BA.debugLine="vZoom = Min(vZoom,vZoomMax)";
_vzoom = (float) (__c.Min(_vzoom,_vzoommax));
 //BA.debugLineNum = 272;BA.debugLine="vZoom = Max(vZoom,vZoomMin)";
_vzoom = (float) (__c.Max(_vzoom,_vzoommin));
 };
 break;
case 4:
 //BA.debugLineNum = 275;BA.debugLine="Touch.Clear";
_touch.Clear();
 //BA.debugLineNum = 276;BA.debugLine="TimerLC.Enabled = False";
_timerlc.setEnabled(__c.False);
 //BA.debugLineNum = 277;BA.debugLine="If Abs(X+obj.Left-X0) < MovingTouch AND Abs(Y+o";
if (__c.Abs(_x+_obj.getLeft()-_x0)<_movingtouch && __c.Abs(_y+_obj.getTop()-_y0)<_movingtouch && _singleclick) { 
 //BA.debugLineNum = 278;BA.debugLine="If SubExists(vModule,vEventName&\"_Click\") Then";
if (__c.SubExists(ba,_vmodule,_veventname+"_Click")) { 
 //BA.debugLineNum = 279;BA.debugLine="vTouchData.Tag = vTag";
_vtouchdata.Tag = _vtag;
 //BA.debugLineNum = 280;BA.debugLine="CallSub2(vModule,vEventName&\"_Click\",vTouchDa";
__c.CallSubNew2(ba,_vmodule,_veventname+"_Click",(Object)(_vtouchdata));
 };
 };
 break;
}
;
 //BA.debugLineNum = 284;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 285;BA.debugLine="End Sub";
return false;
}
public String  _zoomview(int _newzoom,int _posx,int _posy) throws Exception{
int _width = 0;
int _height = 0;
int _left = 0;
int _top = 0;
 //BA.debugLineNum = 287;BA.debugLine="Private Sub ZoomView (NewZoom As Int,posX As Int,p";
 //BA.debugLineNum = 288;BA.debugLine="Dim Width,Height As Int";
_width = 0;
_height = 0;
 //BA.debugLineNum = 289;BA.debugLine="Width = NewZoom";
_width = _newzoom;
 //BA.debugLineNum = 290;BA.debugLine="Height = OrigH/OrigW*Width";
_height = (int) (_origh/(double)_origw*_width);
 //BA.debugLineNum = 291;BA.debugLine="If vLimitBorder Then";
if (_vlimitborder) { 
 //BA.debugLineNum = 292;BA.debugLine="If LimitBorderSize Then vZoomMax = obj.Width";
if (_limitbordersize()) { 
_vzoommax = (float) (_obj.getWidth());};
 }else if(_vlimitarea) { 
 //BA.debugLineNum = 294;BA.debugLine="If LimitAreaSize Then vZoomMin = obj.Width";
if (_limitareasize()) { 
_vzoommin = (float) (_obj.getWidth());};
 };
 //BA.debugLineNum = 296;BA.debugLine="Dim Left,Top As Int";
_left = 0;
_top = 0;
 //BA.debugLineNum = 297;BA.debugLine="Left = obj.Left+posX-(posX/obj.Width*Width)";
_left = (int) (_obj.getLeft()+_posx-(_posx/(double)_obj.getWidth()*_width));
 //BA.debugLineNum = 298;BA.debugLine="Top = obj.Top+posY-(posY/obj.Height*Height)";
_top = (int) (_obj.getTop()+_posy-(_posy/(double)_obj.getHeight()*_height));
 //BA.debugLineNum = 299;BA.debugLine="If vLimitBorder Then";
if (_vlimitborder) { 
 //BA.debugLineNum = 300;BA.debugLine="Left = Min(Max(Left,0),Parent.Width-obj.Width)";
_left = (int) (__c.Min(__c.Max(_left,0),_parent.getWidth()-_obj.getWidth()));
 //BA.debugLineNum = 301;BA.debugLine="Top = Min(Max(Top,0),Parent.Height-obj.Height)";
_top = (int) (__c.Min(__c.Max(_top,0),_parent.getHeight()-_obj.getHeight()));
 }else if(_vlimitarea) { 
 //BA.debugLineNum = 303;BA.debugLine="Left = Max(Min(Left,0),Parent.Width-obj.Width)";
_left = (int) (__c.Max(__c.Min(_left,0),_parent.getWidth()-_obj.getWidth()));
 //BA.debugLineNum = 304;BA.debugLine="Top = Max(Min(Top,0),Parent.Height-obj.Height)";
_top = (int) (__c.Max(__c.Min(_top,0),_parent.getHeight()-_obj.getHeight()));
 };
 //BA.debugLineNum = 306;BA.debugLine="obj.SetLayout(Left,Top,Width,Height)";
_obj.SetLayout(_left,_top,_width,_height);
 //BA.debugLineNum = 307;BA.debugLine="ChangeSizeOrPosition";
_changesizeorposition();
 //BA.debugLineNum = 308;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
