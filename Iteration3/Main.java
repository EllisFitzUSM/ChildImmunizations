import java.time.LocalDate;
import java.util.*;


/**
 * Basic Entry Point to Test Child Immunization Functionality
 *
 * @author Ellis Fitzgerald
 * @version March 31st 2025
 */
public class Main {

    public static void main(String[] args) {
        Clinic testClinic = new Clinic("Test Clinic", "123 Alphabet Rd");
        System.out.println(testClinic);
        ImmunizationPatient testPatient = new ImmunizationPatient("1", new Date(1,1,2025), "name", "opnum", "hinum", "ninum", "address", "f", 0, "1", null, 5.5);
        testClinic.addPatient(testPatient);
        testClinic.addVisit(new Visit(testPatient, LocalDate.of(2025, 4, 27), null));
        testClinic.recordImmunization(new Vaccine(1, "fake vaccine", null, 2, 3, 1, 0, "injection", "arm", null));
        System.out.println(testClinic.getImmunizationReport());
    }
}