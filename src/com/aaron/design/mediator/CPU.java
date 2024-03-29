package com.aaron.design.mediator;

/**
 * 同事类——CPU。 具体同事类(ConcreteColleague)角色：所有的具体同事类均从抽象同事类继承而来。实现自己的业务，在需要与其他同事通信的时候 ，就与持有的调停者通信，调停者会负责与其他的同事交互。
 * 
 * @author Aaron
 * @date 2017年6月12日
 * @version 1.0
 * @package_name com.aaron.design.mediator
 */
public class CPU extends Colleague {
    // 分解出来的视频数据
    private String videoData = "";
    // 分解出来的声音数据
    private String soundData = "";

    /**
     * 构造函数
     */
    public CPU(Mediator mediator) {
        super(mediator);
    }

    /**
     * 获取分解出来的视频数据
     */
    public String getVideoData() {
        return videoData;
    }

    /**
     * 获取分解出来的声音数据
     */
    public String getSoundData() {
        return soundData;
    }

    /**
     * 处理数据，把数据分成音频和视频的数据
     */
    public void executeData(String data) {
        // 把数据分解开，前面是视频数据，后面是音频数据
        String[] array = data.split(",");
        this.videoData = array[0];
        this.soundData = array[1];
        // 通知主板，CPU完成工作
        getMediator().changed(this);
    }

}