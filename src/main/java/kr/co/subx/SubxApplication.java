package kr.co.subx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  // Auditing 기능 활성화
public class SubxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubxApplication.class, args);
	}

}
