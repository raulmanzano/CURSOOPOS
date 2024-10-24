package es.uniovi;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "es.uniovi")
@EnableAspectJAutoProxy
public class SpringConfig {

}
