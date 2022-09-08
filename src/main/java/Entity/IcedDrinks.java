package Entity;

public class IcedDrinks {
        public int id_number;
        public String name_of_coffee;
        public String about;

        public IcedDrinks(int id_number, String name_of_coffee, String about) {
            this.id_number = id_number;
            this.name_of_coffee = name_of_coffee;
            this.about = about;
                    }

    public int getId_number() {
        return id_number;
    }

    public void setId_number(int id_number) {
        this.id_number = id_number;
    }

    public String getName_of_coffee() {
        return name_of_coffee;
    }

    public void setName_of_coffee(String name_of_coffee) {
        this.name_of_coffee = name_of_coffee;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "IcedCoffee{" +
                "id_number=" + id_number +
                ", name_of_coffee='" + name_of_coffee + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}


