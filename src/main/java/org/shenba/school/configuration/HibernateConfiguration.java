package org.shenba.school.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@Configuration
public class HibernateConfiguration {
	
	@Bean
	public Hibernate5Module hibernate5Module() {
	  return new Hibernate5Module();
	}

}
