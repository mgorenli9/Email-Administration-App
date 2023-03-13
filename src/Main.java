import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Person per1 = new Person(); // Notice THE POWER OF the CONSTRUCTORS!!!
        System.out.println("Created Email:"+per1.generateEmail());
        per1.showAllInfos();
        System.out.println("\nWorker information:\n"+ per1.workerInfo());

    }
}