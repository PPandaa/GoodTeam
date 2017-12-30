package function;
import javax.swing.JFrame;

import simulate.SimulateInterface;

import javax.swing.JButton;

import java.awt.Container;
import java.awt.event.*;

import java.util.Timer;
import java.util.TimerTask;

public class moveButton extends JFrame {
    public JButton btn;//fish按鈕
    public final int btnSideLen = 60;
    
    public double btnX;//fish的X軸的位置
    public double btnY;//fish的Y軸的位置
    public double vx;//X軸一次的偏移量
    public double vy;//Y軸一次的偏移量
    Timer timer = new Timer();
    RunningButton RB;
    
    private int focusx = 0;  
    private int focusy = 0;
    
    boolean state = false;//true是有timer、false是沒有timer

    public moveButton() {
        this.setTitle("A6");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650, 750);
        this.setResizable(false);
        this.setLayout(null);

        btnX = getWidth() / 2.0;
        btnY = getHeight() / 2.0;
        vx = Math.sin(1) * 5;
        vy = Math.cos(1) * 5;
        btn = new JButton("Test");
        btn.setBounds((int) btnX, (int) btnY, btnSideLen, btnSideLen);
        btn.setToolTipText("<html>名字:<br>魚種:<br>年齡:<br>性別:<br>飽食度:<br>"
				+ "長度:<br>重量:<br>排泄:<br>有無生病:<br>生命力:</html>");

       /* btn.addMouseListener(new MouseAdapter() {
        	@Override
            public void mouseClicked(MouseEvent event) {
        		
        		if(state == true)
        		{
        			RB.cancel();
        			state = false;
        		}
        		else {
        			RB = new RunningButton();
        			timer.schedule(RB, 0, 200);
                    double theta = Math.random() * 2 * Math.PI;
                    vx = Math.sin(theta) * 5;
                    vy = Math.cos(theta) * 5;
                    state = true;
        		}
        			
            }
        });*/
        btn.addMouseListener(new MouseAdapter() {
        	@Override
            public void mousePressed(MouseEvent event) {
        		focusx = event.getX();  
                focusy = event.getY(); 
            }
        });
        btn.addMouseMotionListener(
    			new MouseMotionAdapter() {
    				@Override
    				public void mouseDragged(MouseEvent event) {
    					Container container = btn.getParent();  
    		            int w = container.getWidth();
    		            int h = container.getHeight();  
    		  
    		            btnX = btn.getX() + event.getX() - focusx;  
    		            btnY = btn.getY() + event.getY() - focusy;  
    		  
    		            if (btnX + btn.getWidth() > w) {  
    		            	btnX = w - btn.getWidth();  
    		            }  
    		            if (btnY + btn.getHeight() > h) {  
    		            	btnY = h - btn.getHeight();  
    		            }  
    		            if (btnX < 0) {  
    		            	btnX = 0;  
    		            }  
    		            if (btnY < 0) {  
    		            	btnY = 0;  
    		            }  
    		  
    		            btn.setLocation((int)btnX, (int)btnY);  
    		            //jButton1.setLocation(x, y + jButton1.getHeight());  
    		            container.repaint();  
    		            container = null;  
    				}
    			}
    		);
        btn.addMouseListener(new MouseAdapter() {
        	@Override
            public void mouseEntered(MouseEvent event) {
    			RB.cancel();
    			state = false;       
            }
        });
        btn.addMouseListener(new MouseAdapter() {
        	@Override
            public void mouseExited(MouseEvent event) {

    			RB = new RunningButton();
    			timer.schedule(RB, 0, 200);
                double theta = Math.random() * 2 * Math.PI;
                vx = Math.sin(theta) * 5;
                vy = Math.cos(theta) * 5;
                state = true;
                
            }
        });

        this.add(btn);
        this.setVisible(true);
        RB = new RunningButton();
        timer.schedule(RB, 1000, 200);
    }

    class RunningButton extends TimerTask {
        public void run() {
            boolean crash = false;
            if (btnX + vx < 0) {
                vx = -vx;
                crash = true;
            }
            if (btnX + vx + btnSideLen >= getWidth()) {
                vx = -vx;
                crash = true;
            }
            if (btnY + vy < 0) {
                vy = -vy;
                crash = true;
            }
            if (btnY + vy + btnSideLen >= getHeight()) {
                vy = -vy;
                crash = true;
            }
            if (crash) {
                //crashTimes++;
                //btn.setText("" + crashTimes);
            }
            btnX += vx;
            btnY += vy;
            btn.setBounds((int) btnX, (int) btnY, btnSideLen, btnSideLen);
            // repaint();
        }
    }

    public static void main(String[] args) {
        new moveButton();
    }
}