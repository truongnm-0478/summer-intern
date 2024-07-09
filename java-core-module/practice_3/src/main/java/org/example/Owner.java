package org.example;

public class Owner {
    private String cmnd;
    private String fullName;
    private String email;

    public Owner(String cmnd, String fullName, String email) {
        this.cmnd = cmnd;
        this.fullName = fullName;
        this.email = email;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}