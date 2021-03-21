package edu.fdzc.hotel.system.service;

import edu.fdzc.hotel.common.core.domain.entity.SysAccount;

import java.util.List;

/**
 * 客户业务层
 * @author yezj
 * @date 2021/3/13 16:33
 */
public interface ISysAccountService {

    /**
     * 通过用户名查询用户
     *
     * @param accountName 用户名
     * @return 用户对象信息
     */
    SysAccount selectAccountByAccountName(String accountName);

    /**
     * 查询客户
     *
     * @param accountId 客户ID
     * @return 客户
     */
    SysAccount selectSysAccountById(Long accountId);

    /**
     * 查询客户列表
     *
     * @param sysAccount 客户
     * @return 客户集合
     */
    List<SysAccount> selectSysAccountList(SysAccount sysAccount);

    /**
     * 新增客户
     *
     * @param sysAccount 客户
     * @return 结果
     */
    int insertSysAccount(SysAccount sysAccount);

    /**
     * 修改客户
     *
     * @param sysAccount 客户
     * @return 结果
     */
    int updateSysAccount(SysAccount sysAccount);

    /**
     * 批量删除客户
     *
     * @param accountIds 需要删除的客户ID
     * @return 结果
     */
    int deleteSysAccountByIds(Long[] accountIds);

    /**
     * 删除客户信息
     *
     * @param accountId 客户ID
     * @return 结果
     */
    int deleteSysAccountById(Long accountId);

    /**
     * 校验用户名称是否唯一
     *
     * @param accountName 用户名称
     * @return 结果
     */
    public String checkAccountNameUnique(String accountName);

    /**
     * 校验手机号码是否唯一
     *
     * @param account 用户信息
     * @return 结果
     */
    String checkPhoneUnique(SysAccount account);

    /**
     * 校验email是否唯一
     *
     * @param account 用户信息
     * @return 结果
     */
    String checkEmailUnique(SysAccount account);
}
