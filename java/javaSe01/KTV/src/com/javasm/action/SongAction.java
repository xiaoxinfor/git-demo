package com.javasm.action;

import com.javasm.bean.Song;
import com.javasm.service.ChooseSongService;
import com.javasm.service.impl.ChooseSongServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/18-19:59
 * @Since:jdk1.8
 * @Description:
 */
public class SongAction {
    //歌曲列表
    private List<Song> songList;
    //已点歌曲
    private List<Song> haveSong;
    private Scanner scanner;
    ChooseSongService chooseSongService;

    public SongAction() {
        songList = new ArrayList<>();
        haveSong = new ArrayList<>();
        scanner = new Scanner(System.in);
        chooseSongService = new ChooseSongServiceImpl();
        songList.add(new Song("宁夏", "梁静茹", "3:04", "儿歌歌曲", 101));
        songList.add(new Song("一路向北", "周杰伦", "4:37", "流行歌曲", 200));
        songList.add(new Song("东风破", "周杰伦", "4:30", "民族歌曲", 178));
        songList.add(new Song("丑八怪", "薛之谦", "4:25", "流行歌曲", 150));
        songList.add(new Song("我还想她", "林俊杰", "3:54", "流行歌曲", 120));
        songList.add(new Song("可惜没如果", "林俊杰", "3:44", "流行歌曲", 102));
        songList.add(new Song("不舍", "徐佳莹", "3:56", "流行歌曲", 95));
    }

    public void menu() {
        while (true) {
            System.out.println("**********欢迎进入零点KTV点歌台*********");
            System.out.println("1.点歌");
            System.out.println("2.已点歌曲列表");
            System.out.println("0.退出系统");
            System.out.println("请选择");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    chooseSong();
                    break;
                case 2:
                    yiDian();
                    break;
                case 0:
                    System.out.println("谢谢使用");
                    return;
            }
        }
    }

    /**
     * 点歌台
     */
    public void chooseSong() {
        boolean b = true;
        while (b) {
            System.out.println("**************点歌台****************");
            System.out.println("1.按拼音点歌");
            System.out.println("2.按歌曲名点歌");
            System.out.println("3.按歌星点歌");
            System.out.println("4.按分类点歌");
            System.out.println("5.好歌排行榜");
            System.out.println("0.返回主菜单");
            System.out.println("请选择");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    chooseSongService.pinYinChooseSong(songList, haveSong, scanner);
                    break;
                case 2:
                    chooseSongService.chooseNameSong(songList, haveSong, scanner);
                    break;
                case 3:
                    chooseSongService.chooseSinger(songList, haveSong, scanner);
                    break;
                case 4:
                    chooseSongService.chooseSpecies(songList, haveSong, scanner);
                    break;
                case 5:
                    chooseSongService.songRank(songList, haveSong, scanner);
                    break;
                case 0:
                    b = false;
            }
        }
    }

    public void yiDian() {
        boolean b = true;
        while (b) {
            System.out.println("请选择");
            System.out.println("1.返回主菜单");
            System.out.println("2.返回点歌台");
            System.out.println("3.返回已点列表");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    b = false;
                    break;
                case 2:
                    chooseSong();
                    break;
                case 3:
                    yiDian2();
                    break;
            }
        }
    }

    public void yiDian2() {
        boolean b = true;
        while (b) {
            //已点歌曲
            chooseSongService.hSong(haveSong);
            System.out.println("**********选择操作**********");
            System.out.println("1.歌曲置顶");
            System.out.println("2.歌曲移除");
            System.out.println("3.歌曲前移一位");
            System.out.println("0.返回上一菜单");
            System.out.println("请选择");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    chooseSongService.zhiDing(haveSong, scanner);
                    break;
                case 2:
                    chooseSongService.delete(haveSong, scanner);
                    break;
                case 3:
                    chooseSongService.qianYi(haveSong, scanner);
                    break;
                case 0:
                    b = false;
                    break;
            }
        }
    }
}
