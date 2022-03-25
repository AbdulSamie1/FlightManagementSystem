package bussinesslogic;

import java.sql.SQLException;
import java.util.Vector;

import database.dbHandlerUser;

public class user {
	
	String email;
	String pass;

	public user(String e, String p) {
		this.email=e;
		this.pass=p;
	}
	
	public boolean checkUser() throws ClassNotFoundException, SQLException {
		dbHandlerUser u = new dbHandlerUser(email, pass);
		Vector<String> vUser = u.loadUser();
		int vSize = vUser.size();
		for(int i=0;i<vSize;) {
			if(vUser.get(i+3).equals(email) && vUser.get(i+4).equals(pass)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean verifyNewUser(String fname, String lname) throws ClassNotFoundException, SQLException {
		dbHandlerUser u = new dbHandlerUser(email, pass);
		boolean temp = u.enterUser(fname, lname);
		return temp;
	}

}
