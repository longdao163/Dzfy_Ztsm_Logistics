package dzfy.ztsm.logistics.dao;

import dzfy.ztsm.logistics.domain.DzfyZtsmYymx;

public interface DzfyZtsmYymxMapper {
    int deleteByPrimaryKey(String bxdh);

    int insert(DzfyZtsmYymx record);

    int insertSelective(DzfyZtsmYymx record);

    DzfyZtsmYymx selectByPrimaryKey(String bxdh);

    int updateByPrimaryKeySelective(DzfyZtsmYymx record);

    int updateByPrimaryKey(DzfyZtsmYymx record);
}