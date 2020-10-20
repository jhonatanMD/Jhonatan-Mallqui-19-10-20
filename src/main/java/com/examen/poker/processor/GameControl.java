package com.examen.poker.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import com.examen.poker.util.Constant;

public class GameControl {
	
		static File archivo = null;
		static  FileReader fr = null;
		static  BufferedReader br = null;
		static String valor;
		static int rows;
		
		public static void main(String ... arg) {
	
			
	      try {
	         archivo = new File (Constant.fileRead);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         String linea;
	         while((linea=br.readLine())!=null)
	       
	         if(linea.trim().length() == Constant.lengthRow){ 
	        	 String[] card = linea.split(" ");
	        	 if(Constant.inputValidation(card) == 20) {
	        		 PlaysCard.runner(linea.substring(0,15).trim(),linea.substring(15,29).trim());
	        		 rows++;
	        	 }else {
	        		 throw new Exception("Mal Formato en lineas de Archivo");
	        	 }
	         
	         }else {	        	 
	        	 throw new Exception("Mal Formato en lineas de Archivo");
	         }

	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
		
			
			try {
	            PrintWriter writer = new PrintWriter(Constant.fileWrite ,"UTF-8");
	            writer.println("PUNTAJES SEGUN LAS MANOS DE CARTAS:\n");
	            writer.println("Player 1 : "+ControlCase.game.getPlayer1());
	            writer.println("Player 2 : "+ControlCase.game.getPlayer2());
	            writer.println("Empates por cada jugada :"+ControlCase.game.getEmpate()+"\n");
	            writer.println("Player 1 Gana empate por carta mayor : "+ControlCase.game.getDesempatePlayer1());
	            writer.println("Player 2 Gana empate por carta mayor : "+ControlCase.game.getDesempatePlayer2()+"\n");
	            writer.println("---------PLAYER 1 --------- | ------ PLAYER 2 --------------\r\n" + 
	            		"         "+(Double.valueOf(ControlCase.game.getDesempatePlayer1())*100/rows)+"%                "
	            				+ "|       "+(Double.valueOf(ControlCase.game.getDesempatePlayer2())*100/rows)+" %\r\n" + 
	            		"");
	            writer.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
				System.out.println("Proceso finalizado revisar archivo creado en src/main/resources/files/OutputFilePoker.txt");
			}
	}
	
	
	
	
	
	
	
}
