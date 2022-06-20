package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.StudentDets;
import com.bean.Subjects;
import com.resource.DbResource;

public class StudentDetsDao {

	public int storStudent(StudentDets s) {

		try {

			Connection con = DbResource.getDbConnection();
			PreparedStatement p = con.prepareStatement("insert into studentdets values (?,?,?)");
			p.setInt(1, s.getStdid());
			p.setString(2, s.getStdname());
			p.setInt(3, s.getClid());

			// execute sql at DB and get the result its like SQL%rowcount
			int result = p.executeUpdate();

			return result;

		} catch (Exception e) {
			System.out.println("Exception " + e);
			return 0;
		}

	}

	public List<StudentDets> getStudents() {
		List<StudentDets> stdList = new ArrayList<StudentDets>();

		try {

			Connection con = DbResource.getDbConnection();
			PreparedStatement p = con.prepareStatement("select * from studentdets");

			ResultSet rs = p.executeQuery();

			while (rs.next()) {

				StudentDets s1 = new StudentDets();
				s1.setStdid(rs.getInt(1));
				s1.setStdname(rs.getString(2));
				s1.setClid(rs.getInt(3));
				stdList.add(s1);
			}

		} catch (Exception e) {
			System.out.println("Exception " + e);
		}

		return stdList;

	}

}
