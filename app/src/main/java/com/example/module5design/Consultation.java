package com.example.module5design;

import java.io.Serializable;

public class Consultation implements Serializable{
    private String expertName;
    private String date;
    private String topicSummary;
    private String status;

    public Consultation(String expertName, String date, String topicSummary, String status) {
        this.expertName = expertName;
        this.date = date;
        this.topicSummary = topicSummary;
        this.status = status;
    }

    public String getExpertName() {
        return expertName;
    }

    public String getDate() {
        return date;
    }

    public String getTopicSummary() {
        return topicSummary;
    }

    public String getStatus() {
        return status;
    }
}
