package core;

import core.DAO.ClientDao;
import core.Entity.ClientEntity;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ClientEntity l1 = new ClientEntity();
        l1.setIdClient(4);
        l1.setFirstname("Samah");
        l1.setLastname("Rim");
        l1.setEmail("samah.rim@gmail.com");
        l1.setPhone("06748264537");
        l1.setIdCourseSession(2);
        l1.setAddress("Belfort somewhere");
        ClientDao cd = new ClientDao();
        cd.insertEntity(l1);
        System.out.println(cd.getEntities().toString());

    }
}
