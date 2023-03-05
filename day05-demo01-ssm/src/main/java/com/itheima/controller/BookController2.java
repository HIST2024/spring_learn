package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.exception.BusinessException;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author codermao
 * @date 2023/3/4 23:10
 */
// RESTful标准控制器 （Controller + ResponseBody）
@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Object save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        Integer code = flag ? Code.SAVE_OK : Code.SAVE_ERR;
        String msg = flag ? "保存成功" : "保存失败";
        return new Result(code,flag,msg);
    }

    @PutMapping
    public Object update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        Integer code = flag ? Code.UPDATE_OK : Code.UPDATE_ERR;
        String msg = flag ? "修改成功" : "修改失败";
        return new Result(code,flag,msg);
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Integer id) {

        boolean flag = bookService.delete(id);
        Integer code = flag ? Code.DELETE_OK : Code.DELETE_ERR;
        String msg = flag ? "删除成功" : "删除失败";
        return new Result(code,flag,msg);
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable Integer id) {
        //TODO：异常测试
//        int i = 1 / 0;
        if (id <= 0){
            //用户行为造成的业务异常
            throw new BusinessException(Code.BUSINESS_ERR,"你个傻鸟，这个没有id<=0的用户");
        }
        Book book = bookService.getById(id);
        Integer code = book != null ? Code.GET_OK :Code.GET_ERR;
        String msg = book!=null ? "查询单个成功" : "查询单个失败";
        return new Result(code,book,msg);
    }

    @GetMapping
    public Object getAll() {
        List<Book> list = bookService.getAll();
        Integer code = list!=null ? Code.GET_OK : Code.GET_ERR;
        String msg = list != null ? "查询所有成功" : "查询所有失败";
        return new Result(code,list,msg);
    }
}
