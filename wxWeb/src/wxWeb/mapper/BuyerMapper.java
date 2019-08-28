package wxWeb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import wxWeb.domain.Buyer;

public interface BuyerMapper {
	
	//�������
	@Select("select * from buyer")
	List<Buyer> SelectAll();
	
	//��¼��֤
	@Select("select * from buyer where name = #{name} and password = #{password}")
	Buyer SelectLogin(@Param("name")String name,@Param("passwoed")String password);
	
	//��¼��֤��ʽ2
	@Select("select * from buyer where name = #{name}")
	List<Buyer> SelectLoginWithName(@Param("name")String name);
	
	//�������
	@Insert("insert into buyer (name,password,phone,address,level) "
			+ "values (#{name},#{password},#{phone},#{address},#{level})")
	int InsertBuyer(@Param("name")String name,@Param("password")String password,
			@Param("phone")String phone,@Param("address")String address,@Param("level")String level);
	
	//�޸�����
	@Update("update buyer set password = #{password} where id = #{id}")
	int UpdatePassword(@Param("id")int id,@Param("password")String password);
	
	//�޸�����
	@Update("update buyer set name = #{name} where id = #{id}")
	int UpdateName(@Param("id")int id,@Param("name")String name);
	
	//�޸ĵ�ַ
	@Update("update buyer set address = #{address} where id = #{id}")
	int UpdateAddress(@Param("id")int id,@Param("address")String address);
		
	//�޸���ϵ�绰
	@Update("update buyer set phone = #{phone} where id = #{id}")
	int UpdatePhone(@Param("id")int id,@Param("phone")String phone);
}
