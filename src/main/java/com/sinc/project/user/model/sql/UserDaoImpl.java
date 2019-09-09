package com.sinc.project.user.model.sql;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sinc.project.user.model.vo.UserVO;

@Repository("userD")
@Service("userD")
public class UserDaoImpl implements UserDao{

	// root-context.xml파일에 정의된 schema기반의 sqlSession을 불러옴
	@Resource(name="sqlSession")
	private SqlSession session;
	
	@Override
	public UserVO loginRow(UserVO user) {
		System.out.println("UserDaoImpl loginRow");
		return session.selectOne("com.sinc.user.login", user);
	}

}
