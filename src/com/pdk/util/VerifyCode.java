package com.pdk.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 对图片进行处理的类和方法
 */
public class VerifyCode {
    public static String drawaRandomText(int width, int height, BufferedImage verifyImg) {
        Graphics2D graphics = (Graphics2D) verifyImg.getGraphics();
        graphics.setColor(Color.pink);//设置画笔颜色和验证码背景色
        graphics.fillRect(0, 0, width, height);//填充背景
        graphics.setFont(new Font("微软雅黑", Font.BOLD, 24));
        //数字字母组合
        String baseNumberLetter = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuffer sb = new StringBuffer();
        int x = 10;//旋转原点的坐标
        String ch = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            graphics.setColor(getRandomColor());
            //设置字体的旋转角度
            int degree = random.nextInt() % 30;//角度小于30
            int nextInt = random.nextInt(baseNumberLetter.length());
            ch = baseNumberLetter.charAt(nextInt) + "";
            sb.append(ch);
            //正向旋转
            graphics.rotate(degree * Math.PI / 180, x, 30);
            graphics.drawString(ch, x, 30);
//            //反向旋转
//
            graphics.rotate(-degree * Math.PI / 180, x, 30);
//
            x += 20;
        }

        //画干扰线
        for (int i = 0; i < 6; i++) {
            //设置随机颜色
            graphics.setColor(getRandomColor());
            //随机画线
            graphics.drawLine(random.nextInt(width), random.nextInt(height)
                    , random.nextInt(width), random.nextInt(height));
        }
        //添加噪点
        for (int i = 0; i < 30; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            graphics.setColor(getRandomColor());
            graphics.fillRect(x1, y1, 2, 2);
        }

        return sb.toString();

    }


    private static Color getRandomColor() {
        Random random = new Random();
        Color color = new Color(random.nextInt(256)
                , random.nextInt(256)
                , random.nextInt(256));
        return color;
    }
}
