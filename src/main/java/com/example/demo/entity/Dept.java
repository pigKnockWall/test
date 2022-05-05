package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Dept extends Model<Dept> {
    //uuid
    @TableId(value = "id",type= IdType.UUID)
    private String id;
    private String name;
    private String mobile;
    private Integer manager;
}
