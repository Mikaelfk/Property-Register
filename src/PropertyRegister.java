import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PropertyRegister {
    private final HashMap<String, Property> propertyList = new HashMap<>();

    public void printProperties() {
        Iterator<Property> it = propertyList.values().iterator();
        while(it.hasNext()) {
            Property property = it.next();
            property.printInfo();
        }
    }

    public void addTestProperties() {
        propertyList.put("1445-77/631", new Property(1445, "Gloppen", 77, 631,"", 1017.6, "Jens Olsen"));
        propertyList.put("1445-77/131", new Property(1445, "Gloppen", 77, 131,"Syningom", 661.3, "Nicolay Madsen"));
        propertyList.put("1445-75/19", new Property(1445, "Gloppen", 75, 19,"Fugletorn", 650.6, "Evilyn Jensen"));
        propertyList.put("1445-74/188", new Property(1445, "Gloppen", 74, 188,"", 1457.2, "Karl Ove Bråten"));
        propertyList.put("1445-69/47", new Property(1445, "Gloppen", 69, 47,"Høiberg", 1339.4, "Elsa Indregård"));
    }

    public void addProperty(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber,
                            String name, double area, String nameOfOwner) {
        Property property = new Property(municipalityNumber, municipalityName, lotNumber, sectionNumber, name, area, nameOfOwner);
        String ID = property.getPropertyId();
        propertyList.put(ID, property);
    }

    public void removeProperty() {

    }

    public ArrayList<Property> searchMunicipalityNumber() {
        ArrayList<Property> foundProperties = new ArrayList<>();

        return foundProperties;
    }

    public ArrayList<Property> searchLotNumber() {
        ArrayList<Property> foundProperties = new ArrayList<>();

        return foundProperties;
    }

    public ArrayList<Property> searchSectionNumber() {
        ArrayList<Property> foundProperties = new ArrayList<>();

        return foundProperties;
    }


}
