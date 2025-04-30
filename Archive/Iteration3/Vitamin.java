/**
 * Vitamin.java
 * Vitamin child class to Dosable.
 *
 * @author Ellis Fitzgerald
 * @version April 17th, 2025
 */
public class Vitamin extends Dosable {
    double dosageMG;
    int vitaminNeeded;
    int deficient;

    /**
     * Determines whether the patient needs a vitamin
     * A patient is dosable if they are deficient in that vitamin
     *
     * @return true if condition is met, false otherwise
     */
    public boolean isDeficient() {
        if(vitaminNeeded >= deficient) {
            return true;
        }
        return false;
    }

    /**
     * Returns the dosage of the vitamin in milligrams.
     *
     * @return Dosage in milligrams.
     */
    public double getDosageMG() {
        return dosageMG;
    }
}
