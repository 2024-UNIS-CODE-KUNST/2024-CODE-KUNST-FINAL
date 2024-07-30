package com.example.unisweb.user;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/basic")
    public String basicPage() {
        return "basic";
    }

    @GetMapping("/")
    public ResponseEntity<?> loginSucesss(HttpServletRequest request) {
        LoginSuccessDto loginSuccessDto = userService.loginSuccess(request);
        return ResponseEntity.status(HttpStatus.OK).body(loginSuccessDto);
    }

    @GetMapping("/failure")
    public ResponseEntity<?> loginFail(HttpServletRequest request) {
        LoginFailDto loginFailDto = userService.loginFail(request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(loginFailDto);
    }
}
