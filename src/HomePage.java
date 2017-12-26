import java.util.Scanner;

import javax.swing.JFrame;

public class HomePage extends JFrame
{
	private SimulateInterface SI;
	
	public HomePage()
	{
		//1234567
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
		topic.setFont(new Font("璅扑擃�",Font.BOLD,150));
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
		int input = 0;   //����1����2蝜潛��3隤芣��
		boolean firstIn = true;
		
		System.out.println("甇∟��脣FFS");
		//System.out.println("Start頛詨1 Continue頛詨2 ���牧��撓�3");
		while(input != -1 )
		{
			System.out.println("1.Start 2.Continue 3.���牧���  -1.蝯��");
			input = scanner.nextInt();
			if(firstIn)
			{
				System.out.println("甇∟��脣璅⊥隞");
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
		System.out.println("蝯��");
	}
	/*public void setBak(){
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("C:/Users/user/workspace/FFS/src/background.jpg");
		JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setSize(d.width,d.height);
	}*/
}