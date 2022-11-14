package CH38.VIEW;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import CH38.Controller.FrontController;
import CH38.Domain.BookDTO;
import CH38.Domain.LendDTO;
import CH38.Domain.MemberDTO;

public class GUIView extends JFrame implements ActionListener {
	
	
	// Controller 관련 처리 멤버
	private boolean Loginstate = false;
	private String userid = null;
	private Integer perm = 0; // 0 : 비회원 1 : 회원 2 : 관리자(사서)

	private FrontController controller = new FrontController();
	
	// 액션 처리 관련 멤버
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	
	JLabel lbbookCode;
	JLabel lbbookName;
	JLabel lbisLend;
	
	JTextField txbookCode;
	JTextField txbookName;
	JTextField txisLend;
	
	JTextArea area;
	JScrollPane scroll;
	
	
	//인증 관련 처리 프레임 멤버
	JFrame LoginView = new JFrame("Login View");
	JButton LoginBtn;
	JButton exitBtn;
	JTextField txId;
	JTextField txpw;
	
	public GUIView() {
		super("도서 관리 Ver 0.0 CopyRight ---");
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		//Button - 도서전체조회(권한x), 대여요청, 도서등록, 종료
		
		btn1 = new JButton("도서 조회");
		btn1.setBounds(320, 20, 130, 35);
		btn1.addActionListener(this);
		
		btn2 = new JButton("대여 요청");
		btn2.setBounds(320, 65, 130, 35);
		btn2.addActionListener(this);
		
		btn3 = new JButton("도서 등록");
		btn3.setBounds(320, 110, 130, 35);
		
		btn4 = new JButton("종료");
		btn4.setBounds(320, 155, 130, 35);
		
		//JLabel
		lbbookCode = new JLabel("도서코드");
		lbbookCode.setBounds(10, 20, 130, 35);
		lbbookName = new JLabel("도서명");
		lbbookName.setBounds(10, 65, 130, 35);
		lbisLend = new JLabel("대여가능여부");
		lbisLend.setBounds(10, 110, 130, 35);
		
		//TextField - BookCode, Bookname, islend
		txbookCode = new JTextField();
		txbookCode.setBounds(120, 20, 170, 35);
		txbookName = new JTextField();
		txbookName.setBounds(120, 65, 170, 35);
		txisLend = new JTextField();
		txisLend.setBounds(120, 110, 170, 35);
		
		//TextArea + ScrollPane
		area = new JTextArea();
		scroll = new JScrollPane(area);
		scroll.setBounds(10, 240, 450, 220);
		
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		
		panel.add(txbookCode);
		panel.add(txbookName);
		panel.add(txisLend);
		
		panel.add(lbbookCode);
		panel.add(lbbookName);
		panel.add(lbisLend);
		
		panel.add(scroll);
		
		add(panel);
		setBounds(100, 100, 500, 500); //setBound는 JFrame에게 받아옴.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //setDefaultCloseOperation는 JFrame에게 받아옴.
		setVisible(true); //setVisible는 JFrame에게 받아옴.
		
		//인증창 관련 기본설정
		LoginView.setBounds(100, 100, 500, 170);
		JPanel loginpanel = new JPanel();
		loginpanel.setLayout(null);
		LoginBtn = new JButton("로그인");
		exitBtn = new JButton("종료");
		txId = new JTextField("ID");
		txpw = new JTextField("PW");
		
		txId.setBounds(10, 10, 350, 40);
		txpw.setBounds(10, 60, 350, 40);
		LoginBtn.setBounds(370, 10, 100, 40);
		LoginBtn.addActionListener(this);
		exitBtn.setBounds(370, 60, 100, 40);
		
		loginpanel.add(LoginBtn);
		loginpanel.add(exitBtn);
		loginpanel.add(txId);
		loginpanel.add(txpw);
		
		LoginView.add(loginpanel);
//		LoginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x 버튼 누르면 아예 종료
		LoginView.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // x 버튼 누르면 숨김
		
		LoginView.setVisible(false);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			//1 컨트롤러로부터 모든 책정보 가져오기
			List<BookDTO> list = (List<BookDTO>) controller.ExSubController("/book", 5, null);
			
			//2 Area로 전달하기
			for (int i = 0; i < list.size(); i++) {
				area.append(list.get(i).toString() + "\n");
			}
			
			System.out.println("[SYSTEM Count : " + list.size());
		}
		if(e.getSource() == btn2) { // 도서 대여 요청
			//로그인 상태가 아니라면 -> 로그인창 띄우기 -> 인증 작업 -> 로그인상태, 퍼미션
			
			if(!Loginstate) {
				LoginView.setVisible(true);
			}
			else {
				//로그인 상태라면 -> 퍼미션 체크 + BookCode 받아서 대여 처리 후 View확인
				if(perm > 0) {
					//권한 충족
					int bookcode = Integer.parseInt(txbookCode.getText());
					LendDTO dto = new LendDTO();
					dto.setLogin(true);
					dto.setPerm(perm);
					dto.setMemId(userid);
					dto.setBookcode(bookcode);
					String msg = (String) controller.ExSubController("/lend", 1, dto);
					
					JOptionPane.showMessageDialog(null, msg);
					
				} else {
					//권한 부족.. 메시지창 띄우기
					JOptionPane.showMessageDialog(null, "권한부족..");
				}
				
			}
		}
		
		if(e.getSource() == LoginBtn) {
			String id = txId.getText();
			String pwd = txpw.getText();
			Integer result = (Integer) controller.ExSubController("/auth", 1, new MemberDTO(id, pwd)); // null or role값(1 : 회원, 2 : 사서)
			// null값때문에 Integer로 result의 자료형 설정, Object로 반환되므로 Integer로 다운캐스팅
			if (result != null) {
				//권한 1, 2 를 획득
				Loginstate = true;
				perm = result;
				userid = id;
				JOptionPane.showMessageDialog(null, "로그인 성공!");
				LoginView.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(null, "로그인 실패!");
				LoginView.setVisible(false);
			}
		}
	}
	
	public static void main(String[] args) {
		new GUIView();
	}
}
