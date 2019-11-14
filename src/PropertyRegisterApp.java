import java.util.Iterator;
import java.util.Scanner;

/**
 * A class which allows user interaction with the registry.
 *
 */
public class PropertyRegisterApp {
    /**
     * Object of the propertyRegister class saved in a field.
     */
    private PropertyRegister propertyRegister;
    /**
     * A Scanner which allows for user inputs.
     */
    private Scanner scanner;

    /**
     * Method which initialises the application
     */
    private void init() {
        propertyRegister = new PropertyRegister();
        propertyRegister.addTestProperties();
        System.out.println("Welcome to this property registry.");
        System.out.println("You can search for properties, add properties and remove properties");
        System.out.println("Type 'help' for list of commands");
        boolean finished = false;
        while (!finished) {
            System.out.print("> ");
            scanner = new Scanner(System.in);
            //removes all spaces in the command
            String command = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

            switch (command) {
                case "help":
                    printHelp();
                    break;
                case "searchmunicipalitynumber":
                    searchMunicipalityNumber();
                    break;
                case "searchlotnumber":
                    searchLotNumber();
                    break;
                case "searchsectionnumber":
                    searchSectionNumber();
                    break;
                case "meanarea":
                    calculateMeanArea();
                    break;
                case "search":
                    search();
                    break;
                case "add":
                    addProperty();
                    break;
                case "remove":
                    removeProperty();
                    break;
                case "list":
                    listAllProperties();
                    break;
                case "total":
                    listTotalProperties();
                    break;
                case "quit":
                    System.out.println("Exiting application");
                    finished = true;
                    break;
                default:
                    System.out.println("This command does not exist");
            }
        }
    }

    /**
     * Method which prints out available commands.
     */
    private void printHelp() {
        System.out.println("Available commands:");
        System.out.println("Help");
        System.out.println("Search");
        System.out.println("Search Municipality Number");
        System.out.println("Search Lot Number");
        System.out.println("Search Section Number");
        System.out.println("Add");
        System.out.println("Remove");
        System.out.println("List");
        System.out.println("Total");
        System.out.println("Quit");
    }

    /**
     * Method which searches by municipality number specified by the user.
     */
    private void searchMunicipalityNumber() {
        System.out.println("Type the Municipality Number of the property you are searching for");
        int number = checkInt();
        if (propertyRegister.searchMunicipalityNumber(number).size() == 0) {
            System.out.println("There is no property in the registry with this title");
        } else {
            System.out.println("Here is a list of all the propertys with this title");
            System.out.println("---------------------------------------------------------------------------------------");
            for (int i = 0; i < propertyRegister.searchMunicipalityNumber(number).size(); i++) {
                propertyRegister.searchMunicipalityNumber(number).get(i).printInfo();
                System.out.println("---------------------------------------------------------------------------------------");
            }

        }
    }


    /**
     * Method which searches by lot number specified by the user.
     */
    private void searchLotNumber() {
        System.out.println("Type the lot number of the property you are searching for");
        int number = checkInt();
        if (propertyRegister.searchLotNumber(number).size() == 0) {
            System.out.println("There is no property in the registry with this lot number");
        } else {
            System.out.println("Here is a list of the properties with this lot number");
            System.out.println("---------------------------------------------------------------------------------------");
            for (int i = 0; i < propertyRegister.searchLotNumber(number).size(); i++) {
                propertyRegister.searchLotNumber(number).get(i).printInfo();
                System.out.println("---------------------------------------------------------------------------------------");
            }

        }
    }

    /**
     * Method which searches by section number specified by the user.
     */
    private void searchSectionNumber() {
        System.out.println("Type the section number of the property you are searching for");
        int number = checkInt();
        if (propertyRegister.searchSectionNumber(number) == null) {
            System.out.println("There is no property in the registry with this section number");
        } else {
            System.out.println("---------------------------------------------------------------------------------------");
            for (int i = 0; i < propertyRegister.searchSectionNumber(number).size(); i++) {
                propertyRegister.searchSectionNumber(number).get(i).printInfo();
                System.out.println("---------------------------------------------------------------------------------------");
            }

        }
    }

