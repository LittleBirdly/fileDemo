package filedemo;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
@MyAnnotation
public class MyFilenameFilter implements FilenameFilter {
	List<String> fileNameList = null;			//文件名列表
	
	
	public MyFilenameFilter() {
		
	}
	
	public MyFilenameFilter(List<String> fileNameList) {
		this.fileNameList = fileNameList;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		if(null == fileNameList) {
			if(name.toLowerCase().endsWith(".txt")) {
				
				return false;
			} else if(name.toLowerCase().endsWith(".html")) {
				
				return true;
			}
		} else {
			for(String fileName : fileNameList) {
				if(name.equals(fileName)) {
					
					return true;
				}
			}
		}
		
		return false;
	}

}
