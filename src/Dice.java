// Dice.java
// Class representing a dice used in the battle simulation
public class Dice {

    private int sides; // The number of sides on the dice

    /**
     * Constructor to create a dice object.
     * @param sides The number of sides on the dice (default is 6).
     */
    public Dice(int sides) {
        // If no sides are provided, default to a 6-sided dice
        if (sides <= 0) {
            this.sides = 6;
        } else {
            this.sides = sides;
        }
    }

    /**
     * Simulates rolling the dice, returning a random integer between 1 and the number of sides.
     * @return The result of the dice roll.
     */
    public int roll() {
        // Generate a random number between 1 and `sides`.
        // `Math.random()` generates a value in the range [0, 1),
        // multiplying it by `sides` ensures it spans [0, sides),
        // adding 1 ensures it starts from 1, and casting to int removes the decimal part.
        return (int) (Math.random() * sides) + 1;
    }

    // Main method to demonstrate the dice roll
    public static void main(String[] args) {
        Dice dice = new Dice(6);  // Create a 6-sided dice
        System.out.println("Rolling the dice: " + dice.roll());
    }
}
