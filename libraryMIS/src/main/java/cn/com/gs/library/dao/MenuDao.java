package cn.com.gs.library.dao;

import java.util.List;

import cn.com.gs.library.model.Menu;

public interface MenuDao {
	Menu getMenuById(Integer id);
	List<Menu> getMenuByPid(Integer pid);
	//TODO
	List<Menu> getMenuByIds(String ids);
}
