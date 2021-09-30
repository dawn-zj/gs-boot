package cn.com.gs.library.service;

import java.util.List;

import cn.com.gs.library.model.Role;
import cn.com.gs.library.model.vo.RoleVO;

public interface IRoleService {
	List<RoleVO> getRole();
	RoleVO getRoleById(Integer id);
}
