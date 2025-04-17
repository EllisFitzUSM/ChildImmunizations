/**
 * Return.java
 * Represents the Monthly Immunization Return record for a clinic.
 * Outputs a formatted report matching the Ghana Health Service template.
 *
 * @author Abdirahman Mohamed
 * April 17, 2025
 */
public class Return {
    /** 
    * The name of the immunization centre or clinic. 
    */
    private String immunizationCentre;

    /** 
    * The metro or city area of the clinic. 
    */
    private String metro;

    /** 
    * The administrative region of the clinic. 
    */
    private String region;

    /** 
    * The reporting month (e.g., "April 2025"). 
    */
    private String month;

    /** 
    * Total doses of vaccine administered during the month. 
    */
    private int totalDosesAdministered;

    /** 
    * Total doses of vaccine used from stock. 
    */
    private int totalDosesUsed;

    /** 
    * Vaccine wastage rate as a percentage. 
    */
    private double wastageRate;

    /** 
    * Number of Vitamin A deficiency cases recorded. 
    */
    private int vitaminADeficiency;

    /** 
    * Number of adverse events following Vitamin A supplementation. 
    */
    private int vitaminAAEFIReported;

    /** 
    * Number of safety boxes used for sharps disposal. 
    */
    private int safetyBoxesUsed;

    /** 
    * Number of safety boxes disposed via incineration. 
    */
    private int safetyBoxesDisposedIncinerator;

    /** 
    * Number of safety boxes disposed in pits. 
    */
    private int safetyBoxesDisposedPit;

    /**
     * Constructs a new Return record with all required fields.
     *
     * @param immunizationCentre            Name of the immunization centre
     * @param metro                         Metro or city area
     * @param region                        Administrative region
     * @param month                         Reporting month
     * @param totalDosesAdministered        Total doses administered
     * @param totalDosesUsed               Total doses used from stock
     * @param wastageRate                   Wastage rate percentage
     * @param vitaminADeficiency            Recorded Vitamin A deficiency cases
     * @param vitaminAAEFIReported          Recorded adverse events for Vitamin A
     * @param safetyBoxesUsed               Number of safety boxes used
     * @param safetyBoxesDisposedIncinerator Number disposed via incinerator
     * @param safetyBoxesDisposedPit        Number disposed in pits
     */
    public Return(
        String immunizationCentre,
        String metro,
        String region,
        String month,
        int totalDosesAdministered,
        int totalDosesUsed,
        double wastageRate,
        int vitaminADeficiency,
        int vitaminAAEFIReported,
        int safetyBoxesUsed,
        int safetyBoxesDisposedIncinerator,
        int safetyBoxesDisposedPit
    ) {
        this.immunizationCentre = immunizationCentre;
        this.metro = metro;
        this.region = region;
        this.month = month;
        this.totalDosesAdministered = totalDosesAdministered;
        this.totalDosesUsed = totalDosesUsed;
        this.wastageRate = wastageRate;
        this.vitaminADeficiency = vitaminADeficiency;
        this.vitaminAAEFIReported = vitaminAAEFIReported;
        this.safetyBoxesUsed = safetyBoxesUsed;
        this.safetyBoxesDisposedIncinerator = safetyBoxesDisposedIncinerator;
        this.safetyBoxesDisposedPit = safetyBoxesDisposedPit;
    }

    /** 
    * @return the immunization centre or clinic name 
    */
    public String getImmunizationCentre() {
        return immunizationCentre;
    }

    /** 
    * @param immunizationCentre the immunization centre to set 
    */
    public void setImmunizationCentre(String immunizationCentre) {
        this.immunizationCentre = immunizationCentre;
    }

    /** 
    * @return the metro or city area 
    */
    public String getMetro() {
        return metro;
    }

    /** 
    * @param metro the metro to set 
    */
    public void setMetro(String metro) {
        this.metro = metro;
    }

    /**
    * @return the administrative region 
    */
    public String getRegion() {
        return region;
    }

    /** 
    * @param region the region to set 
    */
    public void setRegion(String region) {
        this.region = region;
    }

    /** 
    * @return the reporting month 
    */
    public String getMonth() {
        return month;
    }

    /** @param month the month to set */
    public void setMonth(String month) {
        this.month = month;
    }

    /** 
    * @return total doses administered 
    */
    public int getTotalDosesAdministered() {
        return totalDosesAdministered;
    }

    /** 
    * @param totalDosesAdministered the total doses administered to set 
    */
    public void setTotalDosesAdministered(int totalDosesAdministered) {
        this.totalDosesAdministered = totalDosesAdministered;
    }

    /** 
    * @return total doses used 
    */
    public int getTotalDosesUsed() {
        return totalDosesUsed;
    }

    /** 
    * @param totalDosesUsed the total doses used to set 
    */
    public void setTotalDosesUsed(int totalDosesUsed) {
        this.totalDosesUsed = totalDosesUsed;
    }

