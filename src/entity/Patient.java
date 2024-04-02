package entity;

public class Patient {
    private int id;
    private String name;
    private String lastname;
    private String borndate;
    private int dni;

    public Patient(int id, String name, String lastname, String borndate, int dni) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.borndate = borndate;
        this.dni = dni;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBorndate() {
        return borndate;
    }

    public void setBorndate(String borndate) {
        this.borndate = borndate;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", borndate='" + borndate + '\'' +
                ", dni=" + dni +
                '}';
    }
}
