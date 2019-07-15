package com.candymanage.candy.web.controller.province;

import com.candymanage.candy.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hyb
 * @Description candy
 * @Date 2019/07/15 17:38
 */
@RestController
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Object getProvince() {
        return provinceService.getProvince();
    }
}
