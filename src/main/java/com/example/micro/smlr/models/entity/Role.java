package com.example.micro.smlr.models.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> users;



    @Override
    public String getAuthority() {
        return "ROLE_" + name.toUpperCase();
    }
}
