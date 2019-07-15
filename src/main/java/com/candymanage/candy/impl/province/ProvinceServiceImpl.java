package com.candymanage.candy.impl.province;

import com.candymanage.candy.bean.province.Province;
import com.candymanage.candy.dao.province.ProvinceDAO;
import com.candymanage.candy.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hyb
 * @Description candy
 * @Date 2019/07/15 17:31
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceDAO provinceDAO;

    @Override
    public List<Province> getProvince() {
        List<Province> list = provinceDAO.getProvince();
        return list;
    }
}
