package com.chenmo.reflect;

import java.lang.reflect.Method;

import org.junit.Test;

public class MethodTest {

	@Test
	public void demo1() throws Exception {
		
		Class class1 = Class.forName("com.chenmo.reflect.Person");
		Person p =  (Person)class1.newInstance();
		Method method =  class1.getMethod("eat");
		method.invoke(p);
	}
	
	@Test
	public void demo2() throws Exception {
		Class class1 = Class.forName("com.chenmo.reflect.Person");
		
		Person p =  (Person)class1.newInstance();
		
		Method method = class1.getDeclaredMethod("run");
		
		method.setAccessible(true);
		
		method.invoke(p, null);
		
		
	}

	@Test
	public void demo3() throws Exception {
		
        Class class1 = Class.forName("com.chenmo.reflect.Person");
		
		Person p =  (Person)class1.newInstance();
		
		Method method = class1.getDeclaredMethod("say", String.class);
		
		method.setAccessible(true);
	 
	    Object obj =  method.invoke(p, "tom");
		
	    System.out.println(obj);
		
		
	}
	
	
	
}
