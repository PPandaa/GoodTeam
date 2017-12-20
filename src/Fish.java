import java.util.Random;

public class Fish {
	public static final int AGE = 1036800;	//12天長一歲
	public static final int SUITABLE_CLEANLINESS = 40;	//最低乾淨度
	public static final int SUITABLE_OXYGENCONTENT = 4;	//最低含氧量
	public static final int MAX_SATIATION = 100;		//飽食度上限
	public static final int MAX_EXCRETION = 100;		//排泄上限
	public static final int MAX_LIFE = 100;				//最大生命上限
	public static final int MIN_LIFE = 50;				//最小生命上限
	public static final int SUITABLE_SATIATION = 80;	//最適飽食度
	public static final int SICK_LIFE = 40;				//生病生命力
	
	public String[] fishCategory = {"紅十字魚","孔雀魚","小丑魚","斑馬魚","麗麗魚",
							"紅劍魚","寶蓮燈魚","紅綠燈魚","三角燈魚","銀屏燈魚",
							"迷你燈魚","紅龍魚","接吻魚","非洲慈鯛","黑尾紅月光"};
	public String[] fishGender = {"雄","雌"};
	Random random = new Random();
	private String name;			//名字
	private final String category;	//魚種
	private final String gender;	//性別
	private final String character;	//性格
	private int age;			//年齡	(非歲數)
	private int realAge;		//實際年齡	(歲數)
	private double length;		//長度
	private double weight;		//重量
	private int satiation; 		//飽食度
	private int excretion; 		//排泄
	private double life;		//生命力
	private double maxLife;		//最大生命力
	private boolean sick;		//生病
	private boolean dead;		//死亡
	private final double suitableMaxTemperature;	//最大適溫
	private final double suitableMinTemperature;	//最小適溫
	private final double suitableMaxpH;			//最大適pH
	private final double suitableMinpH;			//最小適pH
	
	public Fish(String name,int category,int gender,int age)
	{
		//設初始值
		this.name = name;
		this.age = age;
		this.category = fishCategory[category];
		this.gender = fishGender[gender];
		setRealAge();
		setMaxLife();
		//gender = "male";
		this.character = "溫和";
		length = (double)random.nextInt(400) / 100 + 2;   //cm
		weight = (double)random.nextInt(1000) / 100+ 10 ; //g
		satiation = random.nextInt(30) + 60;   //%
		excretion = 0 ; //%
		sick = false;
		life = 100 ;
		suitableMaxTemperature = 28;
		suitableMinTemperature = 20;
		suitableMaxpH = 8.0;
		suitableMinpH = 6.0;
		dead = false;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public String getGender() {
		return gender;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getSatiation() {
		return satiation;
	}

	public void setSatiation(int satiation) {
		this.satiation = satiation;
	}

	public int getExcretion() {
		return excretion;
	}

	public void setExcretion(int excretion) {
		this.excretion = excretion;
	}

	public void setSick(boolean sick) {
		this.sick = sick;
	}
	
	public boolean getSick()
	{
		return sick;
	}

	public double getLife() {
		return life;
	}

	public void setLife(double life) {
		this.life = life;
	}

	public double getSuitableMaxTemperature() {
		return suitableMaxTemperature;
	}
	
	public double getSuitableMinTemperature() {
		return suitableMinTemperature;
	}
	
	public double getSuitableMaxpH() {
		return suitableMaxpH;
	}

	public double getSuitableMinpH() {
		return suitableMinpH;
	}

	public String getCharacter() {
		return character;
	}
	
	public boolean isDead()
	{
		return dead;
	}

	public void setDead(boolean dead)
	{
		this.dead = dead;
	}

	
	public void changeAge(int var)
	{
		age += var;
		setRealAge();
		setMaxLife();
	}
	
	public void changeLength(double var)
	{
		length += var;
	}
	
	public void changeWeight(double var)
	{
		weight += var;
	}

	public void changeSatiation(int var)
	{
		satiation += var;
		if (satiation > MAX_SATIATION)	//飽食度不超過100
			satiation = MAX_SATIATION;
		else if (satiation < 0)			//飽食度不小於0
			satiation = 0;
	}
	
	public void changeLife(double var)
	{
		if (sick && var < 0)life = life + var * 2;	//生病生命力下降兩倍
		else life += var;
		
		if (life > SICK_LIFE)	//生命力 > 40 健康
		{
			sick = false;
			if (life > maxLife)	//不超過最大生命
				life = maxLife;
		}
		else					//生命力 < 40 生病
		{
			sick = true;
			if (life < 0)		//生命力< 0 死亡
			{
				life = 0;
				dead = true;
			}
		}
	}
	
	public boolean changeExcretion(double var)
	{
		excretion += var;
		if (excretion >= MAX_EXCRETION)
		{
			excretion = 0;
			return true;
		}
		return false;
	}
	
	public int getRealAge()
	{
		return realAge;
	}
	
	public void setRealAge()
	{
		realAge = age / AGE;
	}
	
	public double getMaxLife()
	{
		return maxLife;
	}
	
	public void setMaxLife()
	{
	//MAX_LIFE= {100, 90, 80, 70, 60, 50};
		if (realAge == 0)
			maxLife = MAX_LIFE;
		else
		{
			maxLife = MAX_LIFE - (realAge - 1) / 10 * 10;
			if (maxLife < MIN_LIFE)
				maxLife = MIN_LIFE;
		}
	}
	
	public boolean inSuitableTemperature(double var)
	{
		if (var > suitableMaxTemperature || var < suitableMinTemperature)
			return false;
		return true;
	}
	
	public boolean inSuitablepH(double var)
	{
		if (var > suitableMaxpH || var < suitableMinpH)
			return false;
		return true;
	}

	public String isSick() 
	{
		if(sick == true)
			return "有";
		else
			return "否";
	}
	
	public boolean isStarving()
	{
		if (satiation == 0)
			return true;
		return false;
	}
	
	@Override
	public String toString(){
		if (dead == true)
			return ("姓名:"+ getName() +" 死亡");
		return String.format("姓名:%s    魚種:%s    年齡:%d歲        性別:%s\n"
						   + "飽食度:%d%c    長度:%.5fcm    重量:%.5fg    排泄:%d%c\n"
						   + "有無生病:%s    生命力:%.0f",
				getName(),getCategory(),getRealAge(),getGender(),getSatiation(),37,getLength(),getWeight(),getExcretion(),37,isSick(),getLife());
	}
}
