package simulate;
import java.util.Date;
import java.util.TimerTask;

import background.Background;
import function.BackgroundManager;
import function.FishManager;

public class BackgroundTask extends TimerTask {
	private static final int perSecond = 1000;
	private Background background; 
	private FishManager fishManager;
	private BackgroundManager backgroundManager;
	private Date date;
	SimulateInterface SI;
	
	public BackgroundTask(Background background,FishManager fishManager, BackgroundManager backgroundManager,
			SimulateInterface SI)
	{
		this.background = background;
		this.backgroundManager = backgroundManager;
		this.fishManager = fishManager;
		this.SI = SI;
		date = new Date();
	}
	
	public BackgroundTask(Background background,FishManager fishManager, BackgroundManager backgroundManager, SimulateInterface SI, Date date)
	{
		this.background = background;
		this.backgroundManager = backgroundManager;
		this.fishManager = fishManager;
		this.date = date;
	}
	@Override
	public void run() {
		int sec = background.getSecond();
		//System.out.println("\n\n");
		//backgroundManager.display();
		//fishManager.printFishes();
		
		//背景資訊改變
		backgroundManager.growingCleanliness(sec);
		backgroundManager.growingOxygenContent(sec);
		backgroundManager.growingpH(sec);
		backgroundManager.growingTemperature(sec);
		//魚資訊改變
		if(fishManager.haveFish())
		{
			fishManager.growingAge(sec);
			fishManager.growingLength(sec);
			fishManager.growingWeight(sec);
			fishManager.growingSatiation(sec);
			fishManager.growingExcretion(sec);
			fishManager.growingLife(sec);
			fishManager.autoFeed(sec);
		}
		SI.setBackgroundInfo();
		
		//時間改變
		long time = date.getTime() + perSecond;
		date.setTime(time);
		background.setDate(date);
		background.setTime(date); 
		background.setSecond(++sec) ; 
	}
}