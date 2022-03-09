package ma.enset.hospital;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }


	//c'est mieux que implement commandlinerunner interface

	@Bean
	CommandLineRunner start(){
		return  args -> {

		};
	}


}