    /**
     * This method asks the user for inputs which create a property id.
     * @return the id of a property in a string
     */
    String id() {
        System.out.println("Type in the municipality number of the property you wish to search for");
        int municipalityNumber = checkInt();
        System.out.println("Type in the lot number of the property you wish to search for");
        int lotNumber = checkInt();
        System.out.println("Type in the section number of the property you wish to search for");
        int sectionNumber = checkInt();
        return municipalityNumber+"-"+lotNumber+"/"+sectionNumber;
    }

    /**
     * This method searches the registry based on an id.
     */
    private void search() {
        String id = id();
        Property returnedsearch = propertyRegister.search(id);
        if (returnedsearch == null) {
            System.out.println("There is no property corresponding to these numbers");
        } else {
            System.out.println("----------------------------------------------------");
            returnedsearch.printInfo();
            System.out.println("----------------------------------------------------");
        }
    }

    /**
     * Method which adds a property. Asks the user for each input needed.
     */
    private void addProperty() {
        System.out.println("Type the municipality number of the property you wish to add");
        int municipalityNumber = checkInt();

        System.out.println("Type the municipality name of the property you wish to add");
        String municipalityName = scanner.nextLine();
        System.out.println("Type in the lot number of the property you wish to add");
        int lotNumber = checkInt();

        System.out.println("Type in the section number of the property you wish to add");
        int sectionNumber = checkInt();

        System.out.println("Type in the name of the property you wish to add");
        String name = scanner.nextLine();

        System.out.println("Type in the area of the property you wish to add");
        double area = 0;
        boolean done = false;
        do {
            try {
                scanner = new Scanner(System.in);
                area = scanner.nextDouble();
                done = true;
            } catch (Exception e) {
                System.out.println("This is not a valid number, please input a number");
            }
        } while (!done);
        scanner.nextLine();
        System.out.println("Type the name of the owner of the property");
        String nameOfOwner = scanner.nextLine();

        if(propertyRegister.search(municipalityNumber+"-"+lotNumber+"/"+sectionNumber) != null) {
            System.out.println("A property with this ID already exists, type 'yes' if you wish to overwrite it." +
                    "Type 'no' if you do not wish to overwrite the previous property");
            if(scanner.nextLine().toLowerCase().equals("yes")) {
                propertyRegister.addProperty(municipalityNumber, municipalityName, lotNumber, sectionNumber, name, area, nameOfOwner);
                System.out.println("The property has been added to the registry");
            }
            else {
                System.out.println("You have not added the property");
            }
        }

    }

    /**
     * Method which removes a property.
     */
    private void removeProperty() {
        String id = id();
        Property returnedSearch = propertyRegister.search(id);
        if (returnedSearch == null) {
            System.out.println("No property was found");
        } else {
            System.out.println("----------------------------------------------------");
            returnedSearch.printInfo();
            System.out.println("----------------------------------------------------");
            System.out.println("Type yes if this is the property you wish to delete");
            if (scanner.nextLine().toLowerCase().equals("yes")) {
                propertyRegister.deleteProperty(id);
            } else {
                System.out.println("The property has not been deleted");
            }
        }

    }

    /**
     * Method which prints all the propertys.
     */
    private void listAllProperties() {
        Iterator<Property> propertyIterator = propertyRegister.getIterator();
        if (!propertyIterator.hasNext()) {
            System.out.println("The registry is empty.");
        } else {
            System.out.println("Here is a list of all the properties in the registry");
            System.out.println("----------------------------------------------------");
            while (propertyIterator.hasNext()) {
                Property property = propertyIterator.next();
                property.printInfo();
                System.out.println("----------------------------------------------------");

            }
        }
    }

    /**
     * Method that checks if input is a valid integer.
     */
    private int checkInt() {
        boolean done = false;
        int input = 0;
        do {
            try {
                scanner = new Scanner(System.in);
                input = Integer.parseInt(scanner.nextLine());
                done = true;
            } catch (Exception e) {
                System.out.println("This is not a valid number, please input a number");
            }
        } while (!done);
        return input;
    }

    /**
     * Method that calulates the mean area of all the properties
     */
    private void calculateMeanArea() {
        System.out.println(propertyRegister.calculateMeanAreal());
    }

    /**
     * Method that lists the amount of properties in the registry
     */
    private void listTotalProperties() {
        System.out.println("The total number of propeties in the register:");
        System.out.println(propertyRegister.getTotalProperties());
    }

    public static void main(String[] args) {
        PropertyRegisterApp propertyLibrary = new PropertyRegisterApp();
        propertyLibrary.init();
    }
}
