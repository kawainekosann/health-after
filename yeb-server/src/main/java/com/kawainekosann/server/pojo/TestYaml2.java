package com.kawainekosann.server.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
@Data
@ConstructorBinding
@Validated
public class TestYaml2 {
    private String str;
    private int num;
    private double Dnum;
    private Date birth;
    private List<String> list;
    private Set<String> set;
    private Map<String, String> map;
    private List<User> users;

}
