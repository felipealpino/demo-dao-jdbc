package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	/*A classe vai expor um metodo que expoe o tipo da interface mas internamente vai instanciar a implementa��o
	 *  � um macete para n�o precisar expor a implementa��o e deixar somente a interface
	 *  Ou seja, no programa podemos acrescentar uma instancia de SellerDao ou outro ... 
	 *  SellerDao sellerDao = DaoFactory.createSellerDao() 
	 *  Dessa forma o programa nao conhece a implementa��o, ele conhece somente a interface
	 *  � uma forma de fazer uma inje��o de dependencia sem explicitar a implementa��o
	 */

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());  //DB.getConnection() porque o contrutor pede. 
	}
	
}
