import java.util.Scanner;

public class Main {

private Scanner sc;
public static ABB dataBase;

public Main(){

    sc = new Scanner(System.in);
}

    public static void main(String[] args) {

        Main m =new Main();
        dataBase = new ABB();

        int option = 0;
        do{
            option = m.showMenu();
            m.executeOperation(option);
        }while(option!=4);

        }


    public int showMenu() {

        int option=0;

        System.out.println(
                "***************************\n" +
                        "Registro DANE\n" +
                        "***************************\n" +
                        "(1) To register a citizen.\n" +
                        "(2) To search by ID.\n" +
                        "(3) To delete a citizen.\n" +
                        "(4) To exit.\n");
        option= Integer.parseInt(sc.nextLine());
        return option;
    }

    public void executeOperation(int operation) {

        switch (operation) {

            case 1:
                registerCitizen();
                break;

            case 2:
                searchById();
                break;

            case 3:
                delete();
                break;

            case 4:
                System.out.println("Bye!");
                break;

            default:
                System.out.println("Please type a valid option.\n");
                break;
        }
    }

    public void registerCitizen() {

        String name;
        int id;
        String birthday;
        String city;

        System.out.println("Please type the name of the citizen:");
        name = sc.nextLine();
        System.out.println("Please type the id of the citizen");
        id = Integer.parseInt(sc.nextLine());
        System.out.println("Please type the birthday of the citizen in format dd/mm/yy:");
        birthday = sc.nextLine();
        System.out.println("Please type the city of the citizen:");
        city = sc.nextLine();


        dataBase.insert(new Node(new Citizen(name, birthday, id, city)));

        System.out.println("Citizen added.\n");

    }

    public void searchById() {

        int id;
        System.out.println("Please type the ID number:");
        id = Integer.parseInt(sc.nextLine());

        Node temp = dataBase.search(id);
        System.out.println(temp==null?"Not found.": temp + "Found in " + dataBase.getCount()
                + " iterations.\n***************************");

    }

    public void delete() {

        int id;
        System.out.println("Please type the ID number ");
        id = Integer.parseInt(sc.nextLine());

        dataBase.delete(id);

        System.out.println("Citizen deleted.");
    }

}
