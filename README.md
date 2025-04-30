# Child Immunizations

## Goals:
1. Develop a data entry system to replace/ease the use of the <b>Ghana Health Service Immunization Register</b>
2. Provide an improved way of presenting <b>Immunization Returns reports</b>
3. Develop a system to alert CHO's of immunization needs

## Development Team
**Team Lead**
| Mason Beale |
|--------|

**Team Members**  
| Team 1 | Abdirahman Mohamed | Ellis Fitzgerald |
|--------|--------|--------|
| Team 2 | Milo Keys | Gabrielle Akers |

## Organization
Each iterations code is stored in a separate fold in Archive. iterations has the java code, use-cases, and a UML diagram. The documentation fold stores example for our monthly returns.

## Code Documentation
**Class Header Example**
```java
/**
* ImmunizationRecord.java
* Manages patient immunization history and status tracking.
* Handles data validation and database interactions.
*
* @author Mason Beale
* @version 03/15/2024
*/
```
**Method Documentation Example**
```java
/**
* Calculates immunization due dates based on birth date
* 
* @param birthDate LocalDate patient's date of birth
* @param vaccineType String vaccine identifier code
* @return LocalDate calculated due date
* @throws InvalidVaccineTypeException for unsupported vaccine codes
*/
```
