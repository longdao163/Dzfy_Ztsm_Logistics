/********************************************
 * 驾驶员管理的数据库访问层
 *
 * @author zwq
 * @create 2018-05-31 22:37
 *********************************************/

package dzfy.ztsm.logistics.dao;

import dzfy.ztsm.logistics.domain.DzfyZtsmJsy;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("dzfyZtsmJsyMapper")
public class DzfyZtsmJsyMapper extends BaseDao<DzfyZtsmJsy, Serializable>{

}
