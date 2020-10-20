package com.examen.poker.processor;

import java.util.Arrays;

import com.examen.poker.util.Constant;


public final class PlaysCard {

	/*
	 * Este metodo llama cada jugada mandandole 
	 * como parametro las cartas de cada jugador
	 * 
	 * */
	public static void runner(String cards , String cards2) {			
			
		
			int Player1 = score(cards);
			int Player2 = score(cards2);
			
			// Evalua las jugadas de cada mano de jugadores 
			// gana uno o se va al desempate segun la carta mayor
			if(Player1 > Player2) {
				ControlCase.game.sumPlayer1();
			}else if(Player1 < Player2) {
				ControlCase.game.sumPlayer2();
			}else {
				
				ControlCase.game.sumEmpate();
				
				//Evalua cartas mayores de cada jugador sino enuncia un empate
				switch (Player1) {
				case 9:
					ControlCase.sum(ControlCase.convertStringCard(cards), ControlCase.convertStringCard(cards2));
					break;
				case 8:
					ControlCase.process(ControlCase.convertStringCard(cards), ControlCase.convertStringCard(cards2));
					break;
				case 7:
					ControlCase.process(ControlCase.convertStringCard(cards), ControlCase.convertStringCard(cards2));
					break;
				case 6:
					ControlCase.bigNumber(ControlCase.convertStringCard(cards), ControlCase.convertStringCard(cards2));
					break;
				case 5:
					ControlCase.sum(ControlCase.convertStringCard(cards), ControlCase.convertStringCard(cards2));
					break;
				case 4:
					ControlCase.process(ControlCase.convertStringCard(cards), ControlCase.convertStringCard(cards2));
					break;
				case 3:
					ControlCase.process(ControlCase.convertStringCard(cards), ControlCase.convertStringCard(cards2));
					break;
				case 2:
					ControlCase.process(ControlCase.convertStringCard(cards), ControlCase.convertStringCard(cards2));
					break;
				case 1:
					ControlCase.bigNumber(ControlCase.convertStringCard(cards), ControlCase.convertStringCard(cards2));
					break;
				default:
					ControlCase.game.sumEmpate();
					break;
				}
			}
			
		}
		
		/*
		 * Metodo llama la jugada 
		 * segun la mano del jugador
		 * 
		 * */
		public static int score(String cards) {
			
				if(isRoyalFlush(cards)) { // Escalera Real
					return 10;
				}
				else  if(isStraightFlush(cards)) { // Escalera y Colores
					return 9;
				}
				else if (isFourOfAKind(cards)) { // Poker(4 Iguales)
		            return 8;
		        } else  if (isFullHouse(cards)) { // 3 Iguales y 2 Iguales
		            return 7;
		        } else if (isFlush(cards)) { // Simbolos Iguales
		            return 6;
		        } else if (isStraight(cards)) { //Escalera
		           return 5;
		        } else if (isThreeOfAKind(cards)) { // 3 Iguales
		            return 4;
		        } else if (isTwoPair(cards)) { // 2 Pares
		            return 3;
		        } else if (isPair(cards)) { // 1 Par
		            return 2;
		        } else {
		            return 1; // Carta Mayor
		        }
		}
		
		/*
		 * Metodo para saber si la mano es Par
		 * */
		 public static boolean isPair(String card) {
			 
		        for (String rank : Constant.RANKS) {
		            int count = countOccurences(card, rank);
		            {
		                if (count >= 2) {
		                    return true;
		                }
		            }
		        }
		        return false;
		    }
		
		 /*
			 * Metodo para saber si la mano es 2 Pares
			 * 
			 * */
		 public static boolean isTwoPair(String cards) { 
	
		        for (String rankA : Constant.RANKS) { 
		            int countA = countOccurences(cards, rankA); 
		            for (String rankB : Constant.RANKS) { 
		                int countB = countOccurences(cards, rankB); 
		                if ((!rankA.equals(rankB)) && countA >= 2 && countB >= 2) {
		                   
		                    return true; 
		                }
		            }
		        }
		        return false; 
		    }
		 
