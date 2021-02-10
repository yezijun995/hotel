package edu.fdzc.hotel.configuration;

import com.zpaas.utils.Md5Util;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * MD5加密验证
 *
 * @author yezj
 * @date 2021/2/10 19:11
 */
public class MD5PwdEncoder implements PasswordEncoder {

    private static final String salt = "yifelix";

    public MD5PwdEncoder() {
    }

    @Override
    public String encode(CharSequence charSequence) {
        String s = salt + charSequence.toString();
        String newpwd = Md5Util.encode(s).toUpperCase();
        return newpwd;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        String encPass = salt + charSequence.toString();
        return Md5Util.isPasswordValid(s.toLowerCase(),encPass);
    }
}
