package cn.com.gs.library.service;

import java.util.List;

import cn.com.gs.library.model.Menu;
import cn.com.gs.library.model.vo.MenuVO;

public interface IMenuService {
	Menu getMenuById(Integer id);
	List<MenuVO> getMenuByPid(Integer pid) throws Exception;
}
