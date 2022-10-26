package CH24;

import javax.swing.JFrame;

class C02GUI extends JFrame {
	C02GUI() {
		super("두번째 프레임입니다.");
		setBounds(100, 100, 700, 700); //setBound는 JFrame에게 받아옴.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //setDefaultCloseOperation는 JFrame에게 받아옴.
		setVisible(true); //setVisible는 JFrame에게 받아옴.
	}
}


public class C02Swing {
	
	public static void main(String[] args) {
		new C02GUI();
		

	}

}
