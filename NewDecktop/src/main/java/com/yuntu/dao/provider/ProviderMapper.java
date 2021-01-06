package com.yuntu.dao.provider;
import com.yuntu.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderMapper {
    public List<Provider> getProviderAll();
    Provider getProviderById(int id );
    int delProviderById(int id);
    int updProvider(Provider provider);
    int addProvider(Provider provider);
    List<Provider> getProviderByCondition(@Param("proCode") String proCode, @Param("proName")String proName);
}
