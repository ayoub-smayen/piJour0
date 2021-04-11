package com.project0.esprit.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.project0.esprit.entity.Product1;

@Aspect
@Component
public class ProductServiceAspect {
	
	
	@Before(value = "execution(* com.project0.esprit.service.Iayproduct.*(..)) and args( p1 , imageprod,  category_id ,  publicity_id)")
	public void beforeAdvice(JoinPoint joinPoint, Product1 p1 , byte[] imageprod, Long category_id , Long publicity_id) {
		System.out.println("Before method:" + joinPoint.getSignature());

		System.out.println("Creating Product with name - " + p1.getProductname() + " and id - " + p1.getProduct_id());
	}

	@After(value = "execution(* com.project0.esprit.service.Iayproduct.*(..)) and args( p1 , imageprod,  category_id ,  publicity_id)")
	public void afterAdvice(JoinPoint joinPoint, Product1 p1 , byte[] imageprod, Long category_id , Long publicity_id) {
		System.out.println("After method:" + joinPoint.getSignature());

		System.out.println("Successfully created Product with name - " + p1.getProductname() + " and id - " + p1.getProduct_id());
	}
	
}
