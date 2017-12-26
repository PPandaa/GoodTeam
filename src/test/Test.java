package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import function.Instruction;
import homePage.HomePage;

public class Test{
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	JFrame frame = new JFrame();
	JPanel homePage = new HomePage(frame);
	JPanel instruction = new Instruction(new Color(61, 89, 171),Color.WHITE, SwingConstants.VERTICAL);
	
	CardLayout cardLayout;
	
	Test(){
		//Container c = frame.getContentPane();
		frame.setLayout(new CardLayout());
		frame.add(homePage, "homePage");
		frame.add(instruction, "instruction");
		cardLayout = (CardLayout) frame.getContentPane().getLayout();
		
		action_setting();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(dimension.width,dimension.height);
		frame.setVisible(true);
		//frame.pack();
		//frame.show();
	}
	public void action_setting() {
		((HomePage) homePage).instruction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(frame.getContentPane(), "instruction");
			}
		});
		((Instruction) instruction).close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(frame.getContentPane(), "homePage");
			}
		});
		((Instruction) instruction).comeBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(frame.getContentPane(), "homePage");
			}
		});
	}
	public static void main(String[] args) {
		
		//JFrame frame = new JFrame();
		//HomePage homePage = new HomePage(frame);
		//Instruction instruction = new Instruction(new Color(61, 89, 171),Color.WHITE, SwingConstants.VERTICAL);
		//frame.setLayout(null);
		/*frame.add(homePage);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(dimension.width,dimension.height);
		frame.setVisible(true);*/
		//將視窗設為案X就關閉程式
		new Test();
	}	

}



/*HomePage HP = new HomePage();
HP.run();*/