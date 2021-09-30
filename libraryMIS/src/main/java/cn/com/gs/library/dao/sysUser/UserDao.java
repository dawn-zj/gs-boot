package cn.com.gs.library.dao.sysUser;

import cn.com.gs.library.model.User;

public interface UserDao {
	public User getUserByAccount(String account);
}
