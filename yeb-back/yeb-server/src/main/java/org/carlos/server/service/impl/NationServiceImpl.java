package org.carlos.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.carlos.server.mapper.NationMapper;
import org.carlos.server.pojo.Nation;
import org.carlos.server.service.INationService;
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
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

}
