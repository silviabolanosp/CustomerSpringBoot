package com.spring.customer.model;

import com.spring.customer.annotations.PasswordMatches;
import lombok.*;

import java.util.Collection;
import org.jboss.aerogear.security.otp.api.Base32;
import javax.persistence.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@PasswordMatches
@Table(name = "user_account")
public class User {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private boolean enabled;

    private boolean isUsing2FA;

    private String secret;

    //

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User() {
        super();
        this.secret = Base32.random();
        this.enabled = false;
    }

    public void setRoles(final Collection<Role> roles) {
        this.roles = roles;
    }
    public Collection<Role> getRoles() {
        return roles;
    }

    @Transient
    private String matchingPassword;



}
