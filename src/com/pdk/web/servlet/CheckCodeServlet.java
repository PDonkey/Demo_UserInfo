package com.pdk.web.servlet;

import com.pdk.util.VerifyCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //服务器通知浏览器不要缓存
        response.setHeader("pragma","no-cache");
        response.setHeader("cache-control","no-cache");
        response.setHeader("expires","0");
        int width=100;
        int height=40;
        BufferedImage verifyImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //生成对应宽高的对应图片
        String checkCode = VerifyCode.drawaRandomText(width, height, verifyImg);
        request.getSession().setAttribute("checkcode_server",checkCode);
        response.setContentType("image/png");
        ImageIO.write(verifyImg,"png",response.getOutputStream());

    }
}
