package com.zjh.designpatterns.abstact_factory.advaced2;

public class XmlDAOFactory extends DAOFactory{

    @Override
    public OrderMainDAO createMainDAO() {
        return new XmlMainDAOImpl();
    }

    @Override
    public OrderDetailDAO createDetailDAO() {
        return new XmlDetailDAO();
    }
}
