package es.uniovi.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages = "es.uniovi")
@EnableTransactionManagement()
public class SpringConfig {

	
	@Bean public DataSource dataSource() {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
			cpds.setDriverClass("org.h2.Driver");
		} catch (PropertyVetoException e) {
			throw new IllegalStateException(e);
		} //loads the jdbc driver
        cpds.setJdbcUrl("jdbc:h2:./test.db");
        cpds.setUser("");
        cpds.setPassword("");
        return cpds;
	}
	
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("es.uniovi.domain");
        emf.setPersistenceProvider(new HibernatePersistenceProvider());
        
        Properties jpaProps=new Properties();
        jpaProps.put("hibernate.show_sql", "true");
        jpaProps.put("hibernate.hbm2ddl.auto" ,"create-drop");
        
        emf.setJpaProperties(jpaProps);
        return emf;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }
	

}
