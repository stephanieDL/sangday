package com.day.sang.core.common;

import com.day.sang.core.po.BasePO;

/**
 * Created by yaojialu on 2017/1/9.
 */
public interface BaseRepositoryCustom {

    BasePO save(BasePO abstractBasePO, int userId);

}
