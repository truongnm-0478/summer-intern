package nmt.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;


@Component
@Scope("application")
public class ApplicationBean implements ServletContextAware {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setAttribute("applicationScopedBean", this);
    }
}
