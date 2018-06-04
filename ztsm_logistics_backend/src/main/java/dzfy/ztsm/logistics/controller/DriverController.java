/********************************************
 * “司机管理”控制层
 * @author zwq
 * @create 2018-05-28 23:49
 *********************************************/

package dzfy.ztsm.logistics.controller;

import com.github.pagehelper.PageInfo;
import dzfy.ztsm.logistics.domain.DzfyZtsmJsy;
import dzfy.ztsm.logistics.dto.DriverCondition;
import dzfy.ztsm.logistics.service.DzfyZtsmJsyService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;


@CrossOrigin(origins = "*")
@Controller
@RequestMapping(value = "/driver",method = {RequestMethod.GET, RequestMethod.POST})
public class DriverController {

    private static Logger logger = Logger.getLogger(DriverController.class);


    @Resource(name = "dzfyZtsmJsyService")
    private DzfyZtsmJsyService dzfyZtsmJsyService;

    /**
    * “查询司机”接口
    * @author zwq
    * @create 2018-05-28 23:49
    * @param queryCondition 查询司机数据结构
    * @return
    **/
    @RequestMapping(value = "/getDrivers")
    public @ResponseBody
    PageInfo<DzfyZtsmJsy> getAllDrivers(@RequestBody DriverCondition queryCondition) throws Exception {
        if(null!=queryCondition){
            try{
                PageInfo<DzfyZtsmJsy> driverPage = dzfyZtsmJsyService.pageFind(queryCondition.getPageNum(),queryCondition.getPageSize(),queryCondition);
                return driverPage;
            }catch (Exception ex){
                // 需添加统一异常处理
                logger.error(ex);
            }
        }
        return null;
    }

    /**
    *  “新增司机”接口
     *  返回最好是状态值，用来判断不同的错误结果
    * @author zwq
    * @create 2018-05-28 23:49
    * @param driver 司机基本信息
    **/
    @RequestMapping(value = "/addDriver")
    public @ResponseBody
    boolean addDriver(@RequestBody DzfyZtsmJsy driver) throws Exception {
        // 生成司机工号
        // 检查司机参数
        if(null!=driver){
            try{
                return dzfyZtsmJsyService.insertSelective(driver)>0?true:false;
            }catch (Exception ex){
                // 需添加统一异常处理
                logger.error(ex);
            }
        }
        return false;
    }


    /**
     *  “更新司机”接口
     *  返回最好是状态值，用来判断不同的错误结果
     * @author zwq
     * @create 2018-05-28 23:49
     * @param driver 司机基本信息
     **/
    @RequestMapping(value = "/editDriver")
    public @ResponseBody
    boolean editDriver(@RequestBody DzfyZtsmJsy driver) throws Exception {
        // 检查司机参数
        if(null!=driver){
            try{
                return dzfyZtsmJsyService.updateByPrimaryKeySelective(driver)>0?true:false;
            }catch (Exception ex){
                // 需添加统一异常处理
                logger.error(ex);
            }
        }
        return false;
    }

    /**
     *  “删除司机”接口
     *  返回最好是状态值，用来判断不同的错误结果
     * @author zwq
     * @create 2018-05-28 23:49
     * @param  gh 司机工号
     **/
    @RequestMapping(value = "/removeDriver")
    public @ResponseBody
    boolean removeDriver(@RequestBody String gh) throws Exception {
        // 检查司机参数
        if(!StringUtils.isEmpty(gh)){
            try{
                return dzfyZtsmJsyService.deleteByPrimaryKey(gh)>0?true:false;
            }catch (Exception ex){
                // 需添加统一异常处理
                logger.error(ex);
            }
        }
        return false;
    }

}
