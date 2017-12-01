package study.bobo.mapper;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import org.springframework.stereotype.Component;
import com.alibaba.druid.support.http.WebStatFilter;

//@Component
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
initParams={
    @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
})
public class DruidStatFilter extends WebStatFilter{
	public DruidStatFilter() {
		System.err.println("DruidStatFilter");
	}
}
