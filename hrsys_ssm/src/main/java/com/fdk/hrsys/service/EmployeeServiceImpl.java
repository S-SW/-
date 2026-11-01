package com.fdk.hrsys.service;

import com.fdk.hrsys.dao.EmployeeDao;
import com.fdk.hrsys.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    /** 系统日志：FDK 范帝康 24102011031 */
    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> search(Employee condition) {
        List<Employee> list = employeeDao.search(condition);
        log.info("【员工查询】条件 number={} name={} gender={} age={}，命中 {} 条",
                condition.getNumber(), condition.getName(), condition.getGender(),
                condition.getAge(), list.size());
        return list;
    }

    @Override
    public Employee searchById(Integer id) {
        Employee emp = employeeDao.searchById(id);
        log.info("【员工查询】按 id={} 查询结果：{}", id, emp);
        return emp;
    }

    @Override
    public boolean add(Employee emp) {
        // DAO 返回影响行数，Service 转成 boolean：大于0即成功
        boolean ok = employeeDao.add(emp) > 0;
        log.info("【员工新增】number={} name={} gender={} age={}，结果：{}",
                emp.getNumber(), emp.getName(), emp.getGender(), emp.getAge(), ok ? "成功" : "失败");
        return ok;
    }

    @Override
    public boolean update(Employee emp) {
        boolean ok = employeeDao.update(emp) > 0;
        log.info("【员工修改】id={} number={} name={}，结果：{}",
                emp.getId(), emp.getNumber(), emp.getName(), ok ? "成功" : "失败");
        return ok;
    }

    @Override
    public boolean delete(Integer id) {
        boolean ok = employeeDao.delete(id) > 0;
        log.info("【员工删除】id={}，结果：{}", id, ok ? "成功" : "失败");
        return ok;
    }
}
