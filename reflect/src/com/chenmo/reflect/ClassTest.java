package com.chenmo.reflect;

import org.junit.Test;

public class ClassTest {
	
	@Test
	
	/**
	 *  获取class对象
	 * 1  通过类名.class
	 * 2 通过.getClass
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
