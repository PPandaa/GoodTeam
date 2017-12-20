import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Container.*;
import java.util.*;
import java.util.Timer;

public class Setting {
	Scanner scanner = new Scanner(System.in);
	public Setting(Background bg)
	{
	}
	
	public int runSetting(BackgroundTask backgroundTask, Background background, FishManager fishManager, Timer timer)
	{
		int input;
		System.out.println("1.回到主畫面\n2.加速\n-1.離開設定");
		input = scanner.nextInt();
		while(input!=-1)
		{
			if(input == 1)
			{
				input = -1;
				break;
			}
			if(input == 2)
			{
				backgroundTask.cancel();
				backgroundTask = new BackgroundTask(background, fishManager);
				timer.schedule(backgroundTask,new Date(),speedUp());
			}
			System.out.println("1.回到主畫面\n2.加速\n-1.離開設定");
			input = scanner.nextInt();
		}
		return input;
	}
	public int speedUp()
	{
		int speed = 1000;
		System.out.println("輸入欲增加倍數");
		speed = (int)(speed / scanner.nextInt());
		return speed;
	}
}