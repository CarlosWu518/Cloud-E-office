package org.carlos.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.carlos.server.mapper.DepartmentMapper;
import org.carlos.server.pojo.Department;
import org.carlos.server.service.IDepartmentService;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
