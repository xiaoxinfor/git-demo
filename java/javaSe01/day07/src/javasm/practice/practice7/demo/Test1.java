package javasm.practice.practice7.demo;

import javasm.practice.practice7.bean.Music;
import javasm.practice.practice7.bean.MusicPlay1;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/7-10:54
 * @Since:jdk1.8
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        //创建播放器对象
        MusicPlay1 musicPlay1 = new MusicPlay1("酷狗");
        addMusic(musicPlay1);
        musicPlay1.player();
    }

    /**
     * 添加音乐的静态方法
     */
    public static void addMusic(MusicPlay1 musicPlay1){
        Music[] music = new Music[5];
        music[0] = new Music("十年",3.45,"陈奕迅");
        music[1] = new Music("十一年",3.55,"陈奕迅");
        music[2] = new Music("十二年",4.45,"陈奕迅");
        music[3] = new Music("十三年",3.45,"陈奕迅");
        music[4] = new Music("十四年",5.45,"陈奕迅");
        //将歌存入播放器
        musicPlay1.setMusic(music);
    }
}
