package com.company.logic;

import java.util.List;

public class UserInfoArray {
    List<String> userInfo;

    public static class UserInfoItem {
        String firstname;
        String lastname;

        public UserInfoItem(String firstname, String lastname){
            this.firstname = firstname;
            this.lastname = lastname;
        }
    }
}
