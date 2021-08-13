package com.example.womansafety;

public class UserHelperClass {
    String fullname,email,phonenumber,password,phonenumber1,phonenumber2,phonenumber3;

    public UserHelperClass(String fullname, String email, String phonenumber, String password, String phonenumber1, String phonenumber2, String phonenumber3) {
        this.fullname = fullname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.password = password;
        this.phonenumber1 = phonenumber1;
        this.phonenumber2 = phonenumber2;
        this.phonenumber3 = phonenumber3;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber1() {
        return phonenumber1;
    }

    public void setPhonenumber1(String phonenumber1) {
        this.phonenumber1 = phonenumber1;
    }

    public String getPhonenumber2() {
        return phonenumber2;
    }

    public void setPhonenumber2(String phonenumber2) {
        this.phonenumber2 = phonenumber2;
    }

    public String getPhonenumber3() {
        return phonenumber3;
    }

    public void setPhonenumber3(String phonenumber3) {
        this.phonenumber3 = phonenumber3;
    }
}
