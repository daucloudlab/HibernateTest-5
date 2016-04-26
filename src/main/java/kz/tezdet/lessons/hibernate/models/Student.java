package kz.tezdet.lessons.hibernate.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="student", catalog = "hibernate_db1")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long id ;

    @Column(name = "first_name")
    private String firstName ;
    @Column(name = "last_name")
    private String lastName ;
    @Column(name = "email")
    private String email ;
    @Column(name = "phone")
    private String phone ;

    @OneToMany(mappedBy = "student")
    private Set<MarkDetails> markDetails ;

    public Student(){}

    public Student(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<MarkDetails> getMarkDetails() {
        return markDetails;
    }

    public void setMarkDetails(Set<MarkDetails> markDetails) {
        this.markDetails = markDetails;
    }
}
