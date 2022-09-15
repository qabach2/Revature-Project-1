import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import Entity.MakeOrder;
import Entity.HotDrinks;
import Entity.IcedDrinks;
import Service.MakeOrderService;
import Service.HotService;
import Service.IcedService;
import Util.ConnectionUtil;
public class Main {
    public static void main(String[] args) throws SQLException {
//

        Connection connection = ConnectionUtil.getConnection();
        boolean HaveDrink = true;
        HotService hotService = new HotService();
        IcedService icedService = new IcedService();
        MakeOrderService makeOrderService =new MakeOrderService();
        while (HaveDrink) {

            System.out.println("SELECT ONE: (administration ||  user)");
            Scanner ab = new Scanner(System.in);
            String userInput = ab.nextLine();
            if(userInput.equals("administration")) {

                System.out.println("SELECT ONE: ( all drinks,     get all drinks by id ,    add drinks ,    remove drinks ,     update drinks,    exit )");
                //  ======================TO GET ALL COFFEES FROM DATA BASE==========================
                userInput = ab.nextLine();
                if (userInput.equals("all drinks")) {
                    System.out.println("hot drinks, iced drinks");
                    userInput = ab.nextLine();
                 if (userInput.equals("hot drinks")) {
                    System.out.println(hotService.getAllHotDrinks());
                }
                  if (userInput.equals("iced drinks")) {
                    System.out.println(icedService.getAllIcedDrinks());
                }}
//  ==============================TO GET ALL COFFEeS BY ID========================
            else if(userInput.equals("get all drinks by id")){
                System.out.println("hot drinks, iced drinks");
                userInput = ab.nextLine();
                if(userInput.equals("hot drinks")) {
                    System.out.println("input hot drink id:");
                    int UserInputId = Integer.parseInt(ab.nextLine());
                    System.out.println(hotService.getHotDrinksById(UserInputId));
                }  if (userInput.equals("iced drinks")) {
                    System.out.println("input iced drink id:");
                    int UserInputId = Integer.parseInt(ab.nextLine());
                    System.out.println(icedService.getAllIcedDrinksById(UserInputId));

                }}

////  =============================TO ADD COFFEE TO LIST==============================
            else if (userInput.equals("add drinks")) {
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
                    hotService.addHotDrinks(hotDrinks);
                }  if (userInput.equals("iced drinks")) {
                    System.out.println("please add the name of drink");
                    String UserInputName = ab.nextLine();
                    System.out.println("please add about");
                    String UserInputDescription = ab.nextLine();
                    System.out.println("please add id");
                    int UserInputId = Integer.parseInt(ab.nextLine());
                    IcedDrinks icedDrinks = new IcedDrinks(UserInputId, UserInputName, UserInputDescription);
                    icedService.addIcedDrinks(icedDrinks);
                }
            }
//// ================================TO REMOVE COFFEE================================
            else if (userInput.equals("remove drinks")) {
                System.out.println("hot drink, iced drink");
                userInput = ab.nextLine();
                if (userInput.equals("hot drink")) {
                    System.out.println("please add id_number");
                    int UserInputId = Integer.parseInt(ab.nextLine());
                    hotService.removeHotDrinksById(UserInputId);
                }  if (userInput.equals("iced drink")) {
                    System.out.println("please add id_number");
                    int UserInputId = Integer.parseInt(ab.nextLine());
                    icedService.removeIcedDrinksByIdNumber(UserInputId);
//                    IcedService.removeIcedDrinksById();
                }}
//==================================TO UPDATE COFFEE==============================
             else if (userInput.equals("update drinks")) {
                System.out.println("hot drink, iced drink");
                userInput = ab.nextLine();
                if (userInput.equals("hot drink")) {
                    System.out.println("please add the name");
                    String UserInputName = ab.nextLine();
                    System.out.println("please add description");
                    String UserInputDescription = ab.nextLine();
                    System.out.println("please add id");
                    int UserInputId = Integer.parseInt(ab.nextLine());
                    HotDrinks hotDrinks = new HotDrinks(UserInputId, UserInputName, UserInputDescription);
                    hotService.updateHotDrinksById(hotDrinks);
                } else if (userInput.equals("iced drink")) {
                    System.out.println("please add the name_of_coffee");
                    String UserInputName = ab.nextLine();
                    System.out.println("please add about");
                    String UserInputAbout = ab.nextLine();
                    System.out.println("please add id");
                    int UserInputId_number= Integer.parseInt(ab.nextLine());
                    IcedDrinks icedDrinks = new IcedDrinks(UserInputId_number, UserInputName, UserInputAbout);
                    icedService.updateIcedDrinksById(icedDrinks);
//                    IcedCoffeeService.updateIcedCoffeeById();
                }}
            }
            //  ======================USER TO GET ALL COFFEES ==========================
            else if(userInput.equals("user")) {
                System.out.println("SELECT ONE: (get all drinks  make order,     get order,   remove order ,  update order,    exit )");
                userInput = ab.nextLine();
                if (userInput.equals("get all drinks")) {
                    System.out.println("hot drinks, iced drinks");
                    userInput = ab.nextLine();
                    if (userInput.equals("hot drinks")) {
                        System.out.println(hotService.getAllHotDrinks());
                    }
                    if (userInput.equals("iced drinks")) {
                        System.out.println(icedService.getAllIcedDrinks());
                    }}
//  ================================ TO MAKE ORDER================================================
                else if (userInput.equals("make order")) {
                    if (userInput.equals("make order")) {
                        System.out.println("please add your name");
                        String UserInputName = ab.nextLine();
                        System.out.println("please add name of drink");
                        String UserInputDescription = ab.nextLine();
                        System.out.println("please add id");
                        int UserInputId = Integer.parseInt(ab.nextLine());
                        MakeOrder MakeOrder = new MakeOrder(UserInputId, UserInputName, UserInputDescription);
                       makeOrderService.addMakeOrder(MakeOrder);
                    }
                    }
                }
//  ==================================== TO GET ORDER=============================
            else if(userInput.equals("exit")){
                HaveDrink=false;
                System.out.println("THANK YOU!!");}
            else{
                System.out.println("see you next time ");
            }}}}

//
//





