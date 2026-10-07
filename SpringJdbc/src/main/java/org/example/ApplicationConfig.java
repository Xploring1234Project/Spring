package org.example;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages="org.example.*")
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class ApplicationConfig {



	/*@Bean
    	public DataSource mysqlDataSource() {
         		DriverManagerDataSource dataSource = new DriverManagerDataSource();
         		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
         		InputStream input = classLoader.getResourceAsStream("db.properties");
         		Properties properties = new Properties();
         		try {
             			properties.load(input);//fetch all the key value pair from properties
                    // file and load into the properties object
             			dataSource.setDriverClassName(properties.getProperty("driver"));
            			dataSource.setUrl(properties.getProperty("url"));
            			dataSource.setUsername(properties.getProperty("username"));
             			dataSource.setPassword(properties.getProperty("password"));
             		} catch (IOException e) {
             			e.printStackTrace();
             		}
        	return dataSource;
         	}*/

			@Bean DataSource mysqlDataSource() {
				DriverManagerDataSource datasource =  new DriverManagerDataSource();
				ClassLoader loader = Thread.currentThread().getContextClassLoader();
				InputStream input = loader.getResourceAsStream("db.properties");
				Properties props = new Properties();
				try{
					props.load(input);
					datasource.setDriverClassName(props.getProperty("driver"));
					datasource.setUrl(props.getProperty("url"));
					datasource.setUsername(props.getProperty("username"));
					datasource.setPassword(props.getProperty("password"));

				}catch (Exception e){
					e.printStackTrace();
				}
				return datasource;
			}

			 @Bean
			 public JdbcTemplate jdbcTemplate() {
        		JdbcTemplate template = new JdbcTemplate(mysqlDataSource());
         		return template;
         	}

            	@Bean
        	public PlatformTransactionManager txManager() {
				return new DataSourceTransactionManager(mysqlDataSource());
            }


}

