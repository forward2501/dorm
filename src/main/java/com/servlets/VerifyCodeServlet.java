package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class VerifyCodeServlet  extends HttpServlet{
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	         //声明验证码
	        int width = 60;
	        int height = 30;
	         //随机字符字典，其中0，o，1，I 等难辨别的字符不要
	        String data = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789abcdefghijklmnpqrstuvwxyz";
	        Random random = new Random();//随机类
	        
	        //创建一张内存中的缓存图片
	        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	        //创建一个彩色的图片
	         //通过graphics绘制图像
	        Graphics graphics = image.getGraphics();
	         // 设置颜色
	        graphics .setColor(Color.BLACK);
	        //填充
	        graphics .fillRect(0, 0, width, height);
	         //白色矩形，画边框
	        graphics .setColor(Color.WHITE);
	        graphics .fillRect(1, 1, width-2, height-2);
	        
	        /*提供缓存区域，为了存放4个随机字符，以便存入session */
	        StringBuilder builder = new StringBuilder();
	        
	          // 随机生成4个字符
	         //设置字体颜色
	        graphics .setFont(new Font("宋体", Font.BOLD&Font.ITALIC, 20));
	        for(int i = 0;i < 4;i++){
	            //随机颜色
	        	graphics .setColor(new Color(random.nextInt(255),random.nextInt(255), random.nextInt(255)));
	            
	            //随机字符
	            int index = random.nextInt(data.length());
	            String str = data.substring(index, index + 1);
	            
	            /**2 缓存*/
	            builder.append(str);
	            
	            //写入
	            graphics .drawString(str, (width / 6) * (i + 1) , 20);                     
	        }
	        //给图中绘制噪音点，让图片不那么好辨别
	        for(int j=0,n=random.nextInt(100);j<n;j++){
	        	graphics .setColor(Color.RED);
	        	graphics .fillRect(random.nextInt(width),random.nextInt(height),1,1);//随机噪音点
	        }
	        
	        /*获得随机数据，并保存session*/
	        String tempStr = builder.toString();
	        request.getSession().setAttribute("sessionCacheData",tempStr);
	        
	        
	        //生成图片发送到浏览器 ,相当于下载
	        ImageIO.write(image, "jpg", response.getOutputStream());
	    }
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	 doGet(request, response);
		}

	
}
