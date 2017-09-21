package com.minkov.uicomponentsdemo.models;

public class Superhero {
    private String id;
    private String name;
    private String secretIdentity;
    private String imgUrl;

    public Superhero(String id, String name, String secretIdentity, String imgUrl){
        this.setId(id);
        this.setName(name);
        this.setSecretIdentity(secretIdentity);
        this.setImgUrl(imgUrl);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    private void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    private void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
