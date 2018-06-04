package dzfy.ztsm.logistics.domain;

public class DzfyZtsmCckx {
    private String kxbs;

    private String bxdh;

    private Short ksxm;

    private Integer xmdj;

    private Integer xmsl;

    private String sldw;

    private Integer kxze;

    public String getKxbs() {
        return kxbs;
    }

    public void setKxbs(String kxbs) {
        this.kxbs = kxbs == null ? null : kxbs.trim();
    }

    public String getBxdh() {
        return bxdh;
    }

    public void setBxdh(String bxdh) {
        this.bxdh = bxdh == null ? null : bxdh.trim();
    }

    public Short getKsxm() {
        return ksxm;
    }

    public void setKsxm(Short ksxm) {
        this.ksxm = ksxm;
    }

    public Integer getXmdj() {
        return xmdj;
    }

    public void setXmdj(Integer xmdj) {
        this.xmdj = xmdj;
    }

    public Integer getXmsl() {
        return xmsl;
    }

    public void setXmsl(Integer xmsl) {
        this.xmsl = xmsl;
    }

    public String getSldw() {
        return sldw;
    }

    public void setSldw(String sldw) {
        this.sldw = sldw == null ? null : sldw.trim();
    }

    public Integer getKxze() {
        return kxze;
    }

    public void setKxze(Integer kxze) {
        this.kxze = kxze;
    }
}