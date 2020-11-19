package com.zjh.designpatterns.abstact_factory.advaced2;

public class Client {
    public static void main(String[] args) {
        DAOFactory daoFactory = new RdbDAOFactory();
        OrderDetailDAO detailDAO = daoFactory.createDetailDAO();
        OrderMainDAO mainDAO = daoFactory.createMainDAO();
        detailDAO.saveOrderDetail();
        mainDAO.saveOrderMain();
    }
}
