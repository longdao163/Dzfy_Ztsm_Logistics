package dzfy.ztsm.logistics.dao;

import dzfy.ztsm.logistics.domain.DzfyZtsmBxfj;

public interface DzfyZtsmBxfjMapper {

    int deleteByPrimaryKey(String fjbs);

    int insert(DzfyZtsmBxfj record);

    int insertSelective(DzfyZtsmBxfj record);

    DzfyZtsmBxfj selectByPrimaryKey(String fjbs);

    int updateByPrimaryKeySelective(DzfyZtsmBxfj record);

    int updateByPrimaryKey(DzfyZtsmBxfj record);
}