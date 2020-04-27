package com.candymanage.candy.service.province;

import com.candymanage.candy.bean.province.City;

import java.util.List;

/**
 * @Author hyb
 * @Description candy
 * @Date 2019/07/15 17:55
 */
public interface CityService {
    List<City> getCtiyList(Integer pCode);

    String getCtiy(String cityCode);
}
