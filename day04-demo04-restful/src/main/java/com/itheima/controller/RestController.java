package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author codermao
 * @date 2023/2/24 17:30
 */
/*
* TODO:restful的springmvc代码实现
*   1.用请求方式来区分不同参数
*   2.请求参数
*       1.如果是简单参数，直接放在地址中
*       2.如果是json格式参数，还是json形式传递
* */
//@Controller
public class RestController {
    /*
     * 前端请求地址：http://localhost:8080/rest
     * */
    @RequestMapping(value = "/rest", method = RequestMethod.GET, produces = "text/html;charset=utf8")
    @ResponseBody
    public String getAll() {
        System.out.println("get:查询全部");
        return "get:查询全部";
    }

    /*
     * 前端请求地址：http://localhost:8080/rest/3
     * 后端：@RequestMapping(value = "/rest/{id} ---》 RequestMapping中value的{id} = 3
     *      @PathVariable Integer id
     * */
    @RequestMapping(value = "/rest/{id}", method = RequestMethod.GET, produces = "text/html;charset=utf8")
    @ResponseBody
    public String getById(@PathVariable Integer id) {
        System.out.println("get:查询 " + id);
        return "get:查询" + id;
    }

    @RequestMapping(value = "/rest/{page}/{size}", method = RequestMethod.GET, produces = "text/html;charset=utf8")
    @ResponseBody
    public String getById(@PathVariable Integer page, @PathVariable Integer size) {
        System.out.println("get:查询 " + page + "," + size);
        return "get:查询 " + page + "," + size;
    }


//    @RequestMapping(value = "/rest", method = RequestMethod.POST, produces = "text/html;charset=utf8")
//    @ResponseBody
//    public String post() {
//        System.out.println("post:新增");
//        return "post:新增";
//    }

    @RequestMapping(value = "/rest", method = RequestMethod.POST, produces = "text/html;charset=utf8")
    @ResponseBody
    public String post(@RequestBody User user) {
        System.out.println("post:新增" + user);
        return "post:新增" + user;
    }

    @RequestMapping(value = "/rest", method = RequestMethod.PUT, produces = "text/html;charset=utf8")
    @ResponseBody
    public String put(@RequestBody User user) {
        System.out.println("put:修改" + user);
        return "put:修改" + user;
    }

    @RequestMapping(value = "/rest", method = RequestMethod.DELETE, produces = "text/html;charset=utf8")
    @ResponseBody
    public String delete() {
        System.out.println("delete:删除");
        return "delete:删除";
    }

    @RequestMapping(value = "/rest/{id}", method = RequestMethod.DELETE, produces = "text/html;charset=utf8")
    @ResponseBody
    public String deleteById(@PathVariable Integer id) {
        System.out.println("delete:删除 "+ id);
        return "delete:删除" + id;
    }
}
