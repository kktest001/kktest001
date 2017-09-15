package com.kk.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kk.spring.beans.User;
import com.kk.spring.services.UserService;

@Controller
@RequestMapping(value = "/main")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login_pre() {

		return "login";

	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String Login(User user, HttpServletRequest request, Model model) {
		System.out.println(user);
		User ruser = (User) userService.getUser(user);
		if (ruser == null || ruser.getUsername() == null) {
			return "false";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("id", ruser.getKid());
			session.setAttribute("username", ruser.getUsername());
			List<User> users = userService.getAllUser(ruser.getKid());
			model.addAttribute("users", users);
			return "userlist";
		}
	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		return "login";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		System.out.println("hello kktest001");
		return "test";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String Register() {

		return "register";
	}

	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String registerTo(User user) {
		List<User> users = userService.insertOne(user);
		return "login";
	}

	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public String saveTo(HttpServletRequest request, User user, Model model) {
		List<User> users = userService.insertOne(user);
		HttpSession session = request.getSession();
		int sid = (int) session.getAttribute("id");
		List<User> rusers = userService.getAllUser(sid);
		model.addAttribute("users", rusers);
		return "userlist";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public User update_pre(Integer id) {
		User user = userService.getUserById(id);

		return user;
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String updateOne(HttpServletRequest request, User user, Model model) {
		List<User> users = userService.updateUser(user);
		HttpSession session = request.getSession();
		int sid = (int) session.getAttribute("id");
		List<User> rusers = userService.getAllUser(sid);
		model.addAttribute("users", rusers);
		return "userlist";

	}

	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
	public String getAllUsers(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		List<User> users = userService.getAllUser(id);
		model.addAttribute("users", users);
		return "userlist";
	}

	@RequestMapping(value = "/getOne", method = RequestMethod.GET)
	public User getOneUser(User user) {
		return null;
	}

	@RequestMapping(value = "/delOne", method = RequestMethod.GET)
	public String deleteOne(HttpServletRequest request, Integer id, Model model) {
		List<User> users = userService.delOne(id);
		HttpSession session = request.getSession();
		int sid = (int) session.getAttribute("id");
		List<User> rusers = userService.getAllUser(sid);
		model.addAttribute("users", rusers);
		return "userlist";
	}

}
