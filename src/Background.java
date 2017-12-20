import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.awt.Container.*;
import java.util.*;

public class Background {

	public static final double DEFAULT_TEMPERATURE	= 26;
	public static final double DEFAULT_PH	= 7;
	public static final double DEFAULT_CLEANLINESS = 90;
	public static final double DEFAULT_OXYGENCONTENT = 80;
	
	private double temperature;
	private double pHValue;
	private double oxygenContent;  //含氧量
	private double cleanliness;
	private Date date;
	private Date time;
	private String month_string;
	private int month_int;
	private int second=0;
	private int speed = 1000;
	private Season season;
	
	public Background()
	{
		setDefaultBackground();
		date = new Date();
		time = new Date();
		month_string = String.format("%tD%n",date);
		month_int = 10*Integer.parseInt(String.valueOf(month_string.charAt(0)))+
				Integer.parseInt(String.valueOf(month_string.charAt(1)));
		season = new Season(month_int);
		setDate(date);
	}
	
	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
	
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getpHValue() {
		return pHValue;
	}

	public void setpHValue(double pHValue) {
		this.pHValue = pHValue;
	}

	public double getOxygenContent() {
		return oxygenContent;
	}

	public void setOxygenContent(double oxygenContent) {
		this.oxygenContent = oxygenContent;
	}

	public double getCleanliness() {
		return cleanliness;
	}

	public void setCleanliness(double cleanliness) {
		this.cleanliness = cleanliness;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
		month_string = String.format("%tD%n",date);
		month_int = 10*Integer.parseInt(String.valueOf(month_string.charAt(0)))+
				Integer.parseInt(String.valueOf(month_string.charAt(1)));
		season.setSeason(month_int);
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	public Season getSeason() {
		return season;
	}
	
	public void setSeason(Season season) {
		this.season = season;
	}
	
	public void setDefaultBackground()
	{
		setTemperature(DEFAULT_TEMPERATURE);
		setpHValue(DEFAULT_PH);
		setCleanliness(DEFAULT_CLEANLINESS);
		setOxygenContent(DEFAULT_OXYGENCONTENT);
	}
	
	public void changeTemperature(double var)
	{
		temperature += var;
	}
	
	public void changepHValue(double var)
	{
		pHValue += var;
	}
	
	public void changeOxygenContent(double var)
	{
		oxygenContent += var;
	}
	
	public void changeCleanliness(double var)
	{
		cleanliness += var;
	}
	
	@Override
	public String toString(){
		return String.format("溫度:%.1f°C pH值:%.1f 含氧量:%.1fPPM 乾淨度:%.1f%c  季節:%s 日期:%tF%n 時間:%tT%n \n",
				getTemperature(),getpHValue(),getOxygenContent(),getCleanliness(),37,season.getName(),getDate(),getTime());
	}
}
