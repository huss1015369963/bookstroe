package org.easybooks.bookstore.service.impl;
import java.util.List;
import org.easybooks.bookstore.dao.ICatalogDAO;
import org.easybooks.bookstore.service.ICatalogService;

public class CatalogService implements ICatalogService{
	private ICatalogDAO catalogDAO;
	public List getAllCatalogs(){
		return catalogDAO.getAllCatalogs();
	}
	
	public ICatalogDAO getCatalogDAO(){
		return catalogDAO;
	}
	public void setCatalogDAO(ICatalogDAO catalogDAO) {
		this.catalogDAO = catalogDAO;
	}

}
