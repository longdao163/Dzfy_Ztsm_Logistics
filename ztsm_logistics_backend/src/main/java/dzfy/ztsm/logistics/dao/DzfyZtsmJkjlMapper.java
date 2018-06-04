package dzfy.ztsm.logistics.dao;

import dzfy.ztsm.logistics.domain.DzfyZtsmJkjl;

public interface DzfyZtsmJkjlMapper {
    int deleteByPrimaryKey(String jkbs);

    int insert(DzfyZtsmJkjl record);

    int insertSelective(DzfyZtsmJkjl record);

    DzfyZtsmJkjl selectByPrimaryKey(String jkbs);

    int updateByPrimaryKeySelective(DzfyZtsmJkjl record);

    int updateByPrimaryKey(DzfyZtsmJkjl record);
}