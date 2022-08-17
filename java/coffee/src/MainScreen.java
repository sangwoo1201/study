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

public class MainScreen extends Frame implements ActionListener {
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	private Image img1, img2, img3, img4, img5, img6, imgSel; //커피이미지변수
	int price1 = 0, price2 = 0; //현재잔액 , 결제금액
	int coffeePrice[] = {2000, 3000, 3500, 4000, 4000, 4000}; //커피가격변수
	String coffeeName[] = {"아메리카노","카푸치노","바닐라라떼","카페모카","카라멜마끼아또","흑당커피"};
	int coffeeCnt[] = {1,1,1,1,1,1};
	int selCoffee = 0; //0~5이 차례대로커피 선택임 배열로 저장해놔서
	String coffee[][] = new String[6][4];
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	Font font20 = new Font("SansSerif", Font.BOLD, 20);
	Font font30 = new Font("SansSerif", Font.BOLD, 30);
	
	Label lbTitle = new Label("커피자판기");
	Label lbCoffee1Cnt = new Label("수량 "+coffeeCnt[0]+"개",Label.CENTER);
	Label lbCoffee2Cnt = new Label("수량 "+coffeeCnt[1]+"개",Label.CENTER);
	Label lbCoffee3Cnt = new Label("수량 "+coffeeCnt[2]+"개",Label.CENTER);
	Label lbCoffee4Cnt = new Label("수량 "+coffeeCnt[3]+"개",Label.CENTER);
	Label lbCoffee5Cnt = new Label("수량 "+coffeeCnt[4]+"개",Label.CENTER);
	Label lbCoffee6Cnt = new Label("수량 "+coffeeCnt[5]+"개",Label.CENTER);
	Label lbCoffee1 = new Label(coffeeName[0],Label.CENTER);
	Label lbCoffee2 = new Label(coffeeName[1],Label.CENTER);
	Label lbCoffee3 = new Label(coffeeName[2],Label.CENTER);
	Label lbCoffee4 = new Label(coffeeName[3],Label.CENTER);
	Label lbCoffee5 = new Label(coffeeName[4]);
	Label lbCoffee6 = new Label(coffeeName[5],Label.CENTER);
	Label lbMoney = new Label("투입금액");
	Label lbSel = new Label("선택상품");
	Label lbSelTitle = new Label("선택커피명");
	Label lbSelPrice = new Label("가격 :    0원");
	Label lbPrice1 = new Label("현재잔액:");
	Label lbSu1 = new Label(price1+"원");
	Label lbPrice2 = new Label("결제금액:");
	Label lbSu2 = new Label(price2+"원");
	
	Button btncoffee1Price = new Button(coffeePrice[0]+"원");
	Button btncoffee2Price = new Button(coffeePrice[1]+"원");
	Button btncoffee3Price = new Button(coffeePrice[2]+"원");
	Button btncoffee4Price = new Button(coffeePrice[3]+"원");
	Button btncoffee5Price = new Button(coffeePrice[4]+"원");
	Button btncoffee6Price = new Button(coffeePrice[5]+"원");
	Button btn1000 = new Button("1000원");
	Button btn5000 = new Button("5000원");
	Button btn10000 = new Button("10000원");
	Button btnPay = new Button("결제하기");
	Button btnAdmin = new Button("관리자모드");
	
	boolean makeCheck=true;
	
	MainScreen() {
		super("메인화면");
		this.setSize(700,600);
		this.center();//중앙배치		
		this.init();//화면구성
		this.getData();
		this.start();//이벤트처리
		this.setVisible(true);
	}
	
