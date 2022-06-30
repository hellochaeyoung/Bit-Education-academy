package javaFileRead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		File file = new File("c:\\Temp\\newfile.txt");
		
		// 한 글자씩 읽기, 잘 사용하지 않음
		FileReader fr = new FileReader(file);
		int ch = fr.read();
		while((ch = fr.read()) != -1) {
			System.out.println((char)ch);
		}
		fr.close();
		
		// 한 문장으로 읽기
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String str = "";
		while((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();

	}

}
