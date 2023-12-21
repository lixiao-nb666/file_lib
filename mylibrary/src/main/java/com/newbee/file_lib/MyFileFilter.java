package com.newbee.file_lib;

import android.text.TextUtils;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

/**
 * 
 * 黎潇自己定义的FILE过滤器
 * 
 */
public class MyFileFilter implements FileFilter{
	private String checkStr;
	private List<String> checkList;
	private FileFilterCheckType checkType;
	public MyFileFilter(String filterstring){
		checkType= FileFilterCheckType.STRING;
		checkStr=filterstring.toLowerCase();
	}

	public MyFileFilter(List<String> checkList){
		checkType= FileFilterCheckType.LIST;
		this.checkList=checkList;
	}
	@Override
	public boolean accept(File pathname) {
		try {
			if(pathname.isDirectory()){
				return false;
			}

			String filename = pathname.getName().toLowerCase();
			switch (checkType){
				case STRING:
					if(TextUtils.isEmpty(checkStr)){
						return false;
					}
					return FileCheckUtil.checkStrIsOk(filename,checkStr);
				case LIST:
					if(null==checkList||checkList.size()==0){
						return false;
					}
					for(String s:checkList){
						if(FileCheckUtil.checkStrIsOk(filename,s)){
							return true;
						}
					}
					break;
			}
		}catch (Exception e){
		}
		return false;
	}





	private enum FileFilterCheckType{
		NONE,
		STRING,
		LIST,
	}

}
