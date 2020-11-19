package com.zjh.designpatterns.abstact_factory.advanced;

public class HyMemory implements MemoryApi{
    @Override
    public void cacheData() {
        System.out.println("现在在使用现代内存");
    }
}
