package kustomize;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.stream.Stream;

public class KustomizeFileReader {


	private static final String FILENAME = "kustomization.yaml";
	private HashSet<String> set = new HashSet<String>(); 
	
	public HashSet<String> getFilesToDownload(String pBuildPath) {
	    set.add(pBuildPath+File.separator+FILENAME);
		//System.out.println("file to download:"+pBuildPath+File.separator+FILENAME);
				try (Stream<String> items = Files.lines(Paths.get(pBuildPath+File.separator+FILENAME))) {
					items
					.filter(s->s.trim().startsWith("-"))
					.filter(s->!s.contains(":"))
					.forEach(s -> {
						s = (s.substring(s.indexOf("-")+1,s.length())).trim();
						if(s.endsWith(".yaml")||s.endsWith(".yml")||s.endsWith(".txt")){
							//System.out.println("file to download:"+ pBuildPath+File.separator+s);
							set.add(pBuildPath+File.separator+s);
						}
						else {
							getFilesToDownload(getSubFolder(s,pBuildPath));
						}
					});
				} catch (IOException e) {
					e.printStackTrace();
				}
		return set;
	}
	
	private String getSubFolder(String pRelativePath, String pBasePath){
		String levels = pRelativePath.substring(0, pRelativePath.lastIndexOf("/")+1);
		String sPath = pRelativePath.substring(pRelativePath.lastIndexOf("/")+1);
		if(levels.startsWith("./")) {
			return pBasePath+File.separator+sPath;
		}else {
			int lev = levels.length() - levels.replaceAll("/", "").length();
			for(int i=0; i < lev;i++) {
				pBasePath = pBasePath.substring(0,pBasePath.lastIndexOf("/"));
			}
			return pBasePath+File.separator+sPath;
		}
	}
	
	
}
