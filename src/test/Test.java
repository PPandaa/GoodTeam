package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import function.Instruction;
import homePage.HomePage;
import simulate.SimulateInterface;
import function.Setting;
import fishStore.FishStore;

public class Test{
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	JFrame frame = new JFrame();
	JPanel homePage = new HomePage(frame);
	JPanel instructionHome = new Instruction(new Color(61, 89, 171),Color.WHITE, SwingConstants.VERTICAL);
	JPanel instructionSim = new Instruction(new Color(61, 89, 171),Color.WHITE, SwingConstants.VERTICAL);
	SimulateInterface simulateInterface = new SimulateInterface(frame);
	JPanel setting = new Setting(frame, simulateInterface);
	JPanel fishStore = new FishStore(frame,simulateInterface.getFish(),simulateInterface);
	
	CardLayout cardLayout;
	
	Test(){
		//Container c = frame.getContentPane();
		frame.setLayout(new CardLayout());
		frame.add(homePage, "homePage");
		frame.add(instructionHome, "instructionHome");
		frame.add(instructionSim, "instructionSim");
		frame.add(simulateInterface, "simulateInterface");
		frame.add(setting, "setting");
		frame.add(fishStore, "fishStore");
		
		cardLayout = (CardLayout) frame.getContentPane().getLayout();
		
		action_setting();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(dimension.width,dimension.height);
		frame.setVisible(true);
		//frame.pack();
		//frame.show();
	}
	public void action_setting() {
		//首頁Panel中的開始按鈕，點擊後，頁面會跳至模擬Panel
		((HomePage) homePage).start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(frame.getContentPane(), "simulateInterface");
			}
		});
		
		//首頁Panel中的繼續按鈕，點擊後，頁面會跳至模擬Panel，且繼續上次模擬狀態
		((HomePage) homePage).continuee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(frame.getContentPane(), "simulateInterface");
			}
		});
		
		//首頁Panel中的說明按鈕，點擊後，頁面會跳至說明Panel
		((HomePage) homePage).instruction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(frame.getContentPane(), "instructionHome");
			}
		});
		
		//說明Panel中的X，點擊會回到首頁Panel
		((Instruction) instructionHome).close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.previous(frame.getContentPane());
			}
		});
		//說明Panel中的return按鈕，點擊會回到首頁Panel
		((Instruction) instructionHome).comeBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.previous(frame.getContentPane());
			}
		});
		
		//說明Panel中的X，點擊會回到模擬Panel
		((Instruction) instructionSim).close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.next(frame.getContentPane());
			}
		});
		//說明Panel中的return按鈕，點擊會回到模擬Panel
		((Instruction) instructionSim).comeBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.next(frame.getContentPane());
			}
		});
		
		//模擬Panel中的設定按鈕，點擊後頁面跳至設定Panel
		((SimulateInterface) simulateInterface).set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(frame.getContentPane(), "setting");
			}
		});
		
		//模擬Panel中的魚店按鈕，點擊後頁面跳至魚店Panel
		((SimulateInterface) simulateInterface).fishStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(frame.getContentPane(), "fishStore");
			}
		});
		
		//模擬Panel中的說明按鈕，點擊後，頁面會跳至說明Panel
		((SimulateInterface) simulateInterface).instruction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(frame.getContentPane(), "instructionSim");
			}
		});
		
		//說明Panel中的返回按鈕，點擊後，頁面回到模擬Panel
		((Setting) setting).back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(frame.getContentPane(), "simulateInterface");
			}
		});
		
		//說明Panel中的首頁按鈕，點擊後，頁面跳至首頁Panel
		((Setting) setting).homepage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(frame.getContentPane(), "homePage");
			}
		});
		
		//說明Panel中的返回按鈕，點擊後，頁面跳至模擬Panel
		((FishStore) fishStore).back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(frame.getContentPane(), "simulateInterface");
			}
		});
	}
	public static void main(String[] args) {
		new Test();
	}	

}



/*HomePage HP = new HomePage();
HP.run();*/