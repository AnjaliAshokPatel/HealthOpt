package com.vacreall.healthopt;

public class Registerdata {


    //private variables
    int _id;
    String first_name;
    String email_id;
    String mobile_number;
    String gender_name;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    String password;

    // Empty constructor
    public Registerdata(){

    }
    // constructor
    public Registerdata(int id, String first_name,String email_id,String phone_number,String mobile_number, String gender_name){
        this._id = id;
        this.first_name = first_name;
        this.gender_name = gender_name;
        this.email_id=email_id;
        this.mobile_number=mobile_number;
    }


    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    public String getName() {
        // TODO Auto-generated method stub
        return first_name;
    }

    // setting  first name
    public void setName(String first_name){
        this.first_name =first_name;
    }

    public String getGenderName() {
        // TODO Auto-generated method stub
        return gender_name;
    }

    public void setGenderName(String gender_name){
        this.gender_name =gender_name;
    }
    public String getEmailId() {
        // TODO Auto-generated method stub
        return email_id;
    }
    public void setEmailId(String email_id){
        this.email_id =email_id;
    }
    public String getMobNo() {
        // TODO Auto-generated method stub
        return  mobile_number;
    }

    public void setMobNo(String mobile_number){
        this.mobile_number=mobile_number;
    }
}
