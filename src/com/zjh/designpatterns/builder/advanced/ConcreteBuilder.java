package com.zjh.designpatterns.builder.advanced;

public class ConcreteBuilder {
    private String contractId;
    private String personName;
    private String companyName;
    private long beginDate;
    private long endDate;
    //其他数据
    private String otherData;

    public ConcreteBuilder(String contractId, long beginDate, long endDate) {
        this.contractId = contractId;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public InsuranceContract build(){
        return new InsuranceContract(this);
    }

    public ConcreteBuilder setPersonName(String personName) {
        this.personName = personName;
        return this;
    }

    public ConcreteBuilder setOtherData(String otherData) {
        this.otherData = otherData;
        return this;
    }

    public ConcreteBuilder setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    //只提供get方法，没有set方法

    public String getContractId() {
        return contractId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPersonName() {
        return personName;
    }

    public long getBeginDate() {
        return beginDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public String getOtherData() {
        return otherData;
    }
}
