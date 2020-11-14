package com.zjh.designpatterns.mediator.concrete;

public class MotherBoard implements Mediator{
    private CPU cpu=null;
    private CDDriver cdDriver = null;
    private SoundCard soundCard = null;
    private VideoCard videoCard = null;

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public CDDriver getCdDriver() {
        return cdDriver;
    }

    public void setCdDriver(CDDriver cdDriver) {
        this.cdDriver = cdDriver;
    }

    public SoundCard getSoundCard() {
        return soundCard;
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = soundCard;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }
    private void openCDDriverReadData(CDDriver cd){
        String data = cd.getData();
        this.cpu.excuteData(data);
    }
    private void openCPU(CPU cpu){
        String videoData = cpu.getVideoData();
        String soundData = cpu.getSoundData();
        this.videoCard.showData(videoData);
        this.soundCard.soundData(soundData);
    }
    @Override
    public void changed(Colleague colleague) {
        if (colleague == cdDriver){
            this.openCDDriverReadData((CDDriver)colleague);
        }else if (colleague == cpu){
            this.openCPU((CPU)colleague);
        }
    }


}
