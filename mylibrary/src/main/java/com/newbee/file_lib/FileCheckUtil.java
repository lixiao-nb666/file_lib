package com.newbee.file_lib;

import android.util.Log;

public class FileCheckUtil {


    public static boolean checkStrIsOk(String nowFileName,String checkStr){

        if(nowFileName.length()<checkStr.length()){
            return false;
        }
        String needCheckStr=nowFileName.substring(nowFileName.length()-checkStr.length());
        return needCheckStr.equals(checkStr);
    }

}
