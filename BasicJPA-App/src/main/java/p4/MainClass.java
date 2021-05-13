package p4;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {
	public static void main(String[] args) {

		// Super-class
		Insurance insurance = new Insurance(4000, "Rajesh", LocalDate.now());

		// child-class
		LifeInsurance li1 = new LifeInsurance(3000, "Suresh", LocalDate.now(), 900000, 50);

		// child-class
		MedicalInsurance mi = new MedicalInsurance(2100, "Suhas", LocalDate.now(), 25000, 3000);

		Configuration cfg = new Configuration();
		SessionFactory fac = cfg.configure().buildSessionFactory();
		Session session = fac.openSession();

		Transaction t = session.beginTransaction();
		
		// EntityManager em;
		session.save(insurance);
		session.save(li1);
		session.save(mi);
		
		mi.setMedicalCoverage(56789);
		t.commit();

		System.out.println(" Data Saved");
		
		
	}

}
