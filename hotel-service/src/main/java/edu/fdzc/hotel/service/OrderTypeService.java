package edu.fdzc.hotel.service;

import edu.fdzc.hotel.po.OrderType;

import java.util.List;

/**
 * 订单类型表(OrderType)表服务接口
 *
 * @author yezj
 * @since 2021-02-10 17:54:08
 */
public interface OrderTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderType queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<OrderType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param orderType 实例对象
     * @return 实例对象
     */
    OrderType insert(OrderType orderType);

    /**
     * 修改数据
     *
     * @param orderType 实例对象
     * @return 实例对象
     */
    OrderType update(OrderType orderType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
