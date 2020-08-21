package com.cy.generate.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/22 23:01
 */
@Data
@Accessors(chain = true)
public class BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;

}
