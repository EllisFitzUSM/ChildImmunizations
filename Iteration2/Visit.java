import java.time.LocalDate;

/***
 * Visit.java
 * Visit class used by clinics when a patient comes in for a service.
 *
 * @author Ellis Fitzgerald
 * @version April 14th, 2025
 */
public class Visit {
    private Patient patient;
    private LocalDate visitDate;
    private Dosable[] dosesAdminstered;
}