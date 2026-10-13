package com.fdk.hrsys;

import com.fdk.hrsys.dao.DepartmentDao;
import com.fdk.hrsys.entity.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DepartmentDaoTest {

    @Autowired
    private DepartmentDao departmentDao;

    // ========== 1. 查询所有部门（search） ==========
    @Test
    public void testSearch() {
        List<Department> list = departmentDao.search();
        System.out.println("========== 查询所有部门 ==========");
        list.forEach(System.out::println);
    }

    // ========== 2. 按 id 查询（searchById） ==========
    @Test
    public void testSearchById() {
        Department dep = departmentDao.searchById(4);
        System.out.println("========== searchById(4) ==========");
        System.out.println(dep);
    }

    // ========== 3. 新增部门（add） ==========
    @Test
    public void testAdd() {
        Department dep = new Department();
        dep.setName("测试部门");
        dep.setNumber("999");

        int result = departmentDao.add(dep);

        System.out.println("========== add ==========");
        System.out.println("影响行数: " + result);
        System.out.println("新增部门的 ID: " + dep.getId());
        System.out.println("新增部门信息: " + dep);
    }

    // ========== 4. 修改部门（update）：修改现有部门 ==========
    @Test
    public void testUpdate() {
        // 以现有部门 id=4 为例
        Department dep = departmentDao.searchById(4);
        System.out.println("========== update 修改前 ==========");
        System.out.println(dep);

        dep.setName("设计部2");
        dep.setNumber("1042");
        int result = departmentDao.update(dep);

        System.out.println("影响行数: " + result);
        System.out.println("========== update 修改后 ==========");
        System.out.println(departmentDao.searchById(4));
    }

    // ========== 5. 删除部门（delete） ==========
    @Test
    public void testDelete() {
        // 先加一个临时部门，再删掉它（避免外键约束报错）
        Department dep = new Department();
        dep.setName("待删除部门");
        dep.setNumber("888");
        departmentDao.add(dep);
        int id = dep.getId();

        int result = departmentDao.delete(id);

        System.out.println("========== delete ==========");
        System.out.println("影响行数: " + result);
        System.out.println("删除后再查 id=" + id + " : " + departmentDao.searchById(id));
    }
}
