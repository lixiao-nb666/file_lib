package com.newbee.file_lib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SortFileInfo implements Serializable {

    private String timeStr;
    private long lastTime;
    private List<FileInfo> fileInfoList;

    public SortFileInfo(String timeStr, long lastTime) {
        this.timeStr = timeStr;
        this.lastTime = lastTime;
    }

    public long getLastTime() {
        return lastTime;
    }

    @Override
    public String toString() {
        return "SortFileInfo{" +
                "timeStr='" + timeStr + '\'' +
                ", lastTime=" + lastTime +
                ", fileInfoList=" + fileInfoList +
                '}';
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public List<FileInfo> getFileInfoList() {
        return fileInfoList;
    }

    public void setFileInfoList(List<FileInfo> fileInfoList) {
        this.fileInfoList = fileInfoList;
    }

    public void addFileInfo(FileInfo fileInfo){
        if(null==fileInfo){
            return;
        }
        if(null==fileInfoList){
            fileInfoList=new ArrayList<>();
        }
        fileInfoList.add(fileInfo);
    }


}
