import java.util.ArrayList;
import java.util.Scanner;

public class DeckOfCards {
    public static final Scanner scanner = new Scanner(System.in);
    public ArrayList<String> cardsDeck = new ArrayList<String>();

    /*
    Simply created a Welcome Message Method without any return type.
    */
    public void welcome() {
        System.out.println("Welcome to the gaming world of Deck of Cards");
    }

    /*
    In this method we have initialized the size of cards.
    In this I have created String type array of Suits and Ranks to store its value and initialize it.
    In this we are printing the size of card.
    In this method we are also printing all the possible combination of card.
    */
    public void deckOfCards() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Queen", "Ace"};
        int numOfCards = suits.length * ranks.length;
        System.out.println("\nNumber of cards in the deck is : " + numOfCards);
        // First we have to itterate for loop for ranks starting from index 0.
        for (int i = 0; i < ranks.length; i++) {
            // Now we have to ittreate the suits for all the indexes of ranks
            for (int j = 0; j < suits.length; j++) {
                cardsDeck.add(ranks[i] + "----->" + suits[j]);
            }
        }
        toDisplay(cardsDeck);
    }

    /*
    Created a display method to print the array list of cardsDeck.
    We are using for-each loop to print all the element of ArrayList.
    We are storing all the elements of cardsDeck arraylist in element.
    */
    public static void toDisplay(ArrayList<String> cardsDeck) {
        System.out.println("\nCards in Deck:");
        for (String element : cardsDeck) {
            System.out.println(element);
        }
        System.out.println();
    }

    /*
    In this we have to define no of players should be minimum 2 and maximum 4.
    So we have use if condition to define no of players.
    If no of player is not within the range then it will again call this method.
    */
    public void noOfPlayers() {
        System.out.print("\nEnter number of players minimum 2 , maximum 4 : ");
        int player = scanner.nextInt();
        if (player >= 2 && player <= 4) {
            System.out.println("\n" + player + " players will play the game");
            sequenceOfPlay(player);  // We are calling sequence method inside the if condition
        } else {
            System.out.println("Please enter number of players in the Range");
            noOfPlayers();
        }
        scanner.close(); // Closed the Scanner Object.
    }

    /*
    In this method we have defined the sequence of the player.
    We are itterating the loop till player input.
    */
    public void sequenceOfPlay(int player) {
        System.out.println("\nSequence of cards are below : ");
        toshuffle(cardsDeck, player);  // caling toShuffle Method inside it.
    }

    /*
    Created a method to shuffle the cards
    Shuffling the cards by using Math.random and storing it in temp variable of ArrayList
    Again we are assigning temp to cardDecck
    */
    public static ArrayList<String> toshuffle(ArrayList<String> cardsDeck, int player) {
        System.out.println("Shuffling the cards before Distribution");
        ArrayList<String> temp = new ArrayList<String>();
        while (!cardsDeck.isEmpty()) {
            int loc = (int) (Math.random() * cardsDeck.size());
            temp.add(cardsDeck.get(loc));
            cardsDeck.remove(loc);
        }
        cardsDeck = temp;
        toDisplay(cardsDeck); // To display the cards this method is called.
        cardDistribution(cardsDeck, player); // Calling Card Distribution method inside this method
        return cardsDeck;
    }

    /*
    Created a method for equal distribution of cards.
    Every player will be distributed 9 cards.
     */
    public static void cardDistribution(ArrayList<String> cardsDeck, int player) {
        // This loop will itterate for no of players
        for (int i = 0; i < player; i++) {
            System.out.print("\nPlayer " + (i + 1) + " got cards:\n");
            // This loop will itterate for no of cards for each player
            for (int j = 0; j < 9; j++) {
                System.out.print("\t" + cardsDeck.get(i+j*player));
            }
        }
        System.out.println();
    }
}
