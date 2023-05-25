package org.example;

public class CommissionWorker extends Employee{
    private double salary;
    private double commission;
    private int  quantity;

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CommissionWorker{" +
                "salary=" + salary +
                ", commission=" + commission +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public void earning() {
        System.out.println("来自普通员工的警告");
    }
}
