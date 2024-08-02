package com.hauhh.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String sno;

    private String name;

    private String sex;


}
