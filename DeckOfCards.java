    import java.util.ArrayList;
    import java.util.Scanner;

    public class DeckOfCards {

        public ArrayList<String> cardsDeck = new ArrayList<>();

        public static final Scanner scanner = new Scanner(System.in);

       /*
        UC1:- Setup the initial game with deck of cards and make sure we have unique cards.
         */

        public void deckOfCards() {

            String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

            String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Queen", "Ace"};

            int numOfCards = suits.length * ranks.length;

            System.out.println("\nNumber of cards in the deck is : " + numOfCards);

            // First we have to iterate for loop for ranks starting from index 0.
            for (int i = 0; i < ranks.length; i++) {

                for (int j = 0; j < suits.length; j++) {

                    cardsDeck.add(ranks[i] + "----->" + suits[j]);
                }
            }

            toDisplay(cardsDeck);
        }
        public static void toDisplay(ArrayList<String> cardsDeck) {

            System.out.println("\nCards in Deck:");

            for (String element : cardsDeck) {

                System.out.println(element);

            }

            System.out.println();
        }
        /*
        UC2 To add no of players in the game
         */


            public void noOfPlayers() {

                System.out.print("\nEnter number of players minimum 2 , maximum 4 : ");

                int player = scanner.nextInt();

                if (player >= 2 && player <= 4) {

                    System.out.println("\n" + player + " players will play the game");

                }
                else {

                    System.out.println("Please enter number of players in the Range");

                    noOfPlayers();

                }

                scanner.close(); // Closed the Scanner Object.

            }
            /*
            Use Case 3:-Add the method to sequence the player
            */
            public void sequenceOfPlay(int player) {

                System.out.println("\nSequence of cards are below : ");

                toshuffle(cardsDeck, player);                      // caling toShuffle Method inside it.

            }

            public ArrayList<String> toshuffle(ArrayList<String> cardsDeck, int player) {

                System.out.println("Shuffling the cards before Distribution");

                ArrayList<String> temp = new ArrayList<>();

                while (!cardsDeck.isEmpty()) {

                    int loc = (int) (Math.random() * cardsDeck.size());

                    temp.add(cardsDeck.get(loc));

                    cardsDeck.remove(loc);

                }

                cardsDeck = temp;

                toDisplay(cardsDeck);                            // To display the cards this method is called.

                cardDistribution(cardsDeck, player);             // Calling Card Distribution method inside this method

                return cardsDeck;

            }
              /*
            Use Case 4:-Created a method for equal distribution of cards.
            Every player will be distributed 9 cards.
            */
              public static void cardDistribution(ArrayList<String> cardsDeck, int player) {
                  // This loop will itterate for no of players
                  for (int i = 0; i < player; i++) {
                      System.out.print("\nPlayer " + (i + 1) + " got cards:\n");
                      // This loop will itterate for no of cards for each player
                      for (int j = 0; j < 9; j++) {
                          System.out.print("\t" + cardsDeck.get(i + j * player));
                      }
                  }
                  System.out.println();
              }
        }
