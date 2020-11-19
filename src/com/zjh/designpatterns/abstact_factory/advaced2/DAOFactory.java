package com.zjh.designpatterns.abstact_factory.advaced2;

public abstract class DAOFactory {
    public abstract OrderMainDAO createMainDAO();
    public abstract OrderDetailDAO createDetailDAO();
}
