package bean;

public class Enterprise {
    private String entId;
    private String entName;
    private String beginDate;
    private String addr;

    private String regCapital;

    public Enterprise() {
    }

    public Enterprise(String entId, String entName, String beginDate, String addr, String regCapital) {
        this.entId = entId;
        this.entName = entName;
        this.beginDate = beginDate;
        this.addr = addr;
        this.regCapital = regCapital;
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "entId='" + entId + '\'' +
                ", entName='" + entName + '\'' +
                ", beginDate='" + beginDate + '\'' +
                ", addr='" + addr + '\'' +
                ", regCapital='" + regCapital + '\'' +
                '}';
    }

    public String getEntId() {
        return entId;
    }

    public void setEntId(String entId) {
        this.entId = entId;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(String regCapital) {
        this.regCapital = regCapital;
    }
}
