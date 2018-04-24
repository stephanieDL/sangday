package com.day.sang.service.impl;

import com.day.sang.core.dao.PassportDao;
import com.day.sang.core.po.PassportPO;
import com.day.sang.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassportServiceImpl implements PassportService{

    private PassportDao passportDao;

    @Autowired
    public PassportServiceImpl(PassportDao passportDao) {
        this.passportDao = passportDao;
    }
    @Override
    public PassportPO getPassportPO(Integer id){
        PassportPO passportPO = passportDao.getOne(id);
        return passportPO;
    }
}
