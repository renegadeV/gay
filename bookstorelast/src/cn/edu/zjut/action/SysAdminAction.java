package cn.edu.zjut.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zjut.po.Category;
import cn.edu.zjut.po.Role;
import cn.edu.zjut.po.SysAdmin;
import cn.edu.zjut.service.ISysAdminService;

public class SysAdminAction extends ActionSupport{
	private ISysAdminService sysadminService=null;
	private SysAdmin sysadmin;
	private Role role;
	protected List<Role> roleList;
	private String[] chkName;  //Ϊ��ѡ�����õ�����
	 //getter()��setter() ����һ��Ҫ��  
	 public String[] getChkName(){  
	    return chkName;  
	    }  
	 public void setChkName(String[] chkName){  
	    this.chkName=chkName;  
	    }  
	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public ISysAdminService getSysadminService() {
		return sysadminService;
	}

	public void setSysadminService(ISysAdminService sysadminService) {
		this.sysadminService = sysadminService;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public SysAdmin getSysadmin() {
		return sysadmin;
	}

	public void setSysadmin(SysAdmin sysadmin) {
		this.sysadmin = sysadmin;
	}

	private boolean islogin(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		if(session.get("sysadmin")==null){
			return false;
		}
		return true;
	}
	
	public String login(){
		if(sysadminService.login(sysadmin.getAccount(), sysadmin.getPassword()))
		{
			Map<String,Object> session=ActionContext.getContext().getSession();
			session.put("sysadmin", sysadmin);
			return "success";
		}
		//this.addActionMessage("��½ʧ�ܣ��û������������");
		return "fail";
	}
	public String logout() {
		Map<String,Object> session=ActionContext.getContext().getSession();
		session.remove("sysadmin");
		return "success";
	}
	//��ӽ�ɫ
	public String addRole() {
		if(islogin()){
			//System.out.println(role.getRoleName());
			sysadminService.saveRole(role);
		return "success";
		}
		//this.addActionMessage("���ʧ�ܣ�");
		return "fail";
	}
	//��ȡ���н�ɫ
	public String getAllRoles() {
		roleList=sysadminService.findAllRoles();
		return "success";
	}
	//ɾ����ɫ
	public String deleteRole(){
		role=sysadminService.findByRoleID(role.getRoleID());
		sysadminService.deleteRole(role);
		roleList=sysadminService.findAllRoles();
		this.addActionMessage("ɾ���ɹ��������...");
		return "success";
	}
	//���½�ɫ
	public String updateRole(){
		if(islogin()){
			sysadminService.updateRole(role);
			roleList=sysadminService.findAllRoles();
			this.addActionMessage("�޸ĳɹ��������...");
			return "success";
		}
		return "fail";
	}
	//ͨ����ɫid��ȡ��ɫ
	public String getRoleByRoleID(){
		role=sysadminService.findByRoleID(role.getRoleID());
		return "success";
	}
	//����Ȩ����
	public String updateRight() {
		if(islogin()){
			Integer rightCode=0;
			//��ȡ��ѡ�������Ȩֵ֮��
			if(this.getChkName()!=null)
			{
				for(int i=0;i<this.getChkName().length;i++){  
					String chkNameValue=this.getChkName()[i];
					rightCode+=Integer.parseInt(chkNameValue);
				}
			}
			role.setRightCode(rightCode);
			sysadminService.updateRole(role);
			roleList=sysadminService.findAllRoles();
			this.addActionMessage("�޸ĳɹ��������...");
			return "success";
		}
		return "fail";
	}
}
