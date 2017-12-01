package study.bobo.mapper;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import org.springframework.stereotype.Component;

import com.alibaba.druid.support.http.StatViewServlet;

@SuppressWarnings("serial")
//@Component
@WebServlet(urlPatterns = "/druid/*", initParams = { 
		@WebInitParam(name = "resetEnable", value = "false")// 禁用HTML页面上的“Reset  All”功能
})
public class DruidStatViewServlet extends StatViewServlet {

	public DruidStatViewServlet() {
		System.err.println("DruidStatViewServlet");
	}
}
