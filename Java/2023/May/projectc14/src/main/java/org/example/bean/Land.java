package org.example.bean;

public class Land {
    private String guid;
    private String name;
    private String area;
    private String sumArea;
    private String inputer;

    @Override
    public String toString() {
        return "Land{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", sumArea='" + sumArea + '\'' +
                ", inputer='" + inputer + '\'' +
                '}';
    }

    public Land() {
    }

    public Land(String guid, String name, String area, String sumArea, String inputer) {
        this.guid = guid;
        this.name = name;
        this.area = area;
        this.sumArea = sumArea;
        this.inputer = inputer;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSumArea() {
        return sumArea;
    }

    public void setSumArea(String sumArea) {
        this.sumArea = sumArea;
    }

    public String getInputer() {
        return inputer;
    }

    public void setInputer(String inputer) {
        this.inputer = inputer;
    }
}
