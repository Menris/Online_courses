package com.project.ad.diploma_project.messages;

import java.util.Date;

/**
 * Created by menri on 22.12.2016.
 */

public class Message {
    private String textMessage;
    private String author;
    private long timeMessage;

    public Message (String textMessage, String author){
        this.textMessage = textMessage;
        this.author = author;

        timeMessage = new Date().getTime();
    }

    public Message() {
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public long getTimeMessage() {
        return timeMessage;
    }

    public void setTimeMessage(long timeMessage) {
        this.timeMessage = timeMessage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}