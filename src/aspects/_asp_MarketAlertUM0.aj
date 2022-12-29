package aspects;

import main.User;
import main.Alert;

import larva.*;
public aspect _asp_MarketAlertUM0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_MarketAlertUM0.initialize();
}
}
}