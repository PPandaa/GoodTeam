package fishStore;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import fish.Fish;
import fish.FishButton;
import simulate.SimulateInterface;

public class FishStore extends JPanel {
	public FishButton fishButton;
	
	//抓電腦螢幕
	private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	
	//JPanel SI;
	
	
	public JButton back;
	public FishStore(JFrame frame,ArrayList<FishButton> fishs,SimulateInterface SI){
		setLayout(null);
		//抓title按鈕，並且設置大小
		ImageIcon titleIcon = new ImageIcon(getClass().getResource("title.PNG"));
		titleIcon.setImage(titleIcon.getImage().getScaledInstance(600,150,Image.SCALE_DEFAULT));
		//抓back按鈕，並且設置大小
		ImageIcon backIcon = new ImageIcon(getClass().getResource("back.PNG"));
		backIcon.setImage(backIcon.getImage().getScaledInstance(371,168,Image.SCALE_DEFAULT));
		//抓in按鈕，並且設置大小
		ImageIcon inIcon = new ImageIcon(getClass().getResource("in.PNG"));
		inIcon.setImage(inIcon.getImage().getScaledInstance(200,100,Image.SCALE_DEFAULT));
		
		//新增Label及Button，並且將圖片塞入
		JLabel title = new JLabel(titleIcon);
		JLabel name = new JLabel("名字");
		name.setFont(new Font("標楷體", Font.BOLD, 35));
		JLabel fishC = new JLabel("魚種");
		fishC.setFont(new Font("標楷體", Font.BOLD, 35));
		JLabel fishG = new JLabel("性別");
		fishG.setFont(new Font("標楷體", Font.BOLD, 35));
		JLabel fishA = new JLabel("年齡");
		fishA.setFont(new Font("標楷體", Font.BOLD, 35));
		JTextField typeName = new JTextField("");
		typeName.setFont(new Font("標楷體", Font.BOLD, 35));
		typeName.setBackground(Color.lightGray);
		
		String[] fishList = {"紅十字魚","孔雀魚","小丑魚","斑馬魚","麗麗魚","紅劍魚","紅龍魚","紅綠燈魚","三角燈魚","銀屏燈魚","迷你燈魚","寶蓮燈魚","接吻魚","非洲慈鯛","黑尾紅月光"};
		String[] fishGender = {"雄","雌"};
		String[] ages = {"1","2","3","4","5","6","7","8","9","10"};
		JComboBox fishCList = new JComboBox(fishList) ;
		fishCList.setFont(new Font("標楷體", Font.BOLD, 35));
		fishCList.setBackground(Color.lightGray);
		JComboBox fishGList = new JComboBox(fishGender) ;
		fishGList.setFont(new Font("標楷體", Font.BOLD, 35));
		fishGList.setBackground(Color.lightGray);
		JComboBox typeAge = new JComboBox(ages);
		typeAge.setFont(new Font("標楷體", Font.BOLD, 35));
		typeAge.setBackground(Color.lightGray);
		back = new JButton(backIcon);
		JButton in = new JButton(inIcon);
		in.addMouseListener(
				new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent event) {
						String fishName = typeName.getText();
						String fishCategory = fishCList.getSelectedItem().toString();
						String fishGender = fishGList.getSelectedItem().toString();
						String fishAge = typeAge.getSelectedItem().toString();
						
						fishButton = new FishButton(fishName,fishCategory,fishGender,fishAge,SI);

						SI.add(fishButton);
						fishs.add(fishButton);
					}
				}
				
			);
		back.setBorder(null);//不繪製按鈕的邊
		back.setContentAreaFilled(false);//不會自行繪製按鈕背景
		in.setBorder(null);//不繪製按鈕的邊
		in.setContentAreaFilled(false);//不會自行繪製按鈕背景
		JTextField textArea = new JTextField("");
		textArea.setEditable(false);
		textArea.setBackground(Color.LIGHT_GRAY);
		
		//設定位置
		back.setBounds(0,0,371,168);
		title.setBounds(500,0,600,150);
		name.setBounds(200,80,200,100);
		fishC.setBounds(200,180,200,100);
		fishG.setBounds(200,280,200,100);
		fishA.setBounds(200,380,200,100);
		typeName.setBounds(330, 105, 270, 50);
		fishCList.setBounds(330, 205, 270, 50);
		fishGList.setBounds(330, 305, 270, 50);
		typeAge.setBounds(330, 405, 270, 50);
		textArea.setBounds(700, 105, 600, 460);
		in.setBounds(350, 480, 200, 100);
		
		//this.setBackground(frame); //調用背景方法
		this.setOpaque(false);
		
		//TOP
		JPanel TOP = new JPanel(); //創建個JPanel
		TOP.setBounds(0, 0, dimension.width, 200);
		TOP.setLayout(null);
		TOP.setOpaque(false); //把JPanel設置為透明 這樣就不會遮住後面的背景 這樣你就能在JPanel隨意加元件了
		//將Label及Button放入Panel中
		TOP.add(back);
		TOP.add(title);
		//將Panel放入視窗中
		this.add(TOP);
		
		//middle
		JPanel middle = new JPanel(); //創建個JPanel
		middle.setBounds(0, 200, dimension.width, dimension.height);
		middle.setLayout(null);
		middle.setOpaque(false); //把JPanel設置為透明 這樣就不會遮住後面的背景 這樣你就能在JPanel隨意加元件了
		
		//將Label及Button放入Panel中
		middle.add(name);
		middle.add(fishC);
		middle.add(fishCList);
		middle.add(fishG);
		middle.add(fishGList);
		middle.add(fishA);
		middle.add(typeName);
		middle.add(typeAge);
		middle.add(textArea);
		middle.add(in);
		
		//將Panel放入視窗中
		add(middle);
	}
	
	
}

