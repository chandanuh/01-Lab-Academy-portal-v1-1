package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Subjects;
import com.resource.DbResource;

public class SubjectsDao {

	public int StoreSubjects(Subjects sub) {

		try {

			Connection con = DbResource.getDbConnection();
			// preparing the sql
			PreparedStatement pstmt = con.prepareStatement("insert into Subjects values(?, ?)");
			// assiging the values
			pstmt.setInt(1, sub.getSubid());
			pstmt.setString(2, sub.getSubname());

			// execute sql at DB and get the result its like SQL%rowcount
			int result = pstmt.executeUpdate();

			return result;

		} catch (Exception e) {
			System.out.println("Exception  " + e);
			return 0;
		}

	}

	// extract the subject info which is stored in DB
	public List<Subjects> getSubjects() {
		List<Subjects> listOfSubj = new ArrayList<Subjects>();

		try {

			Connection con = DbResource.getDbConnection();
			PreparedStatement psmt = con.prepareStatement("select * from Subjects");

			ResultSet rs = psmt.executeQuery();

			// if the above result set has result passing to UI

			// if the condition is TRUE
			while (rs.next()) {

				Subjects s1 = new Subjects();
				s1.setSubid(rs.getInt(1));
				s1.setSubname(rs.getString(2));
				listOfSubj.add(s1);
			}

		} catch (Exception e) {
			System.out.println("Exception getting the subject details " + e);
		}

		return listOfSubj;

	}

	public int validateSubjectId(int id) {

		try {

			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select subid from Subjects where subid = ?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) // rs.next() == false
			{
				System.out.println("record not present");
				return 0;
			} else {
				return 1;

			}

		} catch (Exception e) {
			System.out.println("Exception " + e);
			return 0;
		}

	}

}
