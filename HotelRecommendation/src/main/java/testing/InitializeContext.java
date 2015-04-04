package testing;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.viz.utils.Loader;

public class InitializeContext implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		Loader.initializeCache();
		System.out.println("Cache Initialized");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
