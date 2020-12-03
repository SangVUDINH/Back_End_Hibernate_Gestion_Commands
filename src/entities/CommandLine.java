package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "T_CommandLines" )
public class CommandLine {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int     idCommandLine;

    @ManyToOne
    @JoinColumn( name = "idArticle", nullable = false )
    private Article article;

    @ManyToOne
    @JoinColumn( name = "idCommand", nullable = false )
    private Command command;

    private int     quantity;

    public int getIdCommandLine() {
        return idCommandLine;
    }

    public void setIdCommandLine( int idCommandLine ) {
        this.idCommandLine = idCommandLine;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle( Article article ) {
        this.article = article;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand( Command command ) {
        this.command = command;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CommandLine [idCommandLine=" + idCommandLine + ", article=" + article + ", command=" + command
                + ", quantity=" + quantity + "]";
    }

}
