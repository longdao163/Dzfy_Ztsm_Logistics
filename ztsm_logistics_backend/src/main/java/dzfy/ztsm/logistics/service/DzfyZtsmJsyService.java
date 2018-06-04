/********************************************
 * 驾驶员管理的服务层
 *
 * @author zwq
 * @create 2018-05-31 22:39
 *********************************************/

package dzfy.ztsm.logistics.service;


import com.github.pagehelper.PageInfo;
import dzfy.ztsm.logistics.domain.DzfyZtsmJsy;

import java.lang.reflect.InvocationTargetException;

public interface  DzfyZtsmJsyService extends BaseService<DzfyZtsmJsy>{

     PageInfo<DzfyZtsmJsy> pageFind(int pageNum, int pageSize, Object parameter) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;
}
