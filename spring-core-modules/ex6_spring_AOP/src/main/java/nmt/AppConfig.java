package nmt;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "nmt")
@EnableAspectJAutoProxy
public class AppConfig {
    // Configuration code
}