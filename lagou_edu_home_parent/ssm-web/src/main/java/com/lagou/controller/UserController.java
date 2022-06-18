package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVO;
import com.lagou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**************************************
 * @author pan
 * @version 2022/6/12 0:23
 **************************************/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage (@RequestBody UserVO userVo){

        PageInfo<User> allUserByPage = userService.findAllUserByPage(userVo);
        return new ResponseResult(true, 200, "响应成功", allUserByPage);
    }

    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {
        User login = userService.login(user);

        if(login !=null){
            HttpSession session = request.getSession();
            String access_token = UUID.randomUUID().toString();
            session.setAttribute("access_token",access_token);
            session.setAttribute("user_id",login.getId());

            HashMap<String, Object> map = new HashMap<>();
            map.put("access_token",access_token);
            map.put("user_id",login.getId());
            map.put("user",login);

            return new ResponseResult(true,1,"success",map);
        }else{
            return new ResponseResult(true,400,"用户名密码错误",null);
        }
    }

    @RequestMapping("findUserRoleById")
    public ResponseResult findUserRelationRoleById(Integer id){
        List<Role> list = userService.findUserRelationRoleById(id);

        return new ResponseResult(true,200,"分配角色成功",list);
    }

    @RequestMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UserVO userVO){
        userService.userContextRole(userVO);
        return  new ResponseResult(true,200,"响应成功",null);
    }

    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request){
        //获取请求头token
        String header_token = request.getHeader("Authorization");
        //获取session中的token
        String session_token = (String) request.getSession().getAttribute("access_token");
        if(header_token.equalsIgnoreCase(session_token)){
            //获取用户ID
            Integer user_id = (Integer) request.getSession().getAttribute("user_id");
            ResponseResult result = userService.getUserPermissions(user_id);
            return result;
        }else{
            return new ResponseResult(true,400,"用户名不正确",null);
        }
    }
}
