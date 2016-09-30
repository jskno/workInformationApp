package com.solutions.business.login.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jose on 18/09/2016.
 */
public class LoginsSummary {

    private List<LoginSummary> logins;

    public List<LoginSummary> getLogins() {
        if(logins == null) {
            logins = new ArrayList<>();
        }
        return logins;
    }

    public void setLogins(List<LoginSummary> loggins) { this.logins = loggins; }
}
