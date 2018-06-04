/********************************************
 * 车辆管理的服务层的实现
 *
 * @author zwq
 * @create 2018-05-31 22:40
 *********************************************/

package dzfy.ztsm.logistics.service.impl;

import com.github.pagehelper.PageInfo;
import dzfy.ztsm.logistics.domain.DzfyZtsmCl;
import dzfy.ztsm.logistics.service.DzfyZtsmClService;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service("dzfyZtsmClService")
public class DzfyZtsmClServiceImpl extends BaseServiceImpl<DzfyZtsmCl> implements DzfyZtsmClService {

    public PageInfo<DzfyZtsmCl> pageFind(int pageNum, int pageSize, Object parameter) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        return this.pageFind("selectAllCars",pageNum,pageSize,parameter);
    }
}
