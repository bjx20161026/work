package com.jobsAutomatic.service.util.ftp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FileOperate {

	private String url;

	private FtpFileObject fileObject;
	private FTPClient ftpClient;

	String localUrl = "../data/";

	public FileOperate(String url) {
		this.url = url;
		fileObject = new FtpFileObject(url);
	}

	public String getDownloadFile() throws Exception {
		String filePath = null;
		File file = new File(localUrl);
		if (!file.exists() && !file.isDirectory())
			file.mkdirs();
		filePath = localUrl + url.substring(url.lastIndexOf("/") + 1);
		login();
		cd();
		get(url.substring(url.lastIndexOf("/") + 1), new FileOutputStream(filePath));
		return filePath;
	}
	
	public static void main(String[] args){
		FileOperate fo = new FileOperate("ftp://EOMS_PUT:W1n3m5s#@10.221.232.136:21/EOMS_APP/DATA.PM.WLAN_RW_TW_BG.EOMS_APP/SH-201-170706-00001_WLAN.xls");
	    String a;
		try {
			a = fo.getDownloadFile();
		    System.out.println(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void Makedirs(){
		
	}
	

	public void login() throws Exception {
		FtpFileObject ffo = fileObject;
		ftpClient = new FTPClient();
		ftpClient.setControlEncoding("utf-8");
		ftpClient.connect(ffo.getHost());
		ftpClient.login(ffo.getUsername(), ffo.getPassword());
		ftpClient.enterLocalPassiveMode();
		
	}

	public void cd() throws Exception {
		if (fileObject.getDir() != null && !fileObject.getDir().equals("") && !fileObject.getDir().equals("/"))
			cd(fileObject.getDir());
	}

	public void cd(String dir) throws Exception {
		ftpClient.changeWorkingDirectory(dir);
	}

	public String[] ls() throws Exception {
		String[] names = ftpClient.listNames();
		return names;

	}

	public void get(OutputStream os) throws Exception {
		get(fileObject.getName(), os);
	}

	public void get(String filename, OutputStream os) throws Exception {
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		ftpClient.enterLocalPassiveMode();
		ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
		ftpClient.setControlEncoding("utf-8");
		ftpClient.retrieveFile(filename, os);
		os.flush();
		os.close();
	}

	public InputStream get(String filename) throws Exception {
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		ftpClient.enterLocalPassiveMode();
		ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
		ftpClient.setControlEncoding("utf-8");
		return ftpClient.retrieveFileStream(filename);
	}

	public void put(InputStream is) throws Exception {
		put(fileObject.getName(), is);
	}

	public void put(String filename, InputStream is) throws Exception {

		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		ftpClient.enterLocalPassiveMode();
		ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
		ftpClient.setControlEncoding("utf-8");
		String name = filename + ".temp";
		ftpClient.storeFile(name, is);
		ftpClient.rename(name, filename);
	}

	public void disConnect() {
		try {
			ftpClient.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public FtpFileObject getFileObject() {
		return fileObject;
	}

	public void setFileObject(FtpFileObject fileObject) {
		this.fileObject = fileObject;
	}

	public FTPClient getFtpClient() {
		return ftpClient;
	}

	public void setFtpClient(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}
}
