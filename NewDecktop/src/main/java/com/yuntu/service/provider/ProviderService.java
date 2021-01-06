package com.yuntu.service.provider;

import com.yuntu.pojo.Bill;
import com.yuntu.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderService {
    public List<Provider> getProviderAll();
    Provider getProviderById(int id );
    boolean delProviderById(int id);
    boolean updProvider(Provider provider);
    boolean addProvider(Provider provider);
    List<Provider> getProviderByCondition(String proCode,String proName);
}
