package com.pdk.web.servlet;

import com.pdk.domain.User;
import com.pdk.service.UserService;
import com.pdk.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据
        String verifycode = request.getParameter("verifycode");
        //3.校验验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("checkcode_server");
        //确保验证码的一次性使用过后清除
        session.removeAttribute("checkcode_server");

        if (!checkcode_server.equalsIgnoreCase(verifycode)) {
            request.setAttribute("login_msg", "验证码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        Map<String, String[]> map = request.getParameterMap();
        //4.封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //5.调用Service查询
        UserService service=new UserServiceImpl();
        User loginUser = service.login(user);
        //6.判断是否登陆成功
        if (loginUser!=null) {
            //登陆成功将用户存入Session
            session.setAttribute("user",loginUser);
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/index.jsp");

        }else {
            request.setAttribute("login_msg", "用户名或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
