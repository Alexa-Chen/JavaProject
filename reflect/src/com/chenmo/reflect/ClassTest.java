package com.chenmo.reflect;

import org.junit.Test;

public class ClassTest {
	
	@Test
	
	/**
	 *  ��ȡclass����
	 * 1  ͨ������.class
	 * 2 ͨ��.getClass
	 * 3 Class.forName();
	 */
	public void demo1() throws ClassNotFoundException {
		
		// 1
		Class c1 = Person.class;
		
		//2
		
		Person person = new Person();
		person.getClass();
		
		//3 
		
		Class c2 = Class.forName("com.chenmo.reflect.Person");
		
		
		
		
		
		 
		
		
		
		
	}

}
