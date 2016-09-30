package com.solutions.business.login.control;

import com.solutions.business.login.entity.LoginsSummary;
import com.solutions.business.login.entity.persistence.Login;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Created by Jose on 18/09/2016.
 */
@ApplicationScoped
public class LoginService {

    @Inject
    LoginRepository loginRepository;

    @Inject
    Logger logger;

    public void save(Login login) {
        loginRepository.save(login);
    }

    public LoginsSummary findAllLogins() {
        return LoginMapper.mapLoginsToLoginsSummary(loginRepository.findAllLogins());
    }

 }
