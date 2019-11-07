
public class Property {
    //Fields
    private final int  municipalityNumber;
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

    void printInfo() {
        System.out.println("Municipality Number: " + getMunicipalityNumber());
        System.out.println("Municipality Name: " + getMunicipalityName());
        System.out.println("Lot Number: " + getLotNumber());
        System.out.println("Section Number: " + getSectionNumber());
        System.out.println("Name: " + getName());
        System.out.println("Area: " + getArea());
        System.out.println("Name of Owner: " + getNameOfOwner());
    }
    //Getters for all of the fields
    public int getMunicipalityNumber() {
        return municipalityNumber;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public String getPropertyId() {
        return (municipalityNumber + "-" + lotNumber + "/" + sectionNumber);
    }


}
