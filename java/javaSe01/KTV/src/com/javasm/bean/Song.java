package com.javasm.bean;

import com.javasm.util.PinYinUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/18-19:47
 * @Since:jdk1.8
 * @Description:
 */
@Data


public class Song implements Comparable<Song>{
    //歌名
    private String name;
    //简拼
    private String jpName;
    //全拼
    private String qpName;
    //歌手
    private String singer;
    //歌曲时长
    private String time;
    //歌曲类别
    private String species;
    //被点次数
    private Integer count;

    public Song(String name, String singer, String time, String species, Integer count) {
        this.name = name;
        this.jpName = PinYinUtil.getUpperCase(name,false);
        this.qpName = PinYinUtil.getUpperCase(name,true);
        this.singer = singer;
        this.time = time;
        this.species = species;
        this.count = count;
    }

    @Override
    public int compareTo(Song o) {
        return (this.getCount() > o.getCount()) ? -1 : ((this.getCount() == o.getCount()) ? 0 : 1);
    }
}
