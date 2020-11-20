package com.zjh.designpatterns.builder.advanced;

public class InsuranceContract {
    private String contractId;
    private String personName;
    private String companyName;
    private long beginDate;
    private long endDate;
    //其他数据
    private String otherData;

    //protect类型只能同包访问
    InsuranceContract(ConcreteBuilder builder){
        this.contractId = builder.getContractId();
        this.personName = builder.getPersonName();
        this.companyName = builder.getCompanyName();
        this.beginDate = builder.getBeginDate();
        this.endDate = builder.getEndDate();
        this.otherData = builder.getOtherData();


    }

    @Override
    public String toString() {
        return "InsuranceContract{" +
                "contractId='" + contractId + '\'' +
                ", personName='" + personName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", otherData='" + otherData + '\'' +
                '}';
    }

    public void someOption(){
        System.out.println("操作保险对象，当前对象是：");
        System.out.println(this.toString());
    }
}
