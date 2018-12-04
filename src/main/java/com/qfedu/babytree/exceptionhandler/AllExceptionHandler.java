package com.qfedu.babytree.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

//@ExceptionHandler自己单独使用的时候只对所在的当前类捕获异常功能，如果是全局的需要使用@ControllerAdvice对所有的controller进行增强处理
//@ControllerAdvice默认使用不了，需要使用mvc：annotation-driven配置

//404异常被tomcat拦截，到不了Controller

@ControllerAdvice
public class AllExceptionHandler {
	
	//@ExceptionHandler修饰的方法在发生异常的时候执行，注解的参数是捕获的异常类型Exception表示捕获所有的异常
	//方法的参数可以按照需求进行生命
	//使用实现接口或者注解的方式二选一即可
	//@ExceptionHandler(Exception.class)
	public String handlerException(Exception ex, HttpServletRequest request) {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();  
		ex.printStackTrace(new PrintStream(baos));  
		String exception = baos.toString();  
		System.out.println("这是异常:" + exception); 
		return "error";
		
	}

}
