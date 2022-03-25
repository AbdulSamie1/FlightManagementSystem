package bussinesslogic;

import java.sql.SQLException;
import java.util.Vector;

import database.dbHandlerFlight;

public class flights {
	
	public flights() {
		// TODO Auto-generated constructor stub
	}
	
	public Vector<String> searchbyorigin(String oCity) throws ClassNotFoundException, SQLException{
		Vector<String> vFlights = new Vector<String>();
		dbHandlerFlight f = new dbHandlerFlight();
		Vector<String> temp = new Vector<String>();
		temp = f.loadFlights();
		for(int i=0; i<temp.size();) {
			if(temp.get(i+1).equals(oCity)) {
				vFlights.add(temp.get(i));
				vFlights.add(temp.get(i+1));
				vFlights.add(temp.get(i+2));
				vFlights.add(temp.get(i+3));
				vFlights.add(temp.get(i+4));
				vFlights.add(temp.get(i+5));
				vFlights.add(temp.get(i+6));
				vFlights.add(temp.get(i+7));
				vFlights.add(temp.get(i+8));
				i = i+9;
			}
		}
		return vFlights;
	}
	
	public boolean bookticket(int id, Vector<String> vFlights, int num) throws SQLException {
		Vector<String> tempV = new Vector<String>();
		for(int i=0;i<vFlights.size();) {
			if(vFlights.get(i).equals(String.valueOf(id))) {
				if(num<=Integer.valueOf(vFlights.get(i+4))) {
					int tmp = Integer.valueOf(vFlights.get(i+4));
					tmp = tmp - num;
					tempV.add(vFlights.get(i));
					tempV.add(vFlights.get(i+1));
					tempV.add(vFlights.get(i+2));
					tempV.add(vFlights.get(i+3));
					tempV.add(String.valueOf(tmp));
					tempV.add(vFlights.get(i+5));
					tempV.add(vFlights.get(i+6));
					tempV.add(vFlights.get(i+7));
					tempV.add(vFlights.get(i+8));
					dbHandlerFlight f = new dbHandlerFlight();
					f.updateFlights(tempV);
					return true;
				}
			}
		}
		return false;
	}

}
