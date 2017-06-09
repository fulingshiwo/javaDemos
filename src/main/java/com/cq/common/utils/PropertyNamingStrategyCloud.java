/* =============================================================
 * Created: [2016年2月17日] by ZhengChen
 * =============================================================
 *
 * Copyright 2014-2015 NetDragon Websoft Inc. All Rights Reserved
 *
 * =============================================================
 */
package com.cq.common.utils;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * @author ZhengChen
 * @since 0.1.0
 */
public class PropertyNamingStrategyCloud extends PropertyNamingStrategy.PropertyNamingStrategyBase {

    private static final long serialVersionUID = -6761807038049455432L;

    @Override
    public String translate(String propertyName) {
        return propertyName;
    }

}
