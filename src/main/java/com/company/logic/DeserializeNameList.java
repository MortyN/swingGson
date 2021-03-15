package com.company.logic;

public class DeserializeNameList {
    String firstname;
    String lastname;
    public DeserializeNameList(){
        super();
    }
    public DeserializeNameList(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

}
