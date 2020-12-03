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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "T_Users" )
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int              idUser;

    private String           login;

    private String           password;

    private int              connectionNumber;

    @OneToOne
    @JoinColumn( name = "idUserInformations", nullable = false )
    private UserInformations userInformations;

    @OneToMany( targetEntity = Command.class, mappedBy = "user" )
    private List<Command>    commands = new ArrayList<>();

    @ManyToMany
    @JoinTable( name = "T_Users_Roles_Associations", joinColumns = @JoinColumn( name = "idUser" ), inverseJoinColumns = @JoinColumn( name = "idRole" ) )
    private List<Role>       roles    = new ArrayList<>();

    public User() {
    }

    public User( String login, String password, int connectionNumber ) {
        super();
        this.setLogin( login );
        this.setPassword( password );
        this.setConnectionNumber( connectionNumber );
    }

    public int getIdUser() {
        return idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin( String login ) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public int getConnectionNumber() {
        return connectionNumber;
    }

    public void setConnectionNumber( int connectionNumber ) {
        this.connectionNumber = connectionNumber;
    }

    public UserInformations getUserInformations() {
        return userInformations;
    }

    public void setUserInformations( UserInformations userInformations ) {
        this.userInformations = userInformations;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands( List<Command> commands ) {
        this.commands = commands;
    }

    public void setIdUser( int idUser ) {
        this.idUser = idUser;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles( List<Role> roles ) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User [idUser=" + idUser + ", login=" + login + ", password=" + password + ", connectionNumber="
                + connectionNumber + ", userInformations=" + userInformations + "]";
    }

}
