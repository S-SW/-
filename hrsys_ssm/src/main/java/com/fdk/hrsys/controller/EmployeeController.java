package com.fdk.hrsys.controller;

import com.fdk.hrsys.entity.Employee;
import com.fdk.hrsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 员工控制器 —— Controller 层
 * 个人标识：FDK 范帝康  学号 24102011031
 * 提供员工 增 / 删 / 查 / 改 共 5 个 REST 接口
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /** 查①：条件查询员工列表，不传参 = 查全部 */
    @GetMapping("/list")
    public List<Employee> list(Employee condition) {
        return employeeService.search(condition);
    }

    /** 查②：按 id 查询单个员工（含部门信息） */
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Integer id) {
        return employeeService.searchById(id);
    }

    /** 增：POST JSON 请求体 */
    @PostMapping
    public String add(@RequestBody Employee emp) {
        return employeeService.add(emp) ? "新增成功 (FDK 24102011031)" : "新增失败";
    }

    /** 改：PUT JSON 请求体，必须带 id */
    @PutMapping
    public String update(@RequestBody Employee emp) {
        return employeeService.update(emp) ? "修改成功 (FDK 24102011031)" : "修改失败";
    }

    /** 删：DELETE /employee/{id} */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return employeeService.delete(id) ? "删除成功 (FDK 24102011031)" : "删除失败";
    }
}
