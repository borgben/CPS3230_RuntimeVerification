package larva;


import main.User;
import main.Alert;

import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_MarketAlertUM2 implements _callable{

public static LinkedHashMap<_cls_MarketAlertUM2,_cls_MarketAlertUM2> _cls_MarketAlertUM2_instances = new LinkedHashMap<_cls_MarketAlertUM2,_cls_MarketAlertUM2>();

_cls_MarketAlertUM1 parent;
public static Alert a1;
public Alert a;
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_MarketAlertUM2( Alert a,User u) {
parent = _cls_MarketAlertUM1._get_cls_MarketAlertUM1_inst( u);
this.a = a;
}

public void initialisation() {
}

public static _cls_MarketAlertUM2 _get_cls_MarketAlertUM2_inst( Alert a,User u) { synchronized(_cls_MarketAlertUM2_instances){
_cls_MarketAlertUM2 _inst = new _cls_MarketAlertUM2( a,u);
if (_cls_MarketAlertUM2_instances.containsKey(_inst))
{
_cls_MarketAlertUM2 tmp = _cls_MarketAlertUM2_instances.get(_inst);
 return _cls_MarketAlertUM2_instances.get(_inst);
}
else
{
 _inst.initialisation();
 _cls_MarketAlertUM2_instances.put(_inst,_inst);
 return _inst;
}
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_MarketAlertUM2)
 && (a == null || a.equals(((_cls_MarketAlertUM2)o).a))
 && (parent == null || parent.equals(((_cls_MarketAlertUM2)o).parent)))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_MarketAlertUM2_instances){
_performLogic_Alerts(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_MarketAlertUM2[] a = new _cls_MarketAlertUM2[1];
synchronized(_cls_MarketAlertUM2_instances){
a = _cls_MarketAlertUM2_instances.keySet().toArray(a);}
for (_cls_MarketAlertUM2 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_MarketAlertUM2_instances){
_cls_MarketAlertUM2_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_Alerts = 9;

public void _performLogic_Alerts(String _info, int... _event) {

_cls_MarketAlertUM0.pw.println("[Alerts]AUTOMATON::> Alerts("+a + " " + ") STATE::>"+ _string_Alerts(_state_id_Alerts, 0));
_cls_MarketAlertUM0.pw.flush();

if (0==1){}
else if (_state_id_Alerts==9){
		if (1==0){}
		else if ((_occurredEvent(_event,10/*viewingAlert*/)) && (a .alertType !=a .iconType )){
		_cls_MarketAlertUM0.pw .println ("Incompatible Icon and Alert Type!");

		_state_id_Alerts = 8;//moving to state invalidAlert
		_goto_Alerts(_info);
		}
		else if ((_occurredEvent(_event,10/*viewingAlert*/)) && (a .displayDescription ==null ||a .displayDescription =="")){
		_cls_MarketAlertUM0.pw .println ("Alerts description not displayed!");

		_state_id_Alerts = 8;//moving to state invalidAlert
		_goto_Alerts(_info);
		}
		else if ((_occurredEvent(_event,10/*viewingAlert*/)) && (a .displayHeading ==null ||a .displayHeading =="")){
		_cls_MarketAlertUM0.pw .println ("Alerts heading not displayed!");

		_state_id_Alerts = 8;//moving to state invalidAlert
		_goto_Alerts(_info);
		}
		else if ((_occurredEvent(_event,10/*viewingAlert*/)) && (a .displayPrice ==null ||a .displayPrice =="")){
		_cls_MarketAlertUM0.pw .println ("Alerts price not displayed!\n");

		_state_id_Alerts = 8;//moving to state invalidAlert
		_goto_Alerts(_info);
		}
		else if ((_occurredEvent(_event,10/*viewingAlert*/)) && (a .displayUrl ==null ||a .displayUrl =="")){
		_cls_MarketAlertUM0.pw .println ("Link to original listing not displayed!");

		_state_id_Alerts = 8;//moving to state invalidAlert
		_goto_Alerts(_info);
		}
		else if ((_occurredEvent(_event,10/*viewingAlert*/)) && (a .displayImgUrl ==null ||a .displayImgUrl =="")){
		_cls_MarketAlertUM0.pw .println ("Item image not displayed!");

		_state_id_Alerts = 8;//moving to state invalidAlert
		_goto_Alerts(_info);
		}
		else if ((_occurredEvent(_event,10/*viewingAlert*/))){
		_cls_MarketAlertUM0.pw .println ("Valid Alert "+a .heading );

		_state_id_Alerts = 9;//moving to state validAlert
		_goto_Alerts(_info);
		}
}
}

public void _goto_Alerts(String _info){
_cls_MarketAlertUM0.pw.println("[Alerts]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_Alerts(_state_id_Alerts, 1));
_cls_MarketAlertUM0.pw.flush();
}

public String _string_Alerts(int _state_id, int _mode){
switch(_state_id){
case 9: if (_mode == 0) return "validAlert"; else return "validAlert";
case 8: if (_mode == 0) return "invalidAlert"; else return "!!!SYSTEM REACHED BAD STATE!!! invalidAlert "+new _BadStateExceptionMarketAlertUM().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}