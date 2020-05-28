package com.zjh.designpatterns.flyweight.concrete;

/**
 * 享元接口，通过这个接口可以接受并作用于外部状态
 *
 */
public interface Flyweight {

//    public void operation(String extrinsicState);

    /**
     * 判断传入的安全实体和权限，是否和享元的内部状态匹配
     * @param securityEntity 安全实体
     * @param permit 权限
     * @return true 匹配，false 不匹配
     */
    public boolean match(String securityEntity, String permit);


}
