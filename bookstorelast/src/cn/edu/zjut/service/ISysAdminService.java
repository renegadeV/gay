package cn.edu.zjut.service;

import java.util.List;

import cn.edu.zjut.po.Role;

public interface ISysAdminService {
	public boolean login(String account,String password);
	public void saveRole(Role role);
	public List<Role> findAllRoles();
	public Role findByRoleID(Integer roleID);
	public void deleteRole(Role role);
	public void updateRole(Role role);
}
