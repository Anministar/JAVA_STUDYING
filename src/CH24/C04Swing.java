package CH24;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C04GUI extends JFrame {
	C04GUI() {
		super("네번째 프레임입니다.");						//프레임창 제목
		
		JPanel pannel = new JPanel(); 					//패널 생성
		
		pannel.setLayout(null); 						//Layout 설정 x ==> 그래야 내가 setBounds 해서 원하는 위치에 버튼 형성 가능
		
		
		JTextArea area = new JTextArea();				//텍스트영역창
//		area.setBounds(10, 10, 260, 240);				//스크롤 추가 시 생략
		
		JScrollPane scroll = new JScrollPane(area);		//area에 스크롤 추가하기
		scroll.setBounds(10, 10, 260, 240);
		
		JTextField txt1 = new JTextField();				//텍스트입력창
		txt1.setBounds(10, 260, 260, 30); 				//크기
		
		JButton btn1 = new JButton("버튼1"); 				//버튼 생성
		btn1.setBounds(10, 300, 120, 30);  				//버튼 위치, 크기 지정
		
		JButton btn2 = new JButton("버튼2");
		btn2.setBounds(150, 300, 120, 30);
		
		pannel.add(btn1);		//패널에 추가
		pannel.add(btn2);		//패널에 추가
		pannel.add(txt1);
//		pannel.add(area);		//스크롤 추가 시 생략
		pannel.add(scroll);
		
		add(pannel);									//프레임에 패널 주기
		
		setBounds(100, 100, 300, 400); 					//프레임창 위치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료버튼 사용가능상태 
		setVisible(true); 								//프레임창 보여주기
	}
}


public class C04Swing {
	
	public static void main(String[] args) {
		new C04GUI();
		

	}

}
