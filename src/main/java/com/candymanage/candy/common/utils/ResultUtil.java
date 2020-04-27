package com.candymanage.candy.common.utils;

import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @Author hyb
 * @Description candy
 * @Date 2019/08/30 18:59
 * @Dec
 */
public class ResultUtil {

    //结果信息

    public static String result(String code, Map<String, Object> map, List<Map<String, Object>> list) {
        JSONObject json = new JSONObject();
        if ("0".equals(code)) {
            json.put("rtnMsg", "成功");
            json.put("rtnCode", "0");
        } else {
            json.put("rtnMsg", "失败");
            json.put("rtnCode", "9999");
        }
        json.put("beans", list);
        json.put("object", map);
        return json.toString();
    }
}
