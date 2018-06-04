package dzfy.ztsm.logistics.domain;

public class DzfyZtsmBxfj {
    private String fjbs;

    private String bxdh;

    private String wjlx;

    private String wjmc;

    private String wjdz;

    public String getFjbs() {
        return fjbs;
    }

    public void setFjbs(String fjbs) {
        this.fjbs = fjbs == null ? null : fjbs.trim();
    }

    public String getBxdh() {
        return bxdh;
    }

    public void setBxdh(String bxdh) {
        this.bxdh = bxdh == null ? null : bxdh.trim();
    }

    public String getWjlx() {
        return wjlx;
    }

    public void setWjlx(String wjlx) {
        this.wjlx = wjlx == null ? null : wjlx.trim();
    }

    public String getWjmc() {
        return wjmc;
    }

    public void setWjmc(String wjmc) {
        this.wjmc = wjmc == null ? null : wjmc.trim();
    }

    public String getWjdz() {
        return wjdz;
    }

    public void setWjdz(String wjdz) {
        this.wjdz = wjdz == null ? null : wjdz.trim();
    }
}