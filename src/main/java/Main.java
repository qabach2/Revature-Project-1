import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import Entity.HotDrinks;
import Entity.IcedDrinks;
import Service.HotService;
import Service.IcedService;
import Util.ConnectionUtil;




//import java.util.logging.Logger;
public class Main {
    public static void main(String[] args) throws SQLException {
//         Logger logger = Logger.getLogger(MainMenu.class.getName());
//          logger.info("Info Text");

        Connection connection = ConnectionUtil.getConnection();
        boolean HaveDrinks = true;
        HotService hotService = new HotService();
        IcedService icedService = new IcedService();
        while (HaveDrinks) {
            System.out.println("SELECT ONE: ( all drinks,     get all drinks by id ,    add drink ,    remove drink ,     update drink,    exit )");
            Scanner ab = new Scanner(System.in);
            String userInput = ab.nextLine();
//  TO GET ALL COFFES FROM DATA BASE
            if (userInput.equals("all drinks")) {
                System.out.println("hot drinks, iced drinks");
                userInput = ab.nextLine();
                if (userInput.equals("hot drinks")) {
                    System.out.println(hotService.getAllHotDrinks());
                } else if (userInput.equals("iced drinks")) {
                    System.out.println(icedService.getAllIcedDrinks());
                }}
//  TO GET ALL COFFEeS BY IDS
            else if(userInput.equals("get all coffees by id")){
                System.out.println("hot drinks, iced drinks");
                userInput = ab.nextLine();
                if(userInput.equals("hot drinks")) {
                    System.out.println("input hot drinks id:");
                    int UserInputId = Integer.parseInt(ab.nextLine());
                    System.out.println(hotService.getHotDrinksById(UserInputId));
                } else if (userInput.equals("iced drinks")) {
                    System.out.println("input iced coffee id:");
                    int UserInputId = Integer.parseInt(ab.nextLine());
                    System.out.println(icedService.getAllIcedDrinksById(UserInputId));

                }

            }
//  TO ADD COFFEE TO LIST
            else if (userInput.equals("add coffee")) {
                System.out.println("hot drinks, drinks");
                userInput = ab.nextLine();
                if (userInput.equals("hot drinks")) {
                    System.out.println("please add the name");
                    String UserInputName = ab.nextLine();
                    System.out.println("please add description");
                    String UserInputDescription = ab.nextLine();
                    System.out.println("please add id");
                    int UserInputId = Integer.parseInt(ab.nextLine());
                    HotDrinks hotDrinks = new HotDrinks(UserInputId, UserInputName, UserInputDescription);
                    hotService.addHotCoffee(hotDrinks);
                } else if (userInput.equals("iced coffees")) {
                    System.out.println("please add the name of coffee");
                    String UserInputName = ab.nextLine();
                    System.out.println("please add about");
                    String UserInputDescription = ab.nextLine();
                    System.out.println("please add id");
                    int UserInputId = Integer.parseInt(ab.nextLine());
                    IcedDrinks icedDrinks = new IcedDrinks(UserInputId, UserInputName, UserInputDescription);
                    icedService.addIcedDrinks(icedDrinks);
                } else
                    System.out.println("SELECT ONE: ( all drinks , get all drinks by id, add drinks, remove drinks, update drinks ,exit )");
            }
// TO REMOVE COFFEE
            else if (userInput.equals("remove drinks")) {
                System.out.println("hot drinks, iced drinks");
                userInput = ab.nextLine();
                if (userInput.equals("hot drinks")) {
                    System.out.println("please add id_number");
                    int UserInputId = Integer.parseInt(ab.nextLine());
                    hotService.removeHotDrinksById(UserInputId);
                } else if (userInput.equals("iced coffee")) {
                    System.out.println("please add id_number");
                    int UserInputId = Integer.parseInt(ab.nextLine());
                    icedService.removeIcedDrinksByIdNumber(UserInputId);
//                    IcedCoffeeService.removeIcedCoffeeById();
                } else
                    System.out.println("SELECT ONE: ( all drinks , get all drinks by id,  add drinks, remove drinks, update drinkse ,exit )");
//TO UPDATE COFFEE
            } else if (userInput.equals("update drinks")) {
                System.out.println("hot drinks, iced drinks");
                userInput = ab.nextLine();
                if (userInput.equals("hot drinks")) {
                    System.out.println("please add the name");
                    String UserInputName = ab.nextLine();
                    System.out.println("please add description");
                    String UserInputDescription = ab.nextLine();
                    System.out.println("please add id");
                    int UserInputId = Integer.parseInt(ab.nextLine());
                    HotDrinks hotDrinks = new HotDrinks(UserInputId, UserInputName, UserInputDescription);
                    hotService.updateHotDrinksById(hotDrinks);
                } else if (userInput.equals("iced drinks")) {
                    System.out.println("please add the name_of_coffee");
                    String UserInputName = ab.nextLine();
                    System.out.println("please add about");
                    String UserInputAbout = ab.nextLine();
                    System.out.println("please add id");
                    int UserInputId_number= Integer.parseInt(ab.nextLine());
                    IcedDrinks icedDrinks = new IcedDrinks(UserInputId_number, UserInputName, UserInputAbout);
                    icedService.updateIcedDrinksById(icedDrinks);
//                    IcedCoffeeService.updateIcedCoffeeById();
                } else
                    System.out.println("SELECT ONE: ( all drinks , get all drinks by id, add drinks, remove drinks, update drinks ,exit )");
            }
            else if(userInput.equals("exit")){
                HaveDrinks=false;
                System.out.println("THANK YOU!!");}
            else{
                System.out.println("see you next time ");
            }}}}

//
//





