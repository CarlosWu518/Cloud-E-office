package org.carlos.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.carlos.server.mapper.EmployeeMapper;
import org.carlos.server.pojo.Employee;
import org.carlos.server.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
