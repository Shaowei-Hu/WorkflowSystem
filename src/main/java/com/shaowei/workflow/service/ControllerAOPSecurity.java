package com.shaowei.workflow.service;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import com.shaowei.authorization.domain.Privilege;
import com.shaowei.workflow.exception.CustomAcdessDeniedException;

@Component
public class ControllerAOPSecurity {

	public void securityBefore(JoinPoint jp) {
		System.out.println(jp.getTarget().getClass().toString() + " " + jp.getSignature().getName());
	}

	public Object securityAround(ProceedingJoinPoint pjp) {
		Object obj = null;
		try {

			Object[] args = pjp.getArgs();
			for (Object arg : args) {
				if(arg instanceof HttpServletRequest){
					@SuppressWarnings("unchecked")
					Set<Privilege> privileges = (Set<Privilege>) ((HttpServletRequest)arg).getAttribute("operation");
					String functionName = pjp.getSignature().getName();
					if(privileges!=null && privileges.contains(functionName)){
						System.out.println(pjp.getSignature().getName() + " permission Ok");
						obj = pjp.proceed();
						return obj;
					}
					else {
						throw new CustomAcdessDeniedException(pjp.getSignature().getName());
					}
				}
				else {
					System.out.println("No parameter to execute access controll.");
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
}
