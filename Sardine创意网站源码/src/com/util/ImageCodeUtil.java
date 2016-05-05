package com.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageCodeUtil {
	public static String code="";
	public static BufferedImage getImage(){
		Random r = new Random();
		//1.创建一个bufferedimage对象
		BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		//2.绘制长方形
		Graphics g = image.getGraphics();
		g.setColor(new Color(233, 222, 220));
		g.fillRect(0, 0, 80, 30);
		//3.绘制干扰线
		for(int i = 0;i < 1000;i++){
			g.setColor(new Color(40+r.nextInt(200),40+r.nextInt(200),40+r.nextInt(200)));
			int x = r.nextInt(150);
			int y = r.nextInt(50);
			g.drawLine(x,y, x+r.nextInt(50), y+r.nextInt(30));
		}
		//设置字体类型
		g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE,25));
		//4.写四位数字
		g.setColor(new Color(80, 60, 90));
		int checkCode = r.nextInt(9000)+1000;
		code=checkCode + "";
		g.drawString(checkCode+"", 18, 25);
		//关闭Graphics对象，释放资源
		g.dispose();
		return image;
	}
	
}
