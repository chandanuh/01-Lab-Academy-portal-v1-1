package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.AcamdemicClass;
import com.bean.Subjects;
import com.resource.DbResource;

public class AcamdemicClassDao {

	public int StoreAcamdemicClass(AcamdemicClass a) {

		try {

			Connection con = DbResource.getDbConnection();
			PreparedStatement p = con.prepareStatement("insert into acamdemicclass values (?,?)");
			p.setInt(1, a.getClid());
			p.setInt(2, a.getClassnum());
			// execute sql at DB and get the result its like SQL%rowcount
			int result = p.executeUpdate();

			return result;

		} catch (Exception e) {
			System.out.println("Exception  " + e);
			return 0;
		}

	}

	public List<AcamdemicClass> getAcademic() {

		List<AcamdemicClass> li = new ArrayList<AcamdemicClass>();

		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement p = con.prepareStatement("select * from acamdemicclass");

			ResultSet rs = p.executeQuery();

			// if the above result set has result passing to UI

			// if the condition is TRUE
			while (rs.next()) {

				AcamdemicClass s1 = new AcamdemicClass();
				s1.setClid(rs.getInt(1));
				s1.setClassnum(rs.getInt(2));
				li.add(s1);
			}

		} catch (Exception e) {
			System.out.println("exception " + e);
		}

		return li;
	}

	public int validateClassId(int id) {

		try {

			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select clid from acamdemicclass where clid = ?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("record  present");
				return 1;
			} else {
				System.out.println("record not present");
				return 0;
			}

			/*
			 * if (!rs.next()) // rs.next() == false {
			 * System.out.println("record not present"); return 0; } else { return 1;
			 * 
			 * }
			 */

		} catch (Exception e) {
			System.out.println("Exception " + e);
			return 0;
		}

	}
	
	public int validateClassNum(int id) {

		try {

			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select clid from acamdemicclass where classnum = " + id);
		//	pstmt.setInt(2, id);
		//	pstmt.setInt(id, id);
		//	pstmt.setInt(id, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("Class number is   present");
				return 1;
			} else {
				System.out.println("Class numebr is not present");
				return 0;
			}

			/*
			 * if (!rs.next()) // rs.next() == false {
			 * System.out.println("record not present"); return 0; } else { return 1;
			 * 
			 * }
			 */

		} catch (Exception e) {
			System.out.println("Exception " + e);
			return 0;
		}

	}

}
