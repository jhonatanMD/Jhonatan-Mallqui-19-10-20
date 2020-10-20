package com.examen.poker.model;

public class Card {
	
	private int num;
	private String simbolo;
	
	
	
	
	
	public Card() {
	}

	public Card(int num, String simbolo) {
		this.num = num;
		this.simbolo = simbolo;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	@Override
	public String toString() {
		return "Card [num=" + num + ", simbolo=" + simbolo + "]";
	}
	
	
}
