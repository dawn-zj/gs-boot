package cn.com.gs.library.service;

import java.util.List;

import cn.com.gs.library.model.Button;
import cn.com.gs.library.model.Menu;

public interface IUserService {
	public List<Menu> getMenuByRoleId(Integer roleId);
	public List<Button> getButtonByRoleId(Integer roleId);
	//public Integer login(String account, String password);
}
