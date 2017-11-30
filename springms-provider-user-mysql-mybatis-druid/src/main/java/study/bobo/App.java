package study.bobo;


import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@SpringBootApplication
@MapperScan("study.bobo.mapper.**")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
//	
//	/**
//	 * 注册DruidServlet
//	 * 
//	 */
	@Bean
	public ServletRegistrationBean druidServletRegistrationBean(){
		ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean();
		servletRegistrationBean.setServlet(new StatViewServlet());
		servletRegistrationBean.addUrlMappings("/druid/*");
		return servletRegistrationBean;
	}
//	
//	/**
//	 * 注册druidFileter拦截
//	 * 
//	 */
	@Bean
	public FilterRegistrationBean druidFilterRegistrationBean(){
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		Map<String, String> initParameters=new HashMap<>();
		initParameters.put("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
		filterRegistrationBean.setInitParameters(initParameters);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
//	
//	/**
//     * 配置DataSource
//     * @return
//     * @throws SQLException
//     */
//    @Bean
//    public DataSource druidDataSource() throws SQLException {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUsername("root");
//        druidDataSource.setPassword("123456");
//        druidDataSource.setUrl("jdbc:mysql:///springcloud");
//        druidDataSource.setMaxActive(100);
//        druidDataSource.setFilters("stat,wall");
//        druidDataSource.setInitialSize(10);
//        return druidDataSource;
//    }	
}
