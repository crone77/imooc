package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UsersDAO;
import serviceImpl.UsersDAOImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;

public class UsersAction extends SuperAction implements ModelDriven<Users> {
	private Users user = new Users();

	// 用户登录动作
	public String login() {
		UsersDAO udao = new UsersDAOImpl();
		if (udao.usersLogin(user)) {
			
			//在session中保存登录成功的用户名
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		} else {
			return "login_failure";
		}
	}
	@SkipValidation
	//用户注销方法
	public String logout(){
		if(session.getAttribute("loginUserName")!=null){
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
		
	}
	
	public void validate(){
		//用户名不能为空
		if("".equals(user.getUsername().trim())){
			this.addFieldError("usernameError", "用户名不能为空！");
		}
		if(user.getPassword().length()<6){
			this.addFieldError("passwordError", "密码长度不能少于6位");
		}
	}
	
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
