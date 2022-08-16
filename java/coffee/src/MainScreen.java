package coffee;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class MainScreen extends Frame implements ActionListener {
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	private Image img1, img2, img3, img4, img5, img6, imgSel; //커피이미지변수
	int price1 = 0, price2 = 0; //현재잔액 , 결제금액
	int coffeePrice[] = {2000, 3000, 3500, 4000, 4000, 4000}; //커피가격변수
	String coffeeName[] = {"아메리카노","카푸치노","바닐라라떼","카페모카","카라멜마끼아또","흑당커피"};
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	Font font20 = new Font("SansSerif", Font.BOLD, 20);
	Font font30 = new Font("SansSerif", Font.BOLD, 30);
	
	Label lbTitle = new Label("커피자판기");
	Label lbAmericano = new Label("아메리카노");
	Label lbCappuccino = new Label("카푸치노");
	Label lbVanillaLatte = new Label("바닐라라떼");
	Label lbCafeMocha = new Label("카페모카");
	Label lbCaramelMacchiato = new Label("카라멜마끼아또");
	Label lbBrownSugarCoffee = new Label("흑당커피");
	Label lbMoney = new Label("투입금액");
	Label lbSel = new Label("선택상품");
	Label lbSelTitle = new Label("선택커피명");
	Label lbSelPrice = new Label("가격 :    0원");
	Label lbPrice1 = new Label("현재잔액:");
	Label lbSu1 = new Label(price1+"원");
	Label lbPrice2 = new Label("결제금액:");
	Label lbSu2 = new Label(price2+"원");
	
	Button btnAmericano = new Button("2000원");
	Button btnCappuccino = new Button("3000원");
	Button btnVanillaLatte = new Button("3500원");
	Button btnCafeMocha = new Button("4000원");
	Button btnCaramelMacchiato = new Button("4000원");
	Button btnBrownSugarCoffee = new Button("4000원");
	Button btn1000 = new Button("1000원");
	Button btn5000 = new Button("5000원");
	Button btn10000 = new Button("10000원");
	Button btnPay = new Button("결제하기");
	
	MainScreen() {
		super("메인화면");
		this.setSize(700,600);
		this.center();//중앙배치		
		this.init();//화면구성
		this.start();//이벤트처리
		this.setVisible(true);
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ee) {
			}
			this.repaint();
		}
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
		
		this.add(lbAmericano); lbAmericano.setFont(font15); 
		lbAmericano.setBounds(60, 200, 100, 30);
		this.add(btnAmericano); btnAmericano.setFont(font15);
		btnAmericano.setBounds(60, 230, 100, 30);
		
		this.add(lbCappuccino); lbCappuccino.setFont(font15); 
		lbCappuccino.setBounds(210, 200, 100, 30);
		this.add(btnCappuccino); btnCappuccino.setFont(font15); 
		btnCappuccino.setBounds(210, 230, 100, 30);
		
		this.add(lbVanillaLatte); lbVanillaLatte.setFont(font15); 
		lbVanillaLatte.setBounds(360, 200, 100, 30);
		this.add(btnVanillaLatte); btnVanillaLatte.setFont(font15); 
		btnVanillaLatte.setBounds(360, 230, 100, 30);
		
		this.add(lbCafeMocha); lbCafeMocha.setFont(font15); 
		lbCafeMocha.setBounds(60, 400, 100, 30);
		this.add(btnCafeMocha); btnCafeMocha.setFont(font15); 
		btnCafeMocha.setBounds(60, 430, 100, 30);
		
		this.add(lbCaramelMacchiato); lbCaramelMacchiato.setFont(font15); 
		lbCaramelMacchiato.setBounds(210, 400, 150, 30);
		this.add(btnCaramelMacchiato); btnCaramelMacchiato.setFont(font15); 
		btnCaramelMacchiato.setBounds(210, 430, 100, 30);
		
		this.add(lbBrownSugarCoffee); lbBrownSugarCoffee.setFont(font15); 
		lbBrownSugarCoffee.setBounds(360, 400, 100, 30);
		this.add(btnBrownSugarCoffee); btnBrownSugarCoffee.setFont(font15); 
		btnBrownSugarCoffee.setBounds(360, 430, 100, 30);
		
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
		
		
	}
	
	public void paint(Graphics g) {
		g.drawImage(img1, 50, 80, 100, 100, this);
		g.drawImage(img2, 200, 80, 100, 100, this);
		g.drawImage(img3, 350, 80, 100, 100, this);
		g.drawImage(img4, 50, 280, 100, 100, this);
		g.drawImage(img5, 200, 280, 100, 100, this);
		g.drawImage(img6, 350, 280, 100, 100, this);
		g.drawImage(imgSel, 530, 180, 100, 100, this);
	}
	
	public void start() {
		btnAmericano.addActionListener(this);
		btnCappuccino.addActionListener(this);
		btnVanillaLatte.addActionListener(this);
		btnCafeMocha.addActionListener(this);
		btnCaramelMacchiato.addActionListener(this);
		btnBrownSugarCoffee.addActionListener(this);
		btn1000.addActionListener(this);
		btn5000.addActionListener(this);
		btn10000.addActionListener(this);
		btnPay.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnAmericano) {
			imgSel = Toolkit.getDefaultToolkit().getImage("아메리카노.jpg");
			price2 = coffeePrice[0];
			lbSu2.setText(price2+"원");
			lbSelPrice.setText("가격: "+price2+"원");
			lbSelTitle.setText(coffeeName[0]);
			this.repaint();
		}
		else if(e.getSource() == btnCappuccino) {
			imgSel = Toolkit.getDefaultToolkit().getImage("카푸치노.jpg");
			price2 = coffeePrice[1];
			lbSu2.setText(price2+"원");
			lbSelPrice.setText("가격: "+price2+"원");
			lbSelTitle.setText(coffeeName[1]);
			this.repaint();
		}
		else if(e.getSource() == btnVanillaLatte) {
			imgSel = Toolkit.getDefaultToolkit().getImage("바닐라라떼.jpg");
			price2 = coffeePrice[2];
			lbSu2.setText(price2+"원");
			lbSelPrice.setText("가격: "+price2+"원");
			lbSelTitle.setText(coffeeName[2]);
			this.repaint();
		}
		else if(e.getSource() == btnCafeMocha) {
			imgSel = Toolkit.getDefaultToolkit().getImage("카페모카.jpg");
			price2 = coffeePrice[3];
			lbSu2.setText(price2+"원");
			lbSelPrice.setText("가격: "+price2+"원");
			lbSelTitle.setText(coffeeName[3]);
			this.repaint();
		}
		else if(e.getSource() == btnCaramelMacchiato) {
			imgSel = Toolkit.getDefaultToolkit().getImage("카라멜마끼아또.jpg");
			price2 = coffeePrice[4];
			lbSu2.setText(price2+"원");
			lbSelPrice.setText("가격: "+price2+"원");
			lbSelTitle.setText(coffeeName[4]);
			this.repaint();
		}
		else if(e.getSource() == btnBrownSugarCoffee) {
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
		else if(e.getSource() == btnPay) {
			if(price1 < price2) {
				msg("금액을 투입하여 주십시오.");return;
			}
			if(price1 >= price2) {
				if(price2 == 0) {
					msg("구매할 커피를 선택해주세요.");return;
				}else {
					price1 -= price2; lbSu1.setText(price1+"원");
					price2 = 0;	lbSu2.setText(price2+"원");
					lbSelPrice.setText("가격 :    0원");
					lbSelTitle.setText("선택커피명");
					imgSel = Toolkit.getDefaultToolkit().getImage("선택대기.jpg");
					this.repaint();
					msg("결제가 완료되었습니다!");return;
				}
			}
		}
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
