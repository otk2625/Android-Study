package com.cos.firestoreapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    private String id;
    private String title;
    private String content;
    private String userId;
}
