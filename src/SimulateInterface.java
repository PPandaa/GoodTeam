import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;

public class SimulateInterface
{
	public static final int LOW_SATIATION = 20;

	public static final int EXIT = -1;

	private Background background;
	private BackgroundTask backgroundTask;
	private BackgroundManager backgroundManager;
	private FishManager fishManager;
	private Setting setting;
	private FishStore fishStore;

	// public boolean autoFeedBtn; //自動餵魚按鈕
	// public boolean thermostatBtn;//調溫器按鈕
	// public boolean inflatorBtn; //打氣機按鈕
	// public boolean pumpBtn; //幫浦按鈕

	private ArrayList<Fish> fishes;

	private int input;
	private int inputSetting;
	private Timer timer;
	private Scanner scanner;

	public SimulateInterface()
	{

		// 初始化背景
		background = new Background();
		// 初始化魚
		fishes = new ArrayList<Fish>();
		Fish a = new Fish("1", 1, 1, 0);
		Fish b = new Fish("2", 2, 0, 1);
		Fish c = new Fish("3", 3, 1, 2);
		Fish d = new Fish("4", 4, 0, 3);
		fishes.add(a);
		fishes.add(b);
		fishes.add(c);
		fishes.add(d);
		fishStore = new FishStore(fishes);
		// 初始化操作介面
		fishManager = new FishManager(fishes, background);
		backgroundManager = new BackgroundManager(background, fishManager);
		// 初始化設定
		setting = new Setting(background);
		// 初始化Timer、背景任務
		backgroundTask = new BackgroundTask(background, fishManager, backgroundManager);
		timer = new Timer();
		timer.schedule(backgroundTask, new Date(), 1000);
		// timer.schedule(new backgroundTask(),new Date(),1000);
		// timer.schedule(backgroundTask,new Date(),setting.speedUp());

		scanner = new Scanner(System.in);
	}

	public int run()
	{
		input = 1;
		inputSetting = 0;
		while (input != EXIT)
		{
			System.out.println("1.印背景資訊      2.印魚種資訊      3.新增魚類      4.使用設定功能\n"
					+ "5.餵食      6.自動餵食      7.換水      8.打氣機      9.幫浦\n" + "10.調溫器      11.說明      -1.結束");
			input = scanner.nextInt();
			switch (input)
			{
			case 1: // 1.印背景資訊
				backgroundManager.display();
				break;
			case 2: // 2.印魚種資訊
				fishManager.printFishes();
				break;
			case 3: // 3.新增魚類
				fishStore.addFish();
				break;
			case 4: // 4.使用設定功能
				setting.runSetting(backgroundTask, background, fishManager, backgroundManager, timer);
				break;
			case 5: // 5.餵食
				fishManager.feed();
				break;
			case 6: // 6.自動餵食
				fishManager.pressAutoFeedBtn();
				break;
			case 7: // 7.換水
				// 使用者點擊此按鈕重置水質，溫度回到26，pH值7.0，乾淨度90%，含氧量8ppm
				backgroundManager.changeWater();
				break;
			case 8: // 8.打氣機
				// 使用者開啟使功能時，將提高水含氧量至8.0ppm
				backgroundManager.pressInflatorBtn();
				break;
			case 9: // 9.幫浦
				// 使用者開啟此功能時，系統將調整水乾淨度的改變速率，以及魚缸含氧量的改變速率
				backgroundManager.pressPumpBtn();
				break;
			case 10: // 10.調溫器
				// 使用者開啟此功能時，系統將依照使用者設定之溫度調節魚缸溫度
				backgroundManager.pressThermostatBtn();
				break;
			case 11: // 11.說明
				Instruction.getInstruction();
				break;
			case -1: // -1.結束
				return -1;
			default:
				System.out.println("Try again!");
				break;
			}
		}
		return inputSetting;
	}
}
