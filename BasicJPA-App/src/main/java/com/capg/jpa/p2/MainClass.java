package com.capg.jpa.p2;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {
	
	public static void main(String[] args) throws SQLException {
		
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory(); 
		
		Session session = factory.openSession();// jdbc -> coonection object
		Transaction t = session.beginTransaction();
		
		// ---- write code for data base operation ----
		//insert
		
		Account a = new Account();
		a.setAccountHolderName("Priya");
		a.setBalance(5000);
		a.setOpenningDate(LocalDate.now());
		
		System.out.println("Enter address");
		Address ad = new Address(203,"AshokNagar,Hyderabad","Telangana");
		a.setAddress(ad);
		
		System.out.println("Enter the office address");
		Address ofd = new Address(123,"Hitechcity,Hyderabad","Telangana");
		a.setOffice_address(ofd);
		
		Policy p1 = new Policy("Policy-A",100,2000);
		Policy p2 = new Policy("Policy-B",200,4000);
		Policy p3 = new Policy("Policy-C",300,6000);
		
		List<Policy> pl = Arrays.asList(p1,p2,p3);
		
		a.setPolicies(pl);
		
		session.save(a);  // insert into Account .....
		
		System.out.println("  -->> Data Saved ..");
		t.commit();
		
		Account a1 = (Account) session.load(Account.class, a.getAccId());
		
		System.out.println(a1);
		
		session.close();
		
		
				
	}
}



//delete
		/*Account a = (Account) session.load(Account.class, 101);
		session.delete(a);
		
		t.commit();
		session.close();*/
		
		//update
		/*Account a = (Account) session.load(Account.class, 23);
		a.setAccountHolderName("Sreeja");
		session.update(a);
		
		session.save(a);
		t.commit();
		
		session.close();
		
		System.out.println(a);*/

