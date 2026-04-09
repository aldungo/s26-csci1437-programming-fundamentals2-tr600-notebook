// ========================================
// LECTURE 13: CH13 CLOSEOUT + CH12 SEGUE
// Tuesday, March 3, 2026
// Focus: abstract class vs interface differences/use-cases
// ========================================

// ---------- PART A: CHAPTER 13 CLOSEOUT (DECISION-FOCUSED) ----------

interface Drivable {
    void drive();
}

interface Rechargeable {
    void recharge();
}

abstract class Vehicle {
    private String id;

    public Vehicle(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void start() {
        System.out.println("Vehicle " + id + " starting...");
    }

    public abstract int maxPassengers();
}

class Sedan extends Vehicle {
    public Sedan(String id) {
        super(id);
    }

    @Override
    public int maxPassengers() {
        return 5;
    }
}

class ElectricScooter implements Drivable, Rechargeable {
    private String tag;

    public ElectricScooter(String tag) {
        this.tag = tag;
    }

    @Override
    public void drive() {
        System.out.println("Scooter " + tag + " driving");
    }

    @Override
    public void recharge() {
        System.out.println("Scooter " + tag + " recharging");
    }

    @Override
    public String toString() {
        return "ElectricScooter{" + "tag='" + tag + '\'' + '}';
    }
}

class HybridCar extends Vehicle implements Drivable, Rechargeable {
    public HybridCar(String id) {
        super(id);
    }

    @Override
    public int maxPassengers() {
        return 4;
    }

    @Override
    public void drive() {
        System.out.println("Hybrid car driving");
    }

    @Override
    public void recharge() {
        System.out.println("Hybrid car recharging");
    }
}

class Ch13DecisionDemo {
    public static void main(String[] args) {
        System.out.println("=== Abstract Class vs Interface Demo ===");

        Vehicle sedan = new Sedan("S-101");
        sedan.start();
        System.out.println("Sedan max passengers: " + sedan.maxPassengers());

        ElectricScooter scooter = new ElectricScooter("ES-7");
        scooter.drive();
        scooter.recharge();

        HybridCar hybrid = new HybridCar("H-22");
        hybrid.start();
        hybrid.drive();
        hybrid.recharge();

        System.out.println("\nDecision rule:");
        System.out.println("- Shared state/implementation for related classes -> abstract class");
        System.out.println("- Capability across unrelated classes -> interface");

        System.out.println("\nSelf-study note: Rational extends Number and implements Comparable.");
        System.out.println("Investigate that pattern after class.");
    }
}

// ---------- PART B: CHAPTER 12 BRIDGE ----------

class Ch12BridgeDemo {
    // IDEA #1: helper method detects error and throws
    public static int divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        return numerator / denominator;
    }

    public static void main(String[] args) {
        // IDEA #2: caller method chooses response with try/catch
        try {
            System.out.println("10 / 2 = " + divide(10, 2));
            System.out.println("10 / 0 = " + divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Caught runtime exception: " + e.getMessage());
        } finally {
            // IDEA #3: finally always runs
            System.out.println("Division demo complete.");
        }

        // IDEA #4 (preview only): checked exceptions must be handled or declared.
        // Thursday full chapter: throws clauses, propagation, and file I/O with try-with-resources.
    }
}
