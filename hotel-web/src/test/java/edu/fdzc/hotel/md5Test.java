package edu.fdzc.hotel;

import com.zpaas.utils.Md5Util;
import edu.fdzc.hotel.util.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yezj
 * @date 2021/2/10 19:24
 */
@SpringBootTest
@Slf4j
public class md5Test {

    private static final String salt = "yifelix";

    @Test
    void test1() {
        String s = salt + "123456";
        String newpwd = Md5Util.encode(s).toUpperCase();
        log.info("密码为:{}", newpwd);
    }
}
