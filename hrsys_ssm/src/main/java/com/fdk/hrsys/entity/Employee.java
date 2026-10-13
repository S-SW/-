package com.fdk.hrsys.entity;

public class Employee {
    private Integer id;
    private String number;      // 改为 String，更符合工号语义
    private String name;
    private String gender;
    private Integer age;
    private Department dep;         // 改为 dep，与截图字段名一致

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public Department  getDep() { return dep; }
    public void setDep(Department dep) { this.dep = dep; }

    // 关键：toString 必须输出所有字段，才能复现截图
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", dep=" + dep +
                '}';
    }
}