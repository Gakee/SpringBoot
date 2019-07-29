package com.xin.test;

import com.xin.ElasticApplication;
import com.xin.dao.ItemRepository;
import com.xin.pojo.Item;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticApplication.class)
public class Tests {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    ItemRepository itemRepository;

    /**
     * 创建索引
     */
    @Test
    public void testCreateIndex(){
        elasticsearchTemplate.createIndex(Item.class);
    }

    /**
     * 删除索引
     */
    @Test
    public void testDelIndex(){
        boolean b = elasticsearchTemplate.deleteIndex(Item.class);
        System.out.println("b = " + b);
    }

    /**
     * 插入
     */
    @Test
    public void testInsert(){
        Item item = new Item(1L, "小米手机7", " 手机",
                "小米", 3499.00, "http://image.baidu.com/13123.jpg");

        Item save = itemRepository.save(item);
        System.out.println("save = " + save);
    }

    @Test
    public void insertList() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(2L, "坚果手机R1", " 手机", "锤子", 3699.00, "http://image.baidu.com/13123.jpg"));
        list.add(new Item(3L, "华为META10", " 手机", "华为", 4499.00, "http://image.baidu.com/13123.jpg"));
        list.add(new Item(1L, "小米手机7", "手机", "小米", 3299.00, "http://image.baidu.com/13123.jpg"));
        list.add(new Item(6L, "坚果手机R1", "手机", "锤子", 3699.00, "http://image.baidu.com/13123.jpg"));
        list.add(new Item(7L, "华为META10", "手机", "华为", 4499.00, "http://image.baidu.com/13123.jpg"));
        list.add(new Item(4L, "小米Mix2S", "手机", "小米", 4299.00, "http://image.baidu.com/13123.jpg"));
        list.add(new Item(5L, "荣耀V10", "手机", "华为", 2799.00, "http://image.baidu.com/13123.jpg"));

        // 接收对象集合，实现批量新增
        itemRepository.saveAll(list);
    }

    /**
     * update
     */
    @Test
    public void testUpdate(){
        Item item = new Item(1L, "苹果XSMax", " 手机",
                "小米", 3499.00, "http://image.baidu.com/13123.jpg");
        Item save = itemRepository.save(item);
        System.out.println("save = " + save);
    }

    /**
     * 查询所有
     */
    @Test
    public void testFindAll(){
        Iterable<Item> price = itemRepository.findAll(Sort.by("price").ascending());
        for (Item item : price) {
            System.out.println("item = " + item);
        }
    }

    @Test
    public void queryByPriceBetween(){
        List<Item> list = this.itemRepository.findByPriceBetween(2000.00, 3500.00);
        for (Item item : list) {
            System.out.println("item = " + item);
        }
    }

    @Test
    public void testMatchQuery(){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "小米手机"));
        // 搜索，获取结果
        Page<Item> items = this.itemRepository.search(queryBuilder.build());
        // 总条数
        long total = items.getTotalElements();
        System.out.println("total = " + total);
        for (Item item : items) {
            System.out.println(item);
        }
    }

    @Test
    public void testMathQuery(){
        // 创建对象
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 在queryBuilder对象中自定义查询
        //matchQuery:底层就是使用的termQuery
        queryBuilder.withQuery(QueryBuilders.matchQuery("title","坚果"));
        //查询，search 默认就是分页查找
        Page<Item> page = this.itemRepository.search(queryBuilder.build());
        //获取数据
        long totalElements = page.getTotalElements();
        System.out.println("获取的总条数:"+totalElements);

        for(Item item:page){
            System.out.println(item);
        }


    }


    /**
     * termQuery:功能更强大，除了匹配字符串以外，还可以匹配
     * int/long/double/float/....
     */
    @Test
    public void testTermQuery(){
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withQuery(QueryBuilders.termQuery("price",998.0));
        // 查找
        Page<Item> page = this.itemRepository.search(builder.build());

        for(Item item:page){
            System.out.println(item);
        }
    }
    /**
     * 布尔查询
     */
    @Test
    public void testBooleanQuery(){
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();

        builder.withQuery(
                QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("title","华为"))
                        .must(QueryBuilders.matchQuery("brand","华为"))
        );

        // 查找
        Page<Item> page = this.itemRepository.search(builder.build());
        for(Item item:page){
            System.out.println(item);
        }
    }

    /**
     * 模糊查询
     */
    @Test
    public void testFuzzyQuery(){
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withQuery(QueryBuilders.fuzzyQuery("title","faceoooo"));
        Page<Item> page = this.itemRepository.search(builder.build());
        for(Item item:page){
            System.out.println(item);
        }

    }

    @Test
    public void searchByPage(){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.termQuery("category", "手机"));
        // 分页：
        int page = 0;
        int size = 2;
        queryBuilder.withPageable(PageRequest.of(page,size));

        // 搜索，获取结果
        Page<Item> items = this.itemRepository.search(queryBuilder.build());
        // 总条数
        long total = items.getTotalElements();
        System.out.println("总条数 = " + total);
        // 总页数
        System.out.println("总页数 = " + items.getTotalPages());
        // 当前页
        System.out.println("当前页：" + items.getNumber());
        // 每页大小
        System.out.println("每页大小：" + items.getSize());

        for (Item item : items) {
            System.out.println(item);
        }
    }



}
