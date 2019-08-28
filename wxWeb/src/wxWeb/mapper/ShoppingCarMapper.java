package wxWeb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import wxWeb.domain.ShoppingCar;

public interface ShoppingCarMapper {
	
	//�������ﳵ��ÿ���û�һ�����ﳵ
	@Insert("insert into shoppingcar (buyerId) values (#{buyerId})")
	int InsertShopC(@Param("buyerId")int buyerId);
	
	//���¹��ﳵ�������Ʒ
	@Update("update shoppingcar set content = #{content} where buyerId = #{buyerId}")
	int UpdateShopC(@Param("buyerId")int buyerId,@Param("content")String content);
	
	//���ҹ��ﳵ
	@Select("select * from shoppingcar where buyerId = #{buyerId}")
	ShoppingCar SelectShopC(@Param("buyerId")int buyerId);
}
