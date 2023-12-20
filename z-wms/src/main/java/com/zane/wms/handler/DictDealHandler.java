package com.zane.wms.handler;

import com.zane.common.utils.poi.ExcelHandlerAdapter;

public class DictDealHandler implements ExcelHandlerAdapter {
    @Override
    public Object format(Object value, String[] args) {
        return value;
    }
}
