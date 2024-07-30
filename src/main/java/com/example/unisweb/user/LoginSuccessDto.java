package com.example.unisweb.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginSuccessDto {
    private String authorizedUserId;
    private String authorizedUserSessionId;
}
