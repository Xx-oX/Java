package project;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.imageio.*;

public class MainWindow {
	public static int index = 0;
	public static BufferedImage result;
	public static Image img_worst = null;
	public static Image img_cap = null;
	public static Image img_asian = null;
	public static Image img_drake = null;
	public static Image img_p = null;
	public static Image img_bg = null;
	
	public static void main(String[] args) {
		//set main frame
		JFrame frame = new JFrame("Start");
		frame.setSize(800, 900);
		frame.setDefaultLookAndFeelDecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame mainframe = new JFrame("梗圖產生器");
		mainframe.setSize(800, 600);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setDefaultLookAndFeelDecorated(true);
		mainframe.setVisible(false);
		//set button
		frame.setLayout(null);
		mainframe.setLayout(null);
		//frame.getContentPane().setBackground(new Color(40, 200, 240));
		JButton startbutton = new JButton("開始");
		startbutton.setFont(new Font("微軟正黑體",Font.PLAIN,20));
		startbutton.setBounds(300,620,200,40);
		
		//get img
		try {
			File sourceimg1 = new File("./img/這就對了.jpg");
			img_drake = ImageIO.read(sourceimg1);
			File sourceimg2 = new File("./img/亞洲人之恥.jpg");
			img_asian = ImageIO.read(sourceimg2);
			File sourceimg3 = new File("./img/美國隊長.jpg");
			img_cap = ImageIO.read(sourceimg3);
			File sourceimg4 = new File("./img/我就爛.jpg");
			img_worst = ImageIO.read(sourceimg4);
			File sourceimg5 = new File("./img/pornhub.png");
			img_p = ImageIO.read(sourceimg5);
			File sourceimg6 = new File("./img/bg.jpg");
			img_bg = ImageIO.read(sourceimg6);
		}catch(IOException e) {
			System.out.println("failed to read!");
		}finally {
			
		}
		
		img_bg = img_bg.getScaledInstance(800, 900, java.awt.Image.SCALE_SMOOTH);
		JLabel bg = new JLabel(new ImageIcon(img_bg));
		bg.setBounds(0, 0, 800, 900);
		//frame.add(bg);
		bg.setOpaque(false);
		bg.setLayout(null);
		frame.getLayeredPane().add(bg, 0);		
		img_p = img_p.getScaledInstance(100, 25, java.awt.Image.SCALE_SMOOTH);
		JLabel p = new JLabel(new ImageIcon(img_p));
		p.setBounds(0, 0, 100, 25);
		//frame.add(p);
		frame.getLayeredPane().add(p, 1);		
		
		JLabel tittle = new JLabel("梗圖產生器");
		tittle.setBounds(200, 150, 400, 100);
		tittle.setFont(new Font("微軟正黑體",Font.BOLD,80));
		frame.add(tittle);
		
		
		//set img
		img_drake = img_drake.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH);
		ImageIcon icon_drake = new ImageIcon(img_drake);
		JButton btn_drake = new JButton(icon_drake);
		btn_drake.setBounds(10, 10, 400, 400);
		btn_drake.setVisible(false);
		mainframe.add(btn_drake);
		
		img_asian = img_asian.getScaledInstance(400, 530, java.awt.Image.SCALE_SMOOTH);
		ImageIcon icon_asian = new ImageIcon(img_asian);
		JButton btn_asian = new JButton(icon_asian);
		btn_asian.setBounds(10, 10, 400, 530);
		btn_asian.setVisible(false);
		mainframe.add(btn_asian);
		
		img_cap = img_cap.getScaledInstance(400, 500, java.awt.Image.SCALE_SMOOTH);
		ImageIcon icon_cap = new ImageIcon(img_cap);
		JButton btn_cap = new JButton(icon_cap);
		btn_cap.setBounds(10, 10, 400, 500);
		btn_cap.setVisible(false);
		mainframe.add(btn_cap);
		
