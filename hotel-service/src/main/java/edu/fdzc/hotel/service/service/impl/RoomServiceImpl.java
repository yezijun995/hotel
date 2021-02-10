package edu.fdzc.hotel.service.service.impl;

import edu.fdzc.hotel.mapper.RoomMapper;
import edu.fdzc.hotel.po.Room;
import edu.fdzc.hotel.service.RoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Room)表服务实现类
 *
 * @author yezj
 * @since 2021-02-10 17:57:31
 */
@Service("roomService")
public class RoomServiceImpl implements RoomService {
    @Resource
    private RoomMapper roomMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Room queryById(Long id) {
        return this.roomMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Room> queryAllByLimit(int offset, int limit) {
        return this.roomMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param room 实例对象
     * @return 实例对象
     */
    @Override
    public Room insert(Room room) {
        this.roomMapper.insert(room);
        return room;
    }

    /**
     * 修改数据
     *
     * @param room 实例对象
     * @return 实例对象
     */
    @Override
    public Room update(Room room) {
        this.roomMapper.update(room);
        return this.queryById(room.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.roomMapper.deleteById(id) > 0;
    }
}
