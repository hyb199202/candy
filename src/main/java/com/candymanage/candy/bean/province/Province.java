package com.candymanage.candy.bean.province;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author hyb
 * @Description candy
 * @Date 2019/07/15 17:08
 */
@Data
@ToString
public class Province implements Serializable {
    private String provinceName;
    private Integer provinceCode;
}
