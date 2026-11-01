package com.fdk.hrsys.entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "部门实体")
public class Department {
    @Schema(description = "部门主键 id", example = "1")
    private Integer id;
    @Schema(description = "部门名称", example = "技术部")
    private String name;
    @Schema(description = "部门编号", example = "D001")
    private String number;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    @Override
    public String toString() {
        return "Department{id=" + id + ", name='" + name + "', number='" + number + "'}";
    }
}