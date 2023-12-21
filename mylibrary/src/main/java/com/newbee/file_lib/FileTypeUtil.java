package com.newbee.file_lib;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class FileTypeUtil {

    /**
     * 文件为视频的数组
     */
    private static String fileIsVideo[] = {".mp4", ".3gp", ".wmv", ".ts", ".rmvb", ".mov", ".m4v", ".avi", ".m3u8", ".3gpp", ".3gpp2", ".mkv", ".flv", ".divx", ".f4v", ".rm", ".asf", ".ram", ".mpg", ".v8", ".swf", ".m2v", ".asx", ".ra", ".ndivx", ".xvid"};
    /**
     * 文件为音频的数组q3
     */
    private static String fileIsVoice[] = {".mp3", ".aac", ".wav", ".wma", ".cda", ".flac", ".m4a", ".mid", ".mka", ".mp2", ".mpa", ".mpc", ".ape", ".ofr", ".ogg", ".ra", ".wv", ".tta", ".ac3", ".dts"};

    /**
     * 文件为APK的数组
     */
    private static String fileIsApk[] = {".apk"};

    private static String fileIsImage[] = {".bmp", ".jpg", ".png", ".tiff", ".gif", ".pcx", ".tga", ".exif", ".fpx", ".svg", ".psd", ".cdr", ".pcd", ".dxf", ".ufo", ".eps", ".ai", ".raw", ".jpeg"};
    private static String fileiIsGif[] = {".gif"};
    private static String fileiIsHtml[] = {".html"};
    private static String[] fileTypes[] = {fileIsVideo, fileIsVoice, fileIsApk, fileIsImage, fileiIsGif, fileiIsHtml};


    public static List<String> initList(FileType fileType) {
        switch (fileType) {
            case VIDEO:
                return addListData(fileIsVideo);
            case VOICE:
                return addListData(fileIsVoice);
            case APK:
                return addListData(fileIsApk);
            case IMAGE:
                return addListData(fileIsImage);
            case GIF:
                return addListData(fileiIsGif);
            case HTML:
                return addListData(fileiIsHtml);
            default:
                return null;
        }
    }


    private static List<String> addListData(String[] ss) {
        List checkStrList = new ArrayList<>();
        for (String s : ss) {
            checkStrList.add(s);
        }
        return checkStrList;
    }

    /**
     * 0为视频，1为音频，2为APK，3为图片，4为GIF图片,5为HTML
     * <p>
     * 至于为什么错误会返回99，因为99皮炎平啊
     */
    public static FileType getFileType(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return FileType.NONE;
        }
        int index = filePath.lastIndexOf(".");
        if (index <= 0) {
            return FileType.NONE;
        }

        String filePathLow = filePath.toLowerCase();
        for (FileType fileType : FileType.values()) {
            List<String> checkList = fileType.getCheckStrList();
            if (null != checkList && checkList.size() > 0) {
                for (String s : checkList) {
                    if (FileCheckUtil.checkStrIsOk(filePathLow, s)) {
                        return fileType;
                    }
                }
            }
        }
        return FileType.NONE;
    }

}
