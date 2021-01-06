package com.yuntu.service.bill;

import com.yuntu.pojo.Bill;
import com.yuntu.util.PageUtil;

import java.util.List;

public interface BillService {
    void getPageAll(PageUtil<Bill> pageUtil);
    Bill getBillById(int id);
    boolean delBillById(int id);
    boolean updBill(Bill bill);
    boolean addBill(Bill bill);
    List<Bill> getBillByCondition( String productName,int providerId,int isPayment);
}
