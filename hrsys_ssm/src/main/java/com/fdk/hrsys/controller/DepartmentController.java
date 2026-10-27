package com.fdk.hrsys.controller;

import com.fdk.hrsys.entity.Department;
import com.fdk.hrsys.service.DepartmentService;
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
 * 部门控制器 —— Controller 层
 * 个人标识：FDK 范帝康  学号 24102011031
 * 提供部门 增 / 删 / 查 / 改 共 5 个 REST 接口
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /** 查①：查询全部部门 */
    @GetMapping("/list")
    public List<Department> list() {
        return departmentService.search();
    }

    /** 查②：按 id 查询单个部门 */
    @GetMapping("/{id}")
    public Department getById(@PathVariable Integer id) {
        return departmentService.searchById(id);
    }

    /** 增：POST JSON 请求体 */
    @PostMapping
    public String add(@RequestBody Department dep) {
        return departmentService.add(dep) ? "新增成功 (FDK 24102011031)" : "新增失败";
    }

    /** 改：PUT JSON 请求体，必须带 id */
    @PutMapping
    public String update(@RequestBody Department dep) {
        return departmentService.update(dep) ? "修改成功 (FDK 24102011031)" : "修改失败";
    }

    /** 删：DELETE /department/{id} */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return departmentService.delete(id) ? "删除成功 (FDK 24102011031)" : "删除失败";
    }
}
