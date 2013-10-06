package com.WebQ.interceptors;

import java.util.Map;

import org.apache.log4j.Logger;

import com.WebQ.beans.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void destroy() {
	// TODO Auto-generated method stub

    }

    @Override
    public void init() {
	// TODO Auto-generated method stub

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) {
	try {
	    Map<String, Object> session = actionInvocation
		    .getInvocationContext().getSession();
	    User user = (User) session.get("user");
	    Boolean authorized = (Boolean) session.get("authorized");
	    if (user == null && (authorized != null && authorized)) {
		return ActionSupport.LOGIN;
	    }
	    return actionInvocation.invoke();
	} catch (Exception e) {
	    Logger.getLogger(AuthenticationInterceptor.class).error(
		    e.toString());
	}
	return null;
    }

}
