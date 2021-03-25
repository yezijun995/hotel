package edu.fdzc.hotel.system.mapper;

import edu.fdzc.hotel.common.core.domain.entity.SysAccount;

import java.util.List;

/**
 * @author yezj
 * @date 2021/3/14 0:00
 */
public interface SysAccountMapper {

    /**
     * 查询客户
     *
     * @param accountId 客户ID
     * @return 客户
     */
    public SysAccount selectSysAccountById(Long accountId);

    /**
     * 通过用户名查询客户
     * @param accountName
     * @return
     */
    SysAccount selectAccountByAccountName(String accountName);

    /**
     * 查询客户列表
     *
     * @param sysAccount 客户
     * @return 客户集合
     */
    public List<SysAccount> selectSysAccountList(SysAccount sysAccount);

    /**
     * 新增客户
     *
     * @param sysAccount 客户
     * @return 结果
     */
    public int insertSysAccount(SysAccount sysAccount);

    /**
     * 修改客户
     *
     * @param sysAccount 客户
     * @return 结果
     */
    public int updateSysAccount(SysAccount sysAccount);

    /**
     * 删除客户
     *
     * @param accountId 客户ID
     * @return 结果
     */
    public int deleteSysAccountById(Long accountId);

    /**
     * 批量删除客户
     *
     * @param accountIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysAccountByIds(Long[] accountIds);

    /**
     * 校验用户名称是否唯一
     *
     * @param accountName 用户名称
     * @return 结果
     */
    int checkAccountNameUnique(String accountName);

    /**
     * 校验手机号码是否唯一
     *
     * @param phone 手机号码
     * @return 结果
     */
    SysAccount checkPhoneUnique(String phone);

    /**
     * 校验email是否唯一
     *
     * @param email 用户邮箱
     * @return 结果
     */
    SysAccount checkEmailUnique(String email);

    /**
     * 获取用户数
     * @return
     */
    Long getAccountCount();
}
