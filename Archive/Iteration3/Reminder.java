/*
 * check to see if a patient is past the date for vaccination
 * and sends a reminder
 * Reminder.java
 * 
 * @author Gabrielle Akers
 * version: 4/14/2025
 */
import java.time.LocalDate;

/**
 * Reminder used to notify patients about a vaccine
 *
 * @author ?
 * @version April 17th, 2025
 */
public class Reminder {
	int vaccineID;
	LocalDate dueDate;
	LocalDate date;
	boolean vaccinated;
	boolean reminded;
	String remindStyle;
	
	/**
	 * Checks whether a reminder should be sent to the patient.
	 * A reminder is sent if:
	 * - The current date is after the due date.
	 * - The patient has not yet been vaccinated.
	 * - No reminder has been sent yet.
	 * 
	 * The reminder is sent according to the remindStyle (email, text, or phone call).
	 * After sending, the reminded flag is set to true.
	 */
	public void isReminded() {
		if(date.isAfter(dueDate) && !vaccinated && !reminded) {
			remindStyle.toLowerCase();
			if(remindStyle.equals("email")) {
				System.out.println("Email sent");
			}
			else if(remindStyle.equals("text")) {
				System.out.println("Text sent");
			}
			else {
				System.out.println("Called");
			}
			reminded = true;
		}
	}
}
