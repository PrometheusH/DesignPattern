package com.zjh.designpatterns.template_method.old;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

public class WorkerLogin {
    public boolean login(WorkerLoginModel wlm){
        WorkerModel wm = findWorkerByWorkerId(wlm.getWorkerId());
        if (wm!=null)//即使数据库查不到也部位null，因为new了，所以要再进一步判断
            return wlm.getWorkerId().equals(wm.getWorkerID())
            &&wlm.getPwd().equals(wm.getPwd());
        return false;
    }
    public WorkerModel findWorkerByWorkerId(String workerId){
        WorkerModel wm = new WorkerModel();
        wm.setWorkerID(workerId);
        wm.setName("worker1");
        wm.setPwd("23234");
        wm.setUuid("worker00001");
        return wm;
    }

}
