import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.awt.Container.*;
import java.util.*;
import java.util.Timer;

public class Test {
	public static void main(String args[])
	{
		/*HomePage hp = new HomePage();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		hp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hp.setSize(screenSize.width, screenSize.height);
		hp.setVisible(true);*/
		//Calendar calendar = Calendar.getInstance();
		//calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND)+5);
		//Date firstTime = calendar.getTime();
		//Timer timer = new Timer();
		//timer.schedule(new timeTask(),new Date(), 1000);
		HomePage HP = new HomePage();
		HP.run();
	}
}