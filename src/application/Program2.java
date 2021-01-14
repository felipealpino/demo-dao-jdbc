package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TESTE 1: Department findById ===");
		Department dep = depDao.findById(3);
		System.out.println(dep);
		
		
		System.out.println();
		System.out.println("=== TESTE 2: Department findAll ===");
		List<Department> depList = new ArrayList<>();
		depList = depDao.findAll();
		depList.forEach(System.out::println);
		
		
		System.out.println();
		System.out.println("=== TESTE 3: Department Delete ===");
		System.out.println("Lembre-se que ao digitar o Id abaixo, ele NÃO pode estar em uso pela table seller");
		System.out.print("Insira um Id para ser deletado: ");
		int idToDelete = sc.nextInt();
		sc.nextLine();
		depDao.deleteById(idToDelete);
		System.out.println("Valor deletado!");
		
		
		System.out.println();
		System.out.println("=== TESTE 4: Department Insert ===");
		Department depInsert = new Department(null, "Logistica");
		depDao.insert(depInsert);
		System.out.println("Valor inserido! Novo id: "+depInsert.getId());
		
		
		System.out.println();
		System.out.println("=== TESTE 5: Department Update ===");
		dep = depDao.findById(3);
		String oldName = dep.getName();
		dep.setName("New Fashion");
		String newName = dep.getName();
		depDao.update(dep);
		System.out.println("Atualizado! Id: "+dep.getId()+" de nome: "+oldName+" para "+newName);
		
		

		sc.close();
	}

}
