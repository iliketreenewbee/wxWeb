package wxWeb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import wxWeb.domain.Order;

/*
 * OrderMapper�ӿ�
 * */
public interface OrderMapper {
	
	//��ѯ���ж���
	@Select("select * from order")
	List<Order> SelectAll();
	
	//�������id��ѯ����
	@Select("select * from order where buyerId = #{buyerId}")
	List<Order> SelectWithBuyerId(@Param("buyerId")int buyerId);
	
	//���ݶ���״̬��ѯ����
	@Select("select * from order where orderSituation = #{orderSituation}")
	List<Order> SelectWithOrderSituation(@Param("orderSituation")String orderSituation);
	
	//��������,id������contactPhoneĬ�ϲ���
	@Insert("insert into order "
			+ "(buyerName,buyerId,content,totalPrice,orderTime,orderSituation,sendTime,address,pickCode) "
			+ "values (#{buyerName},#{buyerId},#{content},#{totalPrice},#{prderTime},"
			+ "#{orderSituation},#{sendTime},#{address},#{pickCode})")
	int InsertOrder(@Param("buyerName")String buyerName,@Param("buyerId")int buyerId,
			@Param("content")String content,@Param("totalPrice")float totalPrice,
			@Param("orderTime")String orderTime,@Param("orderSituation")String orderSituation,
			@Param("sendTime")String sendTime,@Param("address")String address,@Param("pickCode")String pickCode);
	
	//���¶���״̬
	@Update("update order set orderSituation = #{orderSituation} where id = #{id}")
	int UpdateOrderSituation(@Param("id")int id,@Param("orderSituation")String orderSituation);
	
}
