package com.javasm.service;

import com.javasm.bean.Song;

import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/18-19:58
 * @Since:jdk1.8
 * @Description:
 */
public interface ChooseSongService {
    /**
     * 歌名
     *
     * @param songList
     * @param haveSong
     * @param scanner
     */
    void chooseNameSong(List<Song> songList, List<Song> haveSong, Scanner scanner);

    /**
     * 拼音点歌
     * @param songList
     * @param haveSong
     * @param scanner
     */
    void pinYinChooseSong(List<Song> songList, List<Song> haveSong, Scanner scanner);

    /**
     * 歌手
     *
     * @param songList
     * @param haveSong
     * @param scanner
     */
    void chooseSinger(List<Song> songList, List<Song> haveSong, Scanner scanner);

    /**
     * 歌曲类型
     *
     * @param songList
     * @param haveSong
     * @param scanner
     */
    void chooseSpecies(List<Song> songList, List<Song> haveSong, Scanner scanner);

    /**
     * 好歌排行榜
     *
     * @param songList
     * @param haveSong
     * @param scanner
     */
    void songRank(List<Song> songList, List<Song> haveSong, Scanner scanner);

    /**
     * 已点歌曲列表
     *
     * @param haveSong
     */
    void hSong(List<Song> haveSong);

    /**
     * 歌曲置顶
     *
     * @param haveSong
     * @param scanner
     */
    void zhiDing(List<Song> haveSong, Scanner scanner);

    /**
     * 删除歌曲
     *
     * @param haveSong
     * @param scanner
     */
    void delete(List<Song> haveSong, Scanner scanner);

    /**
     * 将歌曲前移一位
     *
     * @param haveSong
     * @param scanner
     */
    void qianYi(List<Song> haveSong, Scanner scanner);


}
