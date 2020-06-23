package cn.smbms.dao.user;

import org.mybatis.spring.SqlSessionTemplate;

import cn.smbms.pojo.User;

public class UserMapperImpl implements UserMapper{
	SqlSessionTemplate sqlSession;
	

	@Override
	public int add(User user) {
		return sqlSession.insert("cn.smbms.dao.user.UserMapper.add", user);
	}


	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}


	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}


	@Override
	public User getLoginUser(String userCode) {
		return sqlSession.selectOne("cn.smbms.dao.user.UserMapper.getLoginUser", userCode);
	}
	
}
