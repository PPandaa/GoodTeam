import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

public class BackgroundTask extends TimerTask {
	private Background background; 
//	private SimulateInterface simulateInterface;
	private FishManager fishManager;
	private Date date;
	
	public BackgroundTask(Background bg,FishManager fishManager)
	{
		background = bg;
//		simulateInterface = SI;
		date = new Date();
		this.fishManager = fishManager;
	}
	
	public void display()
	{
		System.out.print(background);
	}
	
	@Override
	public void run() {
		int sec = background.getSecond();
//		background.changeTem(background.getSecond());
		//background.changepH(background.getSecond());
		//fishes = simulateInterface.getFish();
		if(fishManager.haveFish())
		{
			fishManager.growingAge(sec);
			fishManager.growingLength(sec);
//			fishManager.growingLife(sec);
			fishManager.growingSatiation(sec);
//			for(int i = 0; i < fishes.size();i++)
//			{
//				fishes.get(i).changeLength(background.getSecond());
//				fishes.get(i).changeWeight(background.getSecond());
//				fishes.get(i).changeSatiation(background.getSecond());
//				fishes.get(i).changeLife(background.getSecond());
//			}
		}
		//simulateInterface.autoFeed();
//		background.changeOxygenContent(background.getSecond(), simulateInterface.inflatorBtn, simulateInterface.pumpBtn);
//		background.changeCleanliness(background.getSecond(), simulateInterface.pumpBtn);
		
		
		long time = date.getTime();
//		System.out.println(time);
		time +=1000;
		date.setTime(time);
		background.setDate(date);
		background.setTime(date); 
		//System.out.println(background.getSecond());
//		System.out.println(sec);
		sec++;
		background.setSecond(sec) ; 
	}
}