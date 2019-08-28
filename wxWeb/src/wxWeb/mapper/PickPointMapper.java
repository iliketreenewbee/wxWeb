package wxWeb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import wxWeb.domain.PickPoint;

public interface PickPointMapper {
	
	//��ѯ��Ч�����
	@Select("select * from pickpoint where isValue = #{isValue}")
	List<PickPoint> SelectAll(@Param("isValue")String isValue);
	
	//ģ����ѯ��Ч�����
	@Select("select * from pickpoint where isValue = 'true' and name like concat('%',#{key},'%')")
	List<PickPoint> SelectPickPoint(@Param("key")String key);
	
	//���������
	@Insert("insert into pickpoint (name) values (#{name})")
	int InsertPickPoint(@Param("name")String name);
	
	//�޸������
	@Update("update pickpoint set name = #{name} where id = @{id}")
	int UpdatePickPoint(@Param("id")int id,@Param("name")String name);
	
	//ɾ������㣺��isValue��Ϊflase
	@Update("update pickpoint set isValue = #{isValue} where id = @{id}")
	int UpdatePickPointValue(@Param("id")int id,@Param("isValue")String isValue);
	
	//����ɾ�������
	@Delete("delete from pickpoint where id = #{id}")
	int DeletePickPoint(@Param("in")int id);
}
