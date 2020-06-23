package cn.smbms.dao.user;


import cn.smbms.pojo.User;

public interface UserMapper {
	public int add(User user);
	public User getLoginUser(String userCode);
}
