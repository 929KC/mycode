package com.kc.cloudsearch;

import cn.hutool.http.HttpRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CrawlerTest {
    @Test
    public void testFetchPassage() {
        String json = "{\"sortField\":\"createTime\",\"sortOrder\":\"descend\",\"reviewStatus\":1,\"current\":1}";
        String url = "https://www.code-nav.cn/api/post/list/page/vo";
        String result = HttpRequest.
                post(url).
                body(json).
                execute().
                body();
        System.out.println(result);
    }
}
