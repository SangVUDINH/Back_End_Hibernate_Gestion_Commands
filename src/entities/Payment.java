package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "T_Payments" )
@Inheritance( strategy = InheritanceType.JOINED )
public abstract class Payment {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int     idPayment;
    private double  amount;
    private Date    paymentDate = new Date();

    @OneToOne
    @JoinTable( name = "T_Commands_Payments_Associations", joinColumns = @JoinColumn( name = "idPayment" ), inverseJoinColumns = @JoinColumn( name = "idCommand" ) )
    private Command command;

    public Payment() {

    }

    public Command getCommand() {
        return command;
    }

    public void setCommand( Command command ) {
        this.command = command;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment( int idPayment ) {
        this.idPayment = idPayment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount( double amount ) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate( Date paymentDate ) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment [idPayment=" + idPayment + ", amount=" + amount + ", paymentDate=" + paymentDate + ", command="
                + command + "]";
    }

}
