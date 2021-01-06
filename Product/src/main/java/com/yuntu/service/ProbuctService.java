package com.yuntu.service;

import com.yuntu.pojo.Probuct;

import java.util.List;

public interface ProbuctService {
    List<Probuct> getAll();
    boolean addPro(Probuct probuct);
}
