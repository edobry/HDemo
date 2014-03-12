package hdemo;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import javax.sql.DataSource;
import javax.annotation.Resource;

import org.hibernate.cfg.DefaultNamingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@ComponentScan
@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
public class Application {

    public static void main(String[] args) {
    	ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    	AgeRangeRepository ageRepo = context.getBean(AgeRangeRepository.class);
    	GenderRepository genderRepo = context.getBean(GenderRepository.class);

    	//Insert some genders
    	genderRepo.save(new Gender("Male"));
    	genderRepo.save(new Gender("Female"));
    	genderRepo.save(new Gender("Frank"));
    	
    	//Insert some age ranges
    	ageRepo.save(new AgeRange("13-17"));
    	ageRepo.save(new AgeRange("18-24"));
    	ageRepo.save(new AgeRange("25-34"));
    	ageRepo.save(new AgeRange("35-54"));
    	ageRepo.save(new AgeRange("55+"));    	
//    	
//    	
//    	//fetch genders
//    	Iterable<Gender> genders = genderRepo.findAll();
//    	String out = "";
//    	for(Gender g : genders) { out = out.concat(g.getName()); }
//
//    	System.out.println("Genders found: ".concat(out));
//    	
//    	context.close();
    }
    
    @Resource
    Environment env;
    
    @Bean
    public DataSource dataSource() {  
        DriverManagerDataSource dataSource = new DriverManagerDataSource();  
          
        dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));  
        dataSource.setUrl(env.getRequiredProperty("db.url"));  
        dataSource.setUsername(env.getRequiredProperty("db.username"));  
        dataSource.setPassword(env.getRequiredProperty("db.password"));  
          
        return dataSource;
    }
    
    @Bean
    @DependsOn("dataSource")
    public LocalSessionFactoryBean sessionFactory() throws IOException {  
    	LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    	
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(env.getRequiredProperty("entitymanager.packages.to.scan"));
        sessionFactoryBean.setHibernateProperties(hibProperties());
        sessionFactoryBean.setNamingStrategy(new DefaultNamingStrategy());
        sessionFactoryBean.afterPropertiesSet();
        
        return sessionFactoryBean;  
    }
      
    private Properties hibProperties() {  
        Properties properties = new Properties();
        properties.put("entitymanager.packages.to.scan", env.getRequiredProperty("entitymanager.packages.to.scan"));  
        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        return properties;    
    }
      
    @Bean
    @DependsOn("sessionFactory")
    public HibernateTransactionManager transactionManager() throws IOException {  
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();  
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;  
	}

}
