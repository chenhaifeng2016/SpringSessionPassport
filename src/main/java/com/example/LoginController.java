package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by chenh on 2017/4/15.
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    @ResponseBody
    public String home(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
System.out.println("test'''''''''''''''''''''''''''''''''''''''''''");
/*
        Cookie cookie = new Cookie("SESSION", session.getId());

        cookie.setDomain("example.com");
        cookie.setPath("/");
        response.addCookie(cookie);
*/
        if (user == null){
            return "用好未登录" + session.getId();
        } else {
            return "用好已登录" + session.getId();
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request){
        User user = new User();
        user.setUsername("chf");
        user.setPassword("pass");
        request.getSession().setAttribute("user", user);

        Account account = new Account();
        account.setBalance(100);
        request.getSession().setAttribute("account", account);

        return "login successfully "  + request.getSession().getId();
    }
}
