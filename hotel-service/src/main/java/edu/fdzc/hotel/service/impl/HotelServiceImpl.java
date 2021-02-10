package edu.fdzc.hotel.service.impl;

import edu.fdzc.hotel.mapper.HotelMapper;
import edu.fdzc.hotel.po.Hotel;
import edu.fdzc.hotel.service.IHotelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Hotel)表服务实现类
 *
 * @author yezj
 * @since 2021-02-10 17:57:29
 */
@Service("hotelService")
public class HotelServiceImpl implements IHotelService {
    @Resource
    private HotelMapper hotelMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Hotel queryById(Long id) {
        return this.hotelMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Hotel> queryAllByLimit(int offset, int limit) {
        return this.hotelMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param hotel 实例对象
     * @return 实例对象
     */
    @Override
    public Hotel insert(Hotel hotel) {
        this.hotelMapper.insert(hotel);
        return hotel;
    }

    /**
     * 修改数据
     *
     * @param hotel 实例对象
     * @return 实例对象
     */
    @Override
    public Hotel update(Hotel hotel) {
        this.hotelMapper.update(hotel);
        return this.queryById(hotel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.hotelMapper.deleteById(id) > 0;
    }
}
