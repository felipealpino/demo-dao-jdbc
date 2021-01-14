package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TESTE 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println();
		System.out.println("=== TESTE 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);

		System.out.println();
		System.out.println("=== TESTE 3: seller findAll ===");
		list = sellerDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println();
		System.out.println("=== TESTE 4: seller Insert ===");
		//department criado no teste 2
		Seller newSeller = new Seller(null, "Jorge", "Jogin@hotmail.com", new Date(), 5000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserido! Novo id: " +newSeller.getId());;
		
		
		System.out.println();
		System.out.println("=== TESTE 5: seller Update ===");
		//department criado no teste 2
		seller = sellerDao.findById(7); // pegando o item no id 7 -- Felipe Gontijo 
		seller.setEmail("felipeSinerd@codingHard.com"); // Setando um diferente email para o objeto
		sellerDao.update(seller); // fazendo o update do novo objeto 
		System.out.println("Modificado! " + seller );
		
	}

}
