package com.yuntu.service.provider;

import com.yuntu.dao.provider.ProviderMapper;
import com.yuntu.pojo.Bill;
import com.yuntu.pojo.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("providerService")
public class ProviderServiceImpl implements ProviderService{
    @Autowired
    private  ProviderMapper providerMapper;

    public ProviderMapper getProviderMapper() {
        return providerMapper;
    }

    public void setProviderMapper(ProviderMapper providerMapper) {
        this.providerMapper = providerMapper;
    }

    @Override
    public List<Provider> getProviderAll() {
        return providerMapper.getProviderAll();
    }

    @Override
    public Provider getProviderById(int id) {
        return providerMapper.getProviderById(id);
    }

    @Override
    public boolean delProviderById(int id) {
        if (providerMapper.delProviderById(id)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updProvider(Provider provider) {
        if (providerMapper.updProvider(provider)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean addProvider(Provider provider) {
        if (providerMapper.addProvider(provider)>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Provider> getProviderByCondition(String proCode, String proName) {
        return providerMapper.getProviderByCondition(proCode,proName);
    }
}
