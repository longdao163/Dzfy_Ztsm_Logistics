/********************************************
 * 数据结构：车辆的查询条件
 *
 * @author zwq
 * @create 2018-05-31 0:02
 *********************************************/

package dzfy.ztsm.logistics.dto;


public class CarCondition {
    private String cphm;
    private int pageNum;
    private int pageSize;

    public CarCondition() {
        this.cphm = "";
    }

    public String getCphm() {
        return cphm;
    }

    public void setCphm(String cphm) {
        this.cphm = cphm;
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
