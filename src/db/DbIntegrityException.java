package db;

public class DbIntegrityException extends RuntimeException{

	/**
	 * CRIADA SOMENTE PARA DELETAR PARA ARRUMAR O PROBLEMA DE INTEGRIDADE REFERENCIAL
	 */
	private static final long serialVersionUID = 1L;
	
	public DbIntegrityException(String msg) {
		super(msg);
	}

}
