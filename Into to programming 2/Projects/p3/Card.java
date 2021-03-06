package proj3;

/**
 * This class models the Cards used in the Deck.java class
 * Class Invariants:
 *   - None
 * @version 11/02/13
 * @author Joseph Wenzel <jwenzel1@umbc.edu>
 * @project CMSC 202 - Fall 2013 - Project 3
 * @section 06
 */
public class Card {
	
	private Rank rank;
	private Suit suit;
	
	/**
     * Constructor - creates a new Card instance
     * Preconditions: None
     * Postconditions: A Card object is created with the given rank and suit values
     * @param rank the rank of the card ex. ace, king, queen, jack, ten, nine, etc.
     * @param suit the suit of the card ex. spades, hearts, etc.
     */
	public Card(Rank rank, Suit suit){
		this.rank = rank;
		this.suit = suit;
	}
	
	 /**
     * Creates a string telling the cards rank and suit
     * Preconditions: None
     * Postconditions: A string describing the card is returned
     * @return a string saying what the current cards rank and suit are.
     */
	public String toString(){
		String output = rank.getName().toLowerCase() + " of " + suit.getName();
		return output;
	}
	
	 /**
     * Gets the rank of the card
     * Preconditions: None
     * Postconditions: Card's rank is returned
     * @return the rank of the current card
     */
	public Rank getRank() {
		return rank;
	}
	
	 /**
     * Gets the suit of the card
     * Preconditions: None
     * Postconditions: Card's suit is returned
     * @return the suit of the current card
     */
	public Suit getSuit() {
		return suit;
	}
	public static void main(String[] args){
		Card card = new Card(Rank.ACE, Suit.SPADES);
		System.out.println("testing getRank()");
		System.out.println(card.getRank());
		System.out.println("testing getSuit()");
		System.out.println(card.getSuit());
		System.out.println("testing toString()");
		System.out.println(card);
	}
}

