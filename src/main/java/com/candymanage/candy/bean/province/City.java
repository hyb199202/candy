package com.candymanage.candy.bean.province;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author hyb
 * @Description candy
 * @Date 2019/07/15 17:11
 */
@Data
@ToString
public class City implements Serializable {
    private String cityName;
    private Integer cityCode;
    private Integer pCode;
}
