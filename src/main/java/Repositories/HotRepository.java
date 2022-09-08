package Repositories;

import Entity.HotDrinks;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotRepository {
    Connection conn;
    public HotRepository() throws SQLException {
        conn = ConnectionUtil.getConnection();
    }
    public List<HotDrinks> getAllHotDrinks(){
        List<HotDrinks> allHotDrinks = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From HotDrinks");
            while(rs.next()){
                HotDrinks loadedDrinkHotDrinks = new HotDrinks((rs.getInt("id")),(rs.getString("name")),(rs.getString("description")));
                allHotDrinks.add(loadedDrinkHotDrinks);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return allHotDrinks;
    }

    public HotDrinks getHotDrinksById(int id) {
        HotDrinks loadedHotDrinks = null;
        try{
           PreparedStatement statement = conn.prepareStatement("Select * from HotDrinks where id = ?");
           statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            loadedHotDrinks = new HotDrinks((rs.getInt("id")),(rs.getString("name")),(rs.getString("description")));
        }catch(SQLException e){
            e.printStackTrace();

    }
        return loadedHotDrinks;
    }

    public void removeHotDrinksById(int id ){
        try{
            PreparedStatement statement = conn.prepareStatement("Delete from HotDrinks where id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
    }}
    public void addHotDrinks(HotDrinks hotDrinks){

        try{
            PreparedStatement statement = conn.prepareStatement("insert into HotDrinks(id, name, description) " +
                    "values (?, ?, ?)");
            statement.setInt(1, hotDrinks.getId());
            statement.setString(2, hotDrinks.getName());
           statement.setString(3, hotDrinks.getDescription());

            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public HotDrinks updateHotDrinksById(HotDrinks hotDrinks){
       HotDrinks returnval  = null;
        try{
            PreparedStatement statement = conn.prepareStatement("Update HotDrinks set name= ?,description = ? where id = ?");
            statement.setString(1, hotDrinks.getName());
            statement.setString(2, hotDrinks.getDescription());
            statement.setInt(3, hotDrinks.getId());
            statement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return returnval;
    }}
//
