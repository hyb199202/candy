package com.candymanage.candy.impl.weather;

import com.candymanage.candy.bean.province.City;
import com.candymanage.candy.common.utils.HttpUtil;
import com.candymanage.candy.common.utils.ResultUtil;
import com.candymanage.candy.common.utils.StringUtil;
import com.candymanage.candy.service.province.CityService;
import com.candymanage.candy.service.weather.WeatherService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author hyb
 * @Description candy
 * @Date 2019/08/28 14:36
 * 天气
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    private static final String url = "https://gaode.com/service/weather?adcode=";
    @Autowired
    CityService cityService;

    @Override
    public String weatherForecast(String provinceCode) {
        // String provinceCode = json.optString("provinceCode");
        String response = HttpUtil.httpGetJson(url, provinceCode);
        JSONObject resultMap = new JSONObject();
        resultMap.put("resultCode", "-1");
        resultMap.put("resultMsg", "失败");
        JSONObject dateJson = JSONObject.fromObject(response);
        if (StringUtil.isEmpty(response)) {
            return ResultUtil.result("0", resultMap, null);
        }
        //获取天气信息
        JSONObject data = dateJson.optJSONObject("data");
        JSONArray dataArray = data.optJSONArray("data");
        if (StringUtil.isNotEmpty(dataArray)) {
            JSONObject todayDate = dataArray.optJSONObject(0);
            JSONObject live = todayDate.optJSONObject("live");
            String temperature = live.optString("temperature");//温度
            String weather_name = live.optString("weather_name");//天气情况
            String weekday = todayDate.optString("weekday");//星期
            String report_time = todayDate.optString("report_time");//预测日期
            JSONArray forecastDataArray = todayDate.optJSONArray("forecast_data");
            if (StringUtil.isNotEmpty(forecastDataArray)) {
                //日间
                JSONObject forecastData = forecastDataArray.optJSONObject(0);
                String daynight = forecastData.optString("daynight");//0日间
                String maxTemp = forecastData.optString("max_temp");//最高气温
                String minTemp = forecastData.optString("min_temp");//最低气温
                String weatherName = forecastData.optString("weather_name");//天气名
                String windDirectionDesc = forecastData.optString("wind_direction_desc");//风向
                String windPowerDesc = forecastData.optString("wind_power_desc");//风级
                //夜间
                JSONObject forecastData1 = forecastDataArray.optJSONObject(1);
                String daynight1 = forecastData.optString("daynight");//0日间
                String maxTemp1 = forecastData.optString("max_temp");//最高气温
                String minTemp1 = forecastData.optString("min_temp");//最低气温
                String weatherName1 = forecastData.optString("weather_name");//天气名
                String windDirectionDesc1 = forecastData.optString("wind_direction_desc");//风向
                String windPowerDes1 = forecastData.optString("wind_power_desc");//风级
                resultMap.put("resultCode", "0");
                resultMap.put("resultMsg", "成功");
                resultMap.put("resultWeatherName", weatherName);
                resultMap.put("resultTemperature", minTemp + "/" + maxTemp + "°");
                String cityName = getCityName(provinceCode);
                resultMap.put("resultCity", cityName);
            } else {
                resultMap.put("resultCode", "1");
                resultMap.put("resultMsg", "未查到相应数据");
            }
        } else {
            resultMap.put("code", data.optString("code"));
            resultMap.put("message", data.optString("message"));
        }

        return ResultUtil.result("0", resultMap, null);
    }

    public String getCityName(String cityCode) {
        String ctiy = cityService.getCtiy(cityCode);
        return ctiy;
    }
}
