package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PopUpFrame extends JFrame {

	String str;
	JLabel label = new JLabel();
	JButton okButton = new JButton("OK");
	
	public PopUpFrame(String str) {
		
		this.str = str;
		
		label.setText(str);
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		add("Center", label);
		add("South", okButton);
		
		setBounds(250, 250, 200, 120);
		setVisible(true);
		
	}
}
