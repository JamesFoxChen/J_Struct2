package dal.dataaccess;

import org.apache.ibatis.session.SqlSession;
import dal.beans.UserInfo;
import framework.utils.MyBatisUtil;

public class UserInfoDal {

	public UserInfo Select() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IUserInfoMapper mapper = sqlSession.getMapper(IUserInfoMapper.class);
		UserInfo bean = mapper.getById(13);
		sqlSession.close();

		return bean;
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
