import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Container.*;
import java.util.*;
import java.util.Timer;

public class FishStore {
	public static final int MAX_FISH = 15;
	private ArrayList<Fish> fishes;
	private Background background;
	Scanner input = new Scanner(System.in);
	public FishStore(Background bg, ArrayList<Fish> fishes)
	{
		this.background = bg;
		this.fishes = fishes;
	}
	public void addFish()
	{
		if(fishes.size() <= MAX_FISH)
		{
			//String a = input.nextLine();
			System.out.println("輸入魚的名字");
			String name = input.nextLine();
			System.out.println("輸入魚的種類");
			System.out.println("提供以下幾種:\n"
							+ " 0.紅十字魚    1.孔雀魚       2.小丑魚        3.斑馬魚        4.麗麗魚\n"
							+ " 5.紅劍魚        6.寶蓮燈魚   7.紅綠燈魚    8.三角燈魚    9.銀屏燈魚\n"
							+ "10.迷你燈魚  11.紅龍魚    12.接吻魚     13.非洲慈鯛  14.黑尾紅月光");
			int category = input.nextInt();
			System.out.println("輸入魚的性別\n"
							 + "0.雄    1.雌");
			int gender = input.nextInt();
			System.out.println("輸入魚的年齡");
			int age = input.nextInt();
			input.nextLine();
			Fish fish = new Fish(name,category,gender,age);
			fishes.add(fish);
		}
		else
		{
			System.out.println("水族箱已滿");
		}
	}

}
