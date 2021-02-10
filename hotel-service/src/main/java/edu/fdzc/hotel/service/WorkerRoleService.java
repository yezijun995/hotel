package edu.fdzc.hotel.service;

import edu.fdzc.hotel.po.WorkerRole;

import java.util.List;

/**
 * (WorkerRole)表服务接口
 *
 * @author makejava
 * @since 2021-02-10 17:54:11
 */
public interface WorkerRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WorkerRole queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<WorkerRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param workerRole 实例对象
     * @return 实例对象
     */
    WorkerRole insert(WorkerRole workerRole);

    /**
     * 修改数据
     *
     * @param workerRole 实例对象
     * @return 实例对象
     */
    WorkerRole update(WorkerRole workerRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
