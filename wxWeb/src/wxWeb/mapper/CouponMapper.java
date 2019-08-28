package wxWeb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import wxWeb.domain.Coupon;

public interface CouponMapper {
	
	//��ѯ�����Ż�ȯ
	@Select("select * from coupon")
	List<Coupon> SelectAll();
	
	//�����û���ѯ�Ż�ȯ
	@Select("select * from coupon where buyerId = #{buyerId}")
	List<Coupon> SelectCouponWithBuyer(@Param("buyerId")int buyerId);
	
	//�����Ż�ȯ
	@Insert("insert into coupon (discountMoney,discountType,condition,situation,type,fullMoney) values "
			+ "(#{discountMoney},#{discountType},#{condition},#{situation},#{type},#{fullMoney})")
	int InsertCoupon(@Param("discountMoney")float discountMoney,@Param("discountType")String discountType,
			@Param("condition")String condition,@Param("situation")String situation,
			@Param("type")String type,@Param("fullMoney")float fullMoney);
	
	//�޸��Ż�ȯʹ�����
	@Update("update coupon set situation = #{situation} where id = #{id}")
	int UpdateSituation(@Param("id")int id,@Param("situation")String situation);
	
	//��������ѯ�Ż�ȯ
	@Select("select * from coupon where type = #{type}")
	List<Coupon> SelectWitnType(@Param("type")String type);
	
	//�����Ż�����ѯ�Ż�ȯ
	@Select("select * from coupon where discountType = #{discountType}")
	List<Coupon> SelectWitnDiscountType(@Param("discountType")String discountType);
	
	//����ɾ���Ż�ȯ
	@Delete("delete from coupon where id = #{id}")
	int Delete(@Param("id")int id);
}
