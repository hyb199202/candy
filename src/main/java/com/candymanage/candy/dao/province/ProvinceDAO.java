package com.candymanage.candy.dao.province;

import com.candymanage.candy.bean.province.Province;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProvinceDAO {
    @Select("select * from candy_province")
    List<Province> getProvince();
}
