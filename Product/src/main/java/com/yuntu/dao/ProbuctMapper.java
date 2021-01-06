package com.yuntu.dao;

import com.yuntu.pojo.Probuct;

import java.util.List;

public interface ProbuctMapper {
    List<Probuct> getAll();
    int addPro(Probuct probuct);
}
