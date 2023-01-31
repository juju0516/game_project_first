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

public class Map_Choice extends JFrame implements Runnable {
	JPanel jp1, jp2, jp3, card1;
	JButton jb1, jb2, jb3, jb4, jb5, jb6;
	CardLayout cl;
	public ImageIcon img1;
	public ImageIcon img2;
	public ImageIcon img3;
	JLabel jl1, jl2, jl3;
	Chr_Choice chr;
	Map_Choice map = this;
	public int mapDec = 1;
	public Map_Choice(Chr_Choice chr) {
		super("맵 선택");
		this.chr = chr;
		img1 = new ImageIcon("Images/Maps/map1.jpg");
		img2 = new ImageIcon("Images/Maps/map2.jpg");
		img3 = new ImageIcon("Images/Maps/map3.jpg");

		jl1 = new JLabel(img1, JLabel.CENTER);
		jl1.setVerticalTextPosition(JLabel.CENTER);
		jl1.setHorizontalTextPosition(JLabel.CENTER);
		jl1.setPreferredSize(new Dimension(600, 600));
		jp1 = new JPanel();
		jp1.add(jl1);

		jl2 = new JLabel(img2, JLabel.CENTER);
		jl2.setVerticalTextPosition(JLabel.CENTER);
		jl2.setHorizontalTextPosition(JLabel.CENTER);
		jl2.setPreferredSize(new Dimension(600, 600));
		jp2 = new JPanel();
		jp2.add(jl2);

		jl3 = new JLabel(img3, JLabel.CENTER);
		jl3.setVerticalTextPosition(JLabel.CENTER);
		jl3.setHorizontalTextPosition(JLabel.CENTER);
		jl3.setPreferredSize(new Dimension(600, 600));
		jp3 = new JPanel();
		jp3.add(jl3);

		JPanel card = new JPanel();
		cl = new CardLayout();
		card.setLayout(cl);
		
		card.add("Map1", jp1);
		card.add("Map2", jp2);
		card.add("Map3", jp3);


		jb1 = new JButton("<");
		jb2 = new JButton("선택");
		jb3 = new JButton(">");
		JPanel jp4 = new JPanel();

		jp4.add(jb1);
		jp4.add(jb2);
		jp4.add(jb3);
		
		add(card, BorderLayout.CENTER);
		add(jp4, BorderLayout.SOUTH);
	
		cl.show(card, "Map1");
 
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(mapDec>1) {
					cl.previous(card);
					mapDec--;
				}
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(mapDec);
				dispose();
				new Dif_Choice(map,chr);
			}
		});
		
		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(mapDec<3) {
					cl.next(card);
					mapDec++;
				}
			}
		});

		setSize(600, 600);
		setVisible(true);

	}

//	public static void main(String[] args) {
//
//		new Map_Choice();
//	}
	
	public void start() {
		new Map_Choice(chr);
		
	}

	@Override
	public void run() {
		

	}
}
