package study.bobo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("study.bobo.mapper.**")
@EnableAutoConfiguration
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
