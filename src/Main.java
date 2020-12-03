import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Utilisateur;

public class Main {

    public static void main( String[] args ) throws Exception {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory( "Espace_Client" );
            entityManager = entityManagerFactory.createEntityManager();

            System.out.println( "- Lecture d'un utilisateur -----------" );
            Utilisateur uti = entityManager.find( Utilisateur.class, 2 );
            System.out.println( uti.toString() );

            System.out.println( "- Lecture de tous les utilisateurs -----------" );
            List<Utilisateur> utilisateurs = entityManager.createQuery( "from Utilisateur", Utilisateur.class )
                    .getResultList();

            for ( Utilisateur utilisateur : utilisateurs ) {
                System.out.println( utilisateur.toString() );
            }

            // ouverture de la transaction
            EntityTransaction trans = entityManager.getTransaction();
            trans.begin();

            // UPDATE entityManager.persist(Utilisateur uti);
            uti.setName( "NOUVEAU_NAME" );
            entityManager.persist( uti );

            // creer un nouveau ligne INSERT INTO

            Utilisateur newUti = new Utilisateur( "NV_NAME2" );
            entityManager.persist( newUti );

            // entityManager.remove( uti );

            trans.commit();

        } finally {
            if ( entityManager != null )
                entityManager.close();
            if ( entityManagerFactory != null )
                entityManagerFactory.close();
        }
    }

}