    /** 
    * @return the wastage rate percentage 
    */
    public double getWastageRate() {
        return wastageRate;
    }

    /** 
    * @param wastageRate the wastage rate to set 
    */
    public void setWastageRate(double wastageRate) {
        this.wastageRate = wastageRate;
    }

    /** 
    * @return number of Vitamin A deficiency cases 
    */
    public int getVitaminADeficiency() {
        return vitaminADeficiency;
    }

    /** 
    * @param vitaminADeficiency the deficiency count to set 
    */
    public void setVitaminADeficiency(int vitaminADeficiency) {
        this.vitaminADeficiency = vitaminADeficiency;
    }

    /** 
    * @return number of AEFI reported 
    */
    public int getVitaminAAEFIReported() {
        return vitaminAAEFIReported;
    }

    /** 
    * @param vitaminAAEFIReported the AEFI count to set 
    */
    public void setVitaminAAEFIReported(int vitaminAAEFIReported) {
        this.vitaminAAEFIReported = vitaminAAEFIReported;
    }

    /** 
    * @return safety boxes used 
    */
    public int getSafetyBoxesUsed() {
        return safetyBoxesUsed;
    }

    /** 
    * @param safetyBoxesUsed the safety boxes used to set 
    */
    public void setSafetyBoxesUsed(int safetyBoxesUsed) {
        this.safetyBoxesUsed = safetyBoxesUsed;
    }

    /** 
    * @return disposed via incinerator count 
    */
    public int getSafetyBoxesDisposedIncinerator() {
        return safetyBoxesDisposedIncinerator;
    }

    /** 
    * @param safetyBoxesDisposedIncinerator the incinerator count to set 
    */
    public void setSafetyBoxesDisposedIncinerator(int safetyBoxesDisposedIncinerator) {
        this.safetyBoxesDisposedIncinerator = safetyBoxesDisposedIncinerator;
    }

    /** 
    * @return disposed in pits count 
    */
    public int getSafetyBoxesDisposedPit() {
        return safetyBoxesDisposedPit;
    }

    /** 
    * @param safetyBoxesDisposedPit the pit disposal count to set 
    */
    public void setSafetyBoxesDisposedPit(int safetyBoxesDisposedPit) {
        this.safetyBoxesDisposedPit = safetyBoxesDisposedPit;
    }

    /**
     * Returns a detailed report in Ghana Health Service IM MONTHLY RETURNS format.
     *
     * @return the formatted report string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GHANA HEALTH SERVICE\n");
        sb.append("IMMUNIZATION MONTHLY RETURNS\n\n");
        sb.append("Immunization Centre/Clinic: ").append(immunizationCentre).append("\n");
        sb.append("Metro: ").append(metro).append("\n");
        sb.append("Region: ").append(region).append("\n");
        sb.append("For the month of: ").append(month).append("\n\n");
        sb.append("| Disease          | Vaccine | No. of doses | 0-11 Months | 12-23 Months | 24+ Months | Total Administered | 2 doses | 5 doses | 10 doses | 20 doses | Used | Wastage % |");
        sb.append("|------------------|---------|--------------|-------------|--------------|------------|--------------------|---------|---------|----------|----------|------|-----------| ");
        sb.append(String.format("| %-16s | %-7s | %-12s | %-11s | %-12s | %-10s | %-18d | %-7s | %-7s | %-8s | %-8s | %-4d | %9.1f%% | ", "Summary", "--", "--", "--", "--", "--", totalDosesAdministered, "--", "--", "--", "--", totalDosesUsed, wastageRate));
        sb.append("\nVitamin A supplementation\n\n");
        sb.append("| Vitamin A Deficiency | 6-11 months | 12-59 months | Post-Partum |");
        sb.append("|----------------------|-------------|--------------|-------------|");
        sb.append(String.format("| Number               | %-11d | %-12s | %-11s | ", vitaminADeficiency, "--", "--"));
        sb.append(String.format("| AEFI reported        | %-11d | %-12s | %-11s | ", vitaminAAEFIReported, "--", "--"));
        sb.append("Injection safety and waste management\n\n");
        sb.append("| Description                                   | Count |");
        sb.append("|-----------------------------------------------|-------|");
        sb.append(String.format("| Safety boxes used                             | %5d |", safetyBoxesUsed));
        sb.append(String.format("| Safety boxes disposed (incinerator)           | %5d |", safetyBoxesDisposedIncinerator));
        sb.append(String.format("| Safety boxes disposed (pit)                   | %5d |", safetyBoxesDisposedPit));
        return sb.toString();
    }

    /**
     * Demonstrates Return instantiation and output.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Return sample = new Return(
            "City Clinic", "Metro Zone", "Central Region", "April 2025",
            500, 450, 10.0,
            5, 2, 20,
            15, 5
        );
        System.out.println(sample);
    }
}
