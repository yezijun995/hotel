package edu.fdzc.hotel.service.service.impl;

import edu.fdzc.hotel.mapper.OrderTypeMapper;
import edu.fdzc.hotel.po.OrderType;
import edu.fdzc.hotel.service.OrderTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单类型表(OrderType)表服务实现类
 *
 * @author makejava
 * @since 2021-02-10 17:57:31
 */
@Service("orderTypeService")
public class OrderTypeServiceImpl implements OrderTypeService {
    @Resource
    private OrderTypeMapper orderTypeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrderType queryById(Long id) {
        return this.orderTypeMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<OrderType> queryAllByLimit(int offset, int limit) {
        return this.orderTypeMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param orderType 实例对象
     * @return 实例对象
     */
    @Override
    public OrderType insert(OrderType orderType) {
        this.orderTypeMapper.insert(orderType);
        return orderType;
    }

    /**
     * 修改数据
     *
     * @param orderType 实例对象
     * @return 实例对象
     */
    @Override
    public OrderType update(OrderType orderType) {
        this.orderTypeMapper.update(orderType);
        return this.queryById(orderType.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.orderTypeMapper.deleteById(id) > 0;
    }
}
