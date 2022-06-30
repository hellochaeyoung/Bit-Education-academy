package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * java						web(json)
		 * HashMap : 사전
		 * 
		 * 			key value
		 * 			Tree 구조 - 트리 구조는 검색 속도가 굉장히 빠르다
		 * 
		 *
		 * TreeMap : HashMap + sorting
		 * 
		 * 	해시맵과 트리맵은 서로 호환이 가능!
		 */
		
		Map<Integer, String> map = new HashMap<>();
		
		// 추가
		map.put(1001, "Tigers");
		map.put(1002, "Lions");
		map.put(1003, "Twins");
		
		String value = map.get(1002);
		System.out.println(value);
		
		System.out.println(map.size());
		
		// 출력
		// 이터레이터 : 반복자(= 포인터) -> DB : 커서(cursor)
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()) {
			int key = it.next();
			String v = map.get(key);
			System.out.println(key + " " + v);
		}
			// 선형 구조가 아니기 때문에 순서대로 들어가는 것 같아 보여도 아니다!
		
		
		// 삭제
		map.remove(1003);
		
		// 검색
		if(map.containsKey(1002)) {
			System.out.println(map.get(1002));
		}
		// 수정
		map.replace(1001, "Eagles");
		it = map.keySet().iterator();
		while(it.hasNext()) {
			int key = it.next();
			String v = map.get(key);
			System.out.println(key + " " + v);
		}
		
		//Map<String, Object> hmap = new HashMap<>();
		// instanceof로 다 사용할 수 있음
		
		Map<String, String> hmap = new HashMap<>();
		
		hmap.put("apple", "사과");
		hmap.put("pear", "배");
		hmap.put("grape", "포도");
		hmap.put("banana", "바나나");
		hmap.put("orange", "오렌지");
		
		Iterator<String> iter = hmap.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			String v = hmap.get(key);
			System.out.println("key : " + key + ", value : " + v);
		}
		
		// TreeMap
		TreeMap<String, String> tMap = new TreeMap<>(hmap); // <-> 서로 호환 가능
		
		// 오름
		// Iterator<String> itKey = tMap.keySet().iterator(); // -> 오름차순 정렬이 자동으로 수행됨
		
		// 내림
		Iterator<String> itKey = tMap.descendingKeySet().iterator();
		
		while(itKey.hasNext()) {
			String key = itKey.next();
			String v = hmap.get(key);
			System.out.println("key : " + key + ", value : " + v);
		}
		
		
		
	}

}
