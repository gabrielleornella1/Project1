import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.dao.Dbconnection;
import com.example.dao.ErsUsersDaoImp;
import com.example.model.ErsUsersModel;


public class ReceipTest {
	
	public static Dbconnection con = new Dbconnection();
	public static ErsUsersDaoImp cDao = new ErsUsersDaoImp(con);
	public static ErsUsersModel c = null;
	
	
	@Test
	public void insertErsUsers() {
		int ers_users_id= 3;
		int user_role_id= 4;
		c = new ErsUsersModel(ers_users_id, "gabi", "gabi123", "gabrielle", "obiang", "gabi@gmail.com", user_role_id);
		assertEquals(cDao.insert(c), true);
		c = new ErsUsersModel(ers_users_id, "gabi", "gabi123", "gabrielle", "obiang", "gabi@gmail.com", user_role_id);
		assertEquals(cDao.insert(c), false);
		
	}
	
	

}
