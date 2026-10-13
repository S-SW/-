package org.fdk.hrsys;


import com.fdk.hrsys.dao.EmployeeDao;
import com.fdk.hrsys.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

}



