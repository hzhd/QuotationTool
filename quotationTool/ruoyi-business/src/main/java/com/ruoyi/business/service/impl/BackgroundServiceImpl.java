package com.ruoyi.business.service.impl;

import com.ruoyi.business.domain.BackgroundInfo;
import com.ruoyi.business.mapper.BackgroundMapper;
import com.ruoyi.business.service.BackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackgroundServiceImpl implements BackgroundService {


    @Autowired
    private BackgroundMapper mapper;

    @Override
    public BackgroundInfo view() {
        return mapper.view();
    }

    @Override
    public void edit(BackgroundInfo backgroundInfo) {
        mapper.edit(backgroundInfo);
    }
}
