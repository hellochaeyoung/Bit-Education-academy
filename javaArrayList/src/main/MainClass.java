package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainClass {

	static int cnt = 0;
	public static void main(String[] args) {
		
		/*
		 * Collection : 수집
		 * 
		 * List : 목록 
		 * 		  ArrayList, vector
		 * 			배열처럼 사용할 수 있는 컬렉션
		 * 			선형 구조
		 * 			검색 속도 빠름
		 * 			인덱스로 접근
		 * 
		 * 		  LinkedList -> 게임
		 * 			검색 속도 떨어짐
		 * 			삽입/삭제에 용이
		 * 			주소값으로 이어져있음
		 * Map : 
		 */
		
		//ArrayList<Integer> list = new ArrayList<>();

		List<Integer> list = new ArrayList<>();
		
		// 추가
		Integer in = 111;
		list.add(in);
		
		list.add(222);
		
		list.add(new Integer(333));
		
		int len = list.size();
		System.out.println("목록의 크기 : " + len);
		for (int i = 0; i < args.length; i++) {
			System.out.println(list.get(i));
		}
		
		// 원하는 위치에 추가
		list.add(1, 200);
		
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
		// 삭제
		list.remove(2);
		
		
		// 검색
		int index = list.indexOf(333);
		System.out.println(index);
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) == 200) {
				index = i;
				break;
			}
		}
		
		// 수정
		list.set(0, 9999);
		
		List<MyData> objList = new ArrayList<>();
		
		// 추가
		for(int i=0;i<5;i++) {
			insert(objList);
		}
		
		// 원하는 위치에 추가
		indexInsert(objList);
		
		// 검색 이름
		select(objList);
		
		// 수정
		update(objList);
		
		// 삭제
		delete(objList);
	
	}
	
	static void insert(List<MyData> list) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("추가할 이름>>");
		String name = sc.next();
		
		list.add(new MyData(++cnt, name));
	}
	
	static void indexInsert(List<MyData> list) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("추가할 위치>>");
		int idx = sc.nextInt();
		
		System.out.println("추가할 이름>>");
		String name = sc.next();
		
		list.add(idx, new MyData(++cnt, name));
	}
	
	static void select(List<MyData> list) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("검색할 이름>>");
		String name = sc.next();
		
		for(MyData d : list) {
			if(d.getName().equals(name)) {
				System.out.println(d.toString());
			}
		}
	}	
	
	
	static void update(List<MyData> list) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수정할 이름>>");
		String name = sc.next();
		
		System.out.println("새로운 이름>>");
		String newName = sc.next();
		
		for(MyData d : list) {
			if(d.getName().equals(name)) {
				d.setName(newName);
			}
		}
	}

	static void delete(List<MyData> list) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("삭제할 이름>>");
		String name = sc.next();
		
		int c = 0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getName().equals(name)) {
				c = i;
				break;
			}
		}
		
		list.remove(c);
	}
}
