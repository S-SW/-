package com.fdk.hrsys.dao;

import com.fdk.hrsys.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface EmployeeDao {
    // 组合查询：编号、姓名、性别、年龄任意组合（动态 SQL），空对象查全部
    List<Employee> search(Employee condition);
    Employee searchById(int id);
    int add(Employee emp);
    int update(Employee emp);
    int delete(int id);
    // 按部门批量更新：把指定部门下的员工部门关联清空
    int updateByDep(int depId);
}
