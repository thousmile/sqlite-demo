package com.ifsaid.sqlite;

import com.ifsaid.sqlite.entity.DetectClass;
import com.ifsaid.sqlite.service.DetectClassService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SqliteDemoApplicationTests {

    @Autowired
    private DetectClassService service;

    @Test
    public void contextLoads() {
        var list = new ArrayList<DetectClass>();
        for (int i = 100001; i < 101000; i++) {
            DetectClass detectClass = new DetectClass(
                    i,
                    getRandomString(5),
                    getRandomString(10),
                    getRandomString(15),
                    System.currentTimeMillis(),
                    System.currentTimeMillis()
            );
            list.add(detectClass);
            if (list.size() == 50) {
                Integer result = service.batchSave(list);
                log.info("batchSave result: {}", result);
                list.clear();
                continue;
            }
        }
    }

    //可以指定字符串的某个位置是什么范围的值
    public static String getRandomString(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(3);
            long result = 0;
            switch (number) {
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    sb.append(String.valueOf((char) result));
                    break;
                case 1:
                    result = Math.round(Math.random() * 25 + 97);
                    sb.append(String.valueOf((char) result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }
        }
        return sb.toString();
    }

}
