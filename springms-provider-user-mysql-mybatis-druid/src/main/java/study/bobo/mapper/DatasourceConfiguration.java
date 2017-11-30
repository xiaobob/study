package study.bobo.mapper;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class DatasourceConfiguration {
	@Bean(name="dataSource")
	@Qualifier(value="dataSource")
	@Primary
	@ConfigurationProperties(prefix="spring")
    public DataSource dataSource()     {
         return  DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
     }
}
