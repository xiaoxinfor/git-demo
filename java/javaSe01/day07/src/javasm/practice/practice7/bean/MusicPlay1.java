package javasm.practice.practice7.bean;

import java.util.Arrays;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/7-10:47
 * @Since:jdk1.8
 * @Description:
 */
public class MusicPlay1 {
    private String name;//播放器名字
    private Music[] music;//播放音乐列表

    /**
     * 构造方法
     * @param name
     */
    public MusicPlay1(String name) {
        this.name = name;
    }
    public MusicPlay1(){}
    /**
     * set和get方法
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Music[] getMusic() {
        return music;
    }

    public void setMusic(Music[] music) {
        this.music = music;
    }
    /**
     * toString方法
     */
    @Override
    public String toString() {
        return "MusicPlay1{" +
                "name='" + name + '\'' +
                ", music=" + Arrays.toString(music) +
                '}';
    }

    /**
     * 播放音乐方法
     */
    public void player(){
        System.out.println("播放器名称：" + this.name);
        System.out.println("播放音乐列表>>>");
        System.out.println("歌曲名称\t时长\t歌手");
        for (Music music1 : music) {
            System.out.println(music1.getName() + "\t" + music1.getTime() + "\t" + music1.getSinger());
        }
    }
}
