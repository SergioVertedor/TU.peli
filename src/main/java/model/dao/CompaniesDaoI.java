package model.dao;

import model.Companies;

// TODO: Eva - Companies o Company?
public interface CompaniesDaoI extends CommonDaoInt<Companies> {
	
	/**
	 * Busca Company por id
	 * @param idCompany
	 * @return Company con el id dado
	 */
	public Companies searchById(final int idCompany);
	
	/**
	 * Busca Company por nombre
	 * @param name
	 * @return Company con el nombre dado
	 */
	public Companies searchByName(final String name);

	
	

}
