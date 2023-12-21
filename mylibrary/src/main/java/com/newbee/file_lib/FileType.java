package com.newbee.file_lib;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 黎潇自写文件搜索的格式类
 */
public enum FileType {
    NONE,//空
    VIDEO,//视频
    VOICE,//音频
    APK,//安装apk
    IMAGE,//图片
    GIF,//可动图
    HTML,//网页
    ;
    private List<String> checkStrList;

    public List<String> getCheckStrList() {
        if(checkStrList==null||checkStrList.size()==0){
           checkStrList= FileTypeUtil.initList(this);
        }
        return checkStrList;
    }







}
