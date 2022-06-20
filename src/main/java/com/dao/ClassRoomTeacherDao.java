package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.ClassRoomTeacher;
import com.bean.ClassTeacherSubjects;
import com.bean.Subjects;
import com.resource.DbResource;

public class ClassRoomTeacherDao {

	public int StroreClassTeachers(ClassRoomTeacher c) {

		try {

			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into classroomteacher values(?,?,?,?)");

			pstmt.setNull(1, 0);

			// pstmt.setInt(1, "null" );
			pstmt.setInt(2, c.getClassroomid());// this is for classroomid
			pstmt.setInt(3, c.getSubid()); // setting for subid
			pstmt.setInt(4, c.getTid()); // seeting for Tid

			int result = pstmt.executeUpdate();
			return result;

		} catch (Exception e) {

			System.out.println("Exception occured " + e);
			return -11;
		}

	}

	AcamdemicClassDao a = new AcamdemicClassDao();

	public int validateClassNum(int id) {

		if (a.validateClassNum(id) == 1) // (id == 10 || id == 11 || id == 12)

		{
			return 1; //class present 
		} else {
			return 0; // classes not configured 
		}

	}

	public int validateClassPercnt(int id) {

		try {

			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareCall("select classroomid from classroomteacher where classroomid = ?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) // rs.next() == false
			{
				System.out.println("record not classroomteacher and process furether validations");
				return 0; // no records present
			} else {
				return 1; // there is record present with class
			}

		} catch (Exception e) {
			System.out.println("exception " + e);
			return 0;
		}

	}

	// pass the class id
	public int validatPerClasPerSubj(ClassRoomTeacher c) {
		try {

			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con
					.prepareStatement("select subid  from classroomteacher where classroomid = ? and subid= ? ");
			pstmt.setInt(1, c.getClassroomid());
			pstmt.setInt(2, c.getSubid());

			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) // rs.next() == false
			{
				// System.out.println("record not classroomteacher and process further
				// validations");
				return 0; // no records present
			} else {
				return 9999; // combination of the subject and class already present dont insert duplicate
								// records
			}
			// return 1;
		} catch (Exception e) {
			System.out.println("Exception " + e);
			return 0;
		}

	}

	// pass the class id
	public int validatPerClasPerTeacher(ClassRoomTeacher c) {
		try {

			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con
					.prepareStatement("select tid  from classroomteacher where classroomid = ? and tid= ? ");
			pstmt.setInt(1, c.getClassroomid());
			pstmt.setInt(2, c.getTid());

			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) // rs.next() == false
			{
				// System.out.println("Teacher has to be assiged to this calls and create
				// entry");
				return 0; // no records present
			} else {
				return 9999; // Teacher already assigned to this class
			}
			// return 1;
		} catch (Exception e) {
			System.out.println("Exception " + e);
			return 0;
		}

	}

	public int validatPerClasPerTeach(ClassRoomTeacher c) {
		try {

			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con
					.prepareStatement("select subid  from classroomteacher where classroomid = ? and tid= ? ");
			pstmt.setInt(1, c.getClassroomid());
			pstmt.setInt(2, c.getTid());

			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) // rs.next() == false
			{
				System.out.println("record not present  and process further to store the record ");
				return 1; // no records present
			} else {
				return 8888; // combination of the tid and class already present dont insert duplicate
								// records
			}
			// return 1;
		} catch (Exception e) {
			System.out.println("Exception " + e);
			return 0;
		}

	}

	public List<ClassRoomTeacher> getClassRooms() {
		List<ClassRoomTeacher> listOfRooms = new ArrayList<ClassRoomTeacher>();

		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement p = con.prepareStatement("select classroomid, subid, tid    from classroomteacher");

			ResultSet rs = p.executeQuery();

			// if the above result set has result passing to UI

			// if the condition is TRUE
			while (rs.next()) {
				ClassRoomTeacher c = new ClassRoomTeacher();
				c.setClassroomid(rs.getInt(1));
				c.setSubid(rs.getInt(2));
				c.setTid(rs.getInt(3));
				listOfRooms.add(c);
			}

		} catch (Exception e) {
			System.out.println("exception " + e);
		}

		return listOfRooms;
	}

	public List<ClassTeacherSubjects> getAllClassTeacherSubj() {
		// List<Object[]> li = new ArrayList<Object[]>();
		List<ClassTeacherSubjects> li = new ArrayList<ClassTeacherSubjects>();

		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement p = con.prepareStatement("select  c.classroomid, t.tname, s.subname \r\n"
					+ "from   classroomteacher c,  Teachers t ,Subjects s\r\n" + "where c.tid = t.tid \r\n"
					+ "and c.subid = s.subid");

			ResultSet rs = p.executeQuery();

			while (rs.next()) {

				ClassTeacherSubjects ct = new ClassTeacherSubjects();
				ct.setClassroomid(rs.getInt(1));
				ct.setSubname(rs.getString(2));
				ct.setTname(rs.getString(3));

				li.add(ct);
			}

		} catch (Exception e) {
			System.out.println("Exception occured " + e);
		}

		return li;

	}

}
