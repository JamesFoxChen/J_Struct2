package dal.dataaccess;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import dal.beans.UserInfo;

public interface IUserInfoMapper {
	
    //使用@Select注解指明getById方法要执行的SQL
    @Select("select * from userinfo where id=#{id}")
    public UserInfo getById(long id);
    
    //使用@Insert注解指明add方法要执行的SQL
    @Insert("insert into userinfo(userName,password) values(#{userName},#{password})")
    public int add(UserInfo user);
}