		img_worst = img_worst.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH);
		ImageIcon icon_worst = new ImageIcon(img_worst);
		JButton btn_worst = new JButton(icon_worst);
		btn_worst.setBounds(10, 10, 400, 400);
		btn_worst.setVisible(false);
		mainframe.add(btn_worst);
		
		//frame.add(startbutton);
		frame.getLayeredPane().add(startbutton, 2);		
		frame.setVisible(true);
		
		//JTextField
		JTextField[] text = new JTextField[3];
		for(int i=0;i<3;++i) {
			text[i] = new JTextField(/*"輸入想要加入的文字"*/);
			text[i].setFont(new Font("微軟正黑體",Font.PLAIN,20));
			text[i].setBackground(Color.WHITE);
			text[i].setSize(200, 50);
			text[i].setLocation(580, 100 + 75*i);
			text[i].setVisible(false);
			text[i].selectAll();
			mainframe.add(text[i]);
		}
		text[0].setVisible(true);
		
		JButton btn_result = new JButton();
		btn_result.setBounds(10, 10, 400, 400);
		mainframe.add(btn_result);
		btn_result.setVisible(false);
				
		//Result Button
		JButton btn_out = new JButton("輸出結果");
		btn_out.setFont(new Font("微軟正黑體",Font.PLAIN,20));
		btn_out.setBounds(580, 450, 150, 50);
		mainframe.add(btn_out);
		btn_out.setVisible(true);
		
		
		//combobox
		String[] memes_str = {"", "我就爛", "美國隊長", "亞洲人之恥","這就對了"};
		JComboBox memes_combobox = new JComboBox(memes_str);
		memes_combobox.setSize(150, 30);
		memes_combobox.setLocation(620, 10);
		memes_combobox.setFont(new Font("微軟正黑體",Font.PLAIN,20));
		memes_combobox.setVisible(true);
		memes_combobox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				JComboBox<String> combobox = (JComboBox<String>) event.getSource();
				String selected = (String) combobox.getSelectedItem();
				switch(selected){
				case "我就爛":
					index = 0;
					System.out.println(selected);
					btn_drake.setVisible(false);
					btn_asian.setVisible(false);
					btn_cap.setVisible(false);
					btn_worst.setVisible(true);
					text[0].setVisible(true);
					text[1].setVisible(false);
					text[2].setVisible(false);
					btn_result.setBounds(10, 10, 400, 400);
					break;
				case "美國隊長":
					index = 1;
					System.out.println(selected);
					btn_drake.setVisible(false);
					btn_asian.setVisible(false);
					btn_cap.setVisible(true);
					btn_worst.setVisible(false);
					text[0].setVisible(true);
					text[1].setVisible(true);
					text[2].setVisible(true);
					btn_result.setBounds(10, 10, 400, 500);
					break;
				case "亞洲人之恥":
					index = 2;
					System.out.println(selected);
					btn_drake.setVisible(false);
					btn_asian.setVisible(true);
					btn_cap.setVisible(false);
					btn_worst.setVisible(false);
					text[0].setVisible(true);
					text[1].setVisible(true);
					text[2].setVisible(true);
					btn_result.setBounds(10, 10, 400, 530);
					break;
				case "這就對了":
					index = 3;
					System.out.println(selected);
					btn_drake.setVisible(true);
					btn_asian.setVisible(false);
					btn_cap.setVisible(false);
					btn_worst.setVisible(false);
					text[0].setVisible(true);
					text[1].setVisible(true);
					text[2].setVisible(false);
					btn_result.setBounds(10, 10, 400, 400);
					break;
				}
			}
		});
		mainframe.add(memes_combobox);
		//text combo box
		String font_style = "Microsoft YaHei"; 
		String[] font= {"Microsoft YaHei", "微軟正黑體","標楷體","新細明體"};
		JComboBox font_box= new JComboBox(font);
		font_box.setBounds(620, 350, 150, 30);
		font_box.setVisible(true);
		mainframe.add(font_box);
		font_box.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				JComboBox<String> combobox = (JComboBox<String>) event.getSource();
				String font_style = (String) combobox.getSelectedItem();
				System.out.println(font_style);
			}
		});
		
		//check box
		JCheckBox isBold = new JCheckBox();
		isBold.setBounds(620, 380, 50, 50);
		isBold.setVisible(true);
		mainframe.add(isBold);
		
		JLabel bl = new JLabel("粗體");
		bl.setBounds(670, 380, 200, 50);
		bl.setVisible(true);
		mainframe.add(bl);
		
		//set event
		startbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				mainframe.setVisible(true);
			}
		});
		
		int mtype = JOptionPane.INFORMATION_MESSAGE;
		
		btn_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog("命名為");
				String output = "./" + input + ".jpg";
				try {
					if(!input.equals(null)) {
						File out = new File(output);
						ImageIO.write(result, "jpg", out);
						int result = JOptionPane.showConfirmDialog(mainframe, "是否要繼續?", "已輸出圖片", JOptionPane.YES_NO_OPTION, mtype);
						if(result == JOptionPane.NO_OPTION) {System.exit(0);}
					}
			    }
			    catch(IOException outE) {
			    	System.out.println("output failed");
			    }
				catch(NullPointerException nE) {
					System.out.println("ignore");
				}
				
			}
		});
		
		text[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	BufferedImage bimage = null;
            	Graphics2D g;
            	switch(index) {
            	case 0:
            		bimage = new BufferedImage(400,400, BufferedImage.TYPE_INT_RGB); 
	        		g=bimage.createGraphics();
	                g.setColor(Color.BLACK); 
	        		g.setBackground(Color.LIGHT_GRAY); 
	        		g.drawImage(img_worst, 0, 0, null ); 
	        		g.setFont(new Font(font_style,Font.BOLD,50)); 
	        		g.drawString(text[0].getText(),50, 370);
	        		g.dispose();
            		break;
            	case 1:
            		bimage = new BufferedImage(400,500, BufferedImage.TYPE_INT_RGB); 
	        		g=bimage.createGraphics();
	                g.setColor(Color.WHITE); 
	        		g.setBackground(Color.LIGHT_GRAY); 
	        		g.drawImage(img_cap, 0, 0, null ); 
	        		g.setFont(new Font(font_style,Font.BOLD,30)); 
	        		g.drawString(text[0].getText(),25, 110);
	        		g.drawString(text[1].getText(),15, 280);
	        		g.drawString(text[2].getText(),215, 280);
	        		g.dispose();
            		break;
            	case 2:
            		bimage = new BufferedImage(400,530, BufferedImage.TYPE_INT_RGB); 
	        		g=bimage.createGraphics();
	                g.setColor(Color.WHITE); 
	        		g.setBackground(Color.LIGHT_GRAY); 
	        		g.drawImage(img_asian, 0, 0, null );  
	        		g.setFont(new Font(font_style,Font.BOLD,35)); 
	        		g.drawString(text[0].getText(),40, 150);
	        		g.drawString(text[1].getText(),40, 330);
	        		g.drawString(text[2].getText(),40, 505);
	        		g.dispose();
            		break;
            	case 3:
            		bimage = new BufferedImage(400,400, BufferedImage.TYPE_INT_RGB); 
	        		g=bimage.createGraphics();
	                g.setColor(Color.BLACK); 
	        		g.setBackground(Color.LIGHT_GRAY); 
	        		g.drawImage(img_drake, 0, 0, null );  
	        		g.setFont(new Font(font_style,Font.BOLD,30)); 
	        		String[] t0 = text[0].getText().split(" "); 
					String[] t1 = text[1].getText().split(" "); 
	        		for(int i=0;i<Math.min(t0.length, 7);++i) {
	        			g.drawString(t0[i],230, 30 + 30*i);
	        		}
	        		for(int i=0;i<Math.min(t1.length, 7);++i) {
	        			g.drawString(t1[i],230, 230 + 30*i);
	        		}
	        		g.dispose();
            		break;
            	}
            	
            	btn_drake.setVisible(false);
				btn_asian.setVisible(false);
				btn_cap.setVisible(false);
				btn_worst.setVisible(false);
				btn_result.setVisible(true);
				btn_result.setIcon(new ImageIcon(bimage));
            	result = bimage; 	
            }		
		});
		text[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	BufferedImage bimage = null;
            	Graphics2D g;
            	switch(index) {
            	case 0:
            		bimage = new BufferedImage(400,400, BufferedImage.TYPE_INT_RGB); 
	        		g=bimage.createGraphics();
	                g.setColor(Color.BLACK); 
	        		g.setBackground(Color.LIGHT_GRAY); 
	        		g.drawImage(img_worst, 0, 0, null ); 
	        		g.setFont(new Font(font_style,Font.BOLD,50)); 
	        		g.drawString(text[0].getText(),50, 370);
	        		g.dispose();
            		break;
            	case 1:
            		bimage = new BufferedImage(400,500, BufferedImage.TYPE_INT_RGB); 
	        		g=bimage.createGraphics();
	                g.setColor(Color.WHITE); 
	        		g.setBackground(Color.LIGHT_GRAY); 
	        		g.drawImage(img_cap, 0, 0, null ); 
	        		g.setFont(new Font(font_style,Font.BOLD,30)); 
	        		g.drawString(text[0].getText(),25, 110);
	        		g.drawString(text[1].getText(),15, 280);
	        		g.drawString(text[2].getText(),215, 280);
	        		g.dispose();
            		break;
            	case 2:
            		bimage = new BufferedImage(400,530, BufferedImage.TYPE_INT_RGB); 
	        		g=bimage.createGraphics();
	                g.setColor(Color.WHITE); 
	        		g.setBackground(Color.LIGHT_GRAY); 
	        		g.drawImage(img_asian, 0, 0, null );  
	        		g.setFont(new Font(font_style,Font.BOLD,35)); 
	        		g.drawString(text[0].getText(),40, 150);
	        		g.drawString(text[1].getText(),40, 330);
	        		g.drawString(text[2].getText(),40, 505);
	        		g.dispose();
            		break;
            	case 3:
            		bimage = new BufferedImage(400,400, BufferedImage.TYPE_INT_RGB); 
	        		g=bimage.createGraphics();
	                g.setColor(Color.BLACK); 
	        		g.setBackground(Color.LIGHT_GRAY); 
	        		g.drawImage(img_drake, 0, 0, null );  
	        		g.setFont(new Font(font_style,Font.BOLD,30)); 
	        		String[] t0 = text[0].getText().split(" "); 
					String[] t1 = text[1].getText().split(" "); 
	        		for(int i=0;i<Math.min(t0.length, 7);++i) {
	        			g.drawString(t0[i],230, 30 + 30*i);
	        		}
	        		for(int i=0;i<Math.min(t1.length, 7);++i) {
	        			g.drawString(t1[i],230, 230 + 30*i);
	        		}
	        		g.dispose();
            		break;
            	}
            	
            	btn_drake.setVisible(false);
				btn_asian.setVisible(false);
				btn_cap.setVisible(false);
				btn_worst.setVisible(false);
				btn_result.setVisible(true);
				btn_result.setIcon(new ImageIcon(bimage));
            	result = bimage; 
            }		
		});
		text[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	BufferedImage bimage = null;
            	Graphics2D g;
            	switch(index) {
            	case 0:
            		bimage = new BufferedImage(400,400, BufferedImage.TYPE_INT_RGB); 
	        		g=bimage.createGraphics();
	                g.setColor(Color.BLACK); 
	        		g.setBackground(Color.LIGHT_GRAY); 
	        		g.drawImage(img_worst, 0, 0, null ); 
	        		g.setFont(new Font(font_style,Font.BOLD,50)); 
	        		g.drawString(text[0].getText(),50, 370);
	        		g.dispose();
            		break;
            	case 1:
            		bimage = new BufferedImage(400,500, BufferedImage.TYPE_INT_RGB); 
	        		g=bimage.createGraphics();
	                g.setColor(Color.WHITE); 
	        		g.setBackground(Color.LIGHT_GRAY); 
	        		g.drawImage(img_cap, 0, 0, null ); 
	        		g.setFont(new Font(font_style,Font.BOLD,30)); 
	        		g.drawString(text[0].getText(),25, 110);
	        		g.drawString(text[1].getText(),15, 280);
	        		g.drawString(text[2].getText(),215, 280);
	        		g.dispose();
            		break;
            	case 2:
            		bimage = new BufferedImage(400,530, BufferedImage.TYPE_INT_RGB); 
	        		g=bimage.createGraphics();
	                g.setColor(Color.WHITE); 
	        		g.setBackground(Color.LIGHT_GRAY); 
	        		g.drawImage(img_asian, 0, 0, null );  
	        		g.setFont(new Font(font_style,Font.BOLD,35)); 
	        		g.drawString(text[0].getText(),40, 150);
	        		g.drawString(text[1].getText(),40, 330);
	        		g.drawString(text[2].getText(),40, 505);
	        		g.dispose();
            		break;
            	case 3:
            		bimage = new BufferedImage(400,400, BufferedImage.TYPE_INT_RGB); 
	        		g=bimage.createGraphics();
	                g.setColor(Color.BLACK); 
	        		g.setBackground(Color.LIGHT_GRAY); 
	        		g.drawImage(img_drake, 0, 0, null );  
	        		g.setFont(new Font(font_style,Font.BOLD,30)); 
	        		String[] t0 = text[0].getText().split(" "); 
					String[] t1 = text[1].getText().split(" "); 
	        		for(int i=0;i<Math.min(t0.length, 7);++i) {
	        			g.drawString(t0[i],230, 30 + 30*i);
	        		}
	        		for(int i=0;i<Math.min(t1.length, 7);++i) {
	        			g.drawString(t1[i],230, 230 + 30*i);
	        		}
	        		g.dispose();
            		break;
            	}
            	
            	btn_drake.setVisible(false);
				btn_asian.setVisible(false);
				btn_cap.setVisible(false);
				btn_worst.setVisible(false);
				btn_result.setVisible(true);
				btn_result.setIcon(new ImageIcon(bimage));
            	result = bimage; 
            }		
		});	
	}

}
