package edu.fdzc.hotel.system.service.impl;

import edu.fdzc.hotel.common.constant.UserConstants;
import edu.fdzc.hotel.common.core.domain.entity.SysAccount;
import edu.fdzc.hotel.common.utils.DateUtils;
import edu.fdzc.hotel.system.mapper.SysAccountMapper;
import edu.fdzc.hotel.system.service.ISysAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author yezj
 * @date 2021/3/13 23:59
 */
@Slf4j
@Service
public class SysAccountServiceImpl implements ISysAccountService {

    @Autowired
    private SysAccountMapper sysAccountMapper;

    @Override
    public SysAccount selectAccountByAccountName(String accountName) {
        return sysAccountMapper.selectAccountByAccountName(accountName);
    }

    /**
     * 查询客户
     *
     * @param accountId 客户ID
     * @return 客户
     */
    @Override
    public SysAccount selectSysAccountById(Long accountId) {
        return sysAccountMapper.selectSysAccountById(accountId);
    }

    /**
     * 查询客户列表
     *
     * @param sysAccount 客户
     * @return 客户
     */
    @Override
    public List<SysAccount> selectSysAccountList(SysAccount sysAccount) {
        return sysAccountMapper.selectSysAccountList(sysAccount);
    }

    /**
     * 新增客户
     *
     * @param sysAccount 客户
     * @return 结果
     */
    @Override
    public int insertSysAccount(SysAccount sysAccount) {
        sysAccount.setCreateTime(DateUtils.getNowDate());
        return sysAccountMapper.insertSysAccount(sysAccount);
    }

    /**
     * 修改客户
     *
     * @param sysAccount 客户
     * @return 结果
     */
    @Override
    public int updateSysAccount(SysAccount sysAccount) {
        sysAccount.setUpdateTime(DateUtils.getNowDate());
        return sysAccountMapper.updateSysAccount(sysAccount);
    }

    /**
     * 批量删除客户
     *
     * @param accountIds 需要删除的客户ID
     * @return 结果
     */
    @Override
    public int deleteSysAccountByIds(Long[] accountIds) {
        return sysAccountMapper.deleteSysAccountByIds(accountIds);
    }

    /**
     * 删除客户信息
     *
     * @param accountId 客户ID
     * @return 结果
     */
    @Override
    public int deleteSysAccountById(Long accountId) {
        return sysAccountMapper.deleteSysAccountById(accountId);
    }

    @Override
    public String checkAccountNameUnique(String accountName) {
        int count = sysAccountMapper.checkAccountNameUnique(accountName);
        if (count > 0) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public String checkPhoneUnique(SysAccount account) {
        Long accountId = Objects.isNull(account.getAccountId()) ? -1L : account.getAccountId();
        SysAccount sysAccount = sysAccountMapper.checkPhoneUnique(account.getPhone());
        if (Objects.nonNull(sysAccount) && sysAccount.getAccountId().longValue() != accountId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }


    @Override
    public String checkEmailUnique(SysAccount account) {
        Long accountId = Objects.isNull(account.getAccountId()) ? -1L : account.getAccountId();
        SysAccount sysAccount = sysAccountMapper.checkEmailUnique(account.getEmail());
        if (Objects.nonNull(sysAccount) && sysAccount.getAccountId().longValue() != accountId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }
}
