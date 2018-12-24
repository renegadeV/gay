package cn.edu.zjut.service;

import java.util.List;

import cn.edu.zjut.dao.ISysAdminDAO;
import cn.edu.zjut.po.Category;
import cn.edu.zjut.po.Role;

public class SysAdminService implements ISysAdminService{
	ISysAdminDAO sysadminDAO=null;
	public ISysAdminDAO getSysadminDAO() {
		return sysadminDAO;
	}
	public void setSysadminDAO(ISysAdminDAO sysadminDAO) {
		this.sysadminDAO = sysadminDAO;
	}
	public boolean login(String account,String password) {
		// TODO Auto-generated method stub
		return sysadminDAO.login(account, password);
		//return true;
	}
	public void saveRole(Role role) {
		sysadminDAO.saveRole(role);
	}
	public List<Role> findAllRoles(){
		return sysadminDAO.findAllRoles();
	}
	public Role findByRoleID(Integer roleID) {
		// TODO Auto-generated method stub
		return sysadminDAO.findRoleByRoleID(roleID);
	}
	public void deleteRole(Role role) {
		sysadminDAO.deleteRole(role);
	}
	public void updateRole(Role role) {
		sysadminDAO.updateRole(role);
	}
}