		 /*
		  * Metodo para saber si la mano es 3 iguales
		  *
		  * */
		 public static boolean isThreeOfAKind(String cards) { 
	
		        for (String rank : Constant.RANKS) {
		            if (countOccurences(cards, rank) >= 3) { 
		                return true; 
		            }
		        }
	
		        return false; 
	
		    }
		 
		 /*
		 * Metodo para saber si la mano es Simbolos iguales
		 */
		public static boolean isFlush(String cards) {
	
	        
	
	
	        for (String tempChar : Constant.SUITS) { 
	            int count = countOccurences(cards, tempChar);
	
	            if (count >= 5) { 
	                return true;
	            }
	        }
	        return false; 
	    }
		
		/*
		 * Metodo para saber si la mano es Escalera
		 * 
		 * 
		 */
		public static boolean isStraight(String cards) {
			
			String[] c = cards.split(" ");
			
			
			int[] number = new int[5];
			
			for(int i = 0 ; i < c.length ; i++) {
				
				number[i] = Constant.inputKey(c[i].substring(0,1));
			
			}
			
			Arrays.sort(number);
			
			int n = 1;	
			for(int i = 0 ; i < number.length - 1 ; i++) {
				
				if(number[i] + 1 == number[i + 1]) {
					n++;
				}
			}
			
			if(n == 5) {
				
				return true;
			}
			
			return false;
		}
		
		
		/*
		 * Metodo para saber si la mano tiene 3 iguales y 2 pares
		 * 
		 * */
		public static boolean isFullHouse(String cards) { 
	
	        for (int indexA = 1; indexA <= 13; indexA++) {
	            String converted = intToRank(indexA);
	
	            int countA = countOccurences(cards, converted);
	
	            
	            for (int indexB = 1; indexB <= 13; indexB++) {
	
	                if (indexB == indexA) { 
	                    indexB++;
	                }
	                String convertedB = intToRank(indexB);
	
	                int countB = countOccurences(cards, convertedB);
	
	                if ((countA >= 3 && countB >= 2) || (countA >= 2 && countB >= 3)) {
	                	
	                	return true;
	                }
	            }
	        }
	
	        return false; 
	
	    }
		
		
		/*
		 * Metodo para saber si la mano tiene 4 iguales 
		 * 
		 */
		public static boolean isFourOfAKind(String cards) { 
	
	        for (String rank : Constant.RANKS) {
	
	            if (countOccurences(cards, rank) == 4) { 
	                return true;
	            }
	        }
	        return false; 
	    }
		
		/*
		 * Metodo para saber si la mano tiene escalera y simbolos iguales
		 * 
		 */
		public static boolean isStraightFlush(String cards) { 
	        return isStraight(cards) && isFlush(cards); 
	    }
		
		
		/*
		 * Metodo para saber si la mano es escalera de 10 a 14 y simbolos iguales
		 * 
		 **/
		public static boolean isRoyalFlush(String cards) {
			
			int count = 0;
			
			String[] c = cards.split(" ");
			
			int[] number = new int[5];
			
				
			for(int i = 0 ; i < c.length ; i++) {
				
				number[i] = Constant.inputKey(c[i].substring(0,1));
			
			}
			
				
			for(int i = 0 ; i < number.length; i++) {
				
				count += number[i];
			}
			
			
			if(count == 60 && isFlush(cards)) {
				
				return true;
			}
			
			return false;
			
		}
		
		/*
		 * Metodo para saber las concurrencias de datos segun la mano
		 * */
		public static int countOccurences(String haystack, String needle) {
			
	        return haystack.length() - haystack.replace(needle, "").length();
	    
		}
		
		
		/*
		 * Metodo de connversión por numero de carta
		 * */
		public static String intToRank(int old) {
	        String converted = "";
	        switch (old) {
	        
	            case 10:
	                converted = "T";
	                break;
	            case 11:
	                converted = "J";
	                break;
	            case 12:
	                converted = "Q";
	                break;
	            case 13:
	                converted = "K";
	                break;
	            case 14:
	                converted = "A";
	            default: 
	                converted = String.valueOf(old);
	        }
	        return converted;
	    }
	
}
