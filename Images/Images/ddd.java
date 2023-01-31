package Images;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//카드 레이아웃 : 카드가 뒤집혀진 상태에서 이벤트가 발생하면 하나씩 보여주는 형태의 레이아웃 (카드란 JPanel을 뜻함)
public class ddd extends JFrame {
	JPanel card1, card2, card3, card4, card5, pg1, pg2;
	JButton jb1, jb2, jb3, jb4;
	CardLayout cardLayout;

	public ddd() {
		super("카드레이아웃");

		card1 = new JPanel();
		card1.setBackground(Color.PINK);
		card1.add(new JLabel("첫번째 카드"));
		
		card2 = new JPanel();
		card2.setBackground(Color.BLACK);
		card2.add(new JLabel("두번째 카드"));
		
		card3 = new JPanel();
		card3.setBackground(Color.BLUE);
		card3.add(new JLabel("세번째 카드"));
		
		card4 = new JPanel();
		card4.setBackground(Color.CYAN);
		card4.add(new JLabel("네번째 카드"));
		
		card5 = new JPanel();
		card5.setBackground(Color.GRAY);
		card5.add(new JLabel("다섯번째 카드"));
		
		//pg1을 카드 레이아웃으로 변경
		pg1 = new JPanel();
		cardLayout = new CardLayout(); 
		pg1.setLayout(cardLayout);
		
		//카드 레이아웃에 패널 추가
		//pg1.add("호출이름", 해당 컴포넌트);
		pg1.add("1", card1);
		pg1.add("2", card2); // 해당 카드를 호출할 땐 show(cardLayout, "호출이름"
		pg1.add("3", card3);
		pg1.add("4", card4);
		pg1.add("5", card5);
		
		pg2 = new JPanel();
		jb1 = new JButton("<<");
		jb2 = new JButton("<");
		jb3 = new JButton(">");
		jb4 = new JButton(">>");
		
		pg2.add(jb1);
		pg2.add(jb2);
		pg2.add(jb3);
		pg2.add(jb4);

		add(pg1,BorderLayout.CENTER);
		add(pg2,BorderLayout.SOUTH);
			
		pack();
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		//첫 카드 지정
		cardLayout.show(pg1, "3");
				
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.first(pg1);
				//cardLayout.show(pg1, "1");
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.previous(pg1);
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(pg1);
			}
		});
		
		jb4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.last(pg1);
				//cardLayout.show(pg1, "5");
			}
		});
	}

	public static void main(String[] args) {
		new ddd();
	}
}

