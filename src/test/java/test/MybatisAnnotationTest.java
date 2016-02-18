package test;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import dal.beans.*;
import framework.utils.MyBatisUtil;
import dal.dataaccess.*;

public class MybatisAnnotationTest {

	// http://www.cnblogs.com/xdp-gacl/p/4261895.html
	@Test
	public void Select() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		// 得到AdminInfoMapper接口的实现类对象，IAdminInfoMapper接口的实现类对象由sqlSession.getMapper(IAdminInfoMapper.class)动态构建出来
		IAdminInfoMapper mapper = sqlSession.getMapper(IAdminInfoMapper.class);
		// 执行查询操作，将查询结果自动封装成User返回
		AdminInfo bean = mapper.getById(13);
		// 使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(bean.getId());
		System.out.println(bean.getAdminName());
	}

	@Test
	public void SelectAll() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IAdminInfoMapper mapper = sqlSession.getMapper(IAdminInfoMapper.class);
		List<AdminInfo> bean = mapper.getAll();
		sqlSession.close();

		System.out.println(bean.size());
	}

	@Test
	public void SelectAdminRightInfo() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IAdminInfoMapper mapper = sqlSession.getMapper(IAdminInfoMapper.class);
		List<AdminRightInfo> bean = mapper.getAdminRightInfo(1);
		sqlSession.close();

		System.out.println(bean.size());
	}

	@Test
	public void Insert() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IAdminInfoMapper mapper = sqlSession.getMapper(IAdminInfoMapper.class);

		AdminInfo bean = new AdminInfo();
		bean.setAdminName("Admin" + System.currentTimeMillis());

		int result = mapper.add(bean);
		sqlSession.commit();
		sqlSession.close();

		System.out.println(result);
	}

	@Test
	public void Update() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IAdminInfoMapper mapper = sqlSession.getMapper(IAdminInfoMapper.class);

		AdminInfo bean = new AdminInfo();
		bean.setId(12);
		bean.setAdminName("Admin" + System.currentTimeMillis());

		int result = mapper.update(bean);
		sqlSession.commit();
		sqlSession.close();

		System.out.println(result);
	}

	@Test
	public void Delete() {

		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IAdminInfoMapper mapper = sqlSession.getMapper(IAdminInfoMapper.class);

		int result = mapper.deleteById(12);
		sqlSession.commit();
		sqlSession.close();

		System.out.println(result);
	}

	@Test
	public void Commit() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IAdminInfoMapper mapper = sqlSession.getMapper(IAdminInfoMapper.class);

		AdminInfo bean = new AdminInfo();
		bean.setAdminName("James" + System.currentTimeMillis());
		int result = mapper.add(bean);

		bean = new AdminInfo();
		bean.setAdminName("Chen" + System.currentTimeMillis());
		result = mapper.add(bean);

		sqlSession.commit();
		sqlSession.close();

		System.out.println(result);
	}

	@Test
	public void Rollback() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		IAdminInfoMapper mapper = sqlSession.getMapper(IAdminInfoMapper.class);

		AdminInfo bean = new AdminInfo();
		bean.setAdminName("James" + System.currentTimeMillis());
		int result = mapper.add(bean);

		sqlSession.rollback();

		bean = new AdminInfo();
		bean.setAdminName("Chen" + System.currentTimeMillis());
		result = mapper.add(bean);
		sqlSession.close();

		System.out.println(result);
	}
}
