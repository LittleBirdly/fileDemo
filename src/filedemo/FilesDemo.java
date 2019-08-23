package filedemo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilesDemo {
	

	public List<File> RecurTraversalFolder(String folderDir) {
		
		
		return RecurTraversalFolder(folderDir, new ArrayList<File>(), null);
	}
	
	public List<File> RecurTraversalFolder(String folderDir, FilenameFilter myFilter) {
		
		
		return RecurTraversalFolder(folderDir, new ArrayList<File>(), myFilter);
	}
	
	private List<File> RecurTraversalFolder(String folderDir, List<File> reFiles, FilenameFilter myFilter) {
		File[] files = (new File(folderDir)).listFiles();
		for(File file : files) {
			if(file.isDirectory()) {
				RecurTraversalFolder(file.getAbsolutePath() + "\\", reFiles, myFilter);
			} else {
				if(null != myFilter) {
					if(myFilter.accept(file, file.getName())) {
						reFiles.add(file);
					}
				} else {
					reFiles.add(file);
				}
			}
		}
		
		return reFiles;
	}
	
	/***
	 * 将目录下的文件名称汇总并输出到一个文件中
	 * @author ChenJN
	 * @date 2019年1月23日
	 * @param inputUrl 输入文件路径
	 * @param outputUrl 输出文件路径
	 * @param outputFileName 输出文件名称及文件格式
	 * @throws FileNotFoundException 
	 */
	public void outputFilesInfo(String inputUrl, String outputUrl, String outputFileName, FilenameFilter myFilter) throws FileNotFoundException {
		List<File> fileList = new FilesDemo().RecurTraversalFolder(inputUrl, myFilter);
        StringBuilder outputString = new StringBuilder();
		for(File file : fileList) {
			System.out.println(file.getName() + "\r\n");
	        outputString.append(file.getName() + "\r\n");
		}
        FileOutputStream fopS = new FileOutputStream(outputUrl + "\\" + outputFileName);
		try {
			fopS.write(outputString.toString().getBytes());
			fopS.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String ...args) throws FileNotFoundException {
//		String sourceDir = "E:\\ecploseOxygenWorkSpace\\f4_new\\webapp\\html\\";
//		List<File> fileList = new FilesDemo().RecurTraversalFolder(sourceDir, new MyFilenameFilter());
//		Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]*");
//        StringBuilder outputString = new StringBuilder();
//		for(File file : fileList) {
//			StringBuffer buffer = new StringBuffer();
//	        BufferedReader bf= new BufferedReader(new FileReader(file));
//	        String s = null;
//	        try {
//				while((s = bf.readLine()) != null){//使用readLine方法，一次读一行
//				    buffer.append(s.trim());
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	
//	        String xml = buffer.toString();
//	        Matcher m = p.matcher(xml);
//	        int index = 1;
//	        outputString.append("\r\n路径：" + file.getAbsolutePath() + "\r\n");
//	        while(m.find()) {
//	        	if(!"".equals(m.group())) {
//	        		outputString.append("\t" + m.group() + ",");
//	        		if(index % 5 == 0) {
//	        			outputString.append("\r\n");
//	        		}
//	        		index++;
//	        	}
//	        }
//	        if((index-1) % 5 != 0) {
//	        	outputString.append("\r\n");
//	        }
//		}
//        FileOutputStream fopS = new FileOutputStream(".\\newFiles.txt");
//		try {
//			fopS.write(outputString.toString().getBytes());
//			fopS.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		new FilesDemo().outputFilesInfo("C:\\Chen\\Work\\项目文件\\徐州弘安DMS\\doc\\开发文档\\系统导入模板", "C:\\Chen\\Work\\项目文件\\徐州弘安DMS\\doc\\开发文档\\系统导入模板", "fileNames.txt", null);


		//使用POI插件读取WORD文档
//		try {
//			File file = new File("C:\\Users\\a2526\\Desktop\\整车退厂返修逻辑(1).doc");
//			System.out.println(file.length());
//			BufferedInputStream inBuff = new BufferedInputStream(new FileInputStream(file));
//			StringBuilder result = new StringBuilder();
//			WordExtractor re = new WordExtractor(inBuff);
//			result.append(re.getText());
//			re.close();
//			System.out.println(result.toString());

//			byte[] b = new byte[1024 * 14];
//			int len;
//			while ((len = inBuff.read(b)) != -1) {
//
//				System.out.println(new String(new String("陈俊楠").getBytes("GB2312-80"), "GB2312-80"));
//			}

//		} catch(Exception e) {
//
//		}

	}
}
