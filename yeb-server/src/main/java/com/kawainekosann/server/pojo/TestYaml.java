package com.kawainekosann.server.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

//lombok自动getter setter
@Data
///@Component
@ConstructorBinding
//配置文件中前缀为yaml的资源 可以省略prefix =
@ConfigurationProperties(prefix = "yaml.level")
//进行校验
@Validated
public class TestYaml {
    //@Setter
    //@Getter

    @NotNull(message = "请输入年龄")
    //@Email
    //hibernate 里面的校验
    private String str;
    //hibernate 里面的校验
    //@Max(35)
    @Range(message = "年龄范围为 {min} 到 {max} 之间", min = 1, max = 999)
    private int num;
    private double Dnum;
    private Date birth;
    private List<String> list;
    private Set<String> set;
    private Map<String, String> map;
    private List<User> users;

    @Override
    public String toString() {
        return "TestYaml{" +
                "str='" + str + '\'' +
                ", num=" + num +
                ", Dnum=" + Dnum +
                ", birth=" + birth +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", users=" + users +
                '}';
    }
}
