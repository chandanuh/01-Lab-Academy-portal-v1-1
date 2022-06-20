package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Teachers;
import com.resource.DbResource;

public class TeachersDao {

	public int StroreTeahers(Teachers t) {

		try {

			Connection con = DbResource.getDbConnection();

			// based on the user parameter insert records into DB
			PreparedStatement pstmt = con.prepareStatement("insert into Teachers values(?, ?)");
			pstmt.setInt(1, t.getTid());
			pstmt.setString(2, t.getTname());

			int res = pstmt.executeUpdate();

			return res;

		} catch (Exception e) {
			System.out.println("Exception occured in Storing Teachers " + e);
			return 0;
		}

	}

	// to get the teachers details which were stored in DB
	public List<Teachers> getTeacgers() {
		List<Teachers> listOfTeachers = new ArrayList<Teachers>();

		try {

			Connection con = DbResource.getDbConnection();
			// creating the sql
			PreparedStatement psmt = con.prepareStatement("select * from Teachers");

			// running the query and capturing ther result set
			ResultSet rs = psmt.executeQuery();

			// if the above result set has recods passing to UI

			// if the condition is TRUE
			while (rs.next()) {
				Teachers t = new Teachers();
				t.setTid(rs.getInt(1));
				t.setTname(rs.getString(2));
				listOfTeachers.add(t);
			}

			// return listOfTeachers;
		} catch (Exception e) {
			System.out.println("Exception occured while retriving Teachers " + e);
			// return listOfTeachers;
		}

		return listOfTeachers;

	} // end of the method

	// validate employee record exist or not

	public int validateEmp(int id) {

		try {

			Connection con = DbResource.getDbConnection();
			PreparedStatement rs1 = con.prepareStatement("Select tid from Teachers where tid = ?");
			rs1.setInt(1, id);
			ResultSet rs = rs1.executeQuery();
			if (!rs.next()) // rs.next() == false
			{
				System.out.println("record not present");
				return 0;
			} else {
				return 1;
				// System.out.println("EmpID is already exist id is " + id);
			}

		} catch (Exception e) {
			return 0;
		}

	}

}
