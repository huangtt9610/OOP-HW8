import java.util.LinkedList;
import java.util.*;
import java.io.*;

public class Dir_tree {
	
	public static void main(String[] args) {
		try {
		PrintWriter f = new PrintWriter("dir_tree.txt");
		Scanner s=new Scanner(System.in);
		
		System.out.print("Please enter you Path--> ");
		
		File file = new File(s.next());
		f.println(printTree(file));
		
		s.close();
		f.close();
		
		}catch (Exception e) { System.out.println(e);}
	}
	
	//reference to https://stackoverflow.com/questions/33437166/print-directory-like-tree-command
	public static StringBuilder printTree(File f) {
		StringBuilder sb =new StringBuilder();
		
		sb.append("C: "+f.getName() + "\r\n");
		printTree(f,sb,"");
		return sb;
	}

	private static void printTree(File f, StringBuilder sb,String header) {
		LinkedList<File> file =new LinkedList<>();
		LinkedList<File> folder =new LinkedList<>();
		
		
		for(File temp: f.listFiles()) {
			if(temp.isFile()) {
				file.add(temp);
			}
			else {
				folder.add(temp);
			}
		}
		
		if(folder.isEmpty()) {
			printOutFile(file,sb,header+"   ");
		}
		else {
			printOutFile(file,sb,header+"|    ");
		}
		
		while(!folder.isEmpty()) {
			File temp = folder.poll();
			if(folder.isEmpty()) {
				printTree(temp,sb.append(header+"+------"+temp.getName()+"\r\n"),header+"     ");
			}
			else {
				printTree(temp,sb.append(header+"|------"+temp.getName()+"\r\n"),header +"|    ");
			}
		}
		
	}

	private static void printOutFile(LinkedList<File> file, StringBuilder sb,String header) {
		while(!file.isEmpty())
			sb.append(header + "  " +file.poll().getName() + "\r\n");		
	}
}		



