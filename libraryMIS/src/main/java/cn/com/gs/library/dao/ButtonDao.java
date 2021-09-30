package cn.com.gs.library.dao;

import java.util.List;

import cn.com.gs.library.model.Button;

public interface ButtonDao {
	
	Button getButtonById(Integer id);
	
	List<Button> getButtonByUserId(Integer id);
	
	List<Button> getButtonByMenuId(Integer menuId);
}
