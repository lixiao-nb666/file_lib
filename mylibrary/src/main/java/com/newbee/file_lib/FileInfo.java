package com.newbee.file_lib;

import java.io.File;
import java.io.Serializable;

public class FileInfo implements Serializable {
	private String fileName;
	private String filePath;
	private	long lastTime;
	private     double len;//KB

	public FileInfo(String fileName, String filePath, long lastTime,double len) {
		this.fileName = fileName;
		this.filePath = filePath;
		this.lastTime = lastTime;
		this.len=len;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public long getLastTime() {
		return lastTime;
	}

	public void setLastTime(long lastTime) {
		this.lastTime = lastTime;
	}

	public double getLen() {
		return len;
	}

	public void setLen(double len) {
		this.len = len;
	}

	@Override
	public String toString() {
		return "FileInfo{" +
				"fileName='" + fileName + '\'' +
				", filePath='" + filePath + '\'' +
				", lastTime=" + lastTime +
				", len=" + len +
				'}';
	}
}
