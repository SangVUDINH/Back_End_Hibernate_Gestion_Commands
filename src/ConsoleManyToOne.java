import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Command;

public class ConsoleManyToOne {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory( "Espace_Client" );
            entityManager = entityManagerFactory.createEntityManager();

            Command command = entityManager.find( Command.class, 2 );
            System.out.println( command.getUser() );

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
