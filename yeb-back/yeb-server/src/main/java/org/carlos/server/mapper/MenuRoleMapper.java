package org.carlos.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.carlos.server.pojo.MenuRole;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CarlosWu
 * @since 2021-03-13
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     */
    Integer insertRecord(@Param("rid") Integer rid,@Param("mids") Integer[] mids);
}
