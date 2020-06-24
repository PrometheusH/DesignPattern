package com.zjh.designpatterns.observer.another_advanced;

public class WaterQuality extends WaterQualitySubject {
    /**
     * 水质污染级别，0为正常，1轻度污染，2中度污染，3重度污染
     */
    private int polluteLevel = 0;

    /**
     * 通知各个观察者
     */
    @Override
    public void notifyObservers() {
        for (WatcherObserver wo :
                observers) {
            if (this.polluteLevel >= 0) {
                if ("监测人员".equals(wo.getJob())){
                    wo.update(this);
                }
            }
            if (this.polluteLevel >= 1) {
                if ("预警人员".equals(wo.getJob())){
                    wo.update(this);
                }
            }
            if (this.polluteLevel >= 2) {
                if ("部门领导".equals(wo.getJob())){
                    wo.update(this);
                }
            }
        }
    }

    /**
     * 获取水质资源的级别
     * @return
     */
    @Override
    public int getPolluteLevel() {
        return polluteLevel;
    }

    /**
     * 检测水质的情况后，设置水的污染级别
     * @param polluteLevel
     */
    @Override
    public void setPolluteLevel(int polluteLevel) {
        this.polluteLevel = polluteLevel;
        this.notifyObservers();
    }
}

