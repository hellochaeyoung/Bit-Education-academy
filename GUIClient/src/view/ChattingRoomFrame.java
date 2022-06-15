package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.WriteClass;

public class ChattingRoomFrame extends JFrame implements ActionListener{
	
	public String name;
	WriteClass wc;
	String names;
	
	public List<String> userList = new ArrayList<>();
	
	public JTextField inputTextField = new JTextField(14); // 전체 채팅 메시지 입력 창
	public JTextArea msgTextArea = new JTextArea(); // 전체 채팅 메시지 목록
	
	JButton sendButton = new JButton("전송");
	JButton exitButton = new JButton("나가기");
	
	JPanel panel = new JPanel();
	
	public ChattingRoomFrame(String name, WriteClass wc, String names) {
		this.name = name;	
		this.wc = wc;
		this.names = names;
		
		add("Center", msgTextArea);
		
		panel.add(inputTextField);
		panel.add(sendButton);
		panel.add(exitButton);
		
		add("South", panel);
		
		sendButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		setTitle(name + "[" + names + "]");
		
		// 채팅방 생성 위치 다르게 하기 위해 ( 기존에는 동일한 위치에 생성되었음)
		int x = (int)(Math.random() * 500);
		int y = (int)(Math.random() * 500);
		
		setBounds(x,y,700,600);
		setVisible(true);
		
		
	}
	
	public void insertUsers(String names) {
		String[] users = names.split(",");
		
		for(String n : users) {
			userList.add(n);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == sendButton) {
			
			String id = IdFrame.tf.getText(); 
			
			msgTextArea.append("[" + id + "]" + inputTextField.getText() + "\n");
			
			// 채팅방 메시지 서버 전송
			wc.sendRoomChattingMessage(name, id, inputTextField.getText());
			
			inputTextField.setText("");
			
		}else if(e.getSource() == exitButton) {
			
			userList.remove(IdFrame.tf.getText());
			
			// 채팅방 나가기 메시지 서버 전송
			wc.sendExitChattingRoomMessage(name, userList.size());
			
			this.dispose();
		}
		
	}
	
	

}
