package org.carlos.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.carlos.server.pojo.MenuRole;
import org.carlos.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CarlosWu
 * @since 2021-03-13
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
