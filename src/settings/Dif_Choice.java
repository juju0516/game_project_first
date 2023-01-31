package settings;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Frame;

public class Dif_Choice extends JFrame implements Runnable {
	JPanel jp1, jp2, jp3, card1;
	JButton jb1, jb2, jb3, jb4, jb5, jb6;
	CardLayout cl;
	ImageIcon img1, img2, img3;
	JLabel jl1, jl2, jl3;
	Map_Choice map;
	Chr_Choice chr;
	Dif_Choice dif = this;
	public int difficulty = 1;
	public Dif_Choice(Map_Choice map,Chr_Choice chr) {
		super("난이도 선택");
		this.map=map;
		this.chr=chr;
		img1 = new ImageIcon("Images/Dif/EASY.PNG");
		img2 = new ImageIcon("Images/Dif/NORMAL.PNG");
		img3 = new ImageIcon("Images/Dif/HELL.PNG");

		jl1 = new JLabel(img1, JLabel.CENTER);
		jl1.setVerticalTextPosition(JLabel.CENTER);
		jl1.setHorizontalTextPosition(JLabel.CENTER);
		jl1.setPreferredSize(new Dimension(510, 510));
		jp1 = new JPanel();
		jp1.add(jl1);

		jl2 = new JLabel(img2, JLabel.CENTER);
		jl2.setVerticalTextPosition(JLabel.CENTER);
		jl2.setHorizontalTextPosition(JLabel.CENTER);
		jl2.setPreferredSize(new Dimension(510, 510));
		jp2 = new JPanel();
		jp2.add(jl2);

		jl3 = new JLabel(img3, JLabel.CENTER);
		jl3.setVerticalTextPosition(JLabel.CENTER);
		jl3.setHorizontalTextPosition(JLabel.CENTER);
		jl3.setPreferredSize(new Dimension(510, 510));
		jp3 = new JPanel();
		jp3.add(jl3);

		JPanel card = new JPanel();
		cl = new CardLayout();
		card.setLayout(cl);
		
		card.add("Dif1", jp1);
		card.add("Dif2", jp2);
		card.add("Dif3", jp3);


		jb1 = new JButton("<");
		jb2 = new JButton("선택");
		jb3 = new JButton(">");
		JPanel jp4 = new JPanel();

		jp4.add(jb1);
		jp4.add(jb2);
		jp4.add(jb3);
		
		add(card, BorderLayout.CENTER);
		add(jp4, BorderLayout.SOUTH);
	
		cl.show(card, "Dif1");
 
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(difficulty>1) {
					cl.previous(card);
				difficulty--;
				}
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Frame(dif,chr,map);
			}
		});
		
		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(difficulty<3) {
					cl.next(card);
					difficulty++;
					}

			}
		});

		setSize(600, 600);
		setVisible(true);

	}

	
	public void start() {
		new Dif_Choice(map,chr);
		
	}

	@Override
	public void run() {
		

	}
}

