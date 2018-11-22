package it.unipv.mibe.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"it.unipv.mibe.course"})
@EntityScan("it.unipv.mibe.entity")
@EnableJpaRepositories("it.unipv.mibe.dao")
@ServletComponentScan(basePackages = { 
	    "it.unipv.mibe.course"
	   })
public class CourseApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CourseApplication.class);
    }
	
}
