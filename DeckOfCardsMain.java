package com.BridgeLab.WorkShop2.DataStructure.DeckOfCard;


public class DeckOfCardsMain {
	
    public static void main(String[] args) {
	    
	 /*
        In this I have created an object of DeckOfCardsGame class and just calling the method through object.
         */
	    
        DeckOfCards deckOfCardsGame = new DeckOfCards();
	    
        deckOfCardsGame.welcome();
	    
        deckOfCardsGame.deckOfCards();
	    
        deckOfCardsGame.noOfPlayers();
	    
        deckOfCardsGame.sequenceOfPlay(4);
	    
        deckOfCardsGame.toShuffle();
	    
    }
}
