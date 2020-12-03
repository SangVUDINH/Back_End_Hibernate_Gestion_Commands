package entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table( name = "T_CreditCardPayments" )
@PrimaryKeyJoinColumn( name = "idPayment" )
public class CreditCardPayment extends Payment {

    private String cardNumber     = "unknown";
    private String expirationDate = "mm//yy";

    public CreditCardPayment() {
        super();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber( String cardNumber ) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate( String expirationDate ) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return super.toString() + "CreditCardPayment [cardNumber=" + cardNumber + ", expirationDate=" + expirationDate
                + "]";
    }

}
