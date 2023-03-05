package com.example.event;

public class PhotographerForm {
    public String fullname, phone_no, email, function_date, description;

    public PhotographerForm(){

    }

    public PhotographerForm(String fullname, String phone_no, String email, String function_date, String description) {
        this.fullname = fullname;
        this.phone_no = phone_no;
        this.email = email;
        this.function_date = function_date;
        this.description = description;
    }
}
