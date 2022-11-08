/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.curso.pokemoncasigo;

import java.util.Scanner;

/**
 *
 * @author mjimen19
 */
public class PokemonCasiGo {

    private static final GameManager game = new GameManager();
    
    public static void main(String[] args) {
        
        System.out.println("Game starts!");
        System.out.println("Enter a command to play:");
        System.out.println("Commands:");
        System.out.println("1 -> Train your Pokemon");
        System.out.println("2 -> Catch a new Pokemon");
        System.out.println("3 -> Combat with a wild Pokemon");
        System.out.println("4 -> Check your current Pokemon");
        System.out.println("5 -> Help");
        System.out.println("exit -> Ends the game");
        
        Scanner sc = new Scanner(System.in);
        String command;
        do{
            System.out.println("Enter a command");
            command = sc.nextLine();
            
            switch(command){
                case "1" -> commandTraining(sc);
                case "2" -> commandCatch();
                case "3" -> commandCombat(sc);
                case "4" -> commandCheckPokemon();
            }
            
        }while(!command.equals("exit"));
        
    }
    
    private static void commandTraining(Scanner sc){
        System.out.println("Select a Pokemon to train:");
        System.out.println(game.getPlayerPokemonDataString());
        int command = 0;
        try{
            command = sc.nextInt();
            game.trainPokemon(command);
        }catch(Exception e){
            System.out.println("Error at selecting the command");
        }    
        
    }
    
    private static void commandCatch(){
        Pokemon pokeCatch = game.catchRandomPokemon();
        if(pokeCatch == null){
            System.out.println("You can't catch a new Pokemon because your team are full");
        }else{
            System.out.println("Congratulations! You catched a " + pokeCatch.getName());
        }
    }
    
    private static void commandCombat(Scanner sc){
        System.out.println("Select a Pokemon to send to the combat:");
        System.out.println(game.getPlayerPokemonDataString());
        int command = 0;
        try{
            command = sc.nextInt();
            boolean isWin = game.combatPokemon(command);
            if(isWin){
                System.out.println("You win the combat!");
            }else{
                System.out.println("You lost the combat");
            }
        }catch(Exception e){
            System.out.println("Error at selecting the command");
        }    
    }
    
    private static void commandCheckPokemon(){
        System.out.println(game.getPlayerPokemonDataString());
    }
}
