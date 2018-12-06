package com.qfedu.babytree.util;

import com.qfedu.babytree.constan.PageConstants;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import com.github.pagehelper.PageHelper;

@Component
@Aspect
public class PageAspector {

	/**
	 * 在pointcut中定义切入点，然后再@around和其他的通知中复用
	 * 我们的切入点应该是所有的service中带有分页的方法，带有分页的方法需要有以下特点:
	 * 1.所有service中方法名以List结尾的（要求:方法的命名尽量的规范） 2.方法的参数，前两个是一定是字符串类型的，后面参数的个数不限制
	 */
	@Pointcut("execution(* com.qfedu.babytree.serviceImpl.*.*List(java.lang.String,java.lang.String,..))")
	public void pointcut() {

	}

	@Around("pointcut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		//获取目标方法的参数
		Object[] params = joinPoint.getArgs();
		String pageNum = (String) params[0];
		String pageSize = (String) params[1];

		// 指定pageNum和pageSize的默认值
		int pageNumInt;
		int pageSizeInt;

		if (pageNum == null || pageNum.length() == 0) {
			pageNumInt = PageConstants.PAGENUM;
		} else {
			pageNumInt = Integer.valueOf(pageNum);
		}

		if (pageSize == null || pageSize.length() == 0) {
			pageSizeInt = PageConstants.PAGESIZE;
		} else {
			pageSizeInt = Integer.valueOf(pageSize);
		}

		//开启分页
		PageHelper.startPage(pageNumInt, pageSizeInt);

		// 默认@Around通知是阻塞目标方法的调用
		// joinPoint是连接点，也就是切入点
		// proceed表示调用目标方法,并且返回目标方法执行的返回值
		Object obj = joinPoint.proceed(params);
		return obj;
	}
}
