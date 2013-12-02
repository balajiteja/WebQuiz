package com.webq.interceptors;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.webq.beans.User;

public class RegAuthenticationInterceptor implements Interceptor {
	
	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void destroy() {
		Logger.getLogger(RegAuthenticationInterceptor.class).debug(
				"Destroying MyLoggingInterceptor...");
	}
	
	@Override
	public void init() {
		Logger.getLogger(RegAuthenticationInterceptor.class).debug(
				"Initializing  MyLoggingInterceptor...");
	}
	
	@Override
	public String intercept(ActionInvocation actionInvocation) {
		
		try {
			ActionContext context = actionInvocation.getInvocationContext();
			Map<String, Object> session = context.getSession();
			
			String className = actionInvocation.getAction().getClass()
					.getName();
			long startTime = System.currentTimeMillis();
			Logger.getLogger(RegAuthenticationInterceptor.class).debug(
					"Before calling action: " + className);
			
			long endTime = System.currentTimeMillis();
			Logger.getLogger(RegAuthenticationInterceptor.class).debug(
					"After calling action: " + className + " Time taken: "
							+ (endTime - startTime) + " ms");
			
			User user = (User) session.get("user");
			
			if (user != null) {
				return "loggedIn";
			}
			return actionInvocation.invoke();
			
		} catch (Exception e) { // NOSONAR
			Logger.getLogger(RegAuthenticationInterceptor.class).error(
					e.toString());
		}
		return null;
	}
	
}
