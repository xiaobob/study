package study.bobo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("study.bobo.dao")
@EntityScan("study.bobo.domain")
@EnableDiscoveryClient
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
