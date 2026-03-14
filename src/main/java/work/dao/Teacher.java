package work.dao;

import jakarta.persistence.*;

@Entity
@Table(name="teachers")
public class Teacher {
    private int id;
    private String name;
    private String address;
    private String phone;

    public Teacher() {}
    public Teacher(int id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Id
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="addr")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name="phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%-3d %-25s %-20s %-10s \n", getId(), getName(), getAddress(), getPhone());
    }
}
