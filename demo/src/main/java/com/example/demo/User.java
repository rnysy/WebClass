package com.example.demo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor //롬복을 이용한 코드 다이어트
public class User {
	private @NonNull String id;
    private @NonNull String name;
    private @NonNull String email;

    public String toStirng(){
        return id + "/" + name + "/" + email;
    }

}