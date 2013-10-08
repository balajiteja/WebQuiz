package com.WebQ.spring;

import junit.framework.TestCase;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.WebQ.db.RetrieveDbInfo;

public class SpringTest extends TestCase {

    public void testSpringTest() throws Exception {

	WebApplicationContext context = WebApplicationContextUtils
		.getRequiredWebApplicationContext(ServletActionContext
			.getServletContext());

	RetrieveDbInfo retrieveDbInfo = (RetrieveDbInfo) context
		.getBean("retrieveDbInfo");
	retrieveDbInfo.toString();

    }
}
