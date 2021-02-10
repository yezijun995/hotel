package edu.fdzc.hotel.service.service.impl;

import edu.fdzc.hotel.mapper.CheckInMapper;
import edu.fdzc.hotel.po.CheckIn;
import edu.fdzc.hotel.service.CheckInService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 入住退房登记表(CheckIn)表服务实现类
 *
 * @author yezj
 * @since 2021-02-10 17:57:28
 */
@Service("checkInService")
public class CheckInServiceImpl implements CheckInService {
    @Resource
    private CheckInMapper checkInMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CheckIn queryById(Long id) {
        return this.checkInMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CheckIn> queryAllByLimit(int offset, int limit) {
        return this.checkInMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param checkIn 实例对象
     * @return 实例对象
     */
    @Override
    public CheckIn insert(CheckIn checkIn) {
        this.checkInMapper.insert(checkIn);
        return checkIn;
    }

    /**
     * 修改数据
     *
     * @param checkIn 实例对象
     * @return 实例对象
     */
    @Override
    public CheckIn update(CheckIn checkIn) {
        this.checkInMapper.update(checkIn);
        return this.queryById(checkIn.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.checkInMapper.deleteById(id) > 0;
    }
}
