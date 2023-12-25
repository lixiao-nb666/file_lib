package com.newbee.file_lib;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;


/**
 * 黎潇自己写的搜索器
 */
public class MyFileSearch {

    private static String tag = "MyFileSearch>>>";

    /**
     * 获取你所需要的文件下面的符合条件的文件集合
     *
     * @param fileInfos
     * @param file
     * @param MyFileFilter
     * @return
     */
    public static ArrayList<FileInfo> getAllNeedFile(
            ArrayList<FileInfo> fileInfos, File file, MyFileFilter MyFileFilter) {
        tag = "MyFileSearch>>>getAllNeedFile()";
        File files[] = {};
        File needFiles[] = {};
        files = getFiles(file);
        needFiles = getFiles(file, MyFileFilter);

        try {
            for (int i = 0; i < needFiles.length; i++) {
                long length =needFiles[i].length();
                double len=(double)length/1024;//kb
                fileInfos.add(new FileInfo(needFiles[i].getName(), needFiles[i]
                        .getAbsolutePath(),needFiles[i].lastModified(),len));
            }
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    getAllNeedFile(fileInfos, files[i], MyFileFilter);
                }
            }
        } catch (Exception e) {
            Log.w(tag, e);
        }

        return fileInfos;
    }

    /**
     * 获取手机所有的目录集合
     */
    public static ArrayList<FileInfo> getPhoneAllFile(
            ArrayList<FileInfo> fileInfos) {
        tag = "MyFileSearch>>>getPhoneAllFile()";

        File file = Environment.getExternalStorageDirectory();
        File files[] = getFiles(file);
        for (int i = 0; i < files.length; i++) {
            long length =files[i].length();
            double len=(double)length/1024;//kb
            fileInfos.add(new FileInfo(files[i].getName(), files[i]
                    .getAbsolutePath(),files[i].lastModified(),len));
            if (files[i].isDirectory()) {
                getPhoneAllFile(fileInfos, files[i]);
            }
        }
        return fileInfos;
    }

    /**
     * 获取对应文件所有的目录集合
     */
    public static ArrayList<FileInfo> getPhoneAllFile(
            ArrayList<FileInfo> fileInfos, File file) {
        tag = "MyFileSearch>>>getPhoneAllFile()";
        File files[] = getFiles(file);
        for (int i = 0; i < files.length; i++) {
            long length =files[i].length();
            double len=(double)length/1024;//kb
            fileInfos.add(new FileInfo(files[i].getName(), files[i]
                    .getAbsolutePath(),files[i].lastModified(),len));
            if (files[i].isDirectory()) {
                getPhoneAllFile(fileInfos, files[i]);
            }
        }
        return fileInfos;
    }

    /**
     * 获取手机对应搜索条件文件集合
     */
    public static ArrayList<FileInfo> getPhoneAllFile(
            ArrayList<FileInfo> fileInfos, MyFileFilter MyFileFilter) {
        File file = Environment.getExternalStorageDirectory();
        return getAllNeedFile(fileInfos, file, MyFileFilter);
    }

    /**
     * 获取手机所有的视频文件集合
     */
    public static ArrayList<FileInfo> getPhoneAllVideoFile(
            ArrayList<FileInfo> fileInfos) {
        File file = Environment.getExternalStorageDirectory();
        return getAllNeedFile(fileInfos, file, new MyFileFilter(
                FileType.VIDEO.getCheckStrList()));
    }

    /**
     * 获取手机所有的音频文件集合
     */
    public static ArrayList<FileInfo> getPhoneAllVoiceFile(
            ArrayList<FileInfo> fileInfos) {
        File file = Environment.getExternalStorageDirectory();
        return getAllNeedFile(fileInfos, file, new MyFileFilter(
                FileType.VOICE.getCheckStrList()));
    }

    /**
     * 获取手机所有的APK文件集合
     */
    public static ArrayList<FileInfo> getPhoneAllAPKFile(
            ArrayList<FileInfo> fileInfos) {
        File file = Environment.getExternalStorageDirectory();
        return getAllNeedFile(fileInfos, file, new MyFileFilter(
                FileType.APK.getCheckStrList()));
    }

    /**
     * 获取手机所有的图片文件集合
     */
    public static ArrayList<FileInfo> getPhoneAllImageFile(
            ArrayList<FileInfo> fileInfos) {
        File file = Environment.getExternalStorageDirectory();
        return getAllNeedFile(fileInfos, file, new MyFileFilter(
                FileType.IMAGE.getCheckStrList()));
    }

    /**
     * 获取指定文件所有的视频文件集合
     */
    public static ArrayList<FileInfo> getAllVideoFile(
            ArrayList<FileInfo> fileInfos, File file) {
        return getAllNeedFile(fileInfos, file, new MyFileFilter(
                FileType.VIDEO.getCheckStrList()));
    }

    /**
     * 获取指定文件所有的音频文件集合
     */
    public static ArrayList<FileInfo> getAllVoiceFile(
            ArrayList<FileInfo> fileInfos, File file) {
        return getAllNeedFile(fileInfos, file, new MyFileFilter(
                FileType.VOICE.getCheckStrList()));
    }

    /**
     * 获取指定文件所有的APK文件集合
     */
    public static ArrayList<FileInfo> getAllAPKFile(
            ArrayList<FileInfo> fileInfos, File file) {
        return getAllNeedFile(fileInfos, file, new MyFileFilter(
                FileType.APK.getCheckStrList()));
    }

    /**
     * 获取指定文件所有的图片文件集合
     */
    public static ArrayList<FileInfo> getAllImageFile(
            ArrayList<FileInfo> fileInfos, File file) {
        return getAllNeedFile(fileInfos, file, new MyFileFilter(
                FileType.IMAGE.getCheckStrList()));
    }

    /**
     * 传入需要搜索的文件，跟自定义的所有条件,返回所有符合条件的文件
     *
     * @param file
     * @param MyFileFilter
     * @return
     */
    public static File[] getFiles(File file, MyFileFilter MyFileFilter) {
        File[] files = {};
        try {
            files = file.listFiles(MyFileFilter);
        } catch (Exception e) {
            Log.e(tag + "getfiles()>>>", e.toString());
        }
        return files;
    }

    /**
     * 传入需要搜索的文件，获取该文件的所有子目录
     *
     * @param file
     * @return
     */
    public static File[] getFiles(File file) {
        File[] files = {};
        try {
            files = file.listFiles();
        } catch (Exception e) {
            Log.e(tag + "getfiles()>>>", e.toString());
        }
        return files;
    }

}
