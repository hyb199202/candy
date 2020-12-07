package ad;

import com.candymanage.candy.bean.User;
import com.candymanage.RedisUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @packageName: candy
 * @author: hyb
 * @date: 2020-09-14 下午 5:36
 * @description:
 */
@SpringBootTest
public class TestDemo {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void setRedis() {
        User user = new User();
        user.setName("json");
        user.setAge(19);
        user.setWork("coder");
        redisUtil.set("data", user);
    }
}
