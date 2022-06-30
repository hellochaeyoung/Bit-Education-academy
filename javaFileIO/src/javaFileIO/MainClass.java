package javaFileIO;

import java.io.File;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) throws Exception{
		/*
		 * 	저장 매체 : 파일, Database
		 * 
		 * 	*.txt, dll, lib
		 * 
		 * 	dll = Dynamic Link Library -> 동적 파일
		 *  -> 프로그램 실행 중 필요에 의해서 호출하여 사용하는 파일
		 *  -> 불안정, 보안 위험 있지만 장점이 더 많기 때문에 사용
		 * 	
		 * 	lib = Library -> 정적 파일
		 *  -> 메모리에 항상 저장해두고 사용하는 파일, 용량이 클 경우 굉장히 무거워질 수 있다.
		 * 
		 * 
		 */
		
		File file = new File("c:\\");
		/*
		 * String[] fileList = file.list();
		 * 
		 * for (int i = 0; i < fileList.length; i++) { System.out.println(fileList[i]);
		 * }
		 */
		
		File fileList[] = file.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			if(fileList[i].isFile()) {
				System.out.println("[파일]" + fileList[i].getName());
			}else if(fileList[i].isDirectory()) {
				System.out.println("[폴더]" + fileList[i].getName());
			}else {
				System.out.println("[?]" + fileList[i].getName());
			}
		}
		
		File newFile = new File("c:\\Temp\\newfile.txt");
			
		if(newFile.createNewFile()) {
			System.out.println("파일 생성 성공~");
		}else {
			System.out.println("파일 생성 실패~");
		}
		
		// 폴더 생성
		File newDir = new File("c:\\Temp\\subDir");
		if(newDir.mkdir()) {
			System.out.println("폴더 생성 성공!");
		}else {
			System.out.println("폴더 생성 실패~");
		}
		
		// 파일 존재 여부
		if(newFile.exists()) {
			System.out.println("파일 존재");
		}
		
		// 읽기 전용
		//newFile.setReadOnly();
		
		// 쓰기 전용
		newFile.setWritable(true);
		
		// 삭제
		newFile.delete();

	}

}
