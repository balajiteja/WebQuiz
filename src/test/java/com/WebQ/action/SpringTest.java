package com.WebQ.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.WebQ.beans.UsersCollection;
import com.opensymphony.xwork2.ActionSupport;

public class SpringTest extends ActionSupport {

    public static void main(String[] args) {
	SpringTest st = new SpringTest();
	try {
	    st.execute();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    @Override
    public String execute() throws Exception {

	WebApplicationContext context = WebApplicationContextUtils
		.getRequiredWebApplicationContext(ServletActionContext
			.getServletContext());

	UsersCollection userBo1 = (UsersCollection) context
		.getBean("usersCollection");
	userBo1.toString();

	return SUCCESS;

    }
}
