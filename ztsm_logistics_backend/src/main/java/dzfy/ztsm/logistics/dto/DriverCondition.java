/********************************************
 * 数据结构：司机的查询条件
 *
 * @author zwq
 * @create 2018-05-31 0:02
 *********************************************/

package dzfy.ztsm.logistics.dto;


public class DriverCondition {
    private String xm;
    private String sfzh;
    private String jszh;
    private String sjhm;
    private int pageNum;
    private int pageSize;

    public DriverCondition() {
        this.xm = "";
        this.sfzh = "";
        this.jszh = "";
        this.sjhm = "";
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getJszh() {
        return jszh;
    }

    public void setJszh(String jszh) {
        this.jszh = jszh;
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
