package Entity;

public class MakeOrder {
    public int Customer_Id;
    public String Customer_Name;
    public String Drink_Name;
    public MakeOrder (){

    }

    public MakeOrder(int customerId, String customerName, String drinkName) {
        this.Customer_Id = customerId;
        this.Customer_Name = customerName;
        this.Drink_Name = drinkName;
    }

    public int getCustomer_Id() {
        return Customer_Id;
    }

    public void setCustomer_Id(int customer_Id) {
        Customer_Id = customer_Id;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getDrink_Name() {
        return Drink_Name;
    }

    public void setDrink_Name(String drink_Name) {
        Drink_Name = drink_Name;
    }

    @Override
    public String toString() {
        return "AddOrder{" +
                "Customer_Id=" + Customer_Id +
                ", Customer_Name='" + Customer_Name + '\'' +
                ", Drink_Name='" + Drink_Name + '\'' +
                '}';
    }
}

