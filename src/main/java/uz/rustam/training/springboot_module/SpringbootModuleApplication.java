package uz.rustam.training.springboot_module;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootModuleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootModuleApplication.class, args);
	}

	@Override
	public void run(String... args){
		System.out.println("hello world");
	}

}
