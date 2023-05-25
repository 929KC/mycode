package org.example.bean;

public class Requisiton {
    private String Td_guid;
    private String Bpl_guid;
    private String Dl_name;
    private String Area;
    private String Std;

    public Requisiton() {
    }

    public Requisiton(String td_guid, String bpl_guid, String dl_name, String area, String std) {
        Td_guid = td_guid;
        Bpl_guid = bpl_guid;
        Dl_name = dl_name;
        Area = area;
        Std = std;
    }

    @Override
    public String toString() {
        return "Requisiton{" +
                "Td_guid='" + Td_guid + '\'' +
                ", Bpl_guid='" + Bpl_guid + '\'' +
                ", Dl_name='" + Dl_name + '\'' +
                ", Area='" + Area + '\'' +
                ", Std='" + Std + '\'' +
                '}';
    }

    public String getTd_guid() {
        return Td_guid;
    }

    public void setTd_guid(String td_guid) {
        Td_guid = td_guid;
    }

    public String getBpl_guid() {
        return Bpl_guid;
    }

    public void setBpl_guid(String bpl_guid) {
        Bpl_guid = bpl_guid;
    }

    public String getDl_name() {
        return Dl_name;
    }

    public void setDl_name(String dl_name) {
        Dl_name = dl_name;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getStd() {
        return Std;
    }

    public void setStd(String std) {
        Std = std;
    }
}
