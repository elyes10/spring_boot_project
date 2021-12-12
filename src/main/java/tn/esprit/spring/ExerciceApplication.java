package tn.esprit.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.esprit.spring.service.ImageService;

import javax.annotation.Resource;

@EnableAspectJAutoProxy
@EnableScheduling
@EnableSwagger2
@SpringBootApplication
public class ExerciceApplication implements CommandLineRunner {

	@Resource
	ImageService imageService;

	public static void main(String[] args) {
		SpringApplication.run(ExerciceApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		//imageService.init();
	}

}
