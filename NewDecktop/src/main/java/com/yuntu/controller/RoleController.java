package com.yuntu.controller;

import com.yuntu.pojo.Role;
import com.yuntu.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/getRoleAll")
    @ResponseBody
    public List<Role> getRoleAll(){
        return roleService.getAll();
    }
}
