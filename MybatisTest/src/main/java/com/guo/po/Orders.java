package com.guo.po;
import lombok.Data;
import java.util.Date;
@Data
public class Orders {
    private Integer id;
    private Integer userid;
    private String username;
    private Date createtime;
    private String note;
    private String number;
    private User user;

}
