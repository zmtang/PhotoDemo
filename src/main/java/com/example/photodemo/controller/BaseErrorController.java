package com.example.photodemo.controller;

import com.example.photodemo.vo.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * web开发错误处理
 * ErrorController 是
 * @author zmt
 * @date 2019-05-13 11:34
 */
@RestController
public class BaseErrorController implements ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(BaseErrorController.class);

    /**
     * 默认错误路径
     */
    private static final String ERROR_PATH = "/error";


    private ErrorAttributes errorAttributes;

    @Autowired
    public BaseErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    /**
     * 重写getErrorPath()方法 自定义错误控制器
     */
    @Override
    public String getErrorPath() {
        logger.error("出错啦！ 进入自定义错误控制器吧？？？？");
       return "ftl/index";
       // return path_default;
    }

    /**
     * Web页面错误处理
     */
    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public String errorPageHandler(HttpServletRequest request, HttpServletResponse response) {
        int status = response.getStatus();
        switch (status) {
            case 403:
                return "403";
            case 404:
                return "404";
            case 500:
                return "500";
        }
        return "index";

    }

    /**
     * 除Web页面外的错误处理，比如Json/XML等
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public ResponseMessage errorApiHandler(HttpServletRequest request, final Exception ex, final WebRequest req) {

        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        logger.info(ex.getMessage()+"------------------"+ex.getStackTrace());
        Map<String, Object> attr = this.errorAttributes.getErrorAttributes(req, false);
        int status = getStatus(request);

        return ResponseMessage.ofMessage(status, String.valueOf(attr.getOrDefault("message", "error")));
    }

    
    /**
     * JSON格式错误信息
     */
   /*@RequestMapping
    public String error(HttpServletRequest request) {
       return getErrorPath();
    }*/

    /**
     * JSON格式错误信息
     */
    /*@RequestMapping(value = path_default,  produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseMessage error(HttpServletRequest request) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        logger.error("出错啦！ 我跳转一次试试");
        return ResponseMessage.fail("服务器端异常！", "异常信息可以跳转吗");
    }*/

    /**
     * 获取status信息
     * @param request
     * @return
     */
    private int getStatus(HttpServletRequest request) {
        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (status != null) {
            return status;
        }

        return 500;
    }
}
