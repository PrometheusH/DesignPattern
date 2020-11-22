package com.zjh.designpatterns.Prototype.old;

public class OrderBusiness {
    public void saveOrder(OrderApi order){
        while (order.getOrderProductNum()>1000){
            OrderApi newOrder = null;
            if (order instanceof PersonalOrder){
                PersonalOrder newPO = new PersonalOrder();
                PersonalOrder oldPO = (PersonalOrder)order;
                newPO.setCustomerName(oldPO.getCustomerName());
                newPO.setProductId(oldPO.getProductId());
                newPO.setOrderProductNum(1000);
                newOrder = newPO;
            }else if (order instanceof EnterpriseOrder){
                EnterpriseOrder newEO = new EnterpriseOrder();
                EnterpriseOrder oldEO = (EnterpriseOrder)order;

                newEO.setEnterpriseName(oldEO.getEnterpriseName());
                newEO.setProductId(oldEO.getProductId());
                newEO.setOrderProductNum(1000);
                newOrder = newEO;
            }

            order.setOrderProductNum(order.getOrderProductNum()-1000);
            System.out.println("拆分生成订单："+newOrder);
        }
        System.out.println("原始订单=="+order);
    }
}
