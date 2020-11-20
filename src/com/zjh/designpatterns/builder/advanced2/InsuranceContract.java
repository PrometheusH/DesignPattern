package com.zjh.designpatterns.builder.advanced2;


public class InsuranceContract {
    private String contractId;
    private String personName;
    private String companyName;
    private long beginDate;
    private long endDate;
    //其他数据
    private String otherData;

    //protect类型只能同包访问
    InsuranceContract(ConcretBuilder builder){
        this.contractId = builder.getContractId();
        this.personName = builder.getPersonName();
        this.companyName = builder.getCompanyName();
        this.beginDate = builder.getBeginDate();
        this.endDate = builder.getEndDate();
        this.otherData = builder.getOtherData();
    }

    public static class ConcretBuilder{
        private String contractId;
        private String personName;
        private String companyName;
        private long beginDate;
        private long endDate;
        //其他数据
        private String otherData;

        public ConcretBuilder(String contractId, long beginDate, long endDate) {
            this.contractId = contractId;
            this.beginDate = beginDate;
            this.endDate = endDate;
        }

        public ConcretBuilder setPersonName(String personName) {
            this.personName = personName;
            return this;
        }

        public ConcretBuilder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public ConcretBuilder setOtherData(String otherData) {
            this.otherData = otherData;
            return this;
        }

        public String getContractId() {
            return contractId;
        }

        public String getPersonName() {
            return personName;
        }

        public String getCompanyName() {
            return companyName;
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

        public InsuranceContract build(){
            if (contractId==null||contractId.trim().length()==0)
                throw new IllegalArgumentException("合同编号不能为空");
            boolean signPerson = personName!=null&&personName.trim().length()>0;
            boolean signCopany = companyName!=null&&companyName.trim().length()>0;
            if (signPerson&&signCopany)
                throw new IllegalArgumentException("一份保险不能同时与人和公司签订");
            if (signPerson==false&&signCopany==false)
                throw new IllegalArgumentException("保险不能没有签订对象");
            if (beginDate<=0)
                throw new IllegalArgumentException("合同必须有保险开始生效日期");
            if (endDate<=0)
                throw new IllegalArgumentException("合同必须有保险失效日期");
            if (beginDate>=endDate)
                throw new IllegalArgumentException("合同失效日期必须大于生效日期");
            return new InsuranceContract(this);
        }
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
