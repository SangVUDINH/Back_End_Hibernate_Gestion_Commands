import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.User;
import entities.UserInformations;

public class ConsoleOneToOne {

    public static void main( String[] args ) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(
                    "Espace_Client" );
            entityManager = entityManagerFactory.createEntityManager();

            // association INVERSE MAPPEDBY
            List<UserInformations> usersinfos = entityManager
                    .createQuery( "from UserInformations", UserInformations.class )
                    .getResultList();

            for ( UserInformations userinfo : usersinfos ) {
                System.out.println( userinfo.toString() );
            }

            // from CLASS_NAME_java et non from TABLE_NAME
            List<User> users = entityManager.createQuery( "from User",
                    User.class )
                    .getResultList();

            for ( User user : users ) {
                System.out.println( user.toString() );
            }

        } finally {
            if ( entityManager != null )
                entityManager.close();
            if ( entityManagerFactory != null )
                entityManagerFactory.close();
        }

    }

}
