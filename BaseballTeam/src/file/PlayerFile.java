package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import cls.Batter;
import cls.Pitcher;
import cls.Player;

public class PlayerFile {
	
	private File file;
	
	public PlayerFile(File file) {
		this.file = file;
	}
	
	public List<Player> read() throws IOException {
		
		List<Player> list = new ArrayList<>();
		
		if(file.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			StringTokenizer st;
			
			String str = "";
			while((str = br.readLine()) != null) {
				st = new StringTokenizer(str, "/");
				
				String human = st.nextToken();
				if(human.equals("Player")) {
					list.add(parsePlayer(st));
				}else if(human.equals("Picture")) {
					list.add(parsePitcher(st));
				}else if(human.equals("Batter")) {
					list.add(parseBatter(st));
				}
			}
		}
		
		return list;
	}
	
	public void write(List<Player> list) throws IOException {
		
		if(file.exists()) {
			file.delete();
		}
		
		file.createNewFile();
		
		PrintWriter pw = new PrintWriter(file);
		
		for(Player p : list) {
			
			String str = "";
			if(p instanceof Pitcher) {
				str = toStringFromPitcher((Pitcher)p);
			}else if(p instanceof Batter) {
				str = toStringFromBatter((Batter)p);
			}else if(p instanceof Player) {
				str = toStringFromPlayer(p);
			}
			
			pw.println(str);
		}
		
		pw.close();
		
	}
	
	public Player parsePlayer(StringTokenizer st) {
		
		int num = Integer.parseInt(st.nextToken());
		String name = st.nextToken();
		int age = Integer.parseInt(st.nextToken());
		double height = Double.parseDouble(st.nextToken());
		
		return new Player(num, name, age, height);
	}
	
	public Pitcher parsePitcher(StringTokenizer st) {
		
		int num = Integer.parseInt(st.nextToken());
		String name = st.nextToken();
		int age = Integer.parseInt(st.nextToken());
		double height = Double.parseDouble(st.nextToken());
		
		int win = Integer.parseInt(st.nextToken());
		int lose = Integer.parseInt(st.nextToken());
		double rate = Double.parseDouble(st.nextToken());
		
		return new Pitcher(num, name, age, height, win, lose, rate);
	}
	
	public Batter parseBatter(StringTokenizer st) {
		
		int num = Integer.parseInt(st.nextToken());
		String name = st.nextToken();
		int age = Integer.parseInt(st.nextToken());
		double height = Double.parseDouble(st.nextToken());
		
		int count = Integer.parseInt(st.nextToken());
		int hitCount = Integer.parseInt(st.nextToken());
		double hitRate = Double.parseDouble(st.nextToken());
		
		return new Batter(num, name, age, height, count, hitCount, hitRate);
	}
	
	public String toStringFromPlayer(Player p) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Player/").append(p.getNumber() + "/").append(p.getName() + "/").append(p.getAge() + "/").append(p.getHeight() + "/");
		
		return sb.toString();
	}
	
	public String toStringFromPitcher(Pitcher p) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Pitcher/").append(p.getNumber() + "/").append(p.getName() + "/").append(p.getAge() + "/").append(p.getHeight() + "/")
			.append(p.getWin() + "/").append(p.getLose() + "/").append(p.getRate());
		
		return sb.toString();
	}
	
	public String toStringFromBatter(Batter p) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Batter/").append(p.getNumber() + "/").append(p.getName() + "/").append(p.getAge() + "/").append(p.getHeight() + "/")
			.append(p.getCount() + "/").append(p.getHitCount() + "/").append(p.getHitRate());
		
		return sb.toString();
	}
	
	
	

}
