package com.xin.test;

import com.xin.ESApplication;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ESApplication.class)
public class TestDemo {
    @Autowired
    private RestHighLevelClient client;

    /**
     * 创建索引
     */
    @Test
    public void createIndex(){
        CreateIndexRequest request = new CreateIndexRequest("cars");
        request.settings(Settings.builder()
                .put("index.number_of_shards", 2)
                );
        request.mapping("transaction",
                "  {\n" +
                        "    \"transaction\": {\n" +
                        "      \"properties\": {\n" +
                        "        \"message\": {\n" +
                        "          \"type\": \"text\"\n" +
                        "        }\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }",//类型映射，需要的是一个JSON字符串
                XContentType.JSON
                );
    }


}
