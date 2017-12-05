package com.dmxiaoshen.controller;

import com.dmxiaoshen.entity.Book;
import com.dmxiaoshen.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 不加spring.jackson.date-format为yyyy-MM-dd HH:mm:ss
 * Created by hzhsg on 2017/12/5.
 */
@RestController
@RequestMapping("/default")
public class DefaultDateFormatController {


    /**
     *  {
     *   "date": 1512452915669
     *   }
     * @return
     */
    @GetMapping("/map")
    public Map<String,Date> map(){
        Map<String, Date> result = new HashMap<>();
        result.put("date",new Date());
        return result;
    }

    /**
     * {
     *  "name": "Spring Cloud实践",
     *  "description": "一本好书",
     *  "publishDate": 1512453034834,
     *  "createTime": 1512453034834,
     *  "updateTime": 1512453034834
     *  }
     * @return
     */
    @GetMapping("/book")
    public Book book(){
        Book book = new Book();
        book.setName("Spring Cloud实践");
        book.setDescription("一本好书");
        Date now = new Date();
        book.setPublishDate(now);
        book.setCreateTime(now);
        book.setUpdateTime(now);
        return book;
    }

    /**
     *  get方法日期参数为2011-11-11或者1512452915669(时间戳)都不行
     *  "status": 400,
     *  "error": "Bad Request",
     *  "exception": "org.springframework.validation.BindException"
     * @param book
     * @return
     */
    @GetMapping("/book/query")
    public Book query(Book book){
        return book;
    }

    /**
     *  get方法日期参数为2011-11-11或者1512452915669(时间戳)都不行
     *  "status": 400,
     *  "error": "Bad Request",
     *  "exception": "org.springframework.validation.BindException"
     * @param date
     * @return
     */
    @GetMapping("/param/date")
    public Date getDateParam(@RequestParam("date") Date date){
        return date;
    }

    /**
     *  body中以json格式传参
     *  可以: 时间戳 | 2017-11-11 | 2015-09-5 | 2015-9-5 | 2017-05-18T10:26:10.488Z
     * @param book
     * @return
     */
    @PostMapping("/book/save")
    public Book save(@RequestBody Book book){
        return book;
    }


    /**
     * {
     *  "name": "Lisa",
     *  "birthday": "2017-12-05",
     *  "createTime": 1512463525359,
     *  "updateTime": 1512463525359,
     *  "_gender": "female"
     *  }
     * @return
     */
    @GetMapping("/user")
    public User user(){
        User user = new User();
        user.setName("Lisa");
        user.setGender("female");
        Date now = new Date();
        user.setBirthday(now);
        user.setCreateTime(now);
        user.setUpdateTime(now);
        return user;
    }
}
