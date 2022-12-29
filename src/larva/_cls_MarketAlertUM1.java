package larva;


import main.User;
import main.Alert;

import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_MarketAlertUM1 implements _callable{

public static LinkedHashMap<_cls_MarketAlertUM1,_cls_MarketAlertUM1> _cls_MarketAlertUM1_instances = new LinkedHashMap<_cls_MarketAlertUM1,_cls_MarketAlertUM1>();

_cls_MarketAlertUM0 parent;
public static User u1;
public User u;
int no_automata = 1;
 public int noAlerts =0 ;
 public boolean loginState =false ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_MarketAlertUM1( User u) {
parent = _cls_MarketAlertUM0._get_cls_MarketAlertUM0_inst();
this.u = u;
}

public void initialisation() {
}

public static _cls_MarketAlertUM1 _get_cls_MarketAlertUM1_inst( User u) { synchronized(_cls_MarketAlertUM1_instances){
_cls_MarketAlertUM1 _inst = new _cls_MarketAlertUM1( u);
if (_cls_MarketAlertUM1_instances.containsKey(_inst))
{
_cls_MarketAlertUM1 tmp = _cls_MarketAlertUM1_instances.get(_inst);
 return _cls_MarketAlertUM1_instances.get(_inst);
}
else
{
 _inst.initialisation();
 _cls_MarketAlertUM1_instances.put(_inst,_inst);
 return _inst;
}
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_MarketAlertUM1)
 && (u == null || u.equals(((_cls_MarketAlertUM1)o).u))
 && (parent == null || parent.equals(((_cls_MarketAlertUM1)o).parent)))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_MarketAlertUM1_instances){
_performLogic_Users(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){

_cls_MarketAlertUM2[] a2 = new _cls_MarketAlertUM2[1];
synchronized(_cls_MarketAlertUM2._cls_MarketAlertUM2_instances){
a2 = _cls_MarketAlertUM2._cls_MarketAlertUM2_instances.keySet().toArray(a2);}
for (_cls_MarketAlertUM2 _inst : a2)
if (_inst != null
 && (u == null || u.equals(_inst.parent.u))){
_inst._call(_info, _event); 
_inst._call_all_filtered(_info, _event);
}
}

public static void _call_all(String _info, int... _event){

_cls_MarketAlertUM1[] a = new _cls_MarketAlertUM1[1];
synchronized(_cls_MarketAlertUM1_instances){
a = _cls_MarketAlertUM1_instances.keySet().toArray(a);}
for (_cls_MarketAlertUM1 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_MarketAlertUM1_instances){
_cls_MarketAlertUM1_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_Users = 5;

public void _performLogic_Users(String _info, int... _event) {

_cls_MarketAlertUM0.pw.println("[Users]AUTOMATON::> Users("+u + " " + ") STATE::>"+ _string_Users(_state_id_Users, 0));
_cls_MarketAlertUM0.pw.flush();

if (0==1){}
else if (_state_id_Users==4){
		if (1==0){}
		else if ((_occurredEvent(_event,2/*userLoggedOut*/)) && (loginState ==true )){
		loginState =false ;
_cls_MarketAlertUM0.pw .println ("Good logout observed. "+loginState );

		_state_id_Users = 5;//moving to state loggedOut
		_goto_Users(_info);
		}
		else if ((_occurredEvent(_event,0/*userValidLogin*/)) && (loginState ==true )){
		_cls_MarketAlertUM0.pw .println ("Invalid Login.");

		_state_id_Users = 0;//moving to state invalidLogin
		_goto_Users(_info);
		}
		else if ((_occurredEvent(_event,8/*userViewedAlerts*/)) && (loginState ==true )){
		_cls_MarketAlertUM0.pw .println ("User viewed alerts.");

		_state_id_Users = 4;//moving to state loggedIn
		_goto_Users(_info);
		}
		else if ((_occurredEvent(_event,4/*alertCreated*/))){
		_cls_MarketAlertUM0.pw .println ("Alert successfully created.");

		_state_id_Users = 4;//moving to state loggedIn
		_goto_Users(_info);
		}
		else if ((_occurredEvent(_event,6/*alertsDeleted*/))){
		noAlerts =0 ;
_cls_MarketAlertUM0.pw .println ("Alerts successfully deleted.");

		_state_id_Users = 4;//moving to state loggedIn
		_goto_Users(_info);
		}
		else if ((_occurredEvent(_event,8/*userViewedAlerts*/)) && (u .noDisplayedAlerts >5 )){
		_cls_MarketAlertUM0.pw .println ("Number of alerts displayed to user exceeds 5!");

		_state_id_Users = 3;//moving to state invalidNoAlertsDisplayed
		_goto_Users(_info);
		}
}
else if (_state_id_Users==5){
		if (1==0){}
		else if ((_occurredEvent(_event,0/*userValidLogin*/)) && (loginState ==false )){
		loginState =true ;
_cls_MarketAlertUM0.pw .println ("Good login observed. "+loginState );

		_state_id_Users = 4;//moving to state loggedIn
		_goto_Users(_info);
		}
		else if ((_occurredEvent(_event,4/*alertCreated*/))){
		_cls_MarketAlertUM0.pw .println ("Alert successfully created.");

		_state_id_Users = 5;//moving to state loggedOut
		_goto_Users(_info);
		}
		else if ((_occurredEvent(_event,6/*alertsDeleted*/))){
		;
_cls_MarketAlertUM0.pw .println ("Alerts successfully deleted.");

		_state_id_Users = 5;//moving to state loggedOut
		_goto_Users(_info);
		}
		else if ((_occurredEvent(_event,2/*userLoggedOut*/)) && (loginState ==false )){
		_cls_MarketAlertUM0.pw .println ("Invalid Logout!");

		_state_id_Users = 1;//moving to state invalidLogout
		_goto_Users(_info);
		}
		else if ((_occurredEvent(_event,8/*userViewedAlerts*/)) && (loginState ==false )){
		_cls_MarketAlertUM0.pw .println ("Invalid Alert Viewing! "+loginState );

		_state_id_Users = 2;//moving to state invalidAlertViewing
		_goto_Users(_info);
		}
}
}

public void _goto_Users(String _info){
_cls_MarketAlertUM0.pw.println("[Users]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_Users(_state_id_Users, 1));
_cls_MarketAlertUM0.pw.flush();
}

public String _string_Users(int _state_id, int _mode){
switch(_state_id){
case 1: if (_mode == 0) return "invalidLogout"; else return "!!!SYSTEM REACHED BAD STATE!!! invalidLogout "+new _BadStateExceptionMarketAlertUM().toString()+" ";
case 4: if (_mode == 0) return "loggedIn"; else return "loggedIn";
case 5: if (_mode == 0) return "loggedOut"; else return "loggedOut";
case 3: if (_mode == 0) return "invalidNoAlertsDisplayed"; else return "!!!SYSTEM REACHED BAD STATE!!! invalidNoAlertsDisplayed "+new _BadStateExceptionMarketAlertUM().toString()+" ";
case 0: if (_mode == 0) return "invalidLogin"; else return "!!!SYSTEM REACHED BAD STATE!!! invalidLogin "+new _BadStateExceptionMarketAlertUM().toString()+" ";
case 2: if (_mode == 0) return "invalidAlertViewing"; else return "!!!SYSTEM REACHED BAD STATE!!! invalidAlertViewing "+new _BadStateExceptionMarketAlertUM().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}