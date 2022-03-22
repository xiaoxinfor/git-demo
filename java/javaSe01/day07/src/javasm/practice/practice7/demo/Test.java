package javasm.practice.practice7.demo;

import javasm.practice.practice7.bean.Music;
import javasm.practice.practice7.bean.MusicPlay;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-22:13
 * @Since:jdk1.8
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入音乐名，播放时长以及歌手名：");
        String name = scanner.next();
        double time = scanner.nextDouble();
        String singer = scanner.next();

        //创建音乐对象
        Music music1 = new Music(name,time,singer);
        //创建播放器对象
        MusicPlay musicPlay = new MusicPlay("酷狗音乐");
        musicPlay.bo(music1);
    }
}
