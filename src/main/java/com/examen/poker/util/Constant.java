package com.examen.poker.util;

import java.util.HashMap;
import java.util.Map;

public final  class Constant {

	public static Map<String,Integer> change = new HashMap<String, Integer>();
	public static final String[] RANKS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K","A"};
	public static final  String[] SUITS = {"H", "D", "C", "S"}; 
	public static int lengthRow = 29;
	public static final String fileRead = "src/main/resources/files/pokerdata.txt";
	public static final String fileWrite = "src/main/resources/files/OutputFilePoker.txt";
	
	/*
	 * Metodo devuelve dato segun su key del map
	 * */
	public final static Integer inputKey(String key) {
		
		change.put("T", 10);
		change.put("J", 11);
		change.put("Q", 12);
		change.put("K", 13);
		change.put("A", 14);
		change.put("1", 1);
		change.put("2", 2);
		change.put("3", 3);
		change.put("4", 4);
		change.put("5", 5);
		change.put("6", 6);
		change.put("7", 7);
		change.put("8", 8);
		change.put("9", 9);
		
		return change.get(key);
	}
	
	/*
	 * valida entradas y verifica que sean datos de las cartas
	 * 
	 * */
	public static int inputValidation(String[] card ) {
		
		int validation = 0 ;
		if(card.length == 10) {
			for(String n : Constant.RANKS) {
	   		 
	   		 for(int j = 0 ; j < card.length ; j++) {
	   			 
	   			 if(card[j].substring(0,1).equals(n) ) {
	   				validation++;
		   			 }
		   		 }
		   	 }
		   	 
		   	 for(String suits : Constant.SUITS) {
		   		 
		   		 for(int j = 0 ; j < card.length ; j++) {
		   			 
		   			 if(card[j].substring(1,2).equals(suits) ) {
		   				validation++;
		   			 }
		   		 }
		   	 }
		}
   	 return validation;
	}
}
