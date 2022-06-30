package sample03.wind;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.MouseInfo;
import java.awt.Panel;
import java.awt.PointerInfo;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JCheckBox;

public class CoffeeOrder extends Frame implements WindowListener {
	
	Label locationLabel;
	
	Button menuButton;
	Choice menuChoice;
	Label sizeLabel, syrupLabel, otherLabel;
	
	CheckboxGroup sizeGroup, syrupGroup, otherGroup;
	Checkbox sCheckBox, tCheckBox, gCheckBox;
	Checkbox vCheckBox, cCheckBox, hCheckBox;
	
	JCheckBox shotCheckBox;
	Checkbox whipCheckBox;
	
	Label countLabel, opLabel;
	Button orderButton;
	
	public CoffeeOrder() {
		
		setLayout(null);
		
		setLabels();
		setButtons();
		setChoice();
		setCheckBoxes();
		
		init();
		
	}
	
	public void init() {
		
		setTitle("주문");
		setSize(640,480);
		setLocation(0, 0);
		setBackground(Color.LIGHT_GRAY);
		setVisible(true);
		
		addWindowListener(this);
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				locationLabel.setText("x:" + e.getX() + ",y:" + e.getY());
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	public void setLabels() {
		
		locationLabel = new Label();
		locationLabel.setBounds(30,40,100,30);
		add(locationLabel);
		
		sizeLabel = new Label("크기");
		sizeLabel.setBounds(100, 200, 30, 20);
		add(sizeLabel);
		
		syrupLabel = new Label("시럽");
		syrupLabel.setBounds(250, 200, 30, 20);
		add(syrupLabel);
		
		otherLabel = new Label("기타");
		otherLabel.setBounds(400, 200, 30, 20);
		add(otherLabel);
		
		countLabel = new Label("0");
		countLabel.setBounds(200, 400, 50, 50);
		add(countLabel);
		
		opLabel = new Label("잔");
		opLabel.setBounds(250, 400, 50, 50);
		add(opLabel);
		
	}
	
	public void setButtons() {
		
		menuButton = new Button("메뉴보기");
		menuButton.setBounds(500, 50, 100, 40);
		add(menuButton);
		
		orderButton = new Button("주문하기");
		orderButton.setBounds(300, 400, 100, 50);
		add(orderButton);
		
	}
	
	public void setChoice() {
		
		menuChoice = new Choice();
		menuChoice.add("카라멜 마끼야또");
		menuChoice.add("아이스 아메리카노");
		menuChoice.add("아메리카노");
		menuChoice.add("초콜릿 라떼");
		menuChoice.setBounds(100, 100, 300, 20);
		add(menuChoice);
		
	}
	
	public void setCheckBoxes() {
		
		sizeGroup = new CheckboxGroup();
		
		sCheckBox = new Checkbox("Short", sizeGroup, false);
		sCheckBox.setBackground(Color.white);
		sCheckBox.setBounds(100, 250, 100, 50);
		add(sCheckBox);
		
		tCheckBox = new Checkbox("Tall", sizeGroup, false);
		tCheckBox.setBackground(Color.white);
		tCheckBox.setBounds(100, 300, 100, 50);
		add(tCheckBox);
		
		gCheckBox = new Checkbox("Grande", sizeGroup, false);
		gCheckBox.setBackground(Color.white);
		gCheckBox.setBounds(100, 340, 100, 50);
		add(gCheckBox);
		
		//syrupGroup = new CheckboxGroup();
		vCheckBox = new Checkbox("바닐라", false);
		//vCheckBox = new Checkbox("바닐라", syrupGroup, false);
		vCheckBox.setBounds(250, 250, 50, 50);
		add(vCheckBox);
		
		//cCheckBox = new Checkbox("캐러맬", syrupGroup, false);
		cCheckBox = new Checkbox("캐러맬", false);
		cCheckBox.setBounds(250, 300, 50, 50);
		add(cCheckBox);
		
		//hCheckBox = new Checkbox("헤이즐넛", syrupGroup, false);
		hCheckBox = new Checkbox("헤이즐넛", false);
		hCheckBox.setBounds(250, 340, 80, 50);
		add(hCheckBox);
		
		
		shotCheckBox = new JCheckBox("샷 추가", false);
		shotCheckBox.setBounds(400, 250, 100, 50);
		add(shotCheckBox);
		
		whipCheckBox = new Checkbox("휘핑크림", false);
		whipCheckBox.setBounds(400, 300, 100, 50);
		whipCheckBox.setBackground(Color.white);
		add(whipCheckBox);
		
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


}
