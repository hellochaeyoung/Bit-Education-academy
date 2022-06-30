package cls;

public class Batter extends Player {

	private int count;
	private int hitCount;
	private double hitRate;
	
	public Batter(int number, String name, int age, double height, int count, int hitCount, double hitRate) {
		super(number, name, age, height);
		this.count = count;
		this.hitCount = hitCount;
		this.hitRate = hitRate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public double getHitRate() {
		return hitRate;
	}

	public void setHitRate(double hitRate) {
		this.hitRate = hitRate;
	}

	@Override
	public void update(int num, String data) {
		super.update(num, data);
		
		switch(num) {
			case 4 : {
				this.count = Integer.parseInt(data);
				break;
			}
			case 5 : {
				this.hitCount = Integer.parseInt(data);
				break;
			}
			case 6 : {
				this.hitRate = Double.parseDouble(data);
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "Batter " + super.toString() + "[count=" + count + ", hitCount=" + hitCount + ", hitRate=" + hitRate + "]";
	}

	
	
}
