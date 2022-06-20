package com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bean.AcamdemicClass;
import com.bean.Subjects;
import com.dao.AcamdemicClassDao;

public class AcamdemicClassService {

	AcamdemicClassDao ad = new AcamdemicClassDao();

	public String storeAcamec(AcamdemicClass a) {

		int id = a.getClid();
		
		System.out.println("1. Validation of class id ");
		
		if  (ad.validateClassId(id) == 1 )
		{
			System.out.println("2. Validation of class id2 ");
			return "Class Room Id alreay exist"; 
		}
		
		
		if (id == 10 || id == 11 || id == 12) {
			int result = ad.StoreAcamdemicClass(a);

			if (result != 0) {
				return "Academic Classes Details Stored Succcesfully";
			} else {
				return "DB error occured whiler persisting the data";
			}

		} else {
			return "Accepted Class numbers are 10 or 11 or 12 ";
		}

	}

	public List<AcamdemicClass> getAcamdemicDetails() {
		List<AcamdemicClass> acdemicList = ad.getAcademic();
		Iterator<AcamdemicClass> acList = acdemicList.iterator();

		while (acList.hasNext()) {
			AcamdemicClass s = acList.next();
		}

		return acdemicList;

	}

}
