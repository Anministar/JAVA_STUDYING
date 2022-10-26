package CH24;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

class C03GUI extends JFrame {
	C03GUI() {
		super("세번째 프레임입니다.");		//프레임창 제목
		
		JPanel pannel = new JPanel(); //패널 생성
		
		//배경색 지정
		Color col = new Color(207, 211, 37); //RGB(Red(0-255), Green(0-255), Blue(0-255)
		pannel.setBackground(col);
		
		
		add(pannel);					//프레임에 패널 주기
		
		setBounds(100, 100, 700, 700); 	//프레임창 위치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료버튼 사용가능상태 
		setVisible(true); 		//프레임창 보여주기
	}
}


public class C03Swing {
	
	public static void main(String[] args) {
		new C03GUI();
		

	}

}
