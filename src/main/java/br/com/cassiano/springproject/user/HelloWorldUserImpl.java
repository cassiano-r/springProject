package br.com.cassiano.springproject.user;

public class HelloWorldUserImpl implements HelloWorldUser {
	
	@Override
	public void getName(String name){
		System.out.println("Name " + name);
	}
	
	public void getPassWord(String passWord)
	{
		System.out.println("Password "+ passWord);
	}

}
