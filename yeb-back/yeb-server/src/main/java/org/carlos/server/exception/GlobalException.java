package org.carlos.server.exception;

import org.carlos.server.pojo.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/*
 * @Description:全局异常处理
 * @Author: CarlosWu
 * @Date: 2021/5/5 15:07
 * @Version: 0.0.1
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(SQLException.class)
    public RespBean mySqlException(SQLException e){
        if (e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("该数据有关联数据，操作失败！");
        }
        return RespBean.error("数据库异常，操作失败！");
    }
}
