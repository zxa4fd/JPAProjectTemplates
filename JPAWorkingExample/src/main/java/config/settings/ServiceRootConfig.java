package config.settings;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"config.root"})
@ImportResource(value="classpath*:application-context.xml")
@EnableTransactionManagement
public class ServiceRootConfig {
}
