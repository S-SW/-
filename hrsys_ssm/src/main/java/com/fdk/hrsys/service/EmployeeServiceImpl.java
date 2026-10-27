package com.fdk.hrsys.service;

import com.fdk.hrsys.dao.EmployeeDao;
import com.fdk.hrsys.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> search(Employee condition) {
        return employeeDao.search(condition);
    }

    @Override
    public Employee searchById(Integer id) {
        return employeeDao.searchById(id);
    }

    @Override
    public boolean add(Employee emp) {
        // DAO 返回影响行数，Service 转成 boolean：大于0即成功
        return employeeDao.add(emp) > 0;
    }

    @Override
    public boolean update(Employee emp) {
        return employeeDao.update(emp) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return employeeDao.delete(id) > 0;
    }
}
