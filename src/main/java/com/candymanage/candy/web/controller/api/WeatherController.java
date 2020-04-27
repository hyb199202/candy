package com.candymanage.candy.web.controller.api;

import com.candymanage.candy.service.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hyb
 * @Description candy
 * @Date 2019/08/28 14:21
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @RequestMapping(value = "/cityWeather", method = RequestMethod.POST)
    public Object getCity(@RequestParam String provinceCode) {
        String weather = weatherService.weatherForecast(provinceCode);
        return weather;
    }

}
