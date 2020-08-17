package com.cy.generate.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2019/10/5 23:01
 */
@Data
@Accessors(chain = true)
public class BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;

}
