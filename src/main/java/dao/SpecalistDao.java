package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entities.Specalist;

public class SpecalistDao {

	private Connection con;


	public SpecalistDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean addSpecalist(String spec)	{
		boolean f=false;
		
		try {
			String sql="insert into specalist (name) values(?)";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, spec);
			
			int i=ps.executeUpdate();
			if(i>0) {
				f=true;
				
				System.out.println("Specalist done");
			}
			else {
				System.out.println("something went wrong");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public List<Specalist> getAllSpecalist() {
		
		List<Specalist> list = new ArrayList<Specalist>();
		Specalist s = null;

		try {
			String sql = "select * from specalist";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				s = new Specalist();
				s.setS_id(rs.getInt(1));
				s.setS_name(rs.getString(2));
				list.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
 
}
