/********************************************
 * “车辆管理”控制层
 * @author zwq
 * @create 2018-05-28 23:49
 *********************************************/

package dzfy.ztsm.logistics.controller;

import com.github.pagehelper.PageInfo;
import dzfy.ztsm.logistics.domain.DzfyZtsmCl;
import dzfy.ztsm.logistics.dto.CarCondition;
import dzfy.ztsm.logistics.service.DzfyZtsmClService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@CrossOrigin(origins = "*")
@Controller
@RequestMapping(value = "/car",method = {RequestMethod.GET, RequestMethod.POST})
public class CarController {

    private static Logger logger = Logger.getLogger(CarController.class);


    @Resource(name = "dzfyZtsmClService")
    private DzfyZtsmClService dzfyZtsmClService;

    /**
    * “查询车辆”接口
    * @author zwq
    * @create 2018-05-28 23:49
    * @param queryCondition 查询车辆数据结构
    * @return
    **/
    @RequestMapping(value = "/getCars")
    public @ResponseBody
    PageInfo<DzfyZtsmCl> getAllCars(@RequestBody CarCondition queryCondition) throws Exception {
        if(null!=queryCondition){
            try{
                PageInfo<DzfyZtsmCl> carPage = dzfyZtsmClService.pageFind(queryCondition.getPageNum(),queryCondition.getPageSize(),queryCondition);
                return carPage;
            }catch (Exception ex){
                // 需添加统一异常处理
                logger.error(ex);
            }
        }
        return null;
    }

    /**
    *  “新增车辆”接口
     *  返回最好是状态值，用来判断不同的错误结果
    * @author zwq
    * @create 2018-05-28 23:49
    * @param car 车辆基本信息
    **/
    @RequestMapping(value = "/addCar")
    public @ResponseBody
    boolean addCar(@RequestBody DzfyZtsmCl car) throws Exception {
        // 生成司机工号
        // 检查司机参数
        if(null!=car){
            try{
                return dzfyZtsmClService.insertSelective(car)>0?true:false;
            }catch (Exception ex){
                // 需添加统一异常处理
                logger.error(ex);
            }
        }
        return false;
    }


    /**
     *  “更新车辆”接口
     *  返回最好是状态值，用来判断不同的错误结果
     * @author zwq
     * @create 2018-05-28 23:49
     * @param car 车辆基本信息
     **/
    @RequestMapping(value = "/editCar")
    public @ResponseBody
    boolean editCar(@RequestBody DzfyZtsmCl car) throws Exception {
        // 检查司机参数
        if(null!=car){
            try{
                return dzfyZtsmClService.updateByPrimaryKeySelective(car)>0?true:false;
            }catch (Exception ex){
                // 需添加统一异常处理
                logger.error(ex);
            }
        }
        return false;
    }

    /**
     *  “删除车辆”接口
     *  返回最好是状态值，用来判断不同的错误结果
     * @author zwq
     * @create 2018-05-28 23:49
     * @param  xtbs 车辆系统标识
     **/
    @RequestMapping(value = "/removeCar")
    public @ResponseBody
    boolean removeCar(@RequestBody String xtbs) throws Exception {
        // 检查司机参数
        if(!StringUtils.isEmpty(xtbs)){
            try{
                return dzfyZtsmClService.deleteByPrimaryKey(xtbs)>0?true:false;
            }catch (Exception ex){
                // 需添加统一异常处理
                logger.error(ex);
            }
        }
        return false;
    }

}
