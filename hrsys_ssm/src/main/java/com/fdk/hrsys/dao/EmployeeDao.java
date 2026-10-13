package com.fdk.hrsys.dao;

import com.fdk.hrsys.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper // 告诉 MyBatis 这是一个 Mapper 接口
public interface EmployeeMapper {
    // 查询所有员工
    List<Employee> findAll();
}