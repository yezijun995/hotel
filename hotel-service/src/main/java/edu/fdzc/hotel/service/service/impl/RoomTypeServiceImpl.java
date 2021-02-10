package edu.fdzc.hotel.service.service.impl;

import edu.fdzc.hotel.mapper.RoomTypeMapper;
import edu.fdzc.hotel.po.RoomType;
import edu.fdzc.hotel.service.RoomTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 房间类型表(RoomType)表服务实现类
 *
 * @author yezj
 * @since 2021-02-10 17:57:31
 */
@Service("roomTypeService")
public class RoomTypeServiceImpl implements RoomTypeService {
    @Resource
    private RoomTypeMapper roomTypeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RoomType queryById(Long id) {
        return this.roomTypeMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<RoomType> queryAllByLimit(int offset, int limit) {
        return this.roomTypeMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param roomType 实例对象
     * @return 实例对象
     */
    @Override
    public RoomType insert(RoomType roomType) {
        this.roomTypeMapper.insert(roomType);
        return roomType;
    }

    /**
     * 修改数据
     *
     * @param roomType 实例对象
     * @return 实例对象
     */
    @Override
    public RoomType update(RoomType roomType) {
        this.roomTypeMapper.update(roomType);
        return this.queryById(roomType.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.roomTypeMapper.deleteById(id) > 0;
    }
}
