package config.settings;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServiceInitializerConfig
		extends
			AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {ServiceRootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {ServiceWebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
