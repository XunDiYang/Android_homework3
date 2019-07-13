package com.example.chapter3.homework;

public class ContactClass {
    private String name;
    private String signature;
    private int img;

    public ContactClass() {
    }

    public ContactClass(String name, String signature,  int img) {
        this.name = name;
        this.signature = signature;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getSignature() {
        return signature;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
