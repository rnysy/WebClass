package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //유저 리스트를 전부 리턴해줌
    @GetMapping("/user")
    @ResponseBody
    public List<User> list() {
        return userService.list();
    }


    //id를 받아서 일치하는 유저 한명을 리턴해줌
    @GetMapping("/user/{id}")
    @ResponseBody
    public User view(@PathVariable String id) {
        return userService.view(id);
    }

    //user 하나를 받아 새로운 유저를 추가해줌
    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user) {
        return userService.add(user);
    }
  
    //user 하나를 받아 유저를 업데이트 해줌
    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    //id를 받아 id와 일치하는 유저 한명을 삭제해줌
    @DeleteMapping("/user/{id}")
    @ResponseBody
    public boolean delete(@PathVariable String id) {
        return userService.delete(id);
    }



}