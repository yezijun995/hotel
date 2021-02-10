package edu.fdzc.hotel.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

.dao;
        .entity.OrderType;

/**
 * 订单类型表(OrderType)表数据库访问层
 *
 * @author makejava
 * @since 2021-02-10 16:47:41
 */
public interface OrderTypeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderType queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<OrderType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param orderType 实例对象
     * @return 对象列表
     */
    List<OrderType> queryAll(OrderType orderType);

    /**
     * 新增数据
     *
     * @param orderType 实例对象
     * @return 影响行数
     */
    int insert(OrderType orderType);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderType> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OrderType> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderType> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<OrderType> entities);

    /**
     * 修改数据
     *
     * @param orderType 实例对象
     * @return 影响行数
     */
    int update(OrderType orderType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

