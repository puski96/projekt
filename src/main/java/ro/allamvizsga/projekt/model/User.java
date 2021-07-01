package ro.allamvizsga.projekt.model;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="USER_LOGINS")
public class User {

    @Id
    @GeneratedValue(generator = "USER_LOGINS_ID_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "USER_LOGINS_ID_SEQ_GEN", allocationSize = 1, sequenceName = "USER_LOGINS_ID_SEQ")
    private Long id;

    @Column(name="EMAIL")
    @NotBlank
    @Pattern(regexp="^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$", message = "not walid e-mail address")
    private String userName;

    @Column(name="PASSWORD")
    @NotBlank()
    @NotNull
    @Size(min = 8)
    private String password;

    @CreationTimestamp
    @Column(name="CREATED_AT")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name="UPDATED_AT")
    private LocalDateTime updateDateTime;

    @Column(name = "IS_CONFIRMED")
    private Boolean isConfirmed;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_LOGIN_USER_ROLES", joinColumns = @JoinColumn(name = "USER_LOGIN_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ROLE_ID"))
    private Set<UserRole> userRoles;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Boolean getConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        isConfirmed = confirmed;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

	public Boolean getIsConfirmed() {
		return isConfirmed;
	}

	public void setIsConfirmed(Boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}


	
    
}
