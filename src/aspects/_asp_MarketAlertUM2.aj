package aspects;

import main.User;
import main.Alert;

import larva.*;
public aspect _asp_MarketAlertUM2 {

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_MarketAlertUM2.initialize();
}
}
before ( Alert a1) : (call(* Alert.viewingAlert(..)) && target(a1) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_MarketAlertUM0.lock){
Alert a;
User u;
a =a1 ;
u =a .owner ;

_cls_MarketAlertUM2 _cls_inst = _cls_MarketAlertUM2._get_cls_MarketAlertUM2_inst( a,u);
_cls_inst.a1 = a1;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 152/*viewingAlert*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 152/*viewingAlert*/);
}
}
}