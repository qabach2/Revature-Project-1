package Repositories;

import Entity.HotDrinks;
import Entity.MakeOrder;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MakeOrderRepository {
    Connection conn;
    public MakeOrderRepository() throws SQLException {
        conn = ConnectionUtil.getConnection();
    }
    public List<MakeOrder> getAllMakeOrder(){
        List<MakeOrder> allMakeOrder = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From MakeOrder");
            while(rs.next()){
                MakeOrder loadedMakeOrder = new MakeOrder((rs.getInt("Customer_Id")),(rs.getString("Customer_Name")),(rs.getString("Drink_Name")));
                allMakeOrder.add(loadedMakeOrder);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return allMakeOrder;
    }

    public MakeOrder getMakeOrderById(int Customer_Id) {
        MakeOrder loadedMakeOrder = null;
        try{
            PreparedStatement statement = conn.prepareStatement("Select * from MakeOrder where Customer_Id = ?");
            statement.setInt(1, Customer_Id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            loadedMakeOrder = new MakeOrder((rs.getInt("Customer_Id")),(rs.getString("Customer_Name")),(rs.getString("Drink_Name")));
        }catch(SQLException e){
            e.printStackTrace();

        }
        return loadedMakeOrder;
    }

    public MakeOrder getMakeOrderByName(String Customer_Name) {
        MakeOrder loadedMakeOrder = null;
        try{
            PreparedStatement statement = conn.prepareStatement("Select * from MakeOrder where Customer_Name= ?");
            statement.setString(1, Customer_Name);
            ResultSet rs = statement.executeQuery();
            rs.next();
            loadedMakeOrder = new MakeOrder((rs.getInt("Customer_Id")),(rs.getString("Customer_Name")),(rs.getString("Drink_Name")));
        }catch(SQLException e){
            e.printStackTrace();

        }
        return loadedMakeOrder;
    }

    public void removeMakeOrderById(int Customer_Id ){
        try{
            PreparedStatement statement = conn.prepareStatement("Delete from MakeOrder where Customer_Id = ?");
            statement.setInt(1, Customer_Id);
            ResultSet rs = statement.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }}
    public void removeMakeOrderByName(String Customer_Name ){
        try{
            PreparedStatement statement = conn.prepareStatement("Delete from MakeOrder where Customer_Name = ?");
            statement.setString(1, Customer_Name);
            ResultSet rs = statement.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }}
    public void addMakeOrder(MakeOrder makeOrder){

        try{
            PreparedStatement statement = conn.prepareStatement("insert into MakeOrder(Customer_Id, Customer_Name, Drink_Name) " +
                    "values (?, ?, ?)");
            statement.setInt(1, makeOrder.getCustomer_Id());
            statement.setString(2, makeOrder.getCustomer_Name());
            statement.setString(3, makeOrder.getDrink_Name());

            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public MakeOrder updateMakeOrderById(MakeOrder makeOrder){
        MakeOrder returnval  = null;
        try{
            PreparedStatement statement = conn.prepareStatement("Update  set Customer_name= ?,Drink_Name= ? where Customer_Id = ?");
            statement.setString(1, makeOrder.getCustomer_Name());
            statement.setString(2, makeOrder.getDrink_Name());
            statement.setInt(3, makeOrder.getCustomer_Id());
            statement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return returnval;
    }}

