package com.rashid.capp.controller;


import javax.enterprise.inject.New;
import javax.persistence.metamodel.Metamodel;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rashid.capp.command.LoginCommand;
import com.rashid.capp.command.UserCommand;
import com.rashid.capp.domain.User;
import com.rashid.capp.exception.UserBlockedException;
import com.rashid.capp.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= {"/","/index"})
	public String index(Model model) {
		model.addAttribute("command",new LoginCommand());
		return "index"; //JSP - WEF/INF/view/index.jsp
	}
	
	@RequestMapping(value= "/login", method=RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd,Model model,HttpSession session) {
		try {
			User loggedInUser =	userService.login(cmd.getLoginName(), cmd.getPassword());
			
			if(loggedInUser==null) {
				model.addAttribute("err","Login Failed.Enter Valid credentials");
				return "index";  //JSP-Login Form
			}
			else {
				if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
					
					addUserInSession(loggedInUser, session);
					return "redirect: admin/dashboard";
				}
				else if(loggedInUser.getRole().equals(UserService.ROLE_USER)) {
					addUserInSession(loggedInUser, session);
					return "redirect: user/dashboard";
				}
				else {
					model.addAttribute("err","Invalid User Role");
					return "index";  //JSP-Login Form
				}
			}
		} catch (UserBlockedException e) {
			//add error message and go back to form
			model.addAttribute("err",e.getMessage());
			return "index";  //JSP-Login Form
		}
	
	}
	
	@RequestMapping(value= {"/logout"})
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index?act=lo"; //JSP
	}
	@RequestMapping(value= {"/user/dashboard"})
	public String userDashboard() {
		return "dashboard_user"; //JSP
	}
	
	@RequestMapping(value= {"/admin/dashboard"})
	public String adminDashboard() {
		return "dashboard_admin"; //JSP
	}
	
	@RequestMapping(value= {"/admin/users"})
	public String getUserList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		return "users"; //JSP
	}
	
	@RequestMapping(value= {"/reg_form"})
	public String registrationForm(Model model) {
		UserCommand userCommand = new UserCommand();
		model.addAttribute("command",userCommand);
		return "reg_form"; //JSP
	}
	
	@RequestMapping(value= {"/register"})
	public String registerUser(@ModelAttribute("command") UserCommand command ,Model model) {
		try {
			User user = command.getUser();
			user.setRole(UserService.ROLE_USER);
			user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
			userService.register(user);
			
			return "redirect:index?act=reg"; //LoginPage
		} catch(DuplicateKeyException e) {
			model.addAttribute("err", "UserName is already registered.Please select another username");
			return "reg_form";
		}
	}
	
	private void addUserInSession(User user, HttpSession session) {

		session.setAttribute("user", user);
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("role", user.getRole());
	}
	
	@RequestMapping(value= {"/admin/change_status"})
	@ResponseBody
	public String changeLoginStatus(@RequestParam Integer userId, @RequestParam Integer loginStatus) {
		try {
			userService.changeLoginStatus(userId, loginStatus);
			return "SUCCESS: Status Changed";
		}catch(Exception e) {
			return "ERROR: Unable to Change Status";
		}	
	}
	
	@RequestMapping(value= {"/check_avail"})
	@ResponseBody
	public String checkAvailability(@RequestParam String username) {
		if(userService.isUserNameExist(username)) {
			return "This username is already taken.Choose another name";
		}
		else {
			return "Yes! You can take this.";
		}
		
	}
}
