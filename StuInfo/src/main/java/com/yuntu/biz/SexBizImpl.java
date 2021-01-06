package com.yuntu.biz;

import com.yuntu.dao.SexMapper;
import com.yuntu.pojo.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("sexBiz")
public class SexBizImpl implements SexBiz{
    @Autowired
    private SexMapper sexMapper;

    public SexMapper getSexMapper() {
        return sexMapper;
    }

    public void setSexMapper(SexMapper sexMapper) {
        this.sexMapper = sexMapper;
    }

    @Override
    @Transactional(propagation= Propagation.SUPPORTS,readOnly = true)
    public List<Sex> getAll() {
        return sexMapper.getAll();
    }
}