package ro.allamvizsga.projekt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity()
@Table(name = "USER_ROLES")
public class UserRole implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "USER_ROLES_ID_SEQ_GEN")
    @SequenceGenerator(name = "USER_ROLES_ID_SEQ_GEN", allocationSize = 1, sequenceName = "USER_ROLES_ID_SEQ")
    private Long id;

    @Column()
    private String role;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
