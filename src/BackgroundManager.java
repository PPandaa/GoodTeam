/*
按鈕：
              
       打氣：依溫度決定含氧量上升到最大值如下，速度為每小時+0.2ppm
       0-10度：11ppm     11-20：9ppm     21-30：7ppm    31-40：6ppm
       調溫器：隨時間趨向設定之溫度，趨近速度為每秒0.001度
       過濾機：乾淨度緩慢上升趨近90%，速度為每秒+0.01%，
                       ph值趨近於7.0，每秒0.01
*/

public class BackgroundManager
{
	private static final double SEASON_APPROACHING_TEMPERATURE = 0.06; // 溫度 隨 季節 的趨近速度 //每分鐘0.1
	private static final double THERMOSTAT_APPROACHING_TEMPERATURE = 0.001; // 溫度 隨 調溫器 的趨近速度 //每秒鐘0.001
	private static final double INFLATOR_APPROACHING_OXYGENCONTENT = 0.000056; // 含氧量 隨 打氣機 的趨近速度 //每小時0.2
	private static final double PUMP_APPROACHING_CLEANLINESS = 0.01; // 乾淨度 隨 過濾機 的趨近速度 //每秒鐘0.01
	private static final double PUMP_APPROACHING_PH = 0.01; // pH 隨 過濾機 的趨近速度 //每秒鐘0.01
	private static final double PUMP_MAX_CLEANLINESS = 90; // 過濾機的最高乾淨度
	private static final double PUMP_MAX_PH = 7.0; // 過濾機的標準pH值
	private Background background;

	public boolean inflatorBtn; // 打氣機按鈕
	public boolean thermostatBtn;// 調溫器按鈕
	public boolean pumpBtn; // 幫浦按鈕

	public BackgroundManager(Background background)
	{
		this.background = background;
	}

	/**
	 * 按下打氣機按鈕
	 */
	public void pressInflatorBtn()
	{
		if (inflatorBtn)
		{
			inflatorBtn = false;
			System.out.println("打氣機關閉");
		}
		else
		{
			inflatorBtn = true;
			System.out.println("打氣機開啟");
		}
	}

	/**
	 * 按下調溫器按鈕
	 */
	public void pressThermostatBtn()
	{
		if (thermostatBtn)
		{
			thermostatBtn = false;
			System.out.println("調溫器關閉");
		}
		else
		{
			thermostatBtn = true;
			System.out.println("調溫器開啟");
		}
	}

	/**
	 * 按下幫浦按鈕
	 */
	public void pressPumpBtn()
	{
		if (pumpBtn)
		{
			pumpBtn = false;
			System.out.println("幫浦關閉");
		}
		else
		{
			pumpBtn = true;
			System.out.println("幫浦開啟");
		}
	}

	/**
	 * 溫度：趨近季節的溫度，隨時間每分鐘趨近0.1度。SEASON_APPROACHING_TEMPERATURE 春20 夏25 秋20 冬15
	 * 
	 * @param sec
	 */
	public void growingTemperature(int sec)
	{
		if (thermostatBtn)
		{
			background.changeTemperature(THERMOSTAT_APPROACHING_TEMPERATURE);
		}//----------------------------------------------------------------------------------------//
		else
		{
			double currentTemperature = background.getTemperature();

			if (currentTemperature > background.getSeason().getTem())
			// 溫度大於季節溫度
			{
				background.changeTemperature(-1 * SEASON_APPROACHING_TEMPERATURE);
			}
			// 溫度小於季節溫度
			else if (currentTemperature < background.getSeason().getTem())
			{
				background.setTemperature(SEASON_APPROACHING_TEMPERATURE);
			}
		}
	}

	// public void growingpH(int sec)
	// {
	// }

	public void growingOxygenContent(int sec, boolean inflatorBtn, boolean pumpBtn)
	{
		// if (oxygenContent > 0 && sec % 5 == 0)
		// {
		// if (inflatorBtn)
		// {
		// if (oxygenContent < 80)
		// oxygenContent += 0.01;
		// }
		// else if (pumpBtn)
		// {
		// oxygenContent-= 0.02;
		// }
		// else
		// {
		// oxygenContent -= 0.04;
		// }
		// }
		// if (oxygenContent < 0)
		// oxygenContent = 0;
	}

	public void growingCleanliness(int sec, boolean pumpBtn)
	{
		// if (cleanliness > 0 && sec % 5 == 0)
		// {
		// if (pumpBtn)
		// {
		// cleanliness -= 0.1;
		// }
		// else
		// {
		// cleanliness -= 0.3;
		// }
		// }
		// if (cleanliness < 0)
		// cleanliness = 0;
	}

	/**
	 * 換水：直接將乾淨度設為100%，含氧量依溫度給予預設值如下，ph值設為7.0。 含氧量： 0-10度：11ppm , 11-20：9ppm ,
	 * 21-30：7ppm , 31-40：6ppm
	 */
	public void changeWater()
	{
		background.setDefaultBackground();
	}
}
