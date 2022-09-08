package Repositories;

import Entity.IcedDrinks;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IcedRepository {
    Connection conn;


    public IcedRepository() throws SQLException {
        conn = ConnectionUtil.getConnection();
    }
    public IcedRepository(Connection conn){
//        why do we need 2?
//        Mockito allows us to make 'dummy' mock objects that do exactly
//        what we tell them for specific scenarios
//        eg, we can say 'this mock resultset ALWAYS returns this mock data'
        this.conn = conn;
    }
    public List<IcedDrinks> getAllIcedDrinks(){
        List<IcedDrinks> allIcedDrinks = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From IcedDrinks");
            while(rs.next()){
                IcedDrinks loadedDrinksIcedDrinks = new IcedDrinks((rs.getInt("id_number")),(rs.getString("name_of_coffee")),(rs.getString("about")));
                allIcedDrinks.add(loadedDrinksIcedDrinks);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return allIcedDrinks;
    }

    public IcedDrinks getAllIcedDrinksById(int id) {
        IcedDrinks loadedIcedDrinks = null;
        try{
            PreparedStatement statement = conn.prepareStatement("Select * from IcedDrinks where id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            loadedIcedDrinks = new IcedDrinks((rs.getInt("id_number")),(rs.getString("name_of_coffee")),(rs.getString("about")));
        }catch(SQLException e){
            e.printStackTrace();

        }
        return loadedIcedDrinks;
    }

    public void removeIcedDrinksById(int id ){
        try{
            PreparedStatement statement = conn.prepareStatement("Delete from IcedDrinks where id_number = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }}
    public void addIcedDrinks(IcedDrinks icedDrinks){

        try{
            PreparedStatement statement = conn.prepareStatement("insert into IcedDrinks (id_number, name_of_coffee, about) " +
                    "values (?, ?, ?)");
            statement.setInt(1, icedDrinks.getId_number());
            statement.setString(2, icedDrinks.getName_of_coffee());
            statement.setString(3, icedDrinks.getAbout());

            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public IcedDrinks updateIcedDrinksById(IcedDrinks icedDrinks){
        IcedDrinks returnvalue  = null;
        try{
            PreparedStatement statement = conn.prepareStatement("Update IcedDrinks set name_of_coffee = ?,about = ? where id_number = ?");
            statement.setString(1, icedDrinks.getName_of_coffee());
            statement.setString(2, icedDrinks.getAbout());
            statement.setInt(3, icedDrinks.getId_number());


             statement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return returnvalue;
    }}
//


