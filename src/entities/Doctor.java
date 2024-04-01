package entities;

public class Doctor {
    private int id;
    private String name;
    private String lastname;
    private int specialtyId;

    public Doctor(int id, String name, String lastname, int specialtyId) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.specialtyId = specialtyId;
    }

    public Doctor() {
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

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", specialtyId=" + specialtyId +
                '}';
    }
}
