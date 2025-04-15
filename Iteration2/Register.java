/*
 * Register.java
 * @author:Milo Keys
 * @version:
 * Represents a the Register returns required for Ghana clinics.
 * This class holds data for each for patient visits.
 */

 import java.time.LocalDate;
 import java.time.format.DateTimeFormatter;

 public class Register {
     static final DateTimeFormatter DATEFORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

     LocalDate dateOfVisit;
     int childID;
     String name;
     String motherName;
     int parity;
     String address;
     LocalDate registered; //Date Registered 
     LocalDate DOB;
     char sex;
     double weight;
 
     public Register(
             LocalDate dateOfVisit, int childID,
             String name, String motherName,
             int parity, String address,
             LocalDate registered, LocalDate DOB,
             char sex, double weight) {
 
         this.dateOfVisit = dateOfVisit;
         this.childID = childID;
         this.name = name;
         this.motherName = motherName;
         this.parity = parity;
         this.address = address;
         this.registered = registered;
         this.DOB = DOB;
         this.sex = sex;
         this.weight = weight;
     }
 
     /**
      * @return the date of visit
      */
     public LocalDate getDateOfVisit() {
         return dateOfVisit;
     }
 
     /**
      * @param dateOfVisit the date of visit to set
      */
     public void setDateOfVisit(LocalDate dateOfVisit) {
         this.dateOfVisit = dateOfVisit;
     }
 
     /**
      * @return the child ID
      */
     public int getChildID() {
         return childID;
     }
 
     /**
      * @param childID the child ID to set
      */
     public void setChildID(int childID) {
         this.childID = childID;
     }
 
     /**
      * @return the name of the child
      */
     public String getName() {
         return name;
     }
 
     /**
      * @param name the name of the child to set
      */
     public void setName(String name) {
         this.name = name;
     }
 
     /**
      * @return the mother's name
      */
     public String getMotherName() {
         return motherName;
     }
 
     /**
      * @param motherName the mother's name to set
      */
     public void setMotherName(String motherName) {
         this.motherName = motherName;
     }
 
     /**
      * @return the parity (number of pregnancies)
      */
     public int getParity() {
         return parity;
     }
 
     /**
      * @param parity the parity (number of pregnancies) to set
      */
     public void setParity(int parity) {
         this.parity = parity;
     }
 
     /**
      * @return the address
      */
     public String getAddress() {
         return address;
     }
 
     /**
      * @param address the address to set
      */
     public void setAddress(String address) {
         this.address = address;
     }
 
     /**
      * @return the registration date
      */
     public LocalDate getRegistered() {
         return registered;
     }
 
     /**
      * @param registered the registration date to set
      */
     public void setRegistered(LocalDate registered) {
         this.registered = registered;
     }
 
     /**
      * @return the date of birth
      */
     public LocalDate getDOB() {
         return DOB;
     }
 
     /**
      * @param DOB the date of birth to set
      */
     public void setDOB(LocalDate DOB) {
         this.DOB = DOB;
     }
 
     /**
      * @return the sex of the child (M/F)
      */
     public char getSex() {
         return sex;
     }
 
     /**
      * @param sex the sex of the child (M/F) to set
      */
     public void setSex(char sex) {
         this.sex = sex;
     }
 
     /**
      * @return the weight of the child
      */
     public double getWeight() {
         return weight;
     }
 
     /**
      * @param weight the weight of the child to set
      */
     public void setWeight(double weight) {
         this.weight = weight;
     }
     
     /**
      * returns the string representation of a Register
      */
     @Override
     public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getDateOfVisit().format(DATEFORMAT)).append(" ");
        str.append(String.format("%-4d", getChildID())).append(" ");
        str.append(String.format("%-15s",getName())).append(" ");
        str.append(String.format("%-15s",getMotherName())).append(" ");
        str.append(String.format("%-2d",getParity())).append(" ");
        str.append(String.format("%-45s",getAddress())).append(" ");
        str.append(getRegistered().format(DATEFORMAT)).append(" ");
        str.append(getDOB().format(DATEFORMAT)).append(" ");
        str.append(getSex()).append(" ");
        str.append(String.format("%.2f",getWeight()));
         return str.toString();
     }
     public static void main(String[] args) {
        Register test = new Register(LocalDate.of(2025, 4, 15), 100,
                         "John Matworth", "Alice Matworth", 1, "1328 SW 21st St " + //
                        "Blue Springs, Missouri, 64015", LocalDate.of(2020, 1, 20),
                        LocalDate.of(2019, 8, 9), 'M', 55.51);
        Register test2 = new Register(LocalDate.of(2022, 4, 15), 500,
            "Alex Smith", "Jenna Smith", 1, "4258 NE 4st St " + //
        "Blue Springs, MOcl, 8924015", LocalDate.of(2020, 1, 20),
        LocalDate.of(2014, 10, 4), 'F', 70.9123132512333551);
        System.out.println(test);
        System.out.println(test2);
    }
 }