package org.yixi.vblogserver.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class Category {
    private Long id;
    private String cateName;
    private Timestamp date;
}
