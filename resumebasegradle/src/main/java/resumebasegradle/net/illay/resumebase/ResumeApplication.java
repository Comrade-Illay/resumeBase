package resumebasegradle.net.illay.resumebase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;



/**
 * Entry point in application
 * @author illay
 * @version 1.0
 */

@SpringBootApplication
@EnableCaching
public class ResumeApplication {
	 	
	/**
	 * Bean for converting protobuf dto-message to http-message 
	 * @return
	 */
	
	@Bean
	ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}
    /**
	 * Here start point of the program
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ResumeApplication.class);
	}

	@Bean 
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
			
	}
	
}