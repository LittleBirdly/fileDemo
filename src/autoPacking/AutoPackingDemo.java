package autoPacking;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import filedemo.FilesDemo;
import filedemo.MyFilenameFilter;

/***
 * 半自动打增量包工具
 * @author ChenJN
 * @date 2018年11月22日
 */
public class AutoPackingDemo {
	 
		public static String patchFile="D:/patch.txt";//补丁文件,由eclipse svn plugin生成
		
//		public static String projectPath="E:\\ecploseOxygenWorkSpace\\Hozon_inter_NewDev";//项目文件夹路径-接口
		public static String projectPath="E:\\ecploseOxygenWorkSpace\\Hozon_newDev";//项目文件夹路径-业务
		
		public static String webContent="WebContent";//web应用文件夹名
		
		public static String classPath="D:/workspace/FordClubJeeCms/build";//class存放路径
		
		public static String desPath="E:/项目文件/合众开发/10.生产环境更新计划/增量包";//补丁文件包存放路径
		
		public static String version="20190107/1.0/";//补丁版本
		
		public static void main(String[] args) throws Exception { 
			List<String> fileNameList = new ArrayList<String>(); 
			
			fileNameList.add("OldReturnServiceImpl.java");   

			copyFiles(fileNameList);      
		}
		
		public static List<String> getPatchFileList() throws Exception{
			List<String> fileList=new ArrayList<String>();
			FileInputStream f = new FileInputStream(patchFile); 
			BufferedReader dr=new BufferedReader(new InputStreamReader(f,"utf-8"));
			String line;
			while((line=dr.readLine())!=null){
				if(line.indexOf("Index:")!=-1){
					line=line.replaceAll(" ","");
					line=line.substring(line.indexOf(":")+1,line.length());
					fileList.add(line);
				}
			} 
			return fileList;
		}
		
		public static void copyFiles(List<String> list) {
			
			List<String> fileNameList = new ArrayList<String>();
			for(String fileName : list) {
				if(fileName.indexOf(".java") != -1) {
					
					//找到java文件对应的class文件
					fileName = fileName.replace(".java", ".class");
					fileNameList.add(fileName);
				} else {
					fileNameList.add(fileName);
				}
			}
			
			System.out.println("-----------------待匹配文件列表展示开始-----------------");
			for(String fileName : fileNameList) {
				System.out.println(fileName);
			}
			System.out.println("-----------------待匹配文件列表展示结束-----------------");
			
			
			List<File> fileList = new FilesDemo().RecurTraversalFolder(projectPath, new MyFilenameFilter(fileNameList));
			
			System.out.println("-----------------已匹配文件路径列表展示开始-----------------");
			for(File file : fileList) {
				System.out.println(file.getAbsolutePath());
				
				//创建目标文件存放位置父级目录
				File descParent = new File(desPath + "/" + version + "/" + file.getParent().replace(projectPath, ""));
				if(!descParent.exists()) {
					descParent.mkdirs();
				}
				
				copyFile(file.getAbsolutePath(), desPath + "/" + version + "/" + file.getAbsolutePath().replace(projectPath, ""));
			}
			System.out.println("-----------------已匹配文件路径列表展示结束-----------------");
			System.out.println("-----------------需匹配文件项数:"+fileNameList.size()+"-----------------");
			System.out.println("-----------------已匹配文件项数:"+fileList.size()+"-----------------");
			
			
//			for(String fullFileName:list){
//				if(fullFileName.indexOf("src/")!=-1){//对源文件目录下的文件处理
//					String fileName=fullFileName.replace("src","");
//					fullFileName=classPath+fileName;
//					if(fileName.endsWith(".java")){
//						fileName=fileName.replace(".java",".class");
//						fullFileName=fullFileName.replace(".java",".class");
//					}
//					String tempDesPath=fileName.substring(0,fileName.lastIndexOf("/"));
//					String desFilePathStr=desPath+"/"+version+"/WEB-INF/classes"+tempDesPath;
//					String desFileNameStr=desPath+"/"+version+"/WEB-INF/classes"+fileName;
//					File desFilePath=new File(desFilePathStr);
//					if(!desFilePath.exists()){
//						desFilePath.mkdirs();
//					}
//					copyFile(fullFileName, desFileNameStr);
//					System.out.println(fullFileName+"复制完成");
//				}else{//对普通目录的处理
//					String desFileName=fullFileName.replaceAll(webContent,"");
//					fullFileName=projectPath+"/"+fullFileName;//将要复制的文件全路径
//					String fullDesFileNameStr=desPath+"/"+version+desFileName;
//					String desFilePathStr=fullDesFileNameStr.substring(0,fullDesFileNameStr.lastIndexOf("/"));
//					File desFilePath=new File(desFilePathStr);
//					if(!desFilePath.exists()){
//						desFilePath.mkdirs();
//					}
//					copyFile(fullFileName, fullDesFileNameStr);
//					System.out.println(fullDesFileNameStr+"复制完成");
//				}
//				
//			}
			
		}
		
		/***
		 * 复制源文件到指定目录
		 * @author ChenJN
		 * @date 2018年11月4日
		 * @param sourceFileNameStr 原文件路径
		 * @param desFileNameStr 目标文件路径
		 */
		private static void copyFile(String sourceFileNameStr, String desFileNameStr) {
			File srcFile=new File(sourceFileNameStr);
			File desFile=new File(desFileNameStr);
			try {
				copyFile(srcFile, desFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	 
		
		/***
		 * 复制源文件到指定目录
		 * @author ChenJN
		 * @date 2018年11月4日
		 * @param sourceFile 原文件
		 * @param targetFile 目标文件
		 * @throws IOException
		 */
		public static void copyFile(File sourceFile, File targetFile) throws IOException {
	        BufferedInputStream inBuff = null;
	        BufferedOutputStream outBuff = null;
	        try {
	            // 新建文件输入流并对它进行缓冲
	            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
	 
	            // 新建文件输出流并对它进行缓冲
	            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
	 
	            // 缓冲数组
	            byte[] b = new byte[1024 * 5];
	            int len;
	            while ((len = inBuff.read(b)) != -1) {
	                outBuff.write(b, 0, len);
	            }
	            // 刷新此缓冲的输出流
	            outBuff.flush();
	        } finally {
	            // 关闭流
	            if (inBuff != null)
	                inBuff.close();
	            if (outBuff != null)
	                outBuff.close();
	        }
	    }
		
	}
