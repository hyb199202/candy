package com.candymanage.common;

import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbMakerConfigException;
import org.lionsoul.ip2region.DbSearcher;

import java.io.FileNotFoundException;

/**
 * @author: hyb
 * @date: 2020-07-17 上午 9:53
 * @description:
 */
public class IP2RegionTest {
    public static void main(String[] args) {
        String ip = "223.88.1.83";
        try {
            //根据IP进行位置搜索
            DbConfig config = new DbConfig();
            //获取ip库的位置（放到src）（直接通过测试类获取文件Ip2RegionTest为测试类）
            String dbfile = IP2RegionTest.class.getResource("/ip2region.db").getPath();
            //
            DbSearcher searcher = new DbSearcher(config,dbfile);
            //采用Btree 搜索
            DataBlock block =searcher.btreeSearch(ip);
            //打印位置信息（格式：国家|大区|省份|城市|运营商）
            System.out.println(block.getRegion());

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
