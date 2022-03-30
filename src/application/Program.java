package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: Seller findById ===");
		Seller seller = sellerDao.findById(7);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: Seller findByDepartment ===");
		Department department = new Department(4, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
	
		System.out.println("\n=== TEST 3: Seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
	
		/*System.out.println("\n=== TEST 4: Seller insert ===");
		Seller newSeller = new Seller(null, "Antonella", "tutu@hotmail.com", new Date(), 2800.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! Id number = " + newSeller.getId());*/
	
		System.out.println("\n=== TEST 5: Seller update ===");
		seller = sellerDao.findById(1);
		seller.setBaseSalary(2200.0);
		sellerDao.update(seller);
		System.out.println("Update succesful!");
	
		System.out.println("\n=== TEST 6: Seller delete ===");
		sellerDao.deleteById(10);
		System.out.println("Seller deleted from database");
	}

}
