package config.settings;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This is the equivalent of your dispatcher-servlet.xml
 * 
 */

// Tells that this is a configuration
@Configuration
// <mvc:annotation-driven /> equivalent
@EnableWebMvc
// scans packages for annotated components i.e. @Service
// @Repository @Controller @Componenent
@ComponentScan(basePackages = {"config.controller"})
public class ServiceWebConfig {
	/*public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {

		converters.add(new MappingJackson2HttpMessageConverter());

		WebMvcConfigurer.super.configureMessageConverters(converters);
	}*/
	
	private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
        MarshallingHttpMessageConverter xmlConverter = 
          new MarshallingHttpMessageConverter();
 
        XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
        xmlConverter.setMarshaller(xstreamMarshaller);
        xmlConverter.setUnmarshaller(xstreamMarshaller);
 
        return xmlConverter;
    }
}
