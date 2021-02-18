package com.example.myapplication2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    private Integer id;
    private String title;
    private String subTitle;
    private Integer min;
}
