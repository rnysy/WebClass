package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServicelmpl implements UserService {

    List<User> userList;
    public UserServicelmpl() {
        userList = new ArrayList<>();//유저리스트 생성
        //리스트에 유저 추가
        userList.add(new User("user1", "윤재상", "user1@kor"));
        userList.add(new User("user2", "상재윤", "user2@kor"));
        userList.add(new User("user3", "상윤재", "user3@kor"));
    }


    //전체 유저 리스트를 리턴함
    @Override
    public List<User> list() {
        return userList;
    }

    //id를 받아온후 리스트에서 찾아서 리턴함
    @Override
    public User view(String id) {
        //리스트에서 스트림과 필터를 이용하여 유저를 검색
        User user = userList.stream().filter(found -> found.getId().equals(id)).findAny().orElse(null);
        return user;
    }

    //user를 받아와서 유저리스트에 추가
    @Override
    public boolean add(User user) {
        User found = view(user.getId());
        if(found == null) { 
            userList.add(user);
            return true;
        }
        return true;
    }

    //user를 받아와서 유저리스트에 있는 같은 유저의 필드를 업데이트
    @Override
    public User update(User user) {
        User found = view(user.getId());
        if(found != null) {
            found.setName(user.getName());
            found.setEmail(user.getEmail());
        }
        return found;
    }

    //id를 받아와서 id가 같은 유저를 유저리스트에서 삭제함
    @Override
    public boolean delete(String id) {
        User found = view(id);
        return userList.remove(found);
    }

}