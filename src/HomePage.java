import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Container.*;
import java.util.*;

public class HomePage extends JFrame{
	/*private JLabel background;
	private JTextArea topic;
	private JButton start;
	private JButton instruction;
	private JButton toContinue;
	private BorderLayout layout;*/
	private SimulateInterface SI;
	
	public HomePage()
	{
		/*Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		ImageIcon img = new ImageIcon("C:/Users/user/workspace/FFS/src/background.jpg");
		//setBak();
		//setLayout(new FlowLayout());
		Icon startImage = new ImageIcon("C:/Users/user/workspace/FFS/src/start.jpg");
		background = new JLabel(img);
		topic = new JTextArea();
		start = new JButton(startImage);
		instruction = new JButton();
		toContinue = new JButton();
		topic.setBackground(Color.BLUE);
		topic.setText("Fish Farming"+"\n"+"   System");
		topic.setFont(new Font("標楷體",Font.BOLD,150));
		//background.setOpaque(false);
		background.setSize(d.width,d.height);
		//background.setBackground(Color.GREEN);
		add(background);
		//start.setBounds(20,20,10,10);
		background.add(topic);
		//background.add(start);*/
	}
	public void run()
	{
		Scanner scanner = new Scanner(System.in);
		int input = 0;   //選擇1開始2繼續3說明
		boolean firstIn = true;
		SimulateInterface SI = new SimulateInterface();
		
		System.out.println("歡迎進入FFS");
		//System.out.println("Start輸入1 Continue輸入2 查看說明輸入3");
		while(input != -1 )
		{
			System.out.println("1.Start 2.Continue 3.查看說明  -1.結束");
			input = scanner.nextInt();
			if(firstIn)
			{
				System.out.println("歡迎進入模擬介面");
				firstIn = false;
			}
			switch(input)
			{
			case 1: 
				SI = new SimulateInterface();
				input = SI.run();
				break;
			case 2:
				input = SI.run();
				break;
			case 3:
				Instruction.getInstruction();
				input = scanner.nextInt();
				break;
			case -1:
				break;
			default:
				System.out.println("Try again!");
			}
		}
		System.out.println("結束");
	}
	/*public void setBak(){
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("C:/Users/user/workspace/FFS/src/background.jpg");
		JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setSize(d.width,d.height);
	}*/
}