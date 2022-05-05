package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Cloneable{
    //@TableId(value = "id",type = IdType.ID_WORKER)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String status;

    @Override
    public Object clone(){

        return this;
    }
}
