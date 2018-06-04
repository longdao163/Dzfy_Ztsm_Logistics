/********************************************
 * Dao层基础类
 *
 * @author zwq
 * @create 2018-05-31 18:36
 *********************************************/

package dzfy.ztsm.logistics.dao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dzfy.ztsm.logistics.utils.GenericsUtils;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;


@Repository("baseDao")
public class BaseDao<T, PK extends Serializable> extends SqlSessionDaoSupport implements Serializable {

    private static final long serialVersionUID = 7623507504198633838L;

    private final String POSTFIX = "Mapper";

    private final String _INSERT = ".insert";

    private final String _INSERTSELECTIVE = ".insertSelective";

    private final String _SELECTBYPRIMARYKEY = ".selectByPrimaryKey";

    private final String _UPDATEBYPRIMARYKEY = ".updateByPrimaryKey";

    private final String _UPDATEBYPRIMARYKEYSELECTIVE = ".updateByPrimaryKeySelective";

    private final String _DELETEBYPRIMARYKEY = ".deleteByPrimaryKey";

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /*GenericsUtils为工具类，请见下方代码
          泛型获得XXXEntity，将其转换为XXXEntityDao，具体操作替换掉Entity变成XXXDao，对应Mapper.xml中的namespace命名
        */
    public String getNampSpace() {
        Class<T> clazz = (Class) GenericsUtils.getSuperClassGenricType(this.getClass());
        String simpleName = clazz.getName() + POSTFIX;
        return simpleName;
    }

    public int insert(T entity) {
        return getSqlSession().insert(
                (this.getNampSpace().contains("domain") ? this.getNampSpace().replace("domain", "dao")
                        : this.getNampSpace()) + _INSERT, entity);
    }


    public int insertSelective(T record) {
        return getSqlSession().insert((this.getNampSpace().contains("domain") ? this.getNampSpace().replace("domain", "dao")
                : this.getNampSpace()) + _INSERTSELECTIVE, record);
    }

    public T selectByPrimaryKey(PK id) {
        return getSqlSession().selectOne(
                (this.getNampSpace().contains("domain") ? this.getNampSpace().replace("domain", "dao")
                        : this.getNampSpace()) + _SELECTBYPRIMARYKEY, id);
    }


    public int updateByPrimaryKey(T record) {
        return getSqlSession().update(
                (this.getNampSpace().contains("domain") ? this.getNampSpace().replace("domain", "dao")
                        : this.getNampSpace()) + _UPDATEBYPRIMARYKEY, record);
    }

    public int updateByPrimaryKeySelective(T record) {
        return getSqlSession().update(
                (this.getNampSpace().contains("domain") ? this.getNampSpace().replace("domain", "dao")
                        : this.getNampSpace()) + _UPDATEBYPRIMARYKEYSELECTIVE, record);
    }

    public int deleteByPrimaryKey(PK id) {
        return getSqlSession().delete(
                (this.getNampSpace().contains("domain") ? this.getNampSpace().replace("domain", "dao")
                        : this.getNampSpace()) + _DELETEBYPRIMARYKEY, id);
    }

    private Map getParamsFromObj(Object parameter) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        Map params = new HashMap();
        if (parameter != null) {
            if (parameter instanceof Map) {
                params.putAll((Map) parameter);
            } else {
                Map parameterObject = PropertyUtils.describe(parameter);
                params.putAll(parameterObject);
            }
        }
        if(params.containsKey("class"))
        {
            params.remove("class");
        }
        return params;
    }

    public PageInfo<T> pageFind(String statementKey, int pageNum, int pageSize, Object parameter) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{

        PageHelper.startPage(pageNum, pageSize);
        List<T> list = getSqlSession().selectList(statementKey, getParamsFromObj(parameter));
        PageInfo<T> pageInfo = new PageInfo(list);

        return pageInfo;
    }

    public List<T> findTop(int top, String statementKey, Object parameter) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        List<T> list = getSqlSession().selectList(statementKey, getParamsFromObj(parameter), new RowBounds(0, top));
        return list;
    }

    public T findTopOne(String statementKey, Object parameter) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        List<T> list = findTop(1, statementKey, parameter);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    public <M> PageInfo<M> pageFindModel(String statementKey, int pageNum, int pageSize, Object parameter) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        PageHelper.startPage(pageNum, pageSize);
        List<M> list = getSqlSession().selectList(statementKey, getParamsFromObj(parameter));
        PageInfo<M> pageInfo = new PageInfo(list);

        return pageInfo;
    }
}

