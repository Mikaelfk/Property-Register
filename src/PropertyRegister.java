import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * A register for which all the properties are saved in
 */
public class PropertyRegister {
    private final HashMap<String, Property> propertyList = new HashMap<>();

    /**
     * This method adds 5 properties to the list.
     */
    void addTestProperties() {
        propertyList.put("1445-77/631", new Property(1445, "Gloppen", 77, 631, "", 1017.6, "Jens Olsen"));
        propertyList.put("1445-77/131", new Property(1445, "Gloppen", 77, 131, "Syningom", 661.3, "Nicolay Madsen"));
        propertyList.put("1445-75/19", new Property(1445, "Gloppen", 75, 19, "Fugletorn", 650.6, "Evilyn Jensen"));
        propertyList.put("1445-74/188", new Property(1445, "Gloppen", 74, 188, "", 1457.2, "Karl Ove Bråten"));
        propertyList.put("1445-69/47", new Property(1445, "Gloppen", 69, 47, "Høiberg", 1339.4, "Elsa Indregård"));
    }

    /**
     * This method allows the user to add a property to the list
     *
     * @param municipalityNumber User inputs the municipality number
     * @param municipalityName   User inputs the municipality name
     * @param lotNumber          User inputs the lot number
     * @param sectionNumber      user inputs the section number
     * @param name               user inputs the name of the property
     * @param area               user inputs the area of the property
     * @param nameOfOwner        user inputs the name of the owner
     */
    void addProperty(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber,
                     String name, double area, String nameOfOwner) {
        Property property = new Property(municipalityNumber, municipalityName, lotNumber, sectionNumber, name, area, nameOfOwner);
        String ID = property.getPropertyId();
        propertyList.put(ID, property);
    }

    /**
     * This methods searches and returns all the properties with a given municipality number.
     *
     * @param searchProperty this parameter is the municipality number which the user wants to search for
     * @return An arraylist with all the properties with the given municipality number
     */
    ArrayList<Property> searchMunicipalityNumber(int searchProperty) {
        ArrayList<Property> foundProperties = new ArrayList<>();
        Iterator<Property> propertyIterator = this.getIterator();
        while (propertyIterator.hasNext()) {
            Property property = propertyIterator.next();
            if (property.getMunicipalityNumber() == searchProperty) {
                foundProperties.add(property);
            }
        }
        return foundProperties;
    }

    /**
     * This method searches and returns all the properties with a given lot number
     *
     * @param searchProperty The lot number which the user wants to search for
     * @return an arraylist with all the properties with the same lot number as the user specified.
     */
    ArrayList<Property> searchLotNumber(int searchProperty) {
        ArrayList<Property> foundProperty = new ArrayList<>();
        Iterator<Property> propertyIterator = this.getIterator();
        while (propertyIterator.hasNext()) {
            Property property = propertyIterator.next();
            if (property.getLotNumber() == searchProperty) {
                foundProperty.add(property);
            }
        }
        return foundProperty;
    }

    /**
     * This methods searches and returns all the properties with a given section number
     * @param searchProperty the section number which the user wants to search for
     * @return an arraylist with all the properties with the same lot number as the user specified.
     */
    ArrayList<Property> searchSectionNumber(int searchProperty) {
        ArrayList<Property> foundProperty = new ArrayList<>();
        Iterator<Property> propertyIterator = this.getIterator();
        while (propertyIterator.hasNext()) {
            Property property = propertyIterator.next();
            if (property.getSectionNumber() == searchProperty) {
                foundProperty.add(property);
            }
        }
        return foundProperty;
    }

    /**
     * This method searches the registry by the id of the property.
     * @param searchProperty the parameter is the id of the property
     * @return returns a Property object with the given id
     */
    Property search(String searchProperty) {
        return propertyList.get(searchProperty);
    }

    /**
     * This method deletes a book with a given id
     * @param id the id of the property
     */
    void deleteProperty(String id) {
        Iterator<Property> it = this.getIterator();
        while (it.hasNext()) {
            Property property = it.next();
            if (property.getPropertyId().equals(id)) {
                it.remove();
                propertyList.remove(property.getPropertyId());
                System.out.println("The property has been removed from the registry");
            }
        }
    }

    /**
     * This method gets the total amount of properties in the registry
     * @return an integer with the amount of properties in the registry
     */
    int getTotalProperties() {
        return propertyList.size();
    }

    /**
     * This method calculates the mean area of all the properties in the register.
     *
     * @return the mean area.
     */
    double calculateMeanAreal() {
        Iterator<Property> it = this.getIterator();
        double totalArea = 0;
        while (it.hasNext()) {
            Property property = it.next();
            totalArea += property.getArea();
        }
        return totalArea / propertyList.size();
    }

    /**
     * This method returns an iterator that iterates through the values of the HashMap propertyList
     * @return An iterator
     */
    Iterator<Property> getIterator() {
        return this.propertyList.values().iterator();
    }
}

