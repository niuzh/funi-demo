package com.funi.demo.web.controller;

import com.funi.demo.mbg.dto.User;
import com.funi.demo.query.UserQuery;
import com.funi.demo.service.IUserService;
import com.funi.demo.web.supports.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户控制
 * @author zhihuan.niu on 2017/4/21.
 */
@Controller
@RequestMapping("/User")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    /**
     * 查询用户列表
     * @param query
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<User> findUserListByQuery(UserQuery query){
        return userService.findUserList(query);
    }
}
