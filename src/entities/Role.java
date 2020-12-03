package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table( name = "T_Roles" )
public class Role {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int        idRole;
    private String     roleName;

    @ManyToMany
    @JoinTable( name = "T_Users_Roles_Associations", joinColumns = @JoinColumn( name = "idRole" ), inverseJoinColumns = @JoinColumn( name = "idUser" ) )
    private List<User> users = new ArrayList<>();

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole( int idRole ) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName( String roleName ) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers( List<User> users ) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role [idRole=" + idRole + ", roleName=" + roleName + "]";
    }

}
