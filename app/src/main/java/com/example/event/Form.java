package com.example.event;

public class Form {
    public String fullname, phone_no, email, function_date, no_of_guest, no_of_room, function_type1, function_type2, function_time1, function_time2;

    public Form(){

    }

    public Form(String fullname, String phone_no, String email, String function_date, String no_of_guest, String no_of_room, String function_type1,String function_type2, String function_time1, String function_time2) {
        this.fullname = fullname;
        this.phone_no = phone_no;
        this.email = email;
        this.function_date = function_date;
        this.no_of_guest = no_of_guest;
        this.no_of_room = no_of_room;
        this.function_type1 = function_type1;
        this.function_type2 = function_type1;
        this.function_time2 = function_time2;
    }
}
