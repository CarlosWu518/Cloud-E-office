package org.carlos.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.carlos.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CarlosWu
 * @since 2021-03-13
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 根据用户id查询菜单列表
     * @return
     */
    List<Menu> getMenusByAdminId();
}
