package com.yuntu.dao.bill;

import com.yuntu.pojo.Bill;
import com.yuntu.util.PageUtil;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BillMapper {
    List<Bill> getPageAll(PageUtil<Bill> pageUtil);
    int getCount();
    Bill getBillById(int id );
    int delBillById(int id);
    int updBill(Bill bill);
    int addBill(Bill bill);
    List<Bill> getBillByCondition(@Param("productName") String productName, @Param("providerId")int providerId , @Param("isPayment")int isPayment);
}
