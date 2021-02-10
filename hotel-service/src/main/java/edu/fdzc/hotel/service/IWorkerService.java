package edu.fdzc.hotel.service;

import edu.fdzc.hotel.po.Worker;

import java.util.List;

/**
 * (Worker)表服务接口
 *
 * @author yezj
 * @since 2021-02-10 17:54:11
 */
public interface IWorkerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Worker queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Worker> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param worker 实例对象
     * @return 实例对象
     */
    Worker insert(Worker worker);

    /**
     * 修改数据
     *
     * @param worker 实例对象
     * @return 实例对象
     */
    Worker update(Worker worker);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
