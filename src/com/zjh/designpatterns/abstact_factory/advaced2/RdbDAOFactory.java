package com.zjh.designpatterns.abstact_factory.advaced2;

public class RdbDAOFactory extends DAOFactory{

    @Override
    public OrderMainDAO createMainDAO() {
        return new RdbMainDAOImpl();
    }

    @Override
    public OrderDetailDAO createDetailDAO() {
        return new RdbDetailDAOImpl();
    }
}
