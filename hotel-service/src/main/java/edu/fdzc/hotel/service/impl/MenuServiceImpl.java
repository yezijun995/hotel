package edu.fdzc.hotel.service.impl;

import edu.fdzc.hotel.mapper.MenuMapper;
import edu.fdzc.hotel.po.Menu;
import edu.fdzc.hotel.service.IMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Menu)表服务实现类
 *
 * @author yezj
 * @since 2021-02-10 17:57:30
 */
@Service("menuService")
public class MenuServiceImpl implements IMenuService {
    @Resource
    private MenuMapper menuMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Menu queryById(Long id) {
        this.menuMapper.queryById(id);
        return this.menuMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Menu> queryAllByLimit(int offset, int limit) {
        return this.menuMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public Menu insert(Menu menu) {
        this.menuMapper.insert(menu);
        return menu;
    }

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public Menu update(Menu menu) {
        this.menuMapper.update(menu);
        return this.queryById(menu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.menuMapper.deleteById(id) > 0;
    }

    @Override
    public List<Menu> queryAllMenu() {
        return this.menuMapper.queryAllMenu();
    }
}
