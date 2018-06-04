/********************************************
 * 车辆管理的数据库访问层
 *
 * @author zwq
 * @create 2018-05-31 22:37
 *********************************************/

package dzfy.ztsm.logistics.dao;

import dzfy.ztsm.logistics.domain.DzfyZtsmCl;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("dzfyZtsmClMapper")
public class DzfyZtsmClMapper extends BaseDao<DzfyZtsmCl, Serializable>{

}
