package com.example.administrator.tmi.data;

public class Board {
    private int id;
    private int user_id;
    private String title;
    private String content;
    private Member member;

    public Board() {
    }

    public Board(int id, int user_id, String title, String content) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
