public class Citizen {

    private String name;
    private String birthday;
    private int id;
    private String city;

    public Citizen(String name, String birthday, int id, String city) {
        this.name = name;
        this.birthday = birthday;
        this.id = id;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "***************************\n"
                +name+"\n"
                +birthday+"\n"
                +id+"\n"
                +city+"\n"
                +"***************************\n"
                ;
    }
}

