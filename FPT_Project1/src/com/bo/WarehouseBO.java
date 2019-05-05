package com.bo;

import java.util.List;

import com.bean.Warehouse;
import com.dao.WarehouseDAO;

public class WarehouseBO {
	WarehouseDAO warehouseDao = new WarehouseDAO();
	
	public List<Warehouse> getListWarehouse(){
		return warehouseDao.getAllMedicTypeList();
	}
}	
