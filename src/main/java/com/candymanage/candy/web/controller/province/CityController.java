package com.candymanage.candy.web.controller.province;

import com.candymanage.candy.service.province.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hyb
 * @Description candy
 * @Date 2019/07/15 17:58
 */

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    CityService cityService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object getCity(@RequestParam Integer provinceCode) {
        return cityService.getCtiyList(provinceCode);
    }
}
