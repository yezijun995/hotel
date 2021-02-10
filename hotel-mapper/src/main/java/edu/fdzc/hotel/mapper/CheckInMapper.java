package edu.fdzc.hotel.mapper;

import edu.fdzc.hotel.po.CheckIn;
import org.apache.ibatis.annotations.Param;

import java.util.List;



/**
 * 入住退房登记表(CheckIn)表数据库访问层
 *
 * @author yezj
 * @since 2021-02-10 16:51:35
 */
public interface CheckInMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CheckIn queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CheckIn> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param checkIn 实例对象
     * @return 对象列表
     */
    List<CheckIn> queryAll(CheckIn checkIn);

    /**
     * 新增数据
     *
     * @param checkIn 实例对象
     * @return 影响行数
     */
    int insert(CheckIn checkIn);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CheckIn> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CheckIn> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CheckIn> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<CheckIn> entities);

    /**
     * 修改数据
     *
     * @param checkIn 实例对象
     * @return 影响行数
     */
    int update(CheckIn checkIn);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

