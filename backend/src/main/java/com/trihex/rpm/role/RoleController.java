package com.trihex.rpm.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;

@Controller
public class RoleController {

    @Autowired
    RoleService service;

    @RequestMapping(path = "/results/{user}", method = RequestMethod.GET)
    @ResponseBody
    public Iterator<Role> getUserRoles(@PathVariable int user)
    {
        return service.getForUser(user);
    }
}
