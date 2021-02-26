package com.cos.firestoreapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String username;
    private String password;
    private String phone;
}
