package org.example.bean;

public class t_ministry_approve {
    private String Mi_guid;
    private String Proj_guid;
    private String Approve_symbo;
    private String Approve_time;
    private String Submit_time;

    public t_ministry_approve() {
    }

    public t_ministry_approve(String mi_guid, String proj_guid, String approve_symbo, String approve_time, String submit_time) {
        Mi_guid = mi_guid;
        Proj_guid = proj_guid;
        Approve_symbo = approve_symbo;
        Approve_time = approve_time;
        Submit_time = submit_time;
    }

    @Override
    public String toString() {
        return "t_ministry_approve{" +
                "Mi_guid='" + Mi_guid + '\'' +
                ", Proj_guid='" + Proj_guid + '\'' +
                ", Approve_symbo='" + Approve_symbo + '\'' +
                ", Approve_time='" + Approve_time + '\'' +
                ", Submit_time='" + Submit_time + '\'' +
                '}';
    }

    public String getMi_guid() {
        return Mi_guid;
    }

    public void setMi_guid(String mi_guid) {
        Mi_guid = mi_guid;
    }

    public String getProj_guid() {
        return Proj_guid;
    }

    public void setProj_guid(String proj_guid) {
        Proj_guid = proj_guid;
    }

    public String getApprove_symbo() {
        return Approve_symbo;
    }

    public void setApprove_symbo(String approve_symbo) {
        Approve_symbo = approve_symbo;
    }

    public String getApprove_time() {
        return Approve_time;
    }

    public void setApprove_time(String approve_time) {
        Approve_time = approve_time;
    }

    public String getSubmit_time() {
        return Submit_time;
    }

    public void setSubmit_time(String submit_time) {
        Submit_time = submit_time;
    }
}
