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
		// ��ȡ�����url
		String url = request.getRequestURI();
		// �ж�url�Ƿ񹫿���ַ��ʵ��ʹ��ʱ��������ַ���õ������ļ��У�
		// ������蹫����ַ�Ƿ��½�ύ�ĵ�ַ
		if (url.indexOf("login.do") > 0 //��¼��������
				|| url.indexOf("register") > 0 //ע��ҳ����
				|| url.indexOf("register.do") > 0//ע���������
				|| url.indexOf("test") > 0 //����ҳ�����
				|| url.contains("res")
				) {//��Դ���ع��̷���
			return true;
		}

		// �ж�session
		HttpSession session = request.getSession();
		// ��session��ȡ���û������Ϣ
		String username = (String) session.getAttribute("username");
		if (username != null) {
			return true;
		}

		// ִ�е������ʾ�û������Ҫ��֤����ת����½ҳ��
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

		return false;

	}

}
