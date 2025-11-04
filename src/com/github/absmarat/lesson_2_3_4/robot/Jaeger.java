package com.github.absmarat.lesson_2_3_4.robot;

public class Jaeger {
    private String modelName;
    private String origin;
    private String arming;
    private float height;
    private float weight;

    public Jaeger() {
    }

    public Jaeger(String modelName, String origin, String arming, float height, float weight) {
        this.modelName = modelName;
        this.origin = origin;
        this.arming = arming;
        this.height = height;
        this.weight = weight;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getArming() {
        return arming;
    }

    public void setArming(String arming) {
        this.arming = arming;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void run() {
        System.out.println("Бежит");
    }

    public void fly() {
        System.out.println("Летит");
    }
}