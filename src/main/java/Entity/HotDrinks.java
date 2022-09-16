package Entity;

public class HotDrinks {


        public int id;
        public String name;
        public String description;



        public HotDrinks(int id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {

            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "Drinks{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }


