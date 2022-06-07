package work;

public class Work04 {

	// 암호표
	// 알파벳
	static char[] abcCode ={ 
			'`','~','!','@','#', '$','%','^','&','*',
			'(',')','-','_','+', '=','|','[',']','{',
			'}',';',':',',','.', '/'
	};
	
	// 숫자		
	static char[] numCode = {'q','w','e','r','t', 'y','u','i','o','p'};
	
	public static void main(String[] args) {
		
		String src = "abc123";
		
		System.out.println(encrypt(src));
		
		String baseCode = "`~!qwe";
		
		System.out.println(decrypt(baseCode));

	}
	
	static String encrypt(String src) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<src.length();i++) {
			int c = (int)src.charAt(i);
			
			if(c >= 97 && c <= 122) { // 알파벳
				sb.append(abcCode[c - 97]);
			}else { // 숫자
				sb.append(numCode[c - 48]);
			}
		}
		
		return sb.toString();
	}
	
	static String decrypt(String code) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<code.length();i++) {
			int ch = (int)code.charAt(i);
			
			if(ch >= 97 && ch <= 122) {
				for(int j=0;j<numCode.length;j++) {
					if(numCode[j] == code.charAt(i)) {
						sb.append(j+1);
					}
				}
			}else {
				for(int j=0;j<abcCode.length;j++) {
					if(abcCode[j] == code.charAt(i)) {
						sb.append((char)('a' + j));
					}
				}
			}
		}
		
		return sb.toString();
	}

}
