package com.WebQ.interceptors;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ClearCacheInterceptor implements Interceptor {

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
	    ActionContext context = actionInvocation.getInvocationContext();
	    HttpServletResponse response = (HttpServletResponse) context
		    .get(StrutsStatics.HTTP_RESPONSE);

	    response.setHeader("Pragma", "no-cache");
	    response.setHeader("Cache-Control", "no-cache, no-store");
	    response.setDateHeader("Expires", 0);
	    response.setHeader("Vary", "*");

	    String result = actionInvocation.invoke();

	    Logger.getLogger(ClearCacheInterceptor.class).debug(
		    "result" + result);
	    return result;
	} catch (Exception e) {
	    Logger.getLogger(ClearCacheInterceptor.class).error(e.toString());
	}
	return null;
    }

}
