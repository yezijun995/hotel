package edu.fdzc.hotel.common.exception.file;

import edu.fdzc.hotel.common.exception.BaseException;

/**
 * 文件信息异常类
 * 
 * @author yifelix
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
