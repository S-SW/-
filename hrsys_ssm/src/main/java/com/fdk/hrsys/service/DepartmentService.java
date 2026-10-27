package com.fdk.hrsys.service;

import com.fdk.hrsys.entity.Department;
import java.util.List;

public interface DepartmentService {
    List<Department> search();
    Department searchById(Integer id);
    boolean add(Department dep);
    boolean update(Department dep);
    boolean delete(Integer id);
}
