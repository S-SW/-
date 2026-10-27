package com.fdk.hrsys;

import com.fdk.hrsys.entity.Department;
import com.fdk.hrsys.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    // ========== 1. 查询所有部门（search） ==========
    @Test
    public void testSearch() {
        List<Department> list = departmentService.search();
        System.out.println("========== Service 查询所有部门 ==========");
        list.forEach(System.out::println);
    }

    // ========== 2. 按 id 查询（searchById） ==========
    @Test
    public void testSearchById() {
        System.out.println("========== Service searchById(4) ==========");
        System.out.println(departmentService.searchById(4));
    }

    // ========== 3. 新增部门（add） ==========
    @Test
    public void testAdd() {
        Department dep = new Department();
        dep.setName("Service新增部门");
        dep.setNumber("998");

        boolean ok = departmentService.add(dep);

        System.out.println("========== Service add ==========");
        System.out.println("是否成功: " + ok);
        System.out.println("新增部门 ID: " + dep.getId());
    }

    // ========== 4. 修改部门（update） ==========
    @Test
    public void testUpdate() {
        Department dep = departmentService.searchById(4);
        System.out.println("========== Service update 修改前 ==========");
        System.out.println(dep);

        dep.setName("设计部3");
        dep.setNumber("1043");
        boolean ok = departmentService.update(dep);

        System.out.println("是否成功: " + ok);
        System.out.println("修改后: " + departmentService.searchById(4));
    }

    // ========== 5. 删除部门（delete） ==========
    @Test
    public void testDelete() {
        // 先加一个临时部门，再删掉
        Department dep = new Department();
        dep.setName("Service删除测试部门");
        dep.setNumber("887");
        departmentService.add(dep);
        int id = dep.getId();

        boolean ok = departmentService.delete(id);

        System.out.println("========== Service delete ==========");
        System.out.println("是否成功: " + ok);
        System.out.println("删除后再查 id=" + id + " : " + departmentService.searchById(id));
    }
}
