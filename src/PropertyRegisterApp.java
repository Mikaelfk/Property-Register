

public class PropertyRegisterApp {

    public void init() {
        PropertyRegister register = new PropertyRegister();
        register.printProperties();
    }

    public static void main(String[] args) {
        PropertyRegisterApp nice = new PropertyRegisterApp();
        nice.init();
    }
}
