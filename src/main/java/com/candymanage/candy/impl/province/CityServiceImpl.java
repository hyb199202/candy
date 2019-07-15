package com.candymanage.candy.impl.province;

import com.candymanage.candy.bean.province.City;
import com.candymanage.candy.dao.province.CityDAO;
import com.candymanage.candy.service.province.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hyb
 * @Description candy
 * @Date 2019/07/15 17:56
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityDAO cityDAO;

    @Override
    public List<City> getCtiyList(Integer pCode) {
        return cityDAO.getCtiyList(pCode);
    }
}
