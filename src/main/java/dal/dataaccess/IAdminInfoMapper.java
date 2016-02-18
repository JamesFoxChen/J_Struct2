package dal.dataaccess;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import dal.beans.AdminInfo;
import dal.beans.AdminRightInfo;

public interface IAdminInfoMapper {
	
    //使用@Select注解指明getById方法要执行的SQL
    @Select("select * from admininfo where id=#{id}")
    public AdminInfo getById(int id);
    
    //使用@Select注解指明getAll方法要执行的SQL
    @Select("select * from admininfo")
    public List<AdminInfo> getAll();
    
    //使用@Insert注解指明add方法要执行的SQL
    @Insert("insert into admininfo(adminName) values(#{adminName})")
    public int add(AdminInfo user);
    
    //使用@Update注解指明update方法要执行的SQL
    @Update("update admininfo set adminName=#{adminName} where id=#{id}")
    public int update(AdminInfo user);
    
    //使用@Delete注解指明deleteById方法要执行的SQL
    @Delete("delete from admininfo where id=#{id}")
    public int deleteById(int id);
    
    //使用@Select注解指明getById方法要执行的SQL
    @Select("select a.id adminId,a.AdminName adminName,b.RightId rightId,b.Created from admininfo a"+
            " inner join adminright b on a.ID=b.AdminId where a.ID=#{adminId}")
    public List<AdminRightInfo> getAdminRightInfo(int adminId);
}