package com.yuntu.service.bill;

import com.yuntu.dao.bill.BillMapper;
import com.yuntu.pojo.Bill;
import com.yuntu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("billService")
public class BillServiceImpl implements BillService{
    @Autowired
    private BillMapper billMapper;

    public BillMapper getBillMapper() {
        return billMapper;
    }

    public void setBillMapper(BillMapper billMapper) {
        this.billMapper = billMapper;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public void getPageAll(PageUtil<Bill> pageUtil) {
        int count = billMapper.getCount();
        pageUtil.setCounts(count);
        if (pageUtil.getPagecount()>0){
            if (pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            pageUtil.setLists(billMapper.getPageAll(pageUtil));
        }else{
            pageUtil.setLists(new ArrayList<Bill>());
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Bill getBillById(int id) {
        return billMapper.getBillById(id);
    }

    @Override
    public boolean delBillById(int id) {
        if (billMapper.delBillById(id)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updBill(Bill bill) {
        if (billMapper.updBill(bill)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean addBill(Bill bill) {
        if (billMapper.addBill(bill)>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Bill> getBillByCondition(String productName, int providerId, int isPayment) {
        return billMapper.getBillByCondition(productName, providerId, isPayment);
    }
}
