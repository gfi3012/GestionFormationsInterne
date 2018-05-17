package gfi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class GestionFormationsInterneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestionFormationsInterneApplication.class, args);
	}

	public void run(String... arg0) throws Exception {

	}
}
