package dzfy.ztsm.logistics.domain;

import java.util.Date;

public class DzfyZtsmCl {
    private String xtbs;

    private String cphm;

    private Short cllx;

    private String clpp;

    private String clxh;

    private String clys;

    private Integer hzdw;

    private Date gmsj;

    private String fpbh;

    public String getXtbs() {
        return xtbs;
    }

    public void setXtbs(String xtbs) {
        this.xtbs = xtbs == null ? null : xtbs.trim();
    }

    public String getCphm() {
        return cphm;
    }

    public void setCphm(String cphm) {
        this.cphm = cphm == null ? null : cphm.trim();
    }

    public Short getCllx() {
        return cllx;
    }

    public void setCllx(Short cllx) {
        this.cllx = cllx;
    }

    public String getClpp() {
        return clpp;
    }

    public void setClpp(String clpp) {
        this.clpp = clpp == null ? null : clpp.trim();
    }

    public String getClxh() {
        return clxh;
    }

    public void setClxh(String clxh) {
        this.clxh = clxh == null ? null : clxh.trim();
    }

    public String getClys() {
        return clys;
    }

    public void setClys(String clys) {
        this.clys = clys == null ? null : clys.trim();
    }

    public Integer getHzdw() {
        return hzdw;
    }

    public void setHzdw(Integer hzdw) {
        this.hzdw = hzdw;
    }

    public Date getGmsj() {
        return gmsj;
    }

    public void setGmsj(Date gmsj) {
        this.gmsj = gmsj;
    }

    public String getFpbh() {
        return fpbh;
    }

    public void setFpbh(String fpbh) {
        this.fpbh = fpbh == null ? null : fpbh.trim();
    }
}