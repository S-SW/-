package com.fdk.hrsys.service;

import com.fdk.hrsys.dao.DepartmentDao;
import com.fdk.hrsys.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> search() {
        return departmentDao.search();
    }

    @Override
    public Department searchById(Integer id) {
        return departmentDao.searchById(id);
    }

    @Override
    public boolean add(Department dep) {
        return departmentDao.add(dep) > 0;
    }

    @Override
    public boolean update(Department dep) {
        return departmentDao.update(dep) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return departmentDao.delete(id) > 0;
    }
}
