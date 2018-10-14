package se.william.mvcexemple.shoppinglist.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    @NotNull
    @NotEmpty(message = "*Användarnamn måste anges")
    private String username;

    @Column(name = "email")
    @Email(message = "* Ange en giltig mailadress")
    @NotEmpty(message = "*Mail måste anges")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "* Lösenordet måste vara minst 5 tecken")
    @NotEmpty(message = "*Lösenord måste anges")
    private String password;

    @Column(name = "first_name")
    @NotEmpty(message = "*Förnamn måste anges")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "*Eftername måste anges")
    private String lastName;

    @Column(name = "active")
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
