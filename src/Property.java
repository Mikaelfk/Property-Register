/**
 * A class for storing all the information of a certain property
 */
public class Property {
    //Fields
    private final int municipalityNumber;
    private final String municipalityName;
    private final int lotNumber;
    private final int sectionNumber;
    private final String name;
    private final double area;
    private final String nameOfOwner;

    //Constructor
    Property(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, String name, double area, String nameOfOwner) {
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.name = name;
        this.area = area;
        this.nameOfOwner = nameOfOwner;
    }

    /**
     * This method prints out all the information of the property.
     */
    void printInfo() {
        System.out.println("Municipality Number: " + getMunicipalityNumber());
        System.out.println("Municipality Name: " + getMunicipalityName());
        System.out.println("Lot Number: " + getLotNumber());
        System.out.println("Section Number: " + getSectionNumber());
        if (!getName().equals("")) {
            System.out.println("Name: " + getName());
        }
        System.out.println("Area: " + getArea());
        System.out.println("Name of Owner: " + getNameOfOwner());
    }

    /**
     * @return The municipality number
     */
    int getMunicipalityNumber() {
        return municipalityNumber;
    }

    /**
     * @return The municipality name
     */
    private String getMunicipalityName() {
        return municipalityName;
    }

    /**
     * @return The lot number
     */
    int getLotNumber() {
        return lotNumber;
    }

    /**
     * @return The section number
     */
    int getSectionNumber() {
        return sectionNumber;
    }

    /**
     * @return The name of the property
     */
    public String getName() {
        return name;
    }

    /**
     * @return The area of the property.
     */
    double getArea() {
        return area;
    }

    /**
     * @return The name of the property owner
     */
    private String getNameOfOwner() {
        return nameOfOwner;
    }

    /**
     * @return The property id
     */
    String getPropertyId() {
        return (municipalityNumber + "-" + lotNumber + "/" + sectionNumber);
    }
}
