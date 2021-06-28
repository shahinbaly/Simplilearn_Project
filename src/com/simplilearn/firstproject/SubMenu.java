package com.simplilearn.firstproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.simplilearn.firstproject.MainMenu;

public class SubMenu implements MenuInterface{
	String filePath = "src/FileDirectory/";
	ArrayList<String> menuList = new ArrayList<>();


	@Override
	public void getMenuList() {

	    menuList.add("1. Add File");
		menuList.add("2. Search File");
		menuList.add("3. Delete File");
		menuList.add("4. Return to the main Menu");

		System.out.println("Menu : ");
		for (String s : menuList) {

			System.out.println(s);

		}
		menuList.clear();
		
	}
	
public void getUserInput(){
		
		System.out.println("Please Choose a Option :");
		Scanner in = new Scanner(System.in);
		   try {
			   int choiceOption = in.nextInt();
			   
			   this.MenuOption(choiceOption);
	        }
	        catch (InputMismatchException ex) {
	        	System.out.println("Invalid input");
	        	 this.getMenuList();
	        	 this.getUserInput();
	        }
	}



	@Override
	public void MenuOption(int input) {
		 switch(input) {

         case 1: 
      	   
        	 this.AddFile();
        	 this.getMenuList();
        	 this.getUserInput();
             break;
             
         case 2: 
        	 this.SearchFile();
        	 this.getMenuList();
        	 this.getUserInput();
             break;
             
         case 3: 

        	 this.deleteFile();
        	 this.getMenuList();
        	 this.getUserInput();
             break;
             
         case 4: 

        	 new MainMenu().getMenuList();
        	 new MainMenu().getOptions();
      	   break;
             
         default:
             System.out.println("Invalid Option");
             break;
     }
     
	}
	

	public void AddFile() {
		
		System.out.println("Please Enter  File Name:");
		Scanner in = new Scanner(System.in);
		String filename = in.nextLine();

		File f = new File(filePath,filename);
		try {
			if(f.createNewFile()) {
			
			System.out.println("You added a file named: " + filename+" successfully");
			
			} else {
		        System.out.println("Already added this file !");
		      }
			
		} catch (IOException e) {
			 System.out.println(" File added not successful!");
       	 	this.getMenuList();
       	 	this.getUserInput();
		}
		
	}
	
	
	
	public void SearchFile() {
		
		System.out.println("Please Enter the File Name:");
		Scanner in = new Scanner(System.in);
		String Dfilename = in.nextLine();

		  File directory = new File(filePath);
		  String[] flist = directory.list();
		  
		  int flag = 0;
	        if (flist == null) {
	            System.out.println(" Directory has no file.");
	        }
	        else {
	  
	            // Linear search in the array
	            for (int i = 0; i < flist.length; i++) {
	                String filename = flist[i];
	                if (filename.equals(Dfilename)) {
	                    System.out.println(filename + " File found");
	                    flag = 1;
	                }
	            }
	        }
	  
	        if (flag == 0) {
	            System.out.println("File Not Found");
	        }
	    
		
	}
	
	
	public void deleteFile() {
		
		System.out.println("Please Enter the File Name:");
		Scanner in = new Scanner(System.in);
		String Dfilename = in.nextLine();
		
		//Path path = FileSystems.getDefault().getPath(filePath).toAbsolutePath();
		  File directory = new File(filePath);
		  String[] flist = directory.list();
		  File fileDelete;
		  int flag = 0;
	        if (flist == null) {
	            System.out.println("Empty directory.");
	        }
	        else {
	  
	            // Linear search in the array
	            for (int i = 0; i < flist.length; i++) {
	                String filename = flist[i];
	                if (filename.equals(Dfilename)) {
	                	
	                	fileDelete = new File(filePath+""+Dfilename);
	                	 boolean isdeleted = fileDelete.delete();
	                	 if(isdeleted) {
	                		 
	                    System.out.println("File "+Dfilename + " Deleted.");
	                	 }else {
	                		 
	                		  System.out.println("File Not Deleted.");
	                	 }
	                    flag = 1;
	                }
	            }
	        }
	  
	        if (flag == 0) {
	            System.out.println("File Not Found");
	        }

	}
}
