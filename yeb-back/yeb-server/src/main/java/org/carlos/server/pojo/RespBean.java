package org.carlos.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @Description: 公用返回对象
 * @Author: CarlosWu
 * @Date: 2021/3/13 21:38
 * @Version: 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object obj;

    /*
    * 成功返回结果
    * */
    public static  RespBean success(String message){
     return new RespBean(200,message,null);
 }

    /*
    * 成功返回结果
    * */
    public static  RespBean success(String message,Object obj){
        return new RespBean(200,message,obj);
    }
    /*
    * 返回失败结果
    * */
    public static RespBean error(String message){
        return new RespBean(500,message,null);
    }
    /*
     * 返回失败结果
     * */
    public static  RespBean error(String message,Object obj){
        return new RespBean(500,message,obj);
    }
}
