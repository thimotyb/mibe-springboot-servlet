package it.unipv.mibe.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
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
