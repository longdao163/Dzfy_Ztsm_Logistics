package dzfy.ztsm.logistics.domain;

import java.util.Date;

public class DzfyZtsmJsy {
    private String gh;

    private String xm;

    private Boolean xb;

    private Date csny;

    private String sfzh;

    private String jszh;

    private String sjhm;

    private String jtzz;

    private String wxbs;

    private String wxnc;

    private byte[] wxtx;

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh == null ? null : gh.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public Boolean getXb() {
        return xb;
    }

    public void setXb(Boolean xb) {
        this.xb = xb;
    }

    public Date getCsny() {
        return csny;
    }

    public void setCsny(Date csny) {
        this.csny = csny;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh == null ? null : sfzh.trim();
    }

    public String getJszh() {
        return jszh;
    }

    public void setJszh(String jszh) {
        this.jszh = jszh == null ? null : jszh.trim();
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm == null ? null : sjhm.trim();
    }

    public String getJtzz() {
        return jtzz;
    }

    public void setJtzz(String jtzz) {
        this.jtzz = jtzz == null ? null : jtzz.trim();
    }

    public String getWxbs() {
        return wxbs;
    }

    public void setWxbs(String wxbs) {
        this.wxbs = wxbs == null ? null : wxbs.trim();
    }

    public String getWxnc() {
        return wxnc;
    }

    public void setWxnc(String wxnc) {
        this.wxnc = wxnc == null ? null : wxnc.trim();
    }

    public byte[] getWxtx() {
        return wxtx;
    }

    public void setWxtx(byte[] wxtx) {
        this.wxtx = wxtx;
    }
}