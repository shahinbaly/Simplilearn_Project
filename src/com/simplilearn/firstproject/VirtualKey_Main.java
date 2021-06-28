package com.simplilearn.firstproject;

import java.io.IOException;

import com.simplilearn.firstproject.MainMenu;

public class VirtualKey_Main {
	public static void main(String[] args) throws IOException {
		MainMenu mainMenu = new MainMenu();
	
		System.out.println("Project Name: Virtual Key");
		System.out.println("Developer Name: Shahin Akter Baly");
		System.out.println("Address: Dhaka Bangladesh");
	
		mainMenu.getMenuList();
		mainMenu.getOptions();
		
	
	}

}
