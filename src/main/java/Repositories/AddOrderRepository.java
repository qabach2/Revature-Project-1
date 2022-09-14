package Repositories;

import Entity.AddOrder;
import Entity.HotDrinks;
import Util.ConnectionUtil;

import java.sql.*;





public class AddOrderRepository {
    Connection conn;
    public AddOrderRepository() throws SQLException {
        conn = ConnectionUtil.getConnection();
    }


    public void addOrder(AddOrder addOrder){

        try{
            PreparedStatement statement = conn.prepareStatement("insert into AddOrder(CustomerId, CustomerName, DrinkName) " +
                    "values (?, ?, ?)");
            statement.setInt(1, addOrder.getCustomerId());
            statement.setString(2, addOrder.getCustomerName());
            statement.setString(3, addOrder.getDrinkName());

            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
}}}

