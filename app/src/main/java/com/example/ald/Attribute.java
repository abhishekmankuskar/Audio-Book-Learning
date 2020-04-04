package com.example.ald;

import android.net.Uri;

public class Attribute {
    private String year;
    private String dep;
    private String sub;
    private String topic;
    private String audio_path;
    private Uri audio;

    public Attribute(String year, String dep, String sub, String topic, String audio_path) {
        this.year = year;
        this.dep = dep;
        this.sub = sub;
        this.topic = topic;
        this.audio_path = audio_path;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getYear() {
        return year;
    }
    public String getDep() {
        return dep;
    }
    public String getSub() {
        return sub;
    }
    public String getTopic() {
        return topic;
    }
    public String getAudio_path(){
        return audio_path;
    }

}
