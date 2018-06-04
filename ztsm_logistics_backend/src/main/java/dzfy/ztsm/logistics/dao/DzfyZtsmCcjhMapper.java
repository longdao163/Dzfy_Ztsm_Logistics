package dzfy.ztsm.logistics.dao;

import dzfy.ztsm.logistics.domain.DzfyZtsmCcjh;

public interface DzfyZtsmCcjhMapper {
    int deleteByPrimaryKey(String jhbs);

    int insert(DzfyZtsmCcjh record);

    int insertSelective(DzfyZtsmCcjh record);

    DzfyZtsmCcjh selectByPrimaryKey(String jhbs);

    int updateByPrimaryKeySelective(DzfyZtsmCcjh record);

    int updateByPrimaryKey(DzfyZtsmCcjh record);
}