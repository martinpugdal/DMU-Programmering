package model;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.util.Random;

public class YatzyDice {
    // Face values of the 5 dice.
    // 1 <= values[i] <= 6 for i in [0..4]
    private int[] values = new int[5];

    // Number of times the 5 dice have been thrown.
    // 0 <= throwCount <= 3.
    private int throwCount = 0;

    // Random number generator.
    private final Random random = new Random();

    /**
     * Return the 5 face values of the dice.
     */
    public int[] getValues() {
        return values;
    }

    /**
     * Set the 5 face values of the dice.<br/>
     * Pre: 1 <= values[i] <= 6 for i in [0..4].<br/>
     * Note: This method is only to be used in tests.
     */
    void setValues(int[] values) {
        this.values = values;
    }

    /**
     * Return the number of times the 5 dice has been thrown.
     */
    public int getThrowCount() {
        return throwCount;
    }

    /**
     * Reset the throw count.
     */
    public void resetThrowCount() {
        // TODO
        throwCount = 0;
    }

    /**
     * Roll the 5 dice. Only roll dice that are not hold.<br/>
     * Note: holdStatus[index] is true, if die no. index is hold (for index in [0..4]).
     */
    public void throwDice(CheckBox[] cbxHolds) {
        // TODO
        for (int i = 0; i < cbxHolds.length; i++) {
            if (!cbxHolds[i].isSelected()) {
                getValues()[i] = random.nextInt(6)+1;
            }
        }
        throwCount++;
    }

    /**
     * Return all results possible with the current face values.<br/>
     * The order of the results is the same as on the score board.<br/>
     * Note: This is an optional method. Comment this method out,<br/>
     * if you don't want use it.
     */
    public int[] getResults() {
        int[] results = new int[15];
        for (int i = 0; i <= 5; i++) {
            results[i] = this.sameValuePoints(i + 1);
        }
        results[6] = this.onePairPoints();
        results[7] = this.twoPairPoints();
        results[8] = this.threeSamePoints();
        results[9] = this.fourSamePoints();
        results[10] = this.fullHousePoints();
        results[11] = this.smallStraightPoints();
        results[12] = this.largeStraightPoints();
        results[13] = this.chancePoints();
        results[14] = this.yatzyPoints();

        return results;
    }

    // Return an int[7] containing the frequency of face values.
    // Frequency at index v is the number of dice with the face value v, 1 <= v <= 6.
    // Index 0 is not used.
    // Note: This method can be used in several of the following methods.
    private int[] frequency() {
        //TODO
        int [] frequency = new int[7];
        for (int value : values) {
            frequency[value]++;
        }
        return frequency;
    }

    /**
     * Return same-value points for the given face value.<br/>
     * Returns 0, if no dice has the given face value.<br/>
     * Pre: 1 <= value <= 6;
     */
    public int sameValuePoints(int value) {
        // TODO
        return frequency()[value]*value;
    }

    /**
     * Return points for one pair (for the face value giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value.
     */
    public int onePairPoints() {
        // TODO
        int pairPoints = 0;
        int[] frequency = frequency();
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] >= 2 && frequency[i] < 4) {
                pairPoints = i;
            }
        }
        return pairPoints * 2;
    }

    /**
     * Return points for two pairs<br/>
     * (for the 2 face values giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int twoPairPoints() {
        // TODO
        int points = 0;
        int pair1Points = onePairPoints()/2;
        int[] frequency = frequency();
        for (int i = 0; i < pair1Points; i++) {
            if (frequency[i] >= 2 && frequency[i] < 4) {
                points = (pair1Points + i) * 2;
            }
        }
        return points;
    }

    /**
     * Return points for 3 of a kind.<br/>
     * Return 0, if there aren't 3 dice with the same face value.
     */
    public int threeSamePoints() {
        // TODO
        int threeSamePoints = 0;
        int[] frequency = frequency();
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] >= 3) {
                threeSamePoints = i * 3;
            }
        }
        return threeSamePoints;
    }

    /**
     * Return points for 4 of a kind.<br/>
     * Return 0, if there aren't 4 dice with the same face value.
     */
    public int fourSamePoints() {
        // TODO
        int fourSamePoints = 0;
        int[] frequency = frequency();
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] >= 4) {
                fourSamePoints = i * 4;
            }
        }
        return fourSamePoints;
    }

    /**
     * Return points for full house.<br/>
     * Return 0, if there aren't 3 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int fullHousePoints() {
        // TODO
        int fullHousePoints = 0;
        int threeSamePoints = 0;
        int pairPoints = 0;
        int[] frequency = frequency();
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] >= 3) {
                threeSamePoints = i;
            }
        }
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] >= 2 && threeSamePoints != i) {
                pairPoints = i;
            }
        }
        if (threeSamePoints != 0 && pairPoints != 0) {
            fullHousePoints = (threeSamePoints * 3) + (pairPoints * 2);
        }
        return fullHousePoints;
    }

    /**
     * Return points for small straight.<br/>
     * Return 0, if the dice aren't showing 1,2,3,4,5.
     */
    public int smallStraightPoints() {
        // TODO
        int smallStraightPoints = 0;
        int[] frequency = frequency();
        if (frequency[1] == 1 && frequency[2] == 1 && frequency[3] == 1 && frequency[4] == 1 && frequency[5] == 1) {
            smallStraightPoints = 1+2+3+4+5;;
        }
        return smallStraightPoints;
    }

    /**
     * Return points for large straight.<br/>
     * Return 0, if the dice aren't showing 2,3,4,5,6.
     */
    public int largeStraightPoints() {
        // TODO
        int largeStraightPoints = 0;
        int[] frequency = frequency();
        if (frequency[2] == 1 && frequency[3] == 1 && frequency[4] == 1 && frequency[5] == 1 && frequency[6] == 1) {
            largeStraightPoints = 20;
        }
        return largeStraightPoints;
    }

    /**
     * Return points for chance (the sum of face values).
     */
    public int chancePoints() {
        // TODO
        int chancePoints = 0;
        for (int face : getValues()) {
            chancePoints += face;
        }
        return chancePoints;
    }

    /**
     * Return points for yatzy (50 points).<br/>
     * Return 0, if there aren't 5 dice with the same face value.
     */
    public int yatzyPoints() {
        // TODO
        int yatzyPoints = 0;
        int[] frequency = frequency();
        for (int freqNum : frequency) {
            if (freqNum == 5) {
                yatzyPoints = 50;
            }
        }
        return yatzyPoints;
    }
}
