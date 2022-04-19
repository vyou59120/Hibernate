package com.spring5.config;

import com.sun.faces.config.FacesInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyWebInitializer extends FacesInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {

      final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
      context.register(AppConfig.class);
      context.setServletContext(servletContext);
      servletContext.addListener(new ContextLoaderListener(context));
  }
}
