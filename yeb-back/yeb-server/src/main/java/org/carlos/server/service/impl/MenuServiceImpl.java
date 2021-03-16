package org.carlos.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.carlos.server.mapper.MenuMapper;
import org.carlos.server.pojo.Menu;
import org.carlos.server.service.IMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CarlosWu
 * @since 2021-03-13
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
