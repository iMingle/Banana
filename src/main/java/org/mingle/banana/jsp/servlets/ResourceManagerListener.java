package org.mingle.banana.jsp.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mingle.banana.jsp.beans.EmployeeRegistryBean;
import org.mingle.banana.jsp.beans.NewsBean;
import org.mingle.banana.jsp.sql.DataSourceWrapper;

/**
 * This class manages the resources used by the Project Billboard application,
 * creating them and making them available when the application starts and
 * removing them when the application is shut down.
 *
 * @author <a href="mailto:jinminglei@yeah.net">mingle</a>
 * @date 2015年2月27日
 * @version 1.0
 */
public class ResourceManagerListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();

		/*
		 * Get the JDBC driver class name and URL from web.xml context init
		 * parameters
		 */
		String driverClass = application.getInitParameter("driverClass");
		String jdbcURL = application.getInitParameter("jdbcURL");

		DataSourceWrapper ds = null;
		try {
			ds = new DataSourceWrapper();
			ds.setDriverClassName(driverClass);
			ds.setUrl(jdbcURL);
		} catch (Exception e) {
			application.log("Error creating connection pool: ", e);
		}
		EmployeeRegistryBean empReg = new EmployeeRegistryBean();
		empReg.setDataSource(ds);
		application.setAttribute("empReg", empReg);

		NewsBean news = new NewsBean();
		application.setAttribute("news", news);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		application.removeAttribute("empReg");
		application.removeAttribute("news");
	}
}
