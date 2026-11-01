package com.fdk.hrsys.entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "员工实体")
public class Employee {
    @Schema(description = "员工主键 id（新增时可不填，修改时必须填）", example = "1")
    private Integer id;
    @Schema(description = "工号", example = "1001")
    private String number;      // 改为 String，更符合工号语义
    @Schema(description = "姓名", example = "张三")
    private String name;
    @Schema(description = "性别", example = "男")
    private String gender;
    @Schema(description = "年龄", example = "25")
    private Integer age;
    @Schema(description = "所属部门")
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