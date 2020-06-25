package com.zjh.designpatterns.observer.concrete;

public class NewsPaper extends Subject {
    /**
     * 报纸内容
     */
    private String content;

    /**
     * 读者获取报纸的具体内容，就可以阅读了
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置报纸的内容，相当于出版一期新的报纸
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
        //报纸更新了，通知读者
        notifyObservers();
    }
}
