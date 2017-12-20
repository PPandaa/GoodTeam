import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
   魚：
         魚種衝突：紅十字、非洲慈鯛會攻擊其他所有魚種，若此兩種養在一起，體重大
                            者會攻擊體重小者，被攻擊者生命力每秒下降1-3
*/
public class FishManager
{
	private static final double FTM_CLEANLINESS = -2; // 餵太多改變的乾淨度
	private static final double FTM_PHVALUE = 0.1; // 餵太多改變的pH值
	private static final int ONETIME_FEED = 5;	//餵魚一次飽食度增加值
	private static final double EXCRETION_PH = 0.02;	//排泄使pH上升的值
	private static final double EXCRETION_RISE = 1;	//排泄度上升的值
	private Random random;
	private Scanner scanner;
	private ArrayList<Fish> fishes;
	private Background background;
	private int autoFeedTime;	//自動餵食時間(sec)
	private boolean autoFeedBtn; // 自動餵魚按鈕

	public FishManager(ArrayList<Fish> fishes, Background background)
	{
		this.random = new Random();
		this.fishes = fishes;
		this.background = background;
		autoFeedTime = 0;
		scanner = new Scanner(System.in);
	}

	/**
	 * 餵食一次：每一隻魚飽食度+5，滿是100 若餵食過多(每一隻魚飽食度皆100)，多一次餵食，ph值上升0.1， 乾淨度下降2%
	 */
	public void feed()
	{
		boolean feedTooMuch = true;
		for (int i = 0; i < fishes.size(); i++)
		{
			if (!fishes.get(i).isDead() && fishes.get(i).getSatiation() < Fish.MAX_SATIATION)
			{
				// 每條魚飽食度上升5
				fishes.get(i).changeSatiation(ONETIME_FEED);
				// 若每條魚的飽食度皆為100, 則 feedTooMuch = true
				feedTooMuch = false;
			}
		}
		if (feedTooMuch) // 乾淨度下降2%, pH值上升0.1
		{
			background.changeCleanliness(FTM_CLEANLINESS);
			background.changepHValue(FTM_PHVALUE);
		}
	}

	/**
	 * 按下自動餵食按鈕
	 */
	public void pressAutoFeedBtn()
	{
		if (autoFeedBtn)
		{
			autoFeedBtn = false;
			System.out.println("自動餵食關閉");
		}
		else
		{
			autoFeedBtn = true;
			System.out.println("自動餵食開啟");
			System.out.println("輸入自動餵食時間：");
			autoFeedTime = scanner.nextInt();
		}
	}
	/**
	 * 自動餵食：可於設定中設定每多少分鐘餵食一次(飽食度變化同上)，可主動關閉
	 * 
	 * @param autoFeedBtn
	 */
	public void autoFeed(int sec)
	{
		if (autoFeedBtn)
		{
//			for (int i = 0; i < fishes.size(); i++)
//			{
//				if (fishes.get(i).getSatiation() < SimulateInterface.LOW_SATIATION)
//				{
//					feed();
//					break;
//				}
//			}
			if (sec % autoFeedTime == 0)
			{
				feed();
			}
		}
	}

	/**
	 * 年齡：每12天增加一歲
	 * 
	 * @param sec
	 */
	public void growingAge(int sec) // 時間
	{
		if (sec % 1 == 0) // 每秒鐘
		{
			for (int i = 0; i < fishes.size(); i++)
			{
				if (!fishes.get(i).isDead())
					fishes.get(i).changeAge(1);
			}
		}
	}

	/**
	 * 長度：每秒增加0.001-0.003公分
	 * 
	 * @param sec
	 */
	public void growingLength(int sec) // 時間
	{
		if (sec % 1 == 0) // 每秒鐘
		{
			for (int i = 0; i < fishes.size(); i++)
			{
				if (!fishes.get(i).isDead())
					fishes.get(i).changeLength((random.nextDouble() * 2 + 1) / 1000);
			}
		}
	}

