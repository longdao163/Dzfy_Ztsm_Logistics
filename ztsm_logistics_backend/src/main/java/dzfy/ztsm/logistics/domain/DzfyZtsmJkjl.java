package dzfy.ztsm.logistics.domain;

import java.util.Date;

public class DzfyZtsmJkjl {
    private String jkbs;

    private String bxdh;

    private Date jkrq;

    private Integer jkje;

    private String jkr;

    private String clr;

    public String getJkbs() {
        return jkbs;
    }

    public void setJkbs(String jkbs) {
        this.jkbs = jkbs == null ? null : jkbs.trim();
    }

    public String getBxdh() {
        return bxdh;
    }

    public void setBxdh(String bxdh) {
        this.bxdh = bxdh == null ? null : bxdh.trim();
    }

    public Date getJkrq() {
        return jkrq;
    }

    public void setJkrq(Date jkrq) {
        this.jkrq = jkrq;
    }

    public Integer getJkje() {
        return jkje;
    }

    public void setJkje(Integer jkje) {
        this.jkje = jkje;
    }

    public String getJkr() {
        return jkr;
    }

    public void setJkr(String jkr) {
        this.jkr = jkr == null ? null : jkr.trim();
    }

    public String getClr() {
        return clr;
    }

    public void setClr(String clr) {
        this.clr = clr == null ? null : clr.trim();
    }
}