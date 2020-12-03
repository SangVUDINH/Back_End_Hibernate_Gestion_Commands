import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.User;

public class ConsoleOneToMany {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory( "Espace_Client" );
            entityManager = entityManagerFactory.createEntityManager();

            User user = entityManager.find( User.class, 1 );
            System.out.println( user.getCommands() );

            //
            // // from CLASS_NAME_java et non from TABLE_NAME
            // List<Command> commands = entityManager.createQuery( "from
            // Command",
            // Command.class )
            // .getResultList();
            //
            // for ( Command command : commands ) {
            // System.out.println( command.toString() );
            // }

        } finally {
            if ( entityManager != null )
                entityManager.close();
            if ( entityManagerFactory != null )
                entityManagerFactory.close();
        }

    }

}
