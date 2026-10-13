package com.fdk.hrsys.dao;

import com.fdk.hrsys.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DepartmentDao {
    List<Department> search();
    Department searchById(Integer id);
    int add(Department dep);
    int update(Department dep);
    int delete(int id);
}
