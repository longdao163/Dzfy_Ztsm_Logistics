package dzfy.ztsm.logistics.domain;

import java.util.Date;

public class DzfyZtsmBxjl {
    private String jlbs;

    private String bxdh;

    private Short jllx;

    private String shzd;

    private Integer sjyh;

    private String clry;

    private Date clsj;

    private String clyj;

    public String getJlbs() {
        return jlbs;
    }

    public void setJlbs(String jlbs) {
        this.jlbs = jlbs == null ? null : jlbs.trim();
    }

    public String getBxdh() {
        return bxdh;
    }

    public void setBxdh(String bxdh) {
        this.bxdh = bxdh == null ? null : bxdh.trim();
    }

    public Short getJllx() {
        return jllx;
    }

    public void setJllx(Short jllx) {
        this.jllx = jllx;
    }

    public String getShzd() {
        return shzd;
    }

    public void setShzd(String shzd) {
        this.shzd = shzd == null ? null : shzd.trim();
    }

    public Integer getSjyh() {
        return sjyh;
    }

    public void setSjyh(Integer sjyh) {
        this.sjyh = sjyh;
    }

    public String getClry() {
        return clry;
    }

    public void setClry(String clry) {
        this.clry = clry == null ? null : clry.trim();
    }

    public Date getClsj() {
        return clsj;
    }

    public void setClsj(Date clsj) {
        this.clsj = clsj;
    }

    public String getClyj() {
        return clyj;
    }

    public void setClyj(String clyj) {
        this.clyj = clyj == null ? null : clyj.trim();
    }
}