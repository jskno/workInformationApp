package com.solutions.business.login.control;

import com.solutions.business.login.entity.LoginSummary;
import com.solutions.business.login.entity.LoginsSummary;
import com.solutions.business.login.entity.persistence.Login;

import java.util.List;

/**
 * Created by Jose on 18/09/2016.
 */
public class LoginMapper {

    public static LoginSummary mapLoginToLoginSummary(Login login) {
        LoginSummary loginSummary = new LoginSummary();
        loginSummary.setId(login.getId());
        loginSummary.setTitle(login.getTitle());
        loginSummary.setUsername(login.getUsername());
        loginSummary.setPassword(login.getPassword());
        loginSummary.setUrl(login.getUrl());
        loginSummary.setLabels(login.getLabels());
        return loginSummary;
    }

    public static LoginsSummary mapLoginsToLoginsSummary(List<Login> logins) {
        LoginsSummary loginsSummary = new LoginsSummary();
        for(Login login : logins) {
            LoginSummary loginSummary = mapLoginToLoginSummary(login);
            loginsSummary.getLogins().add(loginSummary);
        }
        return loginsSummary;
    }
}
