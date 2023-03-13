import java.util.Scanner;

public class Person {
    private String firstName;
    private String lastName;
    private String password;
    private String department = null; // sales Development accounting
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 8;
    private String alternateEmail;

    public Person(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first name: ");
        this.firstName = input.nextLine();

        System.out.print("Enter last name: ");
        this.lastName = input.nextLine();

        System.out.print("Enter department(sales, dev, acct) : ");
        this.department = input.nextLine();

        // call a method that return random password:
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is:"+ this.password);
    }
    // generate an email : firstname.lastname@department.company.com

    public String generateEmail(){
        if(!department.equals(" ")){
            return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase()+ ".company.com";

        }
        else
            return firstName + "." + lastName + "@sales.company.com";
    }

    // generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password1 = new char[length];
        for(int i = 0; i < length; i++){
            int rand = (int)(Math.random() * passwordSet.length());
            password1[i] = passwordSet.charAt(rand);
        }
        return new String (password1);
    }

    //Set the email capacity
    public void setEmailCapacity(int emailCapacity){ this.mailBoxCapacity = emailCapacity; }
    // Set the alternate email
    public void setAlternateEmail(String altMail){
        this.alternateEmail = altMail;
    }
    //Change the password
    public void setPassword(String password){
        this.password = password;
    }

    public int getEmailCapacity(){return this.mailBoxCapacity;}
    public String getAlternateEmail(){return this.alternateEmail;}
    public String getPassword(){return this.password;}
    public void showAllInfos(){
            int flag = 1;
        do {

        System.out.print("1 - set email capacity\n" +
                "2 - set alternate email\n" +
                "3 - set new password\n" +
                "4 - get email capacity\n" +
                "5 - get alternate email\n" +
                "6 - get password\n" +
                "7 - Quit\n" +
                " What would u like to do?");
        Scanner input = new Scanner(System.in);
        int choice;
        choice = input.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("enter new email capacity.(old capacity is :" + this.mailBoxCapacity + ")");
                    int capacity = input.nextInt();
                    setEmailCapacity(capacity);
                    System.out.println("email capacity updated. new capacity is: " + this.mailBoxCapacity);
                    break;
                }
                case 2: {
                    System.out.print("Current email is :" + generateEmail()+"\nEnter alternate email :");
                    String email1 = input.next();
                    setAlternateEmail(email1);
                    System.out.println("New email created. new email is: " + this.alternateEmail);
                    break;
                }
                case 3: {
                    System.out.print("Your current password is: " + this.password+ "\nEnter new password :");
                    String password1 = input.next();
                    setPassword(password1);
                    System.out.println("your new password is : " + this.password);
                    break;
                }
                case 4: {
                    System.out.println("Your current email capacity is: " + getEmailCapacity());
                    break;
                }
                case 5: {
                    System.out.println("Your current alternate email is : " + getAlternateEmail());
                    break;
                }
                case 6: {
                    System.out.println("Your current password is : " + getPassword());
                    break;
                }
                case 7:{
                    System.out.println("Processes are ended.");
                     flag=0; break;
                }

                default:
                    System.out.println("Unexpected case.");
            }
        }while (flag == 1);
    }
    public String workerInfo(){
        return "Name :" + firstName + " " + lastName +
                "\nDepartment :" + department +
                "\nEmail :" + generateEmail() +
                "\nMailbox Capacity :" + mailBoxCapacity;
    }
}
