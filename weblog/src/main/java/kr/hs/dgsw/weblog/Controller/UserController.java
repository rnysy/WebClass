package kr.hs.dgsw.weblog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.weblog.Domain.User;
import kr.hs.dgsw.weblog.Protocol.ResponseFormat;
import kr.hs.dgsw.weblog.Protocol.ResponseType;
import kr.hs.dgsw.weblog.Service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/create") //유저 생성
    public ResponseFormat create(@RequestBody User user)
    {
        User newUser = userService.create(user);
        if(newUser != null)
        {
            return new ResponseFormat(
                ResponseType.USER_ADD,
                newUser,
                newUser.getId()
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @PutMapping("user/update/{id}") //유저 정보 수정
    public ResponseFormat update(@PathVariable long id, @RequestBody User user)
    {
        User updated = userService.update(id, user);
        if(updated != null)
        {
            return new ResponseFormat(
                ResponseType.USER_UPDATE,
                updated,
                updated.getId()
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @DeleteMapping("/user/delete/{id}") //유저 삭제
    public ResponseFormat delete(@PathVariable long id)
    {
        boolean isSuccess = userService.delete(id);
        if(isSuccess)
        {
            return new ResponseFormat(
                ResponseType.USER_UPDATE,
                isSuccess,
                id
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @GetMapping("/user/read/{id}") // 유저 정보 가져오기
    public ResponseFormat read(@PathVariable long id)
    {
        User user = userService.read(id);
        if(user != null)
        {
            return new ResponseFormat(
                ResponseType.USER_GET,
                user,
                user.getId()
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @GetMapping("/user/read")
    public ResponseFormat readAll()// 모든 유저 정보 가져오기
    {
        List<User> userList = userService.readAll();
        if(userList != null)
        {
            return new ResponseFormat(
                ResponseType.USER_GET,
                userList
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }
}