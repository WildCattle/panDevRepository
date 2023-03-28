package com.gzpanfuyi.web;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CertificationCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //通知浏览器不使用缓存
        response.setHeader("expires", "-1");
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        /**
         * @width 图像的宽度
         * @height 图像的高度
         * @codeCount 验证码的位数
         * @circleCount 干扰点，验证码生成图片后的干扰点，这些干扰点会影响用户对验证码的判断（
         * 防止别有用心的人使用相关的程序来识别验证码图片
         */
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(116,36,4,5);
        String code = captcha.getCode(); //得到生成的码
        HttpSession session = request.getSession(true); //每调用一次此方法，就会生成新的code
        session.setAttribute("certificateCode",code); //在引入redis后可以直接放入redis中
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            captcha.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
