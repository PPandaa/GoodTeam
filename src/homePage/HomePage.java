package homePage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import function.Instruction;

public class HomePage extends JPanel{
	Popup pop = null;
	
	public JButton start;
	public JButton continuee;
	public JButton instruction;
	
	//抓電腦螢幕
	private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	//private final HomePage s = this;
	public HomePage(JFrame frame) {
		
		setLayout(new FlowLayout());
		
		//抓"看板"，並且設置大小
		ImageIcon homePageBoardIcon = new ImageIcon(getClass().getResource("HomePageBoard.PNG"));
		homePageBoardIcon.setImage(homePageBoardIcon.getImage()
				.getScaledInstance(1200,400,Image.SCALE_DEFAULT));
		//抓start按鈕，並且設置大小
		ImageIcon startIcon = new ImageIcon(getClass().getResource("start.PNG"));
		startIcon.setImage(startIcon.getImage().getScaledInstance(550,135,Image.SCALE_DEFAULT));
		//抓continue按鈕，並且設置大小
		ImageIcon continueIcon = new ImageIcon(getClass().getResource("continue.PNG"));
		continueIcon.setImage(continueIcon.getImage().getScaledInstance(550,135,Image.SCALE_DEFAULT));
		//抓instruction按鈕，並且設置大小
		ImageIcon instructionIcon = new ImageIcon(getClass().getResource("instruction.PNG"));
		instructionIcon.setImage(instructionIcon.getImage().getScaledInstance(550,135,Image.SCALE_DEFAULT));
		
		//新增Label及Button，並且將圖片塞入
		JLabel homePageBoard = new JLabel(homePageBoardIcon);
		start = new JButton(startIcon);
		continuee = new JButton(continueIcon);
		instruction = new JButton(instructionIcon);

		start.setBorder(null);//不繪製按鈕的邊
		start.setContentAreaFilled(false);//不會自行繪製按鈕背景
		ImageIcon newStart = new ImageIcon(getClass().getResource("start-2.PNG")); 
		newStart.setImage(newStart.getImage().getScaledInstance(550,135,Image.SCALE_DEFAULT));
		start.setRolloverIcon(newStart);
		/*start.addMouseListener(
				new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent event) {
						
					}
				}
		);*/
		
		continuee.setBorder(null);//不繪製按鈕的邊
		continuee.setContentAreaFilled(false);//不會自行繪製按鈕背景
		ImageIcon newContinue = new ImageIcon(getClass().getResource("continue-2.PNG")); 
		newContinue.setImage(newContinue.getImage().getScaledInstance(550,135,Image.SCALE_DEFAULT));
		continuee.setRolloverIcon(newContinue);
		/*continuee.addMouseListener(
				new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent event) {
						
					}
				}
		);*/
		
		instruction.setBorder(null);//不繪製按鈕的邊
		instruction.setContentAreaFilled(false);//不會自行繪製按鈕背景
		ImageIcon newInstruction = new ImageIcon(getClass().getResource("instruction-2.PNG")); 
		newInstruction.setImage(newInstruction.getImage().getScaledInstance(550,135,Image.SCALE_DEFAULT));
		instruction.setRolloverIcon(newInstruction);
		/*instruction.addMouseListener(
			new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent event) {
					
				}
			}
	
		);*/
				
		setBackground(frame);//調用背景方法
		
		this.setOpaque(false);//把JPanel設置為透明 這樣就不會遮住後面的背景 這樣你就能在JPanel隨意加元件了
		//將Label及Button放入Panel中
		add(homePageBoard);
		add(start);
		add(continuee);
		add(instruction);
		

		}

	
	//設置背景
	public void setBackground(JFrame frame){
		//把JPanel設置為透明 這樣就不會遮住後面的按鈕這樣你就能在JPanel隨意加元件了
		((JPanel)frame.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon(getClass().getResource("background.PNG"));
		img.setImage(img.getImage().getScaledInstance(dimension.width
				,dimension.height,Image.SCALE_DEFAULT));
		
		JLabel background = new JLabel(img);
		frame.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));
		//將背景圖的大小設為電腦螢幕的大小
		background.setBounds(0, 0,dimension.width,dimension.height);
	}

}

/*public void run()
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
}*/