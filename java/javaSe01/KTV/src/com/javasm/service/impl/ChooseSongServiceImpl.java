package com.javasm.service.impl;

import cn.hutool.core.lang.ConsoleTable;
import com.javasm.bean.Song;
import com.javasm.service.ChooseSongService;

import java.util.*;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/18-19:58
 * @Since:jdk1.8
 * @Description:
 */
public class ChooseSongServiceImpl implements ChooseSongService {
    @Override
    public void pinYinChooseSong(List<Song> songList, List<Song> haveSong, Scanner scanner) {
        System.out.println("*****欢迎使用拼音点歌*****");
        System.out.println("请输入拼音");
        String inputPinYin = scanner.next();
        inputPinYin = inputPinYin.toUpperCase();
        //筛选出的歌曲列表
        List<Song> shaiXuanList = new ArrayList<>();
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("序号", "歌曲名", "歌手", "时长");
        //序号
        Integer i = 1;
        for (Song song : songList) {
            if (song.getJpName().equals(inputPinYin) || song.getJpName().startsWith(inputPinYin) || song.getQpName().equals(inputPinYin) || song.getQpName().startsWith(inputPinYin)) {
                consoleTable.addBody(i.toString(), song.getName(), song.getSinger(), song.getTime());
                shaiXuanList.add(song);
                i++;
            }
        }
        consoleTable.print();
        dianGe(shaiXuanList, haveSong, scanner);
    }

    @Override
    public void chooseNameSong(List<Song> songList, List<Song> haveSong, Scanner scanner) {
        System.out.println("*****欢迎使用歌名点歌*****");
        System.out.println("请输入您要点的歌名");
        String inputName = scanner.next();
        for (Song song : songList) {
            if (inputName.equals(song.getName())) {
                //歌曲列表中没有该歌曲
                if (!haveSong.contains(song)) {
                    //加入已点歌曲列表
                    haveSong.add(song);
                    System.out.println("点歌成功,已将《" + song.getName() + "》添加到歌曲列表中");
                    song.setCount(song.getCount() + 1);
                    return;
                }
            }
        }
        System.out.println("点歌失败，没有该歌曲或该歌曲已在歌曲列表中。可反馈给管理员，敬请期待！");
    }

    @Override
    public void chooseSinger(List<Song> songList, List<Song> haveSong, Scanner scanner) {
        System.out.println("*****欢迎使用歌手名点歌*****");
        System.out.println("请输入您要点歌的歌手名");
        String inputName = scanner.next();
        ConsoleTable consoleTable = new ConsoleTable();
        List<Song> shaiXuanList = new ArrayList<>();
        consoleTable.addHeader("序号", "歌曲名", "歌手", "时长");
        //序号
        Integer i = 1;
        for (Song song : songList) {
            if (inputName.equals(song.getSinger())) {
                consoleTable.addBody(i.toString(), song.getName(), song.getSinger(), song.getTime());
                shaiXuanList.add(song);
                i++;
            }
        }
        consoleTable.print();
        dianGe(shaiXuanList, haveSong, scanner);
    }

    @Override
    public void chooseSpecies(List<Song> songList, List<Song> haveSong, Scanner scanner) {
        System.out.println("*****欢迎使用分类点歌*****");
        System.out.println("流行歌曲\t民族歌曲\t儿歌歌曲");
        System.out.println("请选择");
        String input = scanner.next();
        ConsoleTable consoleTable = new ConsoleTable();
        List<Song> shaiXuanList = new ArrayList<>();
        consoleTable.addHeader("序号", "歌曲名", "歌手", "类别", "时长");
        Integer i = 1;//序号
        for (Song song : songList) {
            if (input.equals(song.getSpecies())) {
                consoleTable.addBody(i.toString(), song.getName(), song.getSinger(), song.getSpecies(), song.getTime());
                shaiXuanList.add(song);
                i++;
            }
        }
        consoleTable.print();
        dianGe(shaiXuanList, haveSong, scanner);
    }

    @Override
    public void songRank(List<Song> songList, List<Song> haveSong, Scanner scanner) {
        System.out.println("*****好歌排行榜*****");
        Collections.sort(songList);
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("序号", "歌曲名", "歌手", "时长", "点歌次数");
        Integer i = 1;//序号
        for (Song song : songList) {
            consoleTable.addBody(i.toString(), song.getName(), song.getSinger(), song.getTime(), song.getCount().toString());
            i++;
        }
        consoleTable.print();
        dianGe(songList, haveSong, scanner);
    }

    /**
     * 已点歌曲列表
     *
     * @param haveSong
     */
    @Override
    public void hSong(List<Song> haveSong) {
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("序号", "歌曲名", "歌手", "时长");
        Integer i = 1;
        for (Song song : haveSong) {
            consoleTable.addBody(i.toString(), song.getName(), song.getSinger(), song.getTime());
            i++;
        }
        consoleTable.print();
    }

    @Override
    public void zhiDing(List<Song> haveSong, Scanner scanner) {
        System.out.println("请选择您要置顶的歌曲");
        String inputSongs = scanner.next();
        for (Song song : haveSong) {
            if (inputSongs.equals(song.getName())) {
                if (haveSong.indexOf(song) == 0) {
                    System.out.println("该歌曲已是第一位");
                    return;
                }
                    //将该歌曲与第一位的歌曲互换位置
                    Collections.swap(haveSong, haveSong.indexOf(song), 0);
            }
        }
    }

    @Override
    public void delete(List<Song> haveSong, Scanner scanner) {
        System.out.println("请选择您要删除的歌曲");
        String inputSongs = scanner.next();
        Iterator<Song> it = haveSong.iterator();
        while (it.hasNext()) {
            Song song1 = it.next();
            if (inputSongs.equals(song1.getName())) {
                it.remove();
                return;
            }
        }
        System.out.println("歌曲列表中没有该歌曲，删除失败");
    }

    @Override
    public void qianYi(List<Song> haveSong, Scanner scanner) {
        System.out.println("请选择您要前移的歌曲");
        String inputSongs = scanner.next();
        for (Song song : haveSong) {
            if (inputSongs.equals(song.getName())) {
                if (haveSong.indexOf(song) == 0) {
                    System.out.println("该歌曲已是第一位");
                    return;
                }
                //将该歌曲与它前一位的互换位置
                Collections.swap(haveSong, haveSong.indexOf(song), haveSong.indexOf(song) - 1);
            }
        }
    }

    /**
     * 歌名点歌
     */
    public static void dianGe(List<Song> shaiXuanList, List<Song> haveSong, Scanner scanner) {
        System.out.println("************点歌，输入歌名：***********");
        if (shaiXuanList.isEmpty()) {
            System.out.println("该列表下没有歌曲，请重新选择");
            return;
        }
        String inputSongName = scanner.next();

        for (Song songs : shaiXuanList) {
            if (inputSongName.equals(songs.getName())) {
                //歌曲列表中没有该歌曲
                if (!haveSong.contains(songs)) {
                    //加入歌曲列表
                    haveSong.add(songs);
                    System.out.println("点歌成功,已将[" + songs.getName() + "]添加到歌曲列表中");
                    songs.setCount(songs.getCount() + 1);
                    return;
                }
            }
        }
        System.out.println("该列表下没有该歌曲或该歌曲已在歌曲列表中，添加失败");
    }
}
