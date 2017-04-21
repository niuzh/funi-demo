package com.funi.demo.web.supports;

import com.funi.demo.supports.PageableQuery;
import com.github.pagehelper.PageHelper;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author zhihuan.niu on 2017/4/21.
 */
public class PageMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        // 获取参数类型
        //todo
        Class<?> paramType = methodParameter.getParameterType();
        // 如果该参数类型是PageBounds类自身或者子类，则返回true，表示这个解析器可以解析此类型
        return PageableQuery.class.isAssignableFrom(paramType);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        int pageNum=Integer.parseInt(nativeWebRequest.getParameter("pageNum"));
        int pageSize=Integer.parseInt(nativeWebRequest.getParameter("pageSize"));
        PageHelper.startPage(pageNum, pageSize);
        return null;
    }
}
