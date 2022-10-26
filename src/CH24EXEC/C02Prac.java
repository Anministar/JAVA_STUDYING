package CH24EXEC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Chat1 extends JFrame implements ActionListener, KeyListener{
	
	JTextArea area;
	JScrollPane scroll;
	JTextField txt1;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	
	
	
	Chat1(){
		super("Chat1ting Server");
		
		JPanel pannel = new JPanel();
		
		pannel.setLayout(null);
		
		btn1 = new JButton("파일로저장");
		btn2 = new JButton("1 : 1 요청");
		btn3 = new JButton("대화기록보기");
		btn4 = new JButton("입력");
		
		btn1.setBounds(240, 20, 120, 50);
		btn2.setBounds(240, 80, 120, 50);
		btn3.setBounds(240, 140, 120, 50);
		btn4.setBounds(240, 280, 120, 50);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		
		pannel.add(btn1);
		pannel.add(btn2);
		pannel.add(btn3);
		pannel.add(btn4);
		
		
		txt1 = new JTextField();
		txt1.setBounds(20, 280, 200, 50);
		txt1.addKeyListener(this);
		
		
		pannel.add(txt1);
		
		
		
		area = new JTextArea();
		scroll = new JScrollPane(area);
		scroll.setBounds(20, 20, 200, 230);
		
		
		pannel.add(scroll);
		
		add(pannel);
		
		
		setBounds(100, 100, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("KEYPRESSED함수 : " + e.getKeyChar());
		System.out.println("KEYPRESSED함수 : " + e.getKeyCode());
		if (e.getKeyCode() == 10) {
			area.append(txt1.getText() + "\n");
			txt1.setText("");
		}
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {
			System.out.println("파일로저장 클릭함!!");
		}
		if(e.getSource() == btn2) {
			System.out.println("1 : 1 요청 클릭함!!");
		}
		if(e.getSource() == btn3) {
			System.out.println("대화기록보기 클릭함!!");
		}
		if(e.getSource() == btn4) {
			area.append(txt1.getText() + "\n");
			txt1.setText("");
		}
		
		
		
	}
}


public class C02Prac {

	public static void main(String[] args) {
		new Chat1();

	}

}
