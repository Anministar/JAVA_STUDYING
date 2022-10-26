package CH24EXEC;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Chat extends JFrame {
	Chat(){
		super("Chatting Server");
		
		JPanel pannel = new JPanel();
		
		pannel.setLayout(null);
		
		JButton btn1 = new JButton("파일로저장");
		JButton btn2 = new JButton("1 : 1 요청");
		JButton btn3 = new JButton("대화기록보기");
		JButton btn4 = new JButton("입력");
		
		btn1.setBounds(240, 20, 120, 50);
		btn2.setBounds(240, 80, 120, 50);
		btn3.setBounds(240, 140, 120, 50);
		btn4.setBounds(240, 280, 120, 50);
	
		
		pannel.add(btn1);
		pannel.add(btn2);
		pannel.add(btn3);
		pannel.add(btn4);
		
		
		JTextField txt1 = new JTextField();
		txt1.setBounds(20, 280, 200, 50);
		
		pannel.add(txt1);
		
		JTextArea area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area);
		scroll.setBounds(20, 20, 200, 230);
		
		pannel.add(scroll);
		
		add(pannel);
		
		
		setBounds(100, 100, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
	}
}


public class C01Prac {

	public static void main(String[] args) {
		new Chat();

	}

}
