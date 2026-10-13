package com.fdk.hrsys; // 必须与启动类 HrsysSsmApplication 同包，@SpringBootTest 才能自动找到它

import com.fdk.hrsys.dao.EmployeeDao;
import com.fdk.hrsys.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.fdk.hrsys.entity.Department;

import java.util.List;

@SpringBootTest // 测试类和启动类同包，Spring 会自动找到 HrsysSsmApplication
public class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    // ========== 1. 组合查询（search） ==========
    @Test
    public void testSearch() {
        // 组合条件：性别=男 且 年龄=24
        Employee condition = new Employee();
        condition.setGender("男");
        condition.setAge(24);
        System.out.println("========== search 组合条件（男,24） ==========");
        employeeDao.search(condition).forEach(System.out::println);
        // 姓名模糊
        Employee c2 = new Employee();
        c2.setName("李");
        System.out.println("========== search 姓名模糊（李） ==========");
        employeeDao.search(c2).forEach(System.out::println);
    }

    // ========== 2. 按 id 查询（searchById） ==========
    @Test
    public void testSearchById() {
        Employee emp = employeeDao.searchById(5);
        System.out.println("========== searchById(1) ==========");
        System.out.println(emp);
    }

    // ========== 3. 新增（add） ==========
    @Test
    public void testAdd() {
        Employee employee = new Employee();
        employee.setNumber("10019");
        employee.setName("FDK");
        employee.setGender("男");
        employee.setAge(21);
        Department dep = new Department();
        dep.setId(2);
        employee.setDep(dep);

        int result = employeeDao.add(employee);

        System.out.println("========== add ==========");
        System.out.println("影响行数: " + result);
        System.out.println("新增员工的 ID : " + employee.getId());
        System.out.println("新增员工信息: " + employee);
    }

    // ========== 4. 修改（update）：修改现有员工 ==========
    @Test
    public void testUpdate() {
        // 以现有员工 id=5 为例，先查出原值
        Employee emp = employeeDao.searchById(5);
        System.out.println("========== update 修改前 ==========");
        System.out.println(emp);

        // 修改姓名和年龄
        emp.setName("王强2");
        emp.setAge(30);
        int result = employeeDao.update(emp);

        System.out.println("影响行数: " + result);
        System.out.println("========== update 修改后 ==========");
        System.out.println(employeeDao.searchById(5));
    }

    // ========== 5. 删除（delete） ==========
    @Test
    public void testDelete() {
        // 先查出要删的员工 id=14
        System.out.println("========== delete 删除前 ==========");
        System.out.println(employeeDao.searchById(14));

        int result = employeeDao.delete(14);

        System.out.println("影响行数: " + result);
        System.out.println("========== delete 删除后 ==========");
        System.out.println("再查 id=14 : " + employeeDao.searchById(14));
    }

    // ========== 6. 按部门批量更新（updateByDep） ==========
    @Test
    public void testUpdateByDep() {
        // 把部门 id=1 下的员工部门关联清空
        int result = employeeDao.updateByDep(1);

        System.out.println("========== updateByDep(1) ==========");
        System.out.println("影响行数: " + result);
        System.out.println("更新后查所有: ");
        employeeDao.search(new Employee()).forEach(System.out::println);
    }
}
