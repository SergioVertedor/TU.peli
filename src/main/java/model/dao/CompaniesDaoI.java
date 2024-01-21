package model.dao;

import model.Company;


public interface CompaniesDaoI extends CommonDaoInt<Company> {
	
	/**
	 * Busca Company por id
	 * @param idCompany
	 * @return Company con el id dado
	 */
	public Company searchById(final int idCompany);
	
	/**
	 * Busca Company por nombre
	 * @param name
	 * @return Company con el nombre dado
	 */
	public Company searchByName(final String name);

	
	

}
