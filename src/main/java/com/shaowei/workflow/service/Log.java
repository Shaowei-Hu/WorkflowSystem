package com.shaowei.workflow.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import com.shaowei.workflow.model.Admin;

@Component
public class Log {

	public void logBefore(JoinPoint jp){
		System.out.println(jp.getTarget().getClass().toString() + " " + jp.getSignature().getName());
	}
	
	public Object logAroundLogin(ProceedingJoinPoint pjp){
		Object obj = null;
		try {
			 obj = pjp.proceed();
			if(obj!=null){
				System.out.println(pjp.getSignature().getName() + " sucess, admin " + ((Admin)obj).getAdminName() + " logged.");
			} else {
				System.out.println(pjp.getSignature().getName() + " refuse");
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}
}