	void init() {
		this.setLayout(null);
		
		this.add(lbTitle); lbTitle.setFont(font30); 
		lbTitle.setBounds(100, 40, 160, 30);
		
		img1 = Toolkit.getDefaultToolkit().getImage("아메리카노.jpg");
		img2 = Toolkit.getDefaultToolkit().getImage("카푸치노.jpg");
		img3 = Toolkit.getDefaultToolkit().getImage("바닐라라떼.jpg");
		img4 = Toolkit.getDefaultToolkit().getImage("카페모카.jpg");
		img5 = Toolkit.getDefaultToolkit().getImage("카라멜마끼아또.jpg");
		img6 = Toolkit.getDefaultToolkit().getImage("흑당커피.jpg");
		imgSel = Toolkit.getDefaultToolkit().getImage("선택대기.jpg");
		
		this.add(lbCoffee1Cnt); lbCoffee1Cnt.setFont(font15); 
		lbCoffee1Cnt.setBounds(60, 180, 100, 20);
		this.add(lbCoffee1); lbCoffee1.setFont(font15); 
		lbCoffee1.setBounds(60, 200, 100, 30);
		this.add(btncoffee1Price); btncoffee1Price.setFont(font15);
		btncoffee1Price.setBounds(60, 230, 100, 30);
		
		this.add(lbCoffee2Cnt); lbCoffee2Cnt.setFont(font15); 
		lbCoffee2Cnt.setBounds(210, 180, 100, 20);
		this.add(lbCoffee2); lbCoffee2.setFont(font15); 
		lbCoffee2.setBounds(210, 200, 100, 30);
		this.add(btncoffee2Price); btncoffee2Price.setFont(font15); 
		btncoffee2Price.setBounds(210, 230, 100, 30);
		
		this.add(lbCoffee3Cnt); lbCoffee3Cnt.setFont(font15); 
		lbCoffee3Cnt.setBounds(360, 180, 100, 20);
		this.add(lbCoffee3); lbCoffee3.setFont(font15); 
		lbCoffee3.setBounds(360, 200, 100, 30);
		this.add(btncoffee3Price); btncoffee3Price.setFont(font15); 
		btncoffee3Price.setBounds(360, 230, 100, 30);
		
		this.add(lbCoffee4Cnt); lbCoffee4Cnt.setFont(font15); 
		lbCoffee4Cnt.setBounds(60, 380, 100, 20);
		this.add(lbCoffee4); lbCoffee4.setFont(font15); 
		lbCoffee4.setBounds(60, 400, 100, 30);
		this.add(btncoffee4Price); btncoffee4Price.setFont(font15); 
		btncoffee4Price.setBounds(60, 430, 100, 30);
		
		this.add(lbCoffee5Cnt); lbCoffee5Cnt.setFont(font15); 
		lbCoffee5Cnt.setBounds(210, 380, 100, 20);
		this.add(lbCoffee5); lbCoffee5.setFont(font15); 
		lbCoffee5.setBounds(210, 400, 150, 30);
		this.add(btncoffee5Price); btncoffee5Price.setFont(font15); 
		btncoffee5Price.setBounds(210, 430, 100, 30);
		
		this.add(lbCoffee6Cnt); lbCoffee6Cnt.setFont(font15); 
		lbCoffee6Cnt.setBounds(360, 380, 100, 20);
		this.add(lbCoffee6); lbCoffee6.setFont(font15); 
		lbCoffee6.setBounds(360, 400, 100, 30);
		this.add(btncoffee6Price); btncoffee6Price.setFont(font15); 
		btncoffee6Price.setBounds(360, 430, 100, 30);
		
		this.add(lbSel); lbSel.setFont(font30); 
		lbSel.setBounds(510, 120, 200, 30);
		this.add(lbSelTitle); lbSelTitle.setFont(font15); 
		lbSelTitle.setBounds(530, 300, 200, 30);
		this.add(lbSelPrice); lbSelPrice.setFont(font15); 
		lbSelPrice.setBounds(530, 330, 200, 30);
		
		this.add(lbMoney); lbMoney.setFont(font15); 
		lbMoney.setBounds(60, 460, 100, 30);
		this.add(btn1000); btn1000.setFont(font15); 
		btn1000.setBounds(60, 490, 100, 30);
		this.add(btn5000); btn5000.setFont(font15); 
		btn5000.setBounds(210, 490, 100, 30);
		this.add(btn10000); btn10000.setFont(font15);
		btn10000.setBounds(360, 490, 100, 30);
		this.add(btnPay); btnPay.setFont(font15);
		btnPay.setBounds(510, 490, 100, 30);
		
		this.add(lbPrice1); lbPrice1.setFont(font20); 
		lbPrice1.setBounds(60, 530, 100, 30);
		this.add(lbSu1); lbSu1.setFont(font20); 
		lbSu1.setBounds(220, 530, 100, 30);
		this.add(lbPrice2); lbPrice2.setFont(font20); 
		lbPrice2.setBounds(360, 530, 100, 30);
		this.add(lbSu2); lbSu2.setFont(font20); 
		lbSu2.setBounds(520, 530, 100, 30);
		
		this.add(btnAdmin); btnAdmin.setFont(font15); 
		btnAdmin.setBounds(580, 40, 100, 30);
		
	}
	
