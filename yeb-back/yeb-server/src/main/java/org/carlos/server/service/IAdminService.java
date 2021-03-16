package org.carlos.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.carlos.server.pojo.Admin;
import org.carlos.server.pojo.Menu;
import org.carlos.server.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CarlosWu
 * @since 2021-03-13
 */
public interface IAdminService extends IService<Admin> {
    /*
     * 登录之后返回token
     * */
    RespBean login(String username, String password, String code,HttpServletRequest request);

    /*
     * 根据用户名获取用户
     * */
    Admin getAdminByUserName(String username);

}
