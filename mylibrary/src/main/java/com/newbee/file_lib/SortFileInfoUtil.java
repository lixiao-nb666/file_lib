package com.newbee.file_lib;

import android.util.ArrayMap;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import java.util.List;
import java.util.Map;

public class SortFileInfoUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");

    public static List<SortFileInfo> getSortFileInfoList(List<FileInfo> fileInfoList){
        if(null==fileInfoList||fileInfoList.size()==0){
            return null;
        }
//        sortFileInfoList(fileInfoList);

        Map<String,SortFileInfo>sortFileInfoMap=new ArrayMap<>();
        for(FileInfo fileInfo:fileInfoList){
            Date date = new Date(fileInfo.getLastTime());
            String timeStr=sdf.format(date);

            SortFileInfo sortFileInfo=sortFileInfoMap.get(timeStr);
            if(null==sortFileInfo){
                sortFileInfo=new SortFileInfo(timeStr,fileInfo.getLastTime());
            }
            sortFileInfo.addFileInfo(fileInfo);
            sortFileInfoMap.put(timeStr,sortFileInfo);
        }

        List<SortFileInfo>sortFileInfoList=new ArrayList<>(sortFileInfoMap.values());
        sortSortFileInfoList(sortFileInfoList);
        return sortFileInfoList;
    }


    public static   void sortFileInfoList(List<FileInfo> fileInfoList){
        Comparator comparator=  new Comparator<FileInfo>() {
            @Override
            public int compare(FileInfo f1, FileInfo f2) {
                long diff = f1.getLastTime() - f2.getLastTime();
                if (diff > 0)
                    return -1;
                else if (diff == 0)
                    return 0;
                else
                    return 1;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        Collections.sort(fileInfoList,comparator);
    }


    public static   void sortSortFileInfoList(List<SortFileInfo> sortFileInfoList){
        Comparator comparator=  new Comparator<SortFileInfo>() {
            @Override
            public int compare(SortFileInfo f1, SortFileInfo f2) {
                long diff = f1.getLastTime() - f2.getLastTime();
                if (diff > 0)
                    return -1;
                else if (diff == 0)
                    return 0;
                else
                    return 1;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        Collections.sort(sortFileInfoList,comparator);
    }

}
