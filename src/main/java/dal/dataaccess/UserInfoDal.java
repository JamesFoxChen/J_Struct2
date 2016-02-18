package dal.dataaccess;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import dal.beans.UserInfo;
import framework.utils.MyBatisUtil;

public class UserInfoDal {

	public UserInfo Get() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IUserInfoMapper mapper = sqlSession.getMapper(IUserInfoMapper.class);
		UserInfo bean = mapper.getById(13);
		sqlSession.close();

		return bean;
	}
	
	public List<UserInfo> GetAll() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IUserInfoMapper mapper = sqlSession.getMapper(IUserInfoMapper.class);
		List<UserInfo> lstBean = mapper.getAll();
		sqlSession.close();

		return lstBean;
	}

	public int Insert(UserInfo userInfo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int result = 0;

		try {
			IUserInfoMapper mapper = sqlSession.getMapper(IUserInfoMapper.class);
			result = mapper.add(userInfo);
			sqlSession.commit();
			sqlSession.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			sqlSession.rollback();
			sqlSession.close();
			result = -1;
		}

		return result;
	}
}
