package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author codermao
 * @date 2023/3/4 22:53
 */
@Service
public class BookServiceImpl implements BookService {
    //这个错不用管
    @Autowired
    private BookDao bookDao;

    public boolean save(Book book) {
        //返回被影响的行数，如果行数大于0代表保存成功
        int count = bookDao.save(book);
        return count != 0;
    }

    public boolean update(Book book) {
        int count = bookDao.update(book);
        return count != 0;
    }

    public boolean delete(Integer id) {
        int count = bookDao.delete(id);
        return count != 0;
    }

    public Book getById(Integer id) {
        return bookDao.getById(id);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }
}