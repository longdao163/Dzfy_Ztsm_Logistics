/********************************************
 * 车辆管理的服务层
 *
 * @author zwq
 * @create 2018-05-31 22:39
 *********************************************/

package dzfy.ztsm.logistics.service;


import com.github.pagehelper.PageInfo;
import dzfy.ztsm.logistics.domain.DzfyZtsmCl;

import java.lang.reflect.InvocationTargetException;

public interface DzfyZtsmClService extends BaseService<DzfyZtsmCl>{

     PageInfo<DzfyZtsmCl> pageFind(int pageNum, int pageSize, Object parameter) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;
}
