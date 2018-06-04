package dzfy.ztsm.logistics.dao;

import dzfy.ztsm.logistics.domain.DzfyZtsmBxjl;

public interface DzfyZtsmBxjlMapper {
    int deleteByPrimaryKey(String jlbs);

    int insert(DzfyZtsmBxjl record);

    int insertSelective(DzfyZtsmBxjl record);

    DzfyZtsmBxjl selectByPrimaryKey(String jlbs);

    int updateByPrimaryKeySelective(DzfyZtsmBxjl record);

    int updateByPrimaryKey(DzfyZtsmBxjl record);
}