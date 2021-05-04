package org.carlos.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.carlos.server.pojo.Role;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CarlosWu
 * @since 2021-03-13
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据用户id查询角色列表
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);
}
