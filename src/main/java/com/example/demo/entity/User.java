package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class User {
    @TableId(
            value="id",
            type = IdType.AUTO
    )
    private Integer id;
    private String name;  // null
    private String email;
    //实体类属性，推荐使用包装类型， 可以判断是否为 null
    private Integer age; // 0

}
