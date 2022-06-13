package main;

public class ThreadEx extends Thread {
	
	String msg;

	public ThreadEx(String msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		super.run();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(msg);
			
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
	
	

}
