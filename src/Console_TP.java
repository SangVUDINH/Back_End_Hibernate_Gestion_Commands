import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Command;
import entities.CommandLine;
import entities.Payment;
import entities.Role;
import entities.User;
import entities.UserInformations;

public class Console_TP {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory( "Espace_Client" );
            entityManager = entityManagerFactory.createEntityManager();

            // USER vers USERINFO
            User user = entityManager.find( User.class, 1 );
            System.out.println( user );

            // USERINFO vers USER
            UserInformations userinfo = entityManager.find( UserInformations.class, 1 );
            System.out.println( userinfo );

            // Command vers USER
            Command cmd = entityManager.find( Command.class, 1 );
            System.out.println( cmd );

            // USER vers COMMAND
            User user1 = entityManager.find( User.class, 1 );
            System.out.println( user1 );

            // LECTURE COMMANDS + PAYMENT
            for ( Command cmd1 : user1.getCommands() ) {
                System.out.println( cmd1 );
                System.out.println( "+ CMD / PAYEMENT :" + cmd1.getPayment() );

                // LECTURE COMMAND vers COMMANDLINE
                for ( CommandLine cmdLine : cmd1.getCommandLines() ) {
                    System.out.println( "CMDLINE :" );
                    System.out.println( cmdLine );
                }
            }

            // LECTURE CMDLINE
            System.out.println( "AFFICHE COMMANDLINE :" );
            CommandLine cmdLine = entityManager.find( CommandLine.class, 1 );
            System.out.println( cmdLine );

            // LECTURE ROLES
            System.out.println( "AFFICHE ROLES :" );
            Role role = entityManager.find( Role.class, 1 );
            System.out.println( role );

            // LECTURE ROLE vers USER
            for ( User userR : role.getUsers() ) {
                System.out.println( "USERS :" );
                System.out.println( userR );
            }

            // LECTURE USER vers ROLE
            for ( Role roleR : user1.getRoles() ) {
                System.out.println( "ROLES :" );
                System.out.println( roleR );
            }

            TypedQuery<Payment> query = entityManager.createQuery( "from Payment", Payment.class );
            List<Payment> payments = query.getResultList();
            for ( Payment payment : payments ) {
                System.out.println( payment.getClass().getName() );
                System.out.println( "\t" + payment );
            }
        } finally {
            if ( entityManager != null )
                entityManager.close();
            if ( entityManagerFactory != null )
                entityManagerFactory.close();
        }

    }

}
