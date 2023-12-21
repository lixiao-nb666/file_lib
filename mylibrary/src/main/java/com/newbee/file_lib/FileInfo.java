package com.newbee.file_lib;

import java.io.File;
import java.io.Serializable;

public class FileInfo implements Serializable {
	private String fileName;
	private String filePath;
	private	FileType fileType;

	public FileInfo(){}

	public FileInfo(String fileName, String filePath) {
		this.fileName = fileName;
		this.filePath = filePath;
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

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return "FileInfo{" +
				"fileName='" + fileName + '\'' +
				", filePath='" + filePath + '\'' +
				", fileType=" + fileType +
				'}';
	}
}
