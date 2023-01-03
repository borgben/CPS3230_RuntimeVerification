package aspects;

import main.User;
import main.Alert;

import larva.*;
public aspect _asp_MarketAlertUM1 {

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_MarketAlertUM1.initialize();
}
}
before ( User u1) : (call(* User.userViewedAlerts(..)) && target(u1) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_MarketAlertUM0.lock){
User u;
u =u1 ;

_cls_MarketAlertUM1 _cls_inst = _cls_MarketAlertUM1._get_cls_MarketAlertUM1_inst( u);
_cls_inst.u1 = u1;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 8/*userViewedAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 8/*userViewedAlerts*/);
}
}
before ( User u1) : (call(* User.userLoggedOut(..)) && target(u1) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_MarketAlertUM0.lock){
User u;
u =u1 ;

_cls_MarketAlertUM1 _cls_inst = _cls_MarketAlertUM1._get_cls_MarketAlertUM1_inst( u);
_cls_inst.u1 = u1;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 2/*userLoggedOut*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 2/*userLoggedOut*/);
}
}
before ( User u1) : (call(* User.alertCreated(..)) && target(u1) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_MarketAlertUM0.lock){
User u;
u =u1 ;

_cls_MarketAlertUM1 _cls_inst = _cls_MarketAlertUM1._get_cls_MarketAlertUM1_inst( u);
_cls_inst.u1 = u1;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 4/*alertCreated*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 4/*alertCreated*/);
}
}
before ( User u1) : (call(* User.alertsDeleted(..)) && target(u1) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_MarketAlertUM0.lock){
User u;
u =u1 ;

_cls_MarketAlertUM1 _cls_inst = _cls_MarketAlertUM1._get_cls_MarketAlertUM1_inst( u);
_cls_inst.u1 = u1;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 6/*alertsDeleted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 6/*alertsDeleted*/);
}
}
before ( User u1) : (call(* User.userValidLogin(..)) && target(u1) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_MarketAlertUM0.lock){
User u;
u =u1 ;

_cls_MarketAlertUM1 _cls_inst = _cls_MarketAlertUM1._get_cls_MarketAlertUM1_inst( u);
_cls_inst.u1 = u1;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 0/*userValidLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 0/*userValidLogin*/);
}
}
}