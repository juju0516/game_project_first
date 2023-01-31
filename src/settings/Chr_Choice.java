package settings;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Chr_Choice extends JFrame implements Runnable {
	JPanel jp1, jp2, jp3, card1;
	JButton jb1, jb2, jb3, jb4, jb5, jb6;
	CardLayout cl;
	public ImageIcon img1;
	public ImageIcon img2;
	public ImageIcon img3;
	JLabel jl1, jl2, jl3;
	Chr_Choice chr = this;
	public int chosenCard = 1;
	
	public String c(String ch) {
		return "";
	}
	public Chr_Choice() {
		super("캐릭터 선택");
		img1 = new ImageIcon("Images/CharacterImages/blueWitch/witchChoose.gif");		
		img2 = new ImageIcon("Images/CharacterImages/RedHood/idle.gif");
		img3 = new ImageIcon("Images/CharacterImages/warrior/idle.gif");
		
		
		//Imagescaler
		
		

		jl1 = new JLabel(img1, JLabel.CENTER);
		jl1.setVerticalTextPosition(JLabel.CENTER);
		jl1.setHorizontalTextPosition(JLabel.CENTER);
		jl1.setPreferredSize(new Dimension(500, 500));
		jp1 = new JPanel();
		jp1.add(jl1);

		jl2 = new JLabel(img2, JLabel.CENTER);
		jl2.setVerticalTextPosition(JLabel.CENTER);
		jl2.setHorizontalTextPosition(JLabel.CENTER);
		jl2.setPreferredSize(new Dimension(500, 500));
		jp2 = new JPanel();
		jp2.add(jl2);

		jl3 = new JLabel(img3, JLabel.CENTER);
		jl3.setVerticalTextPosition(JLabel.CENTER);
		jl3.setHorizontalTextPosition(JLabel.CENTER);
		jl3.setPreferredSize(new Dimension(500, 500));
		jp3 = new JPanel();
		jp3.add(jl3);

		JPanel card = new JPanel();
		cl = new CardLayout();
		card.setLayout(cl);
		
		card.add("모코코1", jp1);
		card.add("모코코2", jp2);
		card.add("모코코3", jp3);


		jb1 = new JButton("<");
		jb2 = new JButton("선택");
		jb3 = new JButton(">");
		JPanel jp4 = new JPanel();

		jp4.add(jb1);
		jp4.add(jb2);
		jp4.add(jb3);
		
		add(card, BorderLayout.CENTER);
		add(jp4, BorderLayout.SOUTH);
	
		cl.show(card, "모코코1");
		
		
 
		jb1.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.previous(card);
				if(chosenCard>1) {
					chosenCard--;
					}
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				 
				setVisible(false);
				new Map_Choice(chr);
			}
		});
		
		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.next(card);
				if(chosenCard<3) {
					chosenCard++;
					}

			}
		});

		setSize(600, 600);
		setVisible(true);

	}

	public static void main(String[] args) {

		new Chr_Choice();
	}

	@Override
	public void run() {

	}
}
