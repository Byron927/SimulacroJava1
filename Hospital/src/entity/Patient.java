package entity;

public class Patient {
    private int id;
    private String name;
    private String lastname;
    private String borndate;
    private String dni;

    public Patient(int id, String name, String lastname, String borndate, String dni) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.borndate = borndate;
        this.dni = dni;
    }

    public Patient() {
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
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