	/**
	 * 重量；每秒增加0.001-0.005g
	 * 
	 * @param sec
	 */
	public void growingWeight(int sec) // 時間
	{
		if (sec % 1 == 0) // 每秒鐘
		{
			for (int i = 0; i < fishes.size(); i++)
			{
				if (!fishes.get(i).isDead())
					fishes.get(i).changeWeight((random.nextDouble() * 4 + 1) / 1000);
			}
		}
	}

	/**
	 * 飽食度：隨時間飽食度每分鐘下降1
	 * 
	 * @param sec
	 */
	public void growingSatiation(int sec) // 時間
	{
		if (sec % 60 == 0) // 每分鐘
		{
			for (int i = 0; i < fishes.size(); i++)
			{
				if (!fishes.get(i).isDead())
					fishes.get(i).changeSatiation(-1);
			}
		}
	}

	/**
	 * 生命力：依年齡決定生命力最高值如下，若溫度不在適溫內、不在適合ph值中、乾淨度低於40%、含氧量低於4ppm、飽食度為0，
	 * 其一成立則生命力下降速率，每秒下降1，若兩者成立速率為2，依此類推，若低於40則會生病。 生病：生命力下降速率為平常的兩倍，
	 * 飽食度高於80且環境為適溫、適ph、適乾淨度、適含氧量則每秒生命力增加0.5，最高增至為生命力上限。 生命力上限0-10歲->100 ,
	 * 11-20歲->90 , 21-30歲->80 , 31-40歲->70 , 41-50歲->60 , 50以上->50
	 * 
	 * @param sec
	 */
	public void growingLife(int sec)
	{
		double var;
		if (sec % 1 == 0)	//每秒鐘
		{
			for (int i = 0; i < fishes.size(); i++)
			{
				if (!fishes.get(i).isDead())
				{
					var = 0;
					// 是否在適溫內
					if (!fishes.get(i).inSuitableTemperature(background.getTemperature()))
						var -= 1;
					// 是否在適pH內
					if (!fishes.get(i).inSuitablepH(background.getpHValue()))
						var -= 1;
					// 是否在適乾淨度內
					if (background.getCleanliness() < Fish.SUITABLE_CLEANLINESS)
						var -= 1;
					// 是否在適含氧量內
					if (background.getOxygenContent() < Fish.SUITABLE_OXYGENCONTENT)
						var -= 1;
					// 是否挨餓中
					if (fishes.get(i).isStarving())
						var -= 1;
					// 若以上皆符合，且飽食度大於80則生命力每秒上升0.5
					if (var == 0 && fishes.get(i).getSatiation() > Fish.SUITABLE_SATIATION)
						var = 0.5;
					fishes.get(i).changeLife(var);
				}
			}
		}
	}
	//----------------------------------------------------------------------
	/**			//10秒1%
	 * 排泄：飽食度非 0% 時隨時間每秒增加 0.5% ， 100% 時排泄，造成 pH值上升0.02，排泄完歸零
	 * @param sec
	 */
	public void growingExcretion(int sec)
	{
		if (sec % 10 == 0)
//		if (sec % 2 == 0)
		{
			for (int i = 0; i < fishes.size(); i++)
			{
				if (!fishes.get(i).isDead())
				{
					if (fishes.get(i).changeExcretion(EXCRETION_RISE))
						background.changepHValue(EXCRETION_PH);
				}
			}
		}
	}

	/**
	 * 印出魚缸所有魚
	 */
	public void printFishes()
	{
		if (!haveFish())
			System.out.println("水族箱並沒有魚種\n");
		else
			for (int i = 0; i < fishes.size(); i++)
			{
				System.out.printf("魚%d\n", i);
				System.out.println(fishes.get(i));
			}
	}

	/**
	 * 判斷魚缸內是否有魚
	 */
	public boolean haveFish()
	{
		if (fishes.size() > 0)
			return true;
		return false;
	}
	
	public int getFishNum()
	{
		return fishes.size();
	}
}
