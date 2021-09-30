package cn.com.gs.library.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.gs.library.model.Role;

public interface RoleDao {
	Role getRoleById(Integer id);
	List<Role> getRole();
	//TODO
	int roleMenu(@Param("id") Integer id, @Param("menuIds") String menuIds, @Param("buttonIds") String buttonIds, @Param("update_time") Integer update_time);
}
