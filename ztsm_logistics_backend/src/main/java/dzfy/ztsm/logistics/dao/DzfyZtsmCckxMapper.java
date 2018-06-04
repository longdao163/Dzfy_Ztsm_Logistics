package dzfy.ztsm.logistics.dao;

import dzfy.ztsm.logistics.domain.DzfyZtsmCckx;

public interface DzfyZtsmCckxMapper {

    int deleteByPrimaryKey(String kxbs);

    int insert(DzfyZtsmCckx record);

    int insertSelective(DzfyZtsmCckx record);

    DzfyZtsmCckx selectByPrimaryKey(String kxbs);

    int updateByPrimaryKeySelective(DzfyZtsmCckx record);

    int updateByPrimaryKey(DzfyZtsmCckx record);
}