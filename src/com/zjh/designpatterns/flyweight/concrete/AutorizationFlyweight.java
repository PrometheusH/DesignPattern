package com.zjh.designpatterns.flyweight.concrete;

/**
 * 封装授权数据中重复出现部分的享元对象
 *
 * 老的AutorizationModel中有user，而这个没有，就不与用户进行耦合了
 * 到时候new的时候只new 安全实体+权限 即可，不用再与用户进行绑定了。而且每一个用户都可以共享使用这个Flyweight，这样就减少了实体类
 */
public class AutorizationFlyweight implements Flyweight {

    private String securityEntity;
    private String permit;

    public AutorizationFlyweight(String state) {
        String[] ss = state.split(",");
        securityEntity = ss[0];
        permit = ss[1];
    }

    public String getSecurityEntity() {
        return securityEntity;
    }

    public void setSecurityEntity(String securityEntity) {
        this.securityEntity = securityEntity;
    }

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }

    @Override
    public boolean match(String securityEntity, String permit) {
        if(this.securityEntity.equals(securityEntity)
                &&this.permit.equals(permit)){
            return true;
        }
        return false;
    }
}
