package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "T_Commands" )
public class Command {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int               idCommand;

    @ManyToOne
    @JoinColumn( name = "idUser", nullable = false )
    private User              user;

    @OneToMany( targetEntity = CommandLine.class, mappedBy = "command" )
    private List<CommandLine> commandLines = new ArrayList<>();

    @OneToOne
    @JoinTable( name = "T_Commands_Payments_Associations", joinColumns = @JoinColumn( name = "idCommand" ), inverseJoinColumns = @JoinColumn( name = "idPayment" ) )
    private Payment           payment;

    private Date              commandDate;

    public Command() {
    }

    public Command( User user, Date commandDate ) {
        this.setUser( user );
        this.setCommandDate( commandDate );
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment( Payment payment ) {
        this.payment = payment;
    }

    public int getIdCommand() {
        return idCommand;
    }

    public User getUser() {
        return user;
    }

    public void setUser( User user ) {
        this.user = user;
    }

    public Date getCommandDate() {
        return commandDate;
    }

    public void setCommandDate( Date commandDate ) {
        this.commandDate = commandDate;
    }

    public List<CommandLine> getCommandLines() {
        return commandLines;
    }

    public void setCommandLines( List<CommandLine> commandLines ) {
        this.commandLines = commandLines;
    }

    @Override
    public String toString() {
        return "Command [idCommand=" + idCommand + ", user=" + user + ", commandDate=" + commandDate + "]";
    }

    // public String toString() {
    // StringBuilder builder = new StringBuilder();
    // builder.append( "Commande de >> " ).append( this.user )
    // .append( " - " ).append( this.commandDate ).append( "\n" );
    // return builder.toString();
    // }

}
