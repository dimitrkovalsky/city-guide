package com.guide.city.servlets;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.beans.factory.FactoryBean;

public class FactoryServletHandler implements FactoryBean<ContextHandlerCollection> {

	private String contextPath;
	private String resourceBase;

	public ContextHandlerCollection getObject() throws Exception  {

		WebAppContext webapp = new WebAppContext();
		
        webapp.setContextPath(getContextPath());
        webapp.setResourceBase(getResourceBase());
        webapp.setWar(getResourceBase());
        webapp.setClassLoader(Thread.currentThread().getContextClassLoader());
        webapp.addServlet(Login.class, "/google-auth");
        webapp.addServlet(Logout.class, "/logout");
        webapp.addServlet(FrontServlet.class, "/api");
//        webapp.addFilter(AuthenticationFilter.class, "/", EnumSet.of(DispatcherType.REQUEST));
        
        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[] { webapp });
		
		return contexts;
	}

	public Class<ServletContextHandler> getObjectType() {
		return ServletContextHandler.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getResourceBase() {
		return resourceBase;
	}

	public void setResourceBase(String resourceBase) {
		this.resourceBase = resourceBase;
	}
}