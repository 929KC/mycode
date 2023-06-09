package untis;

/**
 * 雇员
 */
public class Employee {
    //工号、姓名、性别、工作岗位
    private String employeeNo;
    private String name;
    private String gender;
    private String position;

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employee(String employeeNo, String name, String gender, String position) {
        this.employeeNo = employeeNo;
        this.name = name;
        this.gender = gender;
        this.position = position;
    }

    // Getter and setter methods
}