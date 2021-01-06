package com.yuntu.service;

import com.yuntu.dao.ProbuctMapper;
import com.yuntu.pojo.Probuct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("probuctService")
public class ProbuctServiceImpl implements ProbuctService{

    @Autowired
    ProbuctMapper probuctMapper;

    public ProbuctMapper getProbuctMapper() {
        return probuctMapper;
    }

    public void setProbuctMapper(ProbuctMapper probuctMapper) {
        this.probuctMapper = probuctMapper;
    }

    @Override
    public List<Probuct> getAll() {
        return probuctMapper.getAll();
    }

    @Override
    public boolean addPro(Probuct probuct) {
        if(probuctMapper.addPro(probuct)>0){
            return true;
        }
        return false;
    }
}
