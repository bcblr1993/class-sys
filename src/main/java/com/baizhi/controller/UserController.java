package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.utils.CodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    //退出登录
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/back/login.jsp";
    }

    //注册方法
    @RequestMapping("regist")
    public String regist(User user) throws UnsupportedEncodingException {
        String message = null;
        try {
            if (ObjectUtils.isEmpty(user.getUsername())) throw new RuntimeException("用户名不能为空!");
            if (ObjectUtils.isEmpty(user.getPassword())) throw new RuntimeException("密码不能为空!");
            userService.save(user);
            return "redirect:/back/login.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            message = URLEncoder.encode(e.getMessage(), "UTF-8");
        }
        return "redirect:/back/regist.jsp?msg=" + message;
    }

    //登录方法
    @RequestMapping("login")
    public String login(HttpServletRequest request, String code, User user) throws Exception {
        String message = null;
        //验证验证码
        try {
            HttpSession session = request.getSession();
            String imageCode = (String) session.getAttribute("code");
            if (imageCode == null) throw new RuntimeException("验证码已过期!!!");
            if (imageCode.equalsIgnoreCase(code)) {
                user = userService.login(user);
                session.setAttribute("user", user);
                return "redirect:/back/main/main.jsp";
            } else {
                throw new RuntimeException("验证码输入错误~~~");
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = URLEncoder.encode(e.getMessage(), "UTF-8");
        }
        return "redirect:/back/login.jsp?msg=" + message;
    }


    /**
     * 生成验证码
     *
     * @return
     * @throws IOException
     */
    @RequestMapping("getImgCode")
    public void getImageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取验证码
        Map<String, Object> codeAndPic = CodeUtil.generateCodeAndPic(190, 40);
        String code = (String) codeAndPic.get("code");
        log.info("当前的验证码为: {}", code);
        //放入session中
        request.getSession().setAttribute("code", code);
        //将数组写入图片中
        BufferedImage image = (BufferedImage) codeAndPic.get("codePic");
        //设置图片响应类型
        response.setContentType("image/png");
        //响应图片
        //参数1:输出的图片对象是谁   参数2:输出图片格式  //参数3:以什么样的流输出
        ImageIO.write(image, "png", response.getOutputStream());
    }


}
