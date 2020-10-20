package com.examen.poker.model;

public class Game {

	private int player1;
	private int player2;
	private int empate;
	private int desempatePlayer1;
	private int desempatePlayer2;
	
	/*empate cuando las cartas son igaules y 
	van al flujo de desempate y las cartas siguen
	siendo iguales */
	private int empateProceso;
	
	
	public void sumPlayer1() {
		
		this.player1 +=1;
	}
	
	public void sumPlayer2() {
		
		this.player2 +=1;
	}
	
	public void sumEmpate() {
		
		this.empate +=1;
	}
	
	public void sumDesempatePlayer1() {
		
		this.desempatePlayer1 +=1;
	}
	public void sumDesempatePlayer2() {
		
		this.desempatePlayer2 +=1;
	}
	
	public void sumempateProceso() {
		this.empateProceso +=1;
	}

	public int getPlayer1() {
		return player1;
	}

	public int getPlayer2() {
		return player2;
	}

	public int getEmpate() {
		return empate;
	}

	public int getDesempatePlayer1() {
		return desempatePlayer1;
	}

	public int getDesempatePlayer2() {
		return desempatePlayer2;
	}

	public int getEmpateProceso() {
		return empateProceso;
	}
	
	
}
