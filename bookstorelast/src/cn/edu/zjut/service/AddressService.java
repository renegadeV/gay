package cn.edu.zjut.service;

import cn.edu.zjut.dao.IAddressDAO;
import cn.edu.zjut.po.Address;

public class AddressService implements IAddressService{
private IAddressDAO addressDAO=null;
public void setAddressDAO(IAddressDAO addressDAO){
	this.addressDAO=addressDAO;
}
public IAddressDAO getAddressDAO(){
	return  this.addressDAO;
}
@Override
public void updateAddress(Address address) {
	// TODO Auto-generated method stub
	addressDAO.UpdateAddress(address);
	
}

}
