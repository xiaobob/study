package study.bobo;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@SpringBootApplication
@EnableJpaRepositories("study.bobo.dao")
@EntityScan("study.bobo.domain")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	/**
	 * 注册DruidServlet
	 * 
	 */
	@Bean
	public ServletRegistrationBean druidServletRegistrationBean(){
		System.err.println("1111111");
		ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean();
		servletRegistrationBean.setServlet(new StatViewServlet());
		servletRegistrationBean.addUrlMappings("/druid/*");
		servletRegistrationBean.setName("druidStatViewServlet");
		servletRegistrationBean.addInitParameter("loginUsername", "admin");  
		servletRegistrationBean.addInitParameter("loginPassword", "123456");  
		servletRegistrationBean.addInitParameter("resetEnable", "false");  
		return servletRegistrationBean;
	}
	
	/**
	 * 注册druidFileter拦截
	 * 
	 */
	@Bean
	public FilterRegistrationBean druidFilterRegistrationBean(){
		System.err.println("222222");
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.setName("druidWebStatFilter");
		Map<String, String> initParameters=new HashMap<>();
		initParameters.put("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
		filterRegistrationBean.setInitParameters(initParameters);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
	
	
	 @Bean  
	    public DataSource druidDataSource(@Value("${spring.datasource.url}") String url,  
	            @Value("${spring.datasource.driver-class-name}") String driver,  
	            @Value("${spring.datasource.username}") String userName,  
	            @Value("${spring.datasource.password}") String password,  
	            @Value("${spring.datasource.maxActive}") int maxActive,  
	            @Value("${spring.datasource.filters}") String filters,  
	            @Value("${spring.datasource.initialSize}")  
	            int initialSize,  
	            @Value("${spring.datasource.minIdle}")  
	            int minIdle,  
	            @Value("${spring.datasource.maxWait}")  
	            int maxWait,  
	            @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")  
	            int timeBetweenEvictionRunsMillis,  
	            @Value("${spring.datasource.minEvictableIdleTimeMillis}")  
	            int minEvictableIdleTimeMillis,  
	            @Value("${spring.datasource.validationQuery}")  
	            String validationQuery,  
	            @Value("${spring.datasource.testWhileIdle}")  
	            boolean testWhileIdle,  
	            @Value("${spring.datasource.testOnBorrow}")  
	            boolean testOnBorrow,  
	            @Value("${spring.datasource.testOnReturn}")  
	            boolean testOnReturn,  
	            @Value("${spring.datasource.poolPreparedStatements}")  
	            boolean poolPreparedStatements,  
	            @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")  
	            int maxPoolPreparedStatementPerConnectionSize,  
	            @Value("${spring.datasource.connectionProperties}")  
	            String connectionProperties,  
	            @Value("${spring.datasource.useGlobalDataSourceStat}")  
	            boolean useGlobalDataSourceStat  
	  
	    ) {  
	        DruidDataSource dataSource = new DruidDataSource();  
	        /*数据源主要配置*/  
	        dataSource.setUrl(url);  
	        dataSource.setDriverClassName(driver);  
	        dataSource.setUsername(userName);  
	        dataSource.setPassword(password);  
	          
	        /*数据源补充配置*/  
	        dataSource.setMaxActive(maxActive);  
	        dataSource.setInitialSize(initialSize);  
	        dataSource.setMinIdle(minIdle);  
	        dataSource.setMaxWait(maxWait);  
	        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);  
	        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);  
	        dataSource.setValidationQuery(validationQuery);  
	        dataSource.setTestOnBorrow(testOnBorrow);  
	        dataSource.setTestOnReturn(testOnReturn);  
	        dataSource.setTestWhileIdle(testWhileIdle);  
	        dataSource.setPoolPreparedStatements(poolPreparedStatements);  
	        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);  
	        dataSource.setConnectionProperties(connectionProperties);  
	        dataSource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);  
	          
	        try {  
	            dataSource.setFilters(filters);  
	            System.err.println("Druid数据源初始化设置成功......");
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	            System.err.println("Druid数据源初始化设置失败......");
	        }  
	        return dataSource;  
	  
	    }  
}
