package com.newbee.file_lib;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.newbee.file.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<FileInfo> list=new ArrayList<>();
        list=MyFileSearch.getPhoneAllVideoFile(list);
        for(FileInfo fileInfo:list){
            Log.i("kankanshenmegui","kankanwenjian:"+fileInfo);
        }

        Log.i("kankanshenmegui","kankanwenjian:11111");
    }
}
