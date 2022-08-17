package coffee_vendingMachine;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class AdminScreen extends Frame implements ActionListener {
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	String coffee[][] = new String[6][4];
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	Font font20 = new Font("SansSerif", Font.BOLD, 20);
	Font font30 = new Font("SansSerif", Font.BOLD, 30);
	
	Label lbTitle = new Label("커피 자판기(관리자화면)");
	Label lbMenu1 = new Label("상품1");
	Label lbMenu2 = new Label("상품2");
	Label lbMenu3 = new Label("상품3");
	Label lbMenu4 = new Label("상품4");
	Label lbMenu5 = new Label("상품5");
	Label lbMenu6 = new Label("상품6");
	Label lbName1 = new Label("이름:");
	Label lbName2 = new Label("이름:");
	Label lbName3 = new Label("이름:");
	Label lbName4 = new Label("이름:");
	Label lbName5 = new Label("이름:");
	Label lbName6 = new Label("이름:");
	Label lbCount1 = new Label("수량:");
	Label lbCount2 = new Label("수량:");
	Label lbCount3 = new Label("수량:");
	Label lbCount4 = new Label("수량:");
	Label lbCount5 = new Label("수량:");
	Label lbCount6 = new Label("수량:");
	Label lbPrice1 = new Label("가격:");
	Label lbPrice2 = new Label("가격:");
	Label lbPrice3 = new Label("가격:");
	Label lbPrice4 = new Label("가격:");
	Label lbPrice5 = new Label("가격:");
	Label lbPrice6 = new Label("가격:");
	
	TextField tfName1 = new TextField(20);
	TextField tfName2 = new TextField(20);
	TextField tfName3 = new TextField(20);
	TextField tfName4 = new TextField(20);
	TextField tfName5 = new TextField(20);
	TextField tfName6 = new TextField(20);
	TextField tfCount1 = new TextField(20);
	TextField tfCount2 = new TextField(20);
	TextField tfCount3 = new TextField(20);
	TextField tfCount4 = new TextField(20);
	TextField tfCount5 = new TextField(20);
	TextField tfCount6 = new TextField(20);
	TextField tfPrice1 = new TextField(20);
	TextField tfPrice2 = new TextField(20);
	TextField tfPrice3 = new TextField(20);
	TextField tfPrice4 = new TextField(20);
	TextField tfPrice5 = new TextField(20);
	TextField tfPrice6 = new TextField(20);
	
	Button btnApply1 = new Button("적용");
	Button btnApply2 = new Button("적용");
	Button btnApply3 = new Button("적용");
	Button btnApply4 = new Button("적용");
	Button btnApply5 = new Button("적용");
	Button btnApply6 = new Button("적용");
	
	AdminScreen() {
		super("메인화면");
		this.setSize(850,500);
		this.center();//중앙배치		
		this.init();//화면구성
		this.start();//이벤트처리
		this.setVisible(true);
		this.getData();//db에 연동해서 데이터 가져오기
	}
	
	void init() {
		this.setLayout(null);
		
		this.add(lbTitle); lbTitle.setFont(font30); 
		lbTitle.setBounds(70, 60, 500, 30);
		
		this.add(lbMenu1); lbMenu1.setFont(font20); 
		lbMenu1.setBounds(50, 120, 70, 30);
		this.add(lbName1); lbName1.setFont(font20); 
		lbName1.setBounds(120, 120, 70, 30);
		this.add(tfName1); tfName1.setFont(font15); 
		tfName1.setBounds(190, 120, 150, 30);
		this.add(lbCount1); lbCount1.setFont(font20); 
		lbCount1.setBounds(350, 120, 70, 30);
		this.add(tfCount1); tfCount1.setFont(font15); 
		tfCount1.setBounds(420, 120, 80, 30);
		this.add(lbPrice1); lbPrice1.setFont(font20); 
		lbPrice1.setBounds(510, 120, 70, 30);
		this.add(tfPrice1); tfPrice1.setFont(font15); 
		tfPrice1.setBounds(580, 120, 100, 30);
		this.add(btnApply1); btnApply1.setFont(font20); 
		btnApply1.setBounds(690, 120, 100, 30);
		
		this.add(lbMenu2); lbMenu2.setFont(font20); 
		lbMenu2.setBounds(50, 180, 70, 30);
		this.add(lbName2); lbName2.setFont(font20); 
		lbName2.setBounds(120, 180, 70, 30);
		this.add(tfName2); tfName2.setFont(font15); 
		tfName2.setBounds(190, 180, 150, 30);
		this.add(lbCount2); lbCount2.setFont(font20); 
		lbCount2.setBounds(350, 180, 70, 30);
		this.add(tfCount2); tfCount2.setFont(font15); 
		tfCount2.setBounds(420, 180, 80, 30);
		this.add(lbPrice2); lbPrice2.setFont(font20); 
		lbPrice2.setBounds(510, 180, 70, 30);
		this.add(tfPrice2); tfPrice2.setFont(font15); 
		tfPrice2.setBounds(580, 180, 100, 30);
		this.add(btnApply2); btnApply2.setFont(font20); 
		btnApply2.setBounds(690, 180, 100, 30);
		
		this.add(lbMenu3); lbMenu3.setFont(font20); 
		lbMenu3.setBounds(50, 240, 70, 30);
		this.add(lbName3); lbName3.setFont(font20); 
		lbName3.setBounds(120, 240, 70, 30);
		this.add(tfName3); tfName3.setFont(font15); 
		tfName3.setBounds(190, 240, 150, 30);
		this.add(lbCount3); lbCount3.setFont(font20); 
		lbCount3.setBounds(350, 240, 70, 30);
		this.add(tfCount3); tfCount3.setFont(font15); 
		tfCount3.setBounds(420, 240, 80, 30);
		this.add(lbPrice3); lbPrice3.setFont(font20); 
		lbPrice3.setBounds(510, 240, 70, 30);
		this.add(tfPrice3); tfPrice3.setFont(font15); 
		tfPrice3.setBounds(580, 240, 100, 30);
		this.add(btnApply3); btnApply3.setFont(font20); 
		btnApply3.setBounds(690, 240, 100, 30);
		
		this.add(lbMenu4); lbMenu4.setFont(font20); 
		lbMenu4.setBounds(50, 300, 70, 30);
		this.add(lbName4); lbName4.setFont(font20); 
		lbName4.setBounds(120, 300, 70, 30);
		this.add(tfName4); tfName4.setFont(font15); 
		tfName4.setBounds(190, 300, 150, 30);
		this.add(lbCount4); lbCount4.setFont(font20); 
		lbCount4.setBounds(350, 300, 70, 30);
		this.add(tfCount4); tfCount4.setFont(font15); 
		tfCount4.setBounds(420, 300, 80, 30);
		this.add(lbPrice4); lbPrice4.setFont(font20); 
		lbPrice4.setBounds(510, 300, 70, 30);
		this.add(tfPrice4); tfPrice4.setFont(font15); 
		tfPrice4.setBounds(580, 300, 100, 30);
		this.add(btnApply4); btnApply4.setFont(font20); 
		btnApply4.setBounds(690, 300, 100, 30);
		
		this.add(lbMenu5); lbMenu5.setFont(font20); 
		lbMenu5.setBounds(50, 360, 70, 30);
		this.add(lbName5); lbName5.setFont(font20); 
		lbName5.setBounds(120, 360, 70, 30);
		this.add(tfName5); tfName5.setFont(font15); 
		tfName5.setBounds(190, 360, 150, 30);
		this.add(lbCount5); lbCount5.setFont(font20); 
		lbCount5.setBounds(350, 360, 70, 30);
		this.add(tfCount5); tfCount5.setFont(font15); 
		tfCount5.setBounds(420, 360, 80, 30);
		this.add(lbPrice5); lbPrice5.setFont(font20);
		lbPrice5.setBounds(510, 360, 70, 30);
		this.add(tfPrice5); tfPrice5.setFont(font15); 
		tfPrice5.setBounds(580, 360, 100, 30);
		this.add(btnApply5); btnApply5.setFont(font20); 
		btnApply5.setBounds(690, 360, 100, 30);
		
		this.add(lbMenu6); lbMenu6.setFont(font20); 
		lbMenu6.setBounds(50, 420, 70, 30);
		this.add(lbName6); lbName6.setFont(font20); 
		lbName6.setBounds(120, 420, 70, 30);
		this.add(tfName6); tfName6.setFont(font15); 
		tfName6.setBounds(190, 420, 150, 30);
		this.add(lbCount6); lbCount6.setFont(font20); 
		lbCount6.setBounds(350, 420, 70, 30);
		this.add(tfCount6); tfCount6.setFont(font15); 
		tfCount6.setBounds(420, 420, 80, 30);
		this.add(lbPrice6); lbPrice6.setFont(font20); 
		lbPrice6.setBounds(510, 420, 70, 30);
		this.add(tfPrice6); tfPrice6.setFont(font15); 
		tfPrice6.setBounds(580, 420, 100, 30);
		this.add(btnApply6); btnApply6.setFont(font20); 
		btnApply6.setBounds(690, 420, 100, 30);
		
		
	}
	
	public void start() {
		btnApply1.addActionListener(this);
		btnApply2.addActionListener(this);
		btnApply3.addActionListener(this);
		btnApply4.addActionListener(this);
		btnApply5.addActionListener(this);
		btnApply6.addActionListener(this);
	}
	
	void adminClose() {
		this.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		String name1 = tfName1.getText(), count1 = tfCount1.getText(), price1 = tfPrice1.getText();
		String name2 = tfName2.getText(), count2 = tfCount2.getText(), price2 = tfPrice2.getText();
		String name3 = tfName3.getText(), count3 = tfCount3.getText(), price3 = tfPrice3.getText();
		String name4 = tfName4.getText(), count4 = tfCount4.getText(), price4 = tfPrice4.getText();
		String name5 = tfName5.getText(), count5 = tfCount5.getText(), price5 = tfPrice5.getText();
		String name6 = tfName6.getText(), count6 = tfCount6.getText(), price6 = tfPrice6.getText();
		if(e.getSource() == btnApply1) {
			update(name1, count1, price1, 1);
		}
		else if(e.getSource() == btnApply2) {
			update(name2, count2, price2, 2);
		}
		else if(e.getSource() == btnApply3) {
			update(name3, count3, price3, 3);
		}
		else if(e.getSource() == btnApply4) {
			update(name4, count4, price4, 4);
		}
		else if(e.getSource() == btnApply5) {
			update(name5, count5, price5, 5);
		}
		else if(e.getSource() == btnApply6) {
			update(name6, count6, price6, 6);
		}
		
	}
	
	void getData() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("드라이브가 연결안됨.");
			System.exit(0);
		}
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?useUnicode=true&characterEncoding=utf8";
		//String url = "jdbc:mysql://localhost:3306/dw202";
		String user = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from coffee";
		try {
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			int count=0;
			while (rs.next()) {
				coffee[count][0] = rs.getInt("idx")+"";
				coffee[count][1] = rs.getString("name");
				coffee[count][2] = rs.getString("count");
				coffee[count][3] = rs.getString("price");
				count++;
			}
			tfName1.setText(coffee[0][1]);
			tfCount1.setText(coffee[0][2]);
			tfPrice1.setText(coffee[0][3]);
			tfName2.setText(coffee[1][1]);
			tfCount2.setText(coffee[1][2]);
			tfPrice2.setText(coffee[1][3]);
			tfName3.setText(coffee[2][1]);
			tfCount3.setText(coffee[2][2]);
			tfPrice3.setText(coffee[2][3]);
			tfName4.setText(coffee[3][1]);
			tfCount4.setText(coffee[3][2]);
			tfPrice4.setText(coffee[3][3]);
			tfName5.setText(coffee[4][1]);
			tfCount5.setText(coffee[4][2]);
			tfPrice5.setText(coffee[4][3]);
			tfName6.setText(coffee[5][1]);
			tfCount6.setText(coffee[5][2]);
			tfPrice6.setText(coffee[5][3]);
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	
	boolean update(String name, String count, String price, int idx) {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("드라이브가 연결안됨.");
			System.exit(0);
		}
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?useUnicode=true&characterEncoding=utf8";
		//String url = "jdbc:mysql://localhost:3306/dw202";
		String user = "root";
		String pass = "qwer";
		String query = "update coffee set name = ?, count = ?, price = ? where idx = ?";
		try {
			conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, count);
			pstmt.setString(3, price);
			pstmt.setInt(4, idx);
			pstmt.executeUpdate();
			pstmt.close();
			msg("정보수정완료!");
//			this.setVisible(false);
		} catch (SQLException ee) {
			System.err.println("정보수정 실패!!");
			return false;
		}
		return true;
	}
	
	void msg(String msg) {
		final Dialog dlg = new Dialog(this, "알림 메세지창", true);
		dlg.setLayout(null);
		Label lbMsg = new Label(msg);
		dlg.add(lbMsg);	lbMsg.setFont(font20);
		lbMsg.setBounds(100, 100, 450, 30);
		dlg.setSize(480, 200);
		dlg.setLocation(720, 420);
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.setVisible(true);
	}
	
	void center() {
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
//				System.exit(0); 전부 종료
			}
		});
	}
	
}
