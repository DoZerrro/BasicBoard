package com.miniproject.board.controller;

import com.miniproject.board.dto.UserInfoDto;
import com.miniproject.board.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Log4j2
public class UserController {

    private final UserService userService;

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("email") String email
            , @RequestParam("password") String password
            , HttpSession httpSession) {
        try {
            UserInfoDto userInfo = userService.login(email);
            if(userInfo.getPassword().equals(password)) {
                httpSession.setAttribute("userInfo", userInfo);
            }
        } catch(Exception e) {
            return "redirect:/loginForm?error=true";
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("userInfo");
        return "redirect:/";
    }

    @GetMapping("/userRegForm")
    public String userRegForm() {
        return "/userRegForm";
    }

    @PostMapping("/userReg")
    @ResponseBody
    public String userReg(
        @RequestParam("name") String name
        , @RequestParam("email") String email
        , @RequestParam("password") String password
        , @RequestParam("role") int roleId
    ) {
        String msg;
        if(name.equals("") || email.equals("") || password.equals("")) {
            return "<script>" +
                   "alert('데이터를 미입력했습니다.');" +
                   "location.href='userRegForm';" +
                   "</script>";
        }

        boolean check = userService.checkEmail(email);
        if(check) {
            msg = "<script>" +
                  "alert('동일한 이메일이 존재합니다.');" +
                  "location.href='userRegForm';" +
                  "</script>";
        }
        else {
            msg = "<script>" +
                  "location.href='welcome';" +
                  "</script>";
            userService.addUserInfo(email, name, password);
            UserInfoDto userInfo = userService.login(email);
            userService.addUserRole(userInfo.getUserId(), roleId);
        }
        return msg;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
