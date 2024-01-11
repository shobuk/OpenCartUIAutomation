package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AppConstants {

	public static final String 	LOGIN_PAGE_TITLE = "Account Login";
	public static final String 	ACCOUNT_PAGE_TITLE = "My Account";
	public static final String 	LOGIN_PAGE_URL_FRACTION = "route=account/login";
	public static final String 	ACCOUNT_PAGE_URL_FRACTION = "route=account/account";
	
	public static final int SHORT_DEFAULT_WAIT = 5;
	public static final int MEDIUM_DEFAULT_WAIT = 10;
	public static final int LONG_DEFAULT_WAIT = 20;
	
	
	public static final int POLLING_DEFAULT_WAIT = 2;
	public static final Object ACCOUNT_PAGE_HEADER_COUNT = 4;
	public static final List<String> ACCOUNT_PAGE_HEADER_List =   Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
	
}
