package com.cy.generate.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/17 23:04
 */
@Data
@Accessors(chain = true)
public class DemoObject {
    private int sum;
}
