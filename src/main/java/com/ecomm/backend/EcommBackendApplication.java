package com.ecomm.backend;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("com.ecomm.backend.Model")
public class EcommBackendApplication implements CommandLineRunner {

	@Autowired
//	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(EcommBackendApplication.class, args);
	}

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(this.passwordEncoder.encode("rv@123"));
	}
}
