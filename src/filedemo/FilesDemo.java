package filedemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	public static void main(String ...args) throws FileNotFoundException {
		String sourceDir = "E:\\ecploseOxygenWorkSpace\\f4_new\\webapp\\html\\";
		List<File> fileList = new FilesDemo().RecurTraversalFolder(sourceDir, new MyFilenameFilter());
		Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]*");
        StringBuilder outputString = new StringBuilder();
		for(File file : fileList) {
			StringBuffer buffer = new StringBuffer();
	        BufferedReader bf= new BufferedReader(new FileReader(file));
	        String s = null;
	        try {
				while((s = bf.readLine()) != null){//使用readLine方法，一次读一行
				    buffer.append(s.trim());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	        String xml = buffer.toString();
	        Matcher m = p.matcher(xml);
	        int index = 1;
	        outputString.append("\r\n路径：" + file.getAbsolutePath() + "\r\n");
	        while(m.find()) {
	        	if(!"".equals(m.group())) {
	        		outputString.append("\t" + m.group() + ",");
	        		if(index % 5 == 0) {
	        			outputString.append("\r\n");
	        		}
	        		index++;
	        	}
	        }
	        if((index-1) % 5 != 0) {
	        	outputString.append("\r\n");
	        }
		}
        FileOutputStream fopS = new FileOutputStream(".\\newFiles.txt");
		try {
			fopS.write(outputString.toString().getBytes());
			fopS.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
