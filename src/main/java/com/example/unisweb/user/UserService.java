package com.example.unisweb.user;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public LoginSuccessDto loginSuccess(HttpServletRequest request) {
        return new LoginSuccessDto(
                (String)request.getSession().getAttribute("userId"),
                request.getSession().getId()
        );
    }

    public LoginFailDto loginFail(HttpServletRequest request) {
        return new LoginFailDto(
                (String)request.getSession().getAttribute("exception")
        );
    }
}