	public void paint(Graphics g) {
		g.drawImage(img1, 60, 80, 100, 100, this);
		g.drawImage(img2, 210, 80, 100, 100, this);
		g.drawImage(img3, 360, 80, 100, 100, this);
		g.drawImage(img4, 60, 280, 100, 100, this);
		g.drawImage(img5, 210, 280, 100, 100, this);
		g.drawImage(img6, 360, 280, 100, 100, this);
		g.drawImage(imgSel, 530, 180, 100, 100, this);
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
				coffeeName[count] = rs.getString("name");
				coffeeCnt[count] = rs.getInt("count");
				coffeePrice[count] = rs.getInt("price");
				count++;
			}
			lbCoffee1.setText(coffeeName[0]);
			lbCoffee1Cnt.setText("수량"+coffeeCnt[0]+"개");
			btncoffee1Price.setLabel(coffeePrice[0]+"원");
			lbCoffee2.setText(coffeeName[1]);
			lbCoffee2Cnt.setText("수량"+coffeeCnt[1]+"개");
			btncoffee2Price.setLabel(coffeePrice[1]+"원");
			lbCoffee3.setText(coffeeName[2]);
			lbCoffee3Cnt.setText("수량"+coffeeCnt[2]+"개");
			btncoffee3Price.setLabel(coffeePrice[2]+"원");
			lbCoffee4.setText(coffeeName[3]);
			lbCoffee4Cnt.setText("수량"+coffeeCnt[3]+"개");
			btncoffee4Price.setLabel(coffeePrice[3]+"원");
			lbCoffee5.setText(coffeeName[4]);
			lbCoffee5Cnt.setText("수량"+coffeeCnt[4]+"개");
			btncoffee5Price.setLabel(coffeePrice[4]+"원");
			lbCoffee6.setText(coffeeName[5]);
			lbCoffee6Cnt.setText("수량"+coffeeCnt[5]+"개");
			btncoffee6Price.setLabel(coffeePrice[5]+"원");
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	
	public void start() {
		btncoffee1Price.addActionListener(this);
		btncoffee2Price.addActionListener(this);
		btncoffee3Price.addActionListener(this);
		btncoffee4Price.addActionListener(this);
		btncoffee5Price.addActionListener(this);
		btncoffee6Price.addActionListener(this);
		btn1000.addActionListener(this);
		btn5000.addActionListener(this);
		btn10000.addActionListener(this);
		btnPay.addActionListener(this);
		btnAdmin.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btncoffee1Price) {
			selCoffee=0;//1번커피선택
			imgSel = Toolkit.getDefaultToolkit().getImage("아메리카노.jpg");
			price2 = coffeePrice[0];
			lbSu2.setText(price2+"원");
			lbSelPrice.setText("가격: "+price2+"원");
			lbSelTitle.setText(coffeeName[0]);
			this.repaint();
		}
		else if(e.getSource() == btncoffee2Price) {
			selCoffee=1;//2번커피선택
			imgSel = Toolkit.getDefaultToolkit().getImage("카푸치노.jpg");
			price2 = coffeePrice[1];
			lbSu2.setText(price2+"원");
			lbSelPrice.setText("가격: "+price2+"원");
			lbSelTitle.setText(coffeeName[1]);
			this.repaint();
		}
		else if(e.getSource() == btncoffee3Price) {
			selCoffee=2;//3번커피선택
			imgSel = Toolkit.getDefaultToolkit().getImage("바닐라라떼.jpg");
			price2 = coffeePrice[2];
			lbSu2.setText(price2+"원");
			lbSelPrice.setText("가격: "+price2+"원");
			lbSelTitle.setText(coffeeName[2]);
			this.repaint();
		}
		else if(e.getSource() == btncoffee4Price) {
			selCoffee=3;//4번커피선택
			imgSel = Toolkit.getDefaultToolkit().getImage("카페모카.jpg");
			price2 = coffeePrice[3];
			lbSu2.setText(price2+"원");
			lbSelPrice.setText("가격: "+price2+"원");
			lbSelTitle.setText(coffeeName[3]);
			this.repaint();
		}
		else if(e.getSource() == btncoffee5Price) {
			selCoffee=4;//5번커피선택
			imgSel = Toolkit.getDefaultToolkit().getImage("카라멜마끼아또.jpg");
			price2 = coffeePrice[4];
			lbSu2.setText(price2+"원");
			lbSelPrice.setText("가격: "+price2+"원");
			lbSelTitle.setText(coffeeName[4]);
			this.repaint();
		}
		else if(e.getSource() == btncoffee6Price) {
			selCoffee=5;//6번커피선택
			imgSel = Toolkit.getDefaultToolkit().getImage("흑당커피.jpg");
			price2 = coffeePrice[5];
			lbSu2.setText(price2+"원");
			lbSelPrice.setText("가격: "+price2+"원");
			lbSelTitle.setText(coffeeName[5]);
			this.repaint();
		}
		else if(e.getSource() == btn1000) {
			price1 += 1000;
			lbSu1.setText(price1+"원");
		}
		else if(e.getSource() == btn5000) {
			price1 += 5000;
			lbSu1.setText(price1+"원");
		}
		else if(e.getSource() == btn10000) {
			price1 += 10000;
			lbSu1.setText(price1+"원");
		}
		else if(e.getSource() == btnAdmin) {
			AdminScreen as = new AdminScreen();
		}
		else if(e.getSource() == btnPay) {
			if(price1 < price2) {
				msg("금액을 투입하여 주십시오.");return;
			}
			if(price1 >= price2) {
				if(price2 == 0) {
					msg("구매할 커피를 선택해주세요.");return;
				}
			}
			
			//수량체크 메서드
			countCheck(selCoffee);
			
			if(makeCheck==true) {
				price1 -= price2; lbSu1.setText(price1+"원");
				lbSelTitle.setText("선택커피명");
				//제조표시하기			
				try {
					lbSelTitle.setText("맛있는");
					Thread.sleep(1000);
				} catch (InterruptedException e1) {	}
				try {
					lbSelTitle.setText("커피를");
					Thread.sleep(1000);
				} catch (InterruptedException e1) {	}
				try {
					lbSelTitle.setText("제조합니다.");
					Thread.sleep(1000);
				} catch (InterruptedException e1) {	}
				lbSelTitle.setText("선택커피명");
				price2 = 0;	lbSu2.setText(price2+"원");
				lbSelPrice.setText("가격 :    0원");
				imgSel = Toolkit.getDefaultToolkit().getImage("선택대기.jpg");
				this.repaint();
			}else {
				makeCheck=true;
			}
		}
	}
	
	void countCheck(int selCoffee)
	{
		if(coffeeCnt[selCoffee]==0) {
			msg("수량이없어서 구매가불가능합니다.");			
			makeCheck=false;
			return;
		}		
		if(selCoffee==0) {
			coffeeCnt[0]--;
			lbCoffee1Cnt.setText("수량 "+coffeeCnt[0]+"개");
		}
		else if(selCoffee==1) {
			coffeeCnt[1]--;
			lbCoffee2Cnt.setText("수량 "+coffeeCnt[1]+"개");
		}
		else if(selCoffee==2) {
			coffeeCnt[2]--;
			lbCoffee3Cnt.setText("수량 "+coffeeCnt[2]+"개");
		}
		else if(selCoffee==3) {
			coffeeCnt[3]--;
			lbCoffee4Cnt.setText("수량 "+coffeeCnt[3]+"개");
		}
		else if(selCoffee==4) {
			coffeeCnt[4]--;
			lbCoffee5Cnt.setText("수량 "+coffeeCnt[4]+"개");
		}
		else if(selCoffee==5) {
			coffeeCnt[5]--;
			lbCoffee6Cnt.setText("수량 "+coffeeCnt[5]+"개");
		}
		//수정하는 메서드 호출
		update(selCoffee+1, coffeeCnt[selCoffee]);
	}
	
	boolean update(int idx, int count)
	{
		Connection dc=null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {		
		}
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String pass = "qwer";
		try {
			dc = DriverManager.getConnection(url, user, pass);
		} catch (SQLException ee) {
		}
		
		String query = "update coffee set count = ? where idx = ?";
	
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setInt(1, count);
			pstmt.setInt(2, idx);		
			pstmt.executeUpdate();
			pstmt.close();
			msg("결제가 완료 되었습니다!");
		} catch (SQLException ee) {
			System.err.println("정보수정 실패!!:"+ee.getMessage());
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
