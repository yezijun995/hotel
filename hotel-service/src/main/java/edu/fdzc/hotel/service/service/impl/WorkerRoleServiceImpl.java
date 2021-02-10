package edu.fdzc.hotel.service.service.impl;

import edu.fdzc.hotel.mapper.WorkerRoleMapper;
import edu.fdzc.hotel.po.WorkerRole;
import edu.fdzc.hotel.service.WorkerRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (WorkerRole)表服务实现类
 *
 * @author makejava
 * @since 2021-02-10 17:57:34
 */
@Service("workerRoleService")
public class WorkerRoleServiceImpl implements WorkerRoleService {
    @Resource
    private WorkerRoleMapper workerRoleMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public WorkerRole queryById(Long id) {
        return this.workerRoleMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<WorkerRole> queryAllByLimit(int offset, int limit) {
        return this.workerRoleMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param workerRole 实例对象
     * @return 实例对象
     */
    @Override
    public WorkerRole insert(WorkerRole workerRole) {
        this.workerRoleMapper.insert(workerRole);
        return workerRole;
    }

    /**
     * 修改数据
     *
     * @param workerRole 实例对象
     * @return 实例对象
     */
    @Override
    public WorkerRole update(WorkerRole workerRole) {
        this.workerRoleMapper.update(workerRole);
        return this.queryById(workerRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.workerRoleMapper.deleteById(id) > 0;
    }
}
