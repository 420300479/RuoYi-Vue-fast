package com.ruoyi.project.design.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 计算对象 tb_Qzsjjs
 * 
 * @author ruoyi
 * @date 2022-09-15
 */
public class TbQzsjjs extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设计计算表 */
    private Long prId;

    /** 新建定制产品表的压力机基础参数的外键---定制号 */
    private String dzh;

    /** 新建定制产品表的压力机基础参数的外键---机床型号全名，例如 MC1-16-I */
    private String name;

    /** 新建定制产品表的压力机基础参数的外键---机床点数 */
    private Long jcds;

    /** 新建定制产品表的压力机基础参数的外键---公称力 */
    private BigDecimal gcl;

    /** 新建定制产品表的压力机基础参数的外键---公称力行程 */
    private BigDecimal gclxc;

    /** 新建定制产品表的压力机基础参数的外键---滑块行程 */
    private BigDecimal hkxc;

    /** 新建定制产品表的压力机基础参数的外键---最大行程次数 */
    private BigDecimal zdxccs;

    /** A6连杆长度Lmax (模高最低时曲柄中心到球头的距离) */
    private BigDecimal lianganLength;

    /** A7曲轴支承颈直径(mm)d0 */
    private BigDecimal quzhouZcjDia;

    /** A8曲轴曲柄颈直径(mm)da */
    private BigDecimal quzhouQbjDia;

    /** A9球头受力面直径(mm)db */
    @Excel(name = "A9球头受力面直径(mm)db")
    private BigDecimal quzhouQtmDia;

    /** A10 滑动轴承摩擦系数 μ */
    @Excel(name = "A10 滑动轴承摩擦系数 μ")
    private BigDecimal slideFricCoe;

    /**  A11曲柄颈长度(mm)la  */
    @Excel(name = " A11曲柄颈长度(mm)la ")
    private BigDecimal la;

    /**  A13曲柄臂厚度(mm)b  */
    @Excel(name = " A13曲柄臂厚度(mm)b ")
    private BigDecimal b;

    /**  A14曲柄臂高度(mm)h  */
    @Excel(name = " A14曲柄臂高度(mm)h ")
    private BigDecimal h;

    /**  A15曲柄臂形心至支承颈形心的距离(mm)c  */
    @Excel(name = " A15曲柄臂形心至支承颈形心的距离(mm)c ")
    private BigDecimal r;

    /**  A16曲柄颈及支承颈圆角半径(mm) r  */
    @Excel(name = " A16曲柄颈及支承颈圆角半径(mm) r ")
    private BigDecimal c;

    /**  材料表的外键---------------------------A18 曲轴材料  */
    @Excel(name = " 材料表的外键---------------------------A18 曲轴材料 ")
    private String qzClmc;

    /** D1 公称扭矩 */
    @Excel(name = "D1 公称扭矩")
    private BigDecimal nominalTorsion;

    /**  D2曲柄颈最大弯曲应力(MPa)  */
    @Excel(name = " D2曲柄颈最大弯曲应力(MPa) ")
    private BigDecimal qbjzdwqyl;

    /**  D3支承颈最大剪应力(MPa  */
    @Excel(name = " D3支承颈最大剪应力(MPa ")
    private BigDecimal zcjzdjqyl;

    /**  D4挠度  */
    @Excel(name = " D4挠度 ")
    private BigDecimal nd;

    public void setPrId(Long prId) 
    {
        this.prId = prId;
    }

    public Long getPrId() 
    {
        return prId;
    }
    public void setDzh(String dzh) 
    {
        this.dzh = dzh;
    }

    public String getDzh() 
    {
        return dzh;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setJcds(Long jcds) 
    {
        this.jcds = jcds;
    }

    public Long getJcds() 
    {
        return jcds;
    }
    public void setGcl(BigDecimal gcl) 
    {
        this.gcl = gcl;
    }

    public BigDecimal getGcl() 
    {
        return gcl;
    }
    public void setGclxc(BigDecimal gclxc) 
    {
        this.gclxc = gclxc;
    }

    public BigDecimal getGclxc() 
    {
        return gclxc;
    }
    public void setHkxc(BigDecimal hkxc) 
    {
        this.hkxc = hkxc;
    }

    public BigDecimal getHkxc() 
    {
        return hkxc;
    }
    public void setZdxccs(BigDecimal zdxccs) 
    {
        this.zdxccs = zdxccs;
    }

    public BigDecimal getZdxccs() 
    {
        return zdxccs;
    }
    public void setLianganLength(BigDecimal lianganLength) 
    {
        this.lianganLength = lianganLength;
    }

    public BigDecimal getLianganLength() 
    {
        return lianganLength;
    }
    public void setQuzhouZcjDia(BigDecimal quzhouZcjDia) 
    {
        this.quzhouZcjDia = quzhouZcjDia;
    }

    public BigDecimal getQuzhouZcjDia() 
    {
        return quzhouZcjDia;
    }
    public void setQuzhouQbjDia(BigDecimal quzhouQbjDia) 
    {
        this.quzhouQbjDia = quzhouQbjDia;
    }

    public BigDecimal getQuzhouQbjDia() 
    {
        return quzhouQbjDia;
    }
    public void setQuzhouQtmDia(BigDecimal quzhouQtmDia) 
    {
        this.quzhouQtmDia = quzhouQtmDia;
    }

    public BigDecimal getQuzhouQtmDia() 
    {
        return quzhouQtmDia;
    }
    public void setSlideFricCoe(BigDecimal slideFricCoe) 
    {
        this.slideFricCoe = slideFricCoe;
    }

    public BigDecimal getSlideFricCoe() 
    {
        return slideFricCoe;
    }
    public void setLa(BigDecimal la) 
    {
        this.la = la;
    }

    public BigDecimal getLa() 
    {
        return la;
    }
    public void setB(BigDecimal b) 
    {
        this.b = b;
    }

    public BigDecimal getB() 
    {
        return b;
    }
    public void setH(BigDecimal h) 
    {
        this.h = h;
    }

    public BigDecimal getH() 
    {
        return h;
    }
    public void setR(BigDecimal r) 
    {
        this.r = r;
    }

    public BigDecimal getR() 
    {
        return r;
    }
    public void setC(BigDecimal c) 
    {
        this.c = c;
    }

    public BigDecimal getC() 
    {
        return c;
    }
    public void setQzClmc(String qzClmc) 
    {
        this.qzClmc = qzClmc;
    }

    public String getQzClmc() 
    {
        return qzClmc;
    }
    public void setNominalTorsion(BigDecimal nominalTorsion) 
    {
        this.nominalTorsion = nominalTorsion;
    }

    public BigDecimal getNominalTorsion() 
    {
        return nominalTorsion;
    }
    public void setQbjzdwqyl(BigDecimal qbjzdwqyl) 
    {
        this.qbjzdwqyl = qbjzdwqyl;
    }

    public BigDecimal getQbjzdwqyl() 
    {
        return qbjzdwqyl;
    }
    public void setZcjzdjqyl(BigDecimal zcjzdjqyl) 
    {
        this.zcjzdjqyl = zcjzdjqyl;
    }

    public BigDecimal getZcjzdjqyl() 
    {
        return zcjzdjqyl;
    }
    public void setNd(BigDecimal nd) 
    {
        this.nd = nd;
    }

    public BigDecimal getNd() 
    {
        return nd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("prId", getPrId())
            .append("dzh", getDzh())
            .append("name", getName())
            .append("jcds", getJcds())
            .append("gcl", getGcl())
            .append("gclxc", getGclxc())
            .append("hkxc", getHkxc())
            .append("zdxccs", getZdxccs())
            .append("lianganLength", getLianganLength())
            .append("quzhouZcjDia", getQuzhouZcjDia())
            .append("quzhouQbjDia", getQuzhouQbjDia())
            .append("quzhouQtmDia", getQuzhouQtmDia())
            .append("slideFricCoe", getSlideFricCoe())
            .append("la", getLa())
            .append("b", getB())
            .append("h", getH())
            .append("r", getR())
            .append("c", getC())
            .append("qzClmc", getQzClmc())
            .append("nominalTorsion", getNominalTorsion())
            .append("qbjzdwqyl", getQbjzdwqyl())
            .append("zcjzdjqyl", getZcjzdjqyl())
            .append("nd", getNd())
            .toString();
    }
}
