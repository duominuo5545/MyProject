package com.rich.lambda;

/**
 * Created by hanwang206326 on 16/1/15.
 */
public class Employee {
    private String name;
    private int salary;
    private int departId;

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}