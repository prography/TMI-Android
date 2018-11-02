package com.example.administrator.tmi.data;

public class Member {
    private int id;
    private String email;
    private String password;

    public Member(){
        this(0, null, null);
    }

    public Member(String email, String password){
        this(0, email, password);
    }

    public Member(int id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
