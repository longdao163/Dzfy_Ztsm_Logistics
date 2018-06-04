/********************************************
 * 驾驶员管理的服务层的实现
 *
 * @author zwq
 * @create 2018-05-31 22:40
 *********************************************/

package dzfy.ztsm.logistics.service.impl;

import com.github.pagehelper.PageInfo;
import dzfy.ztsm.logistics.domain.DzfyZtsmJsy;
import dzfy.ztsm.logistics.service.DzfyZtsmJsyService;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service("dzfyZtsmJsyService")
public class DzfyZtsmJsyServiceImpl extends BaseServiceImpl<DzfyZtsmJsy> implements DzfyZtsmJsyService {

    public PageInfo<DzfyZtsmJsy> pageFind(int pageNum, int pageSize, Object parameter) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        return this.pageFind("selectAllDrivers",pageNum,pageSize,parameter);
    }
}
