package com.kk.spring.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取请求的url
		String url = request.getRequestURI();
		// 判断url是否公开地址（实际使用时将公开地址配置到配置文件中）
		// 这里假设公开地址是否登陆提交的地址
		if (url.indexOf("login.do") > 0 //登录操作放行
				|| url.indexOf("register") > 0 //注册页放行
				|| url.indexOf("register.do") > 0//注册操作放行
				|| url.indexOf("test") > 0 //测试页面放行
				|| url.contains("res")
				) {//资源加载过程放行
			return true;
		}

		// 判断session
		HttpSession session = request.getSession();
		// 从session中取出用户身份信息
		String username = (String) session.getAttribute("username");
		if (username != null) {
			return true;
		}

		// 执行到这里表示用户身份需要验证，跳转到登陆页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

		return false;

	}

}
