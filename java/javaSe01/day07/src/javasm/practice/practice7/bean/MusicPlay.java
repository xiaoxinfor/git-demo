package javasm.practice.practice7.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-22:08
 * @Since:jdk1.8
 * @Description:播放器
 */
public class MusicPlay {
    private String name;//播放器名字

    public MusicPlay(String name) {
        this.name = name;
    }

    //播放器方法
    public void bo(Music music){
        System.out.println(this.name + "正在播放" + music.getSinger() + "歌唱的音乐【" + music.getName() + "】剩余时间" + music.getTime());
    }
}
