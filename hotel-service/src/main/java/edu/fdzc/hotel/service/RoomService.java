package edu.fdzc.hotel.service;

import edu.fdzc.hotel.po.Room;

import java.util.List;

/**
 * (Room)表服务接口
 *
 * @author makejava
 * @since 2021-02-10 17:54:08
 */
public interface RoomService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Room queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Room> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param room 实例对象
     * @return 实例对象
     */
    Room insert(Room room);

    /**
     * 修改数据
     *
     * @param room 实例对象
     * @return 实例对象
     */
    Room update(Room room);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
