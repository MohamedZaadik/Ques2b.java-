// Abstract class for Mobile Phones
abstract class MobilePhone {
    protected String model;
    protected double price;

    public MobilePhone(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public abstract void display();
}

// Subclass for A10
class A10 extends MobilePhone {
    public A10() {
        super("A10", 299.99);
    }

    @Override
    public void display() {
        System.out.println("Mobile Phone Model: " + model + ", Price: $" + price);
    }
}

// Subclass for X25
class X25 extends MobilePhone {
    public X25() {
        super("X25", 399.99);
    }

    @Override
    public void display() {
        System.out.println("Mobile Phone Model: " + model + ", Price: $" + price);
    }
}

// Subclass for TPlus
class TPlus extends MobilePhone {
    public TPlus() {
        super("TPlus", 499.99);
    }

    @Override
    public void display() {
        System.out.println("Mobile Phone Model: " + model + ", Price: $" + price);
    }
}

// Abstract class for TVs
abstract class TV {
    protected String model;
    protected int size;

    public TV(String model, int size) {
        this.model = model;
        this.size = size;
    }

    public abstract void display();
}

// Subclass for Alpha40
class Alpha40 extends TV {
    public Alpha40() {
        super("Alpha 40", 40);
    }

    @Override
    public void display() {
        System.out.println("TV Model: " + model + ", Size: " + size + " inches");
    }
}

// Subclass for Gamma50
class Gamma50 extends TV {
    public Gamma50() {
        super("Gamma 50", 50);
    }

    @Override
    public void display() {
        System.out.println("TV Model: " + model + ", Size: " + size + " inches");
    }
}

// Subclass for Theta65
class Theta65 extends TV {
    public Theta65() {
        super("Theta 65", 65);
    }

    @Override
    public void display() {
        System.out.println("TV Model: " + model + ", Size: " + size + " inches");
    }
}

// Abstract Factory class
abstract class AbstractFactory {
    public abstract MobilePhone getMobilePhone(String model);
    public abstract TV getTV(String model);
}

// Factory for Mobile Phones
class MobileFactory extends AbstractFactory {
    @Override
    public MobilePhone getMobilePhone(String model) {
        switch (model) {
            case "A10":
                return new A10();
            case "X25":
                return new X25();
            case "TPlus":
                return new TPlus();
            default:
                return null;
        }
    }

    @Override
    public TV getTV(String model) {
        return null; // Not applicable for MobileFactory
    }
}

// Factory for TVs
class TVFactory extends AbstractFactory {
    @Override
    public MobilePhone getMobilePhone(String model) {
        return null; // Not applicable for TVFactory
    }

    @Override
    public TV getTV(String model) {
        switch (model) {
            case "Alpha 40":
                return new Alpha40();
            case "Gamma 50":
                return new Gamma50();
            case "Theta 65":
                return new Theta65();
            default:
                return null;
        }
    }
}

// Factory Demo class
public class FactoryDemo {
    public static void main(String[] args) {
        // Input for Mobile Phone and TV
        String mobileModel = "X25"; // Example input
        String tvModel = "Gamma 50"; // Example input

        // Create MobileFactory and TVFactory
        AbstractFactory mobileFactory = new MobileFactory();
        AbstractFactory tvFactory = new TVFactory();

        // Get MobilePhone and TV objects
        MobilePhone mobilePhone = mobileFactory.getMobilePhone(mobileModel);
        TV tv = tvFactory.getTV(tvModel);

        // Display details
        if (mobilePhone != null) {
            mobilePhone.display();
        } else {
            System.out.println("Mobile Phone model not found.");
        }

        if (tv != null) {
            tv.display();
        } else {
            System.out.println("TV model not found.");
        }
    }
}