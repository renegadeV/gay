package cn.edu.zjut.dao;

import java.util.List;

import cn.edu.zjut.po.Role;

public interface ISysAdminDAO {
	public boolean login(String account,String password);
	public void saveRole(Role role);
	public List<Role> findAllRoles();
	public Role findRoleByRoleID(Integer roleID);
	public void deleteRole(Role role);
	public void updateRole(Role role);
}
