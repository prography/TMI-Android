package com.example.administrator.tmi.data;

public class ItemData {
    private int id;
    private int replyImageId;
    private int likeImageId;
    private String nameText;
    private String dateText;
    private String subjectText;
    private String mainText;
    private String tagsText;
    private int replyCount;

    public ItemData(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReplyImageId() {
        return replyImageId;
    }

    public void setReplyImageId(int replyImageId) {
        this.replyImageId = replyImageId;
    }

    public int getLikeImageId() {
        return likeImageId;
    }

    public void setLikeImageId(int likeImageId) {
        this.likeImageId = likeImageId;
    }

    public String getNameText() {
        return nameText;
    }

    public void setNameText(String nameText) {
        this.nameText = nameText;
    }

    public String getDateText() {
        return dateText;
    }

    public void setDateText(String dateText) {
        this.dateText = dateText;
    }

    public String getSubjectText() {
        return subjectText;
    }

    public void setSubjectText(String subjectText) {
        this.subjectText = subjectText;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public String getTagsText() {
        return tagsText;
    }

    public void setTagsText(String tagsText) {
        this.tagsText = tagsText;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }
}
