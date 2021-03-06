package be.assign.expenseReport.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import be.assign.expenseReport.services.UserDao;
import be.assign.expenseReport.services.UserServiceImpl;

@Configuration
@ComponentScan(basePackages="be.assign.expenseReport")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	public ViewResolver getViewResolver(){
		   InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	       resolver.setPrefix("/WEB-INF/views/");
	       resolver.setSuffix(".jsp");
	       return resolver;
	}
    
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
   }
   @Bean
   public DataSource getDataSource() {
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setDriverClassName("com.mysql.jdbc.Driver");
       dataSource.setUrl("jdbc:mysql://localhost:3306/expensereport");
       dataSource.setUsername("root");
       dataSource.setPassword("Samsung01");
        
       return dataSource;
   }
   @Bean 
   public UserDao getUserDAO() {
       return new UserServiceImpl(getDataSource());
   }

}
