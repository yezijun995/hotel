package edu.fdzc.hotel.common.exception.user;

import edu.fdzc.hotel.common.exception.BaseException;

/**
 * 用户信息异常类
 * 
 * @author yifelix
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
