package edu.fdzc.hotel.service.impl;

import edu.fdzc.hotel.mapper.WorkerMapper;
import edu.fdzc.hotel.po.Worker;
import edu.fdzc.hotel.service.IWorkerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Worker)表服务实现类
 *
 * @author yezj
 * @since 2021-02-10 17:57:34
 */
@Service("workerService")
public class WorkerServiceImpl implements IWorkerService {
    @Resource
    private WorkerMapper workerMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Worker queryById(Long id) {
        return this.workerMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Worker> queryAllByLimit(int offset, int limit) {
        return this.workerMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param worker 实例对象
     * @return 实例对象
     */
    @Override
    public Worker insert(Worker worker) {
        this.workerMapper.insert(worker);
        return worker;
    }

    /**
     * 修改数据
     *
     * @param worker 实例对象
     * @return 实例对象
     */
    @Override
    public Worker update(Worker worker) {
        this.workerMapper.update(worker);
        return this.queryById(worker.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.workerMapper.deleteById(id) > 0;
    }
}
