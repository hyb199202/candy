package com.candymanage.candy.dao.province;

import com.candymanage.candy.bean.province.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CityDAO {
    @Select("SELECT * FROM candy_city WHERE p_code =#{pCode}")
    List<City> getCtiyList(@Param("pCode") Integer pCode);

    @Select("SELECT city_name FROM candy_city WHERE city_code =#{cityCode}")
    String getCtiy(@Param("cityCode") String cityCode);
}
