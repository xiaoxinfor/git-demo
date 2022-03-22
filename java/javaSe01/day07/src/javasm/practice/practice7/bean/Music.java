package javasm.practice.practice7.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-22:06
 * @Since:jdk1.8
 * @Description:音乐类
 */
public class Music {
    private String name;//音乐名
    private double time;//播放时长
    private String singer;//歌手

    public Music(String name, double time, String singer) {
        this.name = name;
        this.time = time;
        this.singer = singer;
    }

    public Music() {
    }
    /**
     * get和set方法
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
