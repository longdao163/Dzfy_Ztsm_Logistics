/********************************************
 * Service层基类
 *
 * @author zwq
 * @create 2018-05-31 22:23
 *********************************************/

package dzfy.ztsm.logistics.service;


import com.github.pagehelper.PageInfo;
import java.lang.reflect.InvocationTargetException;

public interface BaseService<T> {

     int insert(T record);
     int insertSelective(T record);
     T selectByPrimaryKey(String id);
     int updateByPrimaryKey(T record);
     int updateByPrimaryKeySelective(T record);
     int deleteByPrimaryKey(String id);
     PageInfo<T> pageFind(String statementKey, int pageNum, int pageSize, Object parameter) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;

}

