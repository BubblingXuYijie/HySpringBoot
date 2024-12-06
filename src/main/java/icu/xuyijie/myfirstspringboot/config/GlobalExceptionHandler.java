package icu.xuyijie.myfirstspringboot.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 徐一杰
 * @date 2024/12/6 8:43
 * @description 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获 ValidationException 异常，自行处理返回给给用户的数据
     * @param e 异常信息
     * @param request 请求信息
     * @return 返回给用户展示的数据
     */
    @ExceptionHandler({ValidationException.class})
    public String handleValidationException(ValidationException e, HttpServletRequest request) {
        return e.getMessage();
    }

    /**
     * 处理实体类字段校验异常
     *
     * @param request 请求信息
     * @param e       体类字段校验异常
     * @return 自定义返回体
     */
    @ExceptionHandler(value = BindException.class)
    public String bizExceptionHandler(HttpServletRequest request, BindException e) {
        return e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
    }

}
