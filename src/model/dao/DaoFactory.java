package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	/*A classe vai expor um metodo que expoe o tipo da interface mas internamente vai instanciar a implementação
	 *  É um macete para não precisar expor a implementação e deixar somente a interface
	 *  Ou seja, no programa podemos acrescentar uma instancia de SellerDao ou outro ... 
	 *  SellerDao sellerDao = DaoFactory.createSellerDao() 
	 *  Dessa forma o programa nao conhece a implementação, ele conhece somente a interface
	 *  É uma forma de fazer uma injeção de dependencia sem explicitar a implementação
	 */

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());  //DB.getConnection() porque o contrutor pede. 
	}
	
}
