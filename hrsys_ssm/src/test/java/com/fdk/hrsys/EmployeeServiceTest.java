package com.fdk.hrsys;

import com.fdk.hrsys.entity.Department;
import com.fdk.hrsys.entity.Employee;
import com.fdk.hrsys.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    // ========== 1. 组合查询（search） ==========
    @Test
    public void testSearch() {
        Employee condition = new Employee();
        condition.setGender("男");
        List<Employee> list = employeeService.search(condition);
        System.out.println("========== Service search（性别=男） ==========");
        list.forEach(System.out::println);
    }

    // ========== 2. 按 id 查询（searchById） ==========
    @Test
    public void testSearchById() {
        System.out.println("========== Service searchById(5) ==========");
        System.out.println(employeeService.searchById(5));
    }

    // ========== 3. 新增（add） ==========
    @Test
    public void testAdd() {
        Employee emp = new Employee();
        emp.setNumber("10020");
        emp.setName("Service新增");
        emp.setGender("女");
        emp.setAge(23);
        Department dep = new Department();
        dep.setId(2);
        emp.setDep(dep);

        boolean ok = employeeService.add(emp);

        System.out.println("========== Service add ==========");
        System.out.println("是否成功: " + ok);
        System.out.println("新增员工 ID: " + emp.getId());
    }

    // ========== 4. 修改（update） ==========
    @Test
    public void testUpdate() {
        Employee emp = employeeService.searchById(5);
        System.out.println("========== Service update 修改前 ==========");
        System.out.println(emp);

        emp.setName("王强3");
        emp.setAge(31);
        boolean ok = employeeService.update(emp);

        System.out.println("是否成功: " + ok);
        System.out.println("修改后: " + employeeService.searchById(5));
    }

    // ========== 5. 删除（delete） ==========
    @Test
    public void testDelete() {
        // 先加一个临时员工，再删掉
        Employee emp = new Employee();
        emp.setNumber("10021");
        emp.setName("Service删除测试");
        emp.setGender("男");
        emp.setAge(26);
        employeeService.add(emp);
        int id = emp.getId();

        boolean ok = employeeService.delete(id);

        System.out.println("========== Service delete ==========");
        System.out.println("是否成功: " + ok);
        System.out.println("删除后再查 id=" + id + " : " + employeeService.searchById(id));
    }
}
