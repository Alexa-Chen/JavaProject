package com.chenmo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;

import org.junit.Test;

public class ConstructorTest {

	
	@Test
	
	/**
	 * ����޲ι��췽�� 
	 */

	public void demo1() throws Exception {
		
		Class class1= Class.forName("com.chenmo.reflect.Person");
		
		Constructor c = class1.getConstructor();
		
		Person person =  (Person)c.newInstance();
		
		person.eat();
		
	}
	
	
	/**
	 * ����вι���
	 * @throws Exception 
	 */
	
	public void demo2() throws Exception {
		Class class1 = Class.forName("com.chenmo.reflect.Person");
		
		Constructor c = class1.getConstructor(String.class,String.class);
		
		Person p = (Person)c.newInstance("aa","bb");
		
		System.out.println(p);
		
	}
	
	
	
	

}
