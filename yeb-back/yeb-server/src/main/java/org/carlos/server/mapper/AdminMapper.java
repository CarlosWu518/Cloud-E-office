package org.carlos.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.carlos.server.pojo.Admin;
import org.carlos.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CarlosWu
 * @since 2021-03-13
 */
public interface AdminMapper extends BaseMapper<Admin> {
    /**
     * 通过用户id查询菜单列表
     * @param id
     * @return
     */
}
