package com.examen.poker.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.examen.poker.model.Card;
import com.examen.poker.model.Game;
import com.examen.poker.util.Constant;

public final class ControlCase {
	

	/*
	 * 
	 * Clase que evalua cartas de cada jugador para un desempate
	 * 
	 * 
	 * */
	public final static Game game = new Game();
	
	
	/*
	 * Metodo suma mano de cada jugador y valida cual es mayor
	 * */
	public final static void sum(List<Card> card , List<Card> card2  ) {
		 winner(card.stream().mapToInt(x -> x.getNum()).sum(),card2.stream().mapToInt(x -> x.getNum()).sum());
	}
	
	/*
	 * Metodo evalua mano de cada jugador segun su maxima carta
	 * */
	public final static void bigNumber(List<Card> card , List<Card> card2) {
		 winner( card.stream().mapToInt(x -> x.getNum()).max().getAsInt(), card2.stream().mapToInt(x -> x.getNum()).max().getAsInt());
	}
	
	/*
	 * Metodo convierte las cartas de string enviadas a una objeto Card y devuel una lista de Card
	 * */
	public final static List<Card> convertStringCard(String card){
		
		List<Card> cardsParse = new ArrayList<>();
		String[] c = card.trim().split(" ");
	
		for(int i = 0 ; i < c.length ; i++) {
			
		 cardsParse.add(new Card(Constant.inputKey(c[i].substring(0,1)),c[i].substring(1,2)));
		
		}
		
		
		return cardsParse;
	}
	
	/*
	 * Metodo evalua el contenido de cada carta y agrega cartas pares , trios ,4 iguales
	 * */
	public final static Map<Integer,Integer> contain(List<Card> cards) {
		
		Map<Integer,Integer> cardFormat = new HashMap<>();
		
	    for(int i = 1 ; i < 15  ;i++ ) {

		int count = 0;
		
		for(Card card : cards)
		{
			if(card.getNum() == i)
			{
				count++;
			}
		}
		
			if(count > 1) {
				cardFormat.put(i, count);
			}
	     }
	    
		return cardFormat;
	}
	
	/*
	 * Metodo evalua el desempate de cada mano 
	 * 
	 * */
	
	public final static void process(List<Card> card , List<Card> card2){
		
		
		//Convierto lista de cartas en un array segun el valor y la cantidad que contiene
		Integer [][] cardFormat = contain(card).entrySet()
			    .stream()
				.sorted(Map.Entry.comparingByValue())
			    .map(e -> new Integer[]{e.getKey(), e.getValue()})
			    .toArray(Integer[][]::new);
	
		Integer [][] cardFormat2 = contain(card2).entrySet()
			    .stream()
				.sorted(Map.Entry.comparingByValue())
			    .map(e -> new Integer[]{e.getKey(), e.getValue()})
			    .toArray(Integer[][]::new);
		
		
		if(cardFormat.length != 0) {
			
			if(cardFormat.length == 1 && cardFormat2.length == 1) {
				
				if( cardFormat[0][1] == 2 && cardFormat2[0][1] == 2) {
					
					if(cardFormat[0][0]==cardFormat2[0][0]) {
						int n1 = 0;
						int n2  = 0;
						if(removeAndMax(card, cardFormat[0][0]) == removeAndMax(card2, cardFormat2[0][0])) {
							 n1 = removeAndMax(card, cardFormat[0][0]);
							
							if (removeAndMax(card, cardFormat[0][0],n1)== removeAndMax(card2, cardFormat2[0][0],n1)) {
								 n2 = removeAndMax(card, cardFormat[0][0],n1);
								winner(removeAndMax(card, cardFormat[0][0],n1,n2),removeAndMax(card2, cardFormat2[0][0],n1,n2));
							}else {
								winner(removeAndMax(card, cardFormat[0][0],n1),removeAndMax(card2, cardFormat[0][0],n1));
							}
							
						}else {
							winner(removeAndMax(card, cardFormat[0][0]),
									removeAndMax(card2, cardFormat2[0][0]));
							}
					}else {
					
						winner(cardFormat[0][0],cardFormat2[0][0]);
					}
				
				}else if( cardFormat[0][1] == 3 && cardFormat2[0][1] == 3) {
					
					if(cardFormat[0][0] == cardFormat2[0][0]) {
						int n = 0;
						if(removeAndMax(card, cardFormat[0][0]) ==	removeAndMax(card2, cardFormat2[0][0])) {
							n = removeAndMax(card, cardFormat[0][0]);
							winner(removeAndMax(card, cardFormat[0][0],n),
									removeAndMax(card2, cardFormat2[0][0],n));
						}else {
						
						winner(removeAndMax(card, cardFormat[0][0]),
								removeAndMax(card2, cardFormat2[0][0]));
						}
					}else {
						winner(cardFormat[0][0],cardFormat2[0][0]);
					}
					
					
				}else if( cardFormat[0][1] == 4 && cardFormat2[0][1] == 4) {
					
					if(cardFormat[0][0] == cardFormat2[0][0]) {
						
						winner(removeAndMax(card, cardFormat[0][0]),
								removeAndMax(card2, cardFormat2[0][0]));
					}else {
						winner(cardFormat[0][0],cardFormat2[0][0]);
					}
					
				
				}
			}else if (cardFormat.length == 2 && cardFormat2.length == 2){
					if( cardFormat[0][1] == 2 &&  cardFormat[1][1] == 2) {
						
						if(cardFormat[0][0] == cardFormat2[0][0] && cardFormat[1][0] == cardFormat2[1][0]) {
							
							winner(removeAndMax(card, cardFormat[0][0],cardFormat[1][0]),
									removeAndMax(card2, cardFormat2[0][0],cardFormat2[1][0]));
						}else {
							winner(cardFormat[0][0]+cardFormat[1][0],cardFormat2[0][0]+cardFormat2[1][0]);
						}
					
						
					}else if(cardFormat[0][1] == 2 &&  cardFormat[1][1] == 3 && cardFormat2[0][1] == 2 &&  cardFormat2[1][1] == 3){
	
							if(cardFormat[1][0] == cardFormat2[1][0]) {
								
								winner(removeAndMax(card, cardFormat[1][0]),
										removeAndMax(card2, cardFormat2[1][0]));
							}else {
								winner(cardFormat[1][0],cardFormat2[1][0]);
							}
						
					}	
			}
			
		}
		
	} 
	
	/*
	 * Remueve carta repetida y devuelve carta maxima
	 * */
	public final static int removeAndMax(List<Card> card , int i){
		
		return  card.stream().mapToInt(x -> x.getNum()).filter(x -> x != i).max().getAsInt();
	}
	
	/*
	 * Remueve carta repetida y devuelve carta maxima
	 * */
	public final static int removeAndMax(List<Card> card , int i,int i2){
		
		return  card.stream().mapToInt(x -> x.getNum()).filter(x -> x != i && x != i2).max().getAsInt();
	}
	
	/*
	 * Remueve carta repetida y devuelve carta maxima
	 * */
	public final static int removeAndMax(List<Card> card , int i,int i2,int i3){
		
		return  card.stream().mapToInt(x -> x.getNum()).filter(x -> x != i && x != i2 && x != i3).max().getAsInt();
	}
	
	/*
	 * Metodo decide ganador por desempate
	 * */
	public final static void winner(int player1 , int player2) {

			
		if(player1 > player2) {
			game.sumDesempatePlayer1();
			game.sumPlayer1();
		}else if(player1 < player2) {
			game.sumDesempatePlayer2();
			game.sumPlayer2();
		}else {
			game.sumempateProceso();
		}
	}
}
