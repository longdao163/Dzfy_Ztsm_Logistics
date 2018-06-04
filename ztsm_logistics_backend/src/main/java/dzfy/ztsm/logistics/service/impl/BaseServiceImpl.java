/********************************************
 * Service层基类的实现
 *
 * @author zwq
 * @create 2018-05-31 22:30
 *********************************************/

package dzfy.ztsm.logistics.service.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import com.github.pagehelper.PageInfo;
import dzfy.ztsm.logistics.dao.BaseDao;
import dzfy.ztsm.logistics.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseDao<T, Serializable> baseDao;

    public BaseDao<T, Serializable> getBaseDao() {
        return baseDao;
    }
    public void setBaseDao(BaseDao<T, Serializable> baseDao) {
        this.baseDao = baseDao;
    }

    public int insert(T entity) {
        return baseDao.insert(entity);
    }

    public int insertSelective(T record) {
        return baseDao.insertSelective(record);
    }

    public T selectByPrimaryKey(String id) {
        return baseDao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKey(T record) {
        return baseDao.updateByPrimaryKey(record);
    }

    public int updateByPrimaryKeySelective(T record) {
        return baseDao.updateByPrimaryKeySelective(record);
    }

    public int deleteByPrimaryKey(String id) {
        return baseDao.deleteByPrimaryKey(id);
    }

    public PageInfo<T> pageFind(String statementKey, int pageNum, int pageSize, Object parameter) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        return baseDao.pageFind(statementKey,pageNum,pageSize,parameter);
    }

}


