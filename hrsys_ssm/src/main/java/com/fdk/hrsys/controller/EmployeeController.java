package com.fdk.hrsys.controller;

import com.fdk.hrsys.entity.Employee;
import com.fdk.hrsys.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 员工控制器 —— Controller 层
 * 个人标识：FDK 范帝康  学号 24102011031
 * 提供员工 增 / 删 / 查 / 改 共 5 个 REST 接口
 */
@Tag(name = "员工管理 Employee", description = "员工的增 / 删 / 查 / 改 共 5 个 REST 接口 —— FDK 范帝康 24102011031")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /** 查①：条件查询员工列表，不传参 = 查全部 */
    @Operation(summary = "条件查询员工列表", description = "按工号/姓名/性别/年龄等条件查询；不传任何参数时查询全部员工")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "查询成功，返回员工列表")})
    @GetMapping("/list")
    public List<Employee> list(@ParameterObject Employee condition) {
        return employeeService.search(condition);
    }

    /** 查②：按 id 查询单个员工（含部门信息） */
    @Operation(summary = "按 id 查询单个员工", description = "根据路径中的 id 查询员工详情（含部门信息）")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "查询成功，返回员工对象")})
    @GetMapping("/{id}")
    public Employee getById(
            @Parameter(name = "id", description = "员工主键 id", required = true, example = "1")
            @PathVariable Integer id) {
        return employeeService.searchById(id);
    }

    /** 增：POST JSON 请求体 */
    @Operation(summary = "新增员工", description = "通过 JSON 请求体新增一条员工记录")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "返回新增结果提示文字")})
    @PostMapping
    public String add(@RequestBody Employee emp) {
        return employeeService.add(emp) ? "新增成功 (FDK 24102011031)" : "新增失败";
    }

    /** 改：PUT JSON 请求体，必须带 id */
    @Operation(summary = "修改员工", description = "通过 JSON 请求体修改员工，请求体必须携带 id")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "返回修改结果提示文字")})
    @PutMapping
    public String update(@RequestBody Employee emp) {
        return employeeService.update(emp) ? "修改成功 (FDK 24102011031)" : "修改失败";
    }

    /** 删：DELETE /employee/{id} */
    @Operation(summary = "删除员工", description = "根据路径中的 id 删除一条员工记录")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "返回删除结果提示文字")})
    @DeleteMapping("/{id}")
    public String delete(
            @Parameter(name = "id", description = "员工主键 id", required = true, example = "1")
            @PathVariable Integer id) {
        return employeeService.delete(id) ? "删除成功 (FDK 24102011031)" : "删除失败";
    }
}
