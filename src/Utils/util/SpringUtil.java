package Utils.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements ApplicationContextAware{
	private static ApplicationContext applicationConext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if(SpringUtil.applicationConext == null) {
			SpringUtil.applicationConext = applicationContext;
		}
	}
	
	public static ApplicationContext getApplicationContext() {
		return applicationConext;
	}
	
	public static Object getBean(String name) {
		return applicationConext.getBean(name);
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return applicationConext.getBean(clazz);
	}
	
	public static <T> T getBean(String name, Class<T> clazz) {
		return applicationConext.getBean(name, clazz);
	}
}
