package com.ruoyi.project.design.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 铝合金芒果对象 tb_fruit3
 * 
 * @author ruoyi
 * @date 2022-09-18
 */
public class TbFruit3 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表编号 */
    private Long frid;

    /** 果子编号 */
    private String dzh;

    /** 果子名称 */
    @Excel(name = "果子名称")
    private String fname;

    /** 位移 */
    @Excel(name = "位移")
    private BigDecimal disp1;

    /** 变形 */
    @Excel(name = "变形")
    private BigDecimal disp2;

    /** 长度1 */
    @Excel(name = "长度1")
    private BigDecimal length1;

    /** 直径1 */
    @Excel(name = "直径1")
    private BigDecimal dia1;

    /** 直径2 */
    @Excel(name = "直径2")
    private BigDecimal dia2;

    /** 直径3 */
    @Excel(name = "直径3")
    private BigDecimal dia3;

    /** 系数 */
    @Excel(name = "系数")
    private BigDecimal coe3;

    /** 长度2 */
    @Excel(name = "长度2")
    private BigDecimal length2;

    /** 长度3 */
    @Excel(name = "长度3")
    private BigDecimal length3;

    /** 高度1 */
    @Excel(name = "高度1")
    private BigDecimal height1;

    /** 长度4 */
    @Excel(name = "长度4")
    private BigDecimal length4;

    /** 半径1 */
    @Excel(name = "半径1")
    private BigDecimal radius1;

    /** 材料1 */
    @Excel(name = "材料1")
    private String mat1;

    /** 扭矩1 */
    @Excel(name = "扭矩1")
    private BigDecimal torsion1;

    /** 应力1 */
    @Excel(name = "应力1")
    private BigDecimal stress1;

    /** 应力2 */
    @Excel(name = "应力2")
    private BigDecimal stress2;

    /** 应力3 */
    @Excel(name = "应力3")
    private BigDecimal stress3;

    /** 应力4 */
    @Excel(name = "应力4")
    private BigDecimal stress4;

    /** 应力5 */
    @Excel(name = "应力5")
    private BigDecimal stress5;

    public void setFrid(Long frid) 
    {
        this.frid = frid;
    }

    public Long getFrid() 
    {
        return frid;
    }
    public void setDzh(String dzh) 
    {
        this.dzh = dzh;
    }

    public String getDzh() 
    {
        return dzh;
    }
    public void setFname(String fname) 
    {
        this.fname = fname;
    }

    public String getFname() 
    {
        return fname;
    }
    public void setDisp1(BigDecimal disp1) 
    {
        this.disp1 = disp1;
    }

    public BigDecimal getDisp1() 
    {
        return disp1;
    }
    public void setDisp2(BigDecimal disp2) 
    {
        this.disp2 = disp2;
    }

    public BigDecimal getDisp2() 
    {
        return disp2;
    }
    public void setLength1(BigDecimal length1) 
    {
        this.length1 = length1;
    }

    public BigDecimal getLength1() 
    {
        return length1;
    }
    public void setDia1(BigDecimal dia1) 
    {
        this.dia1 = dia1;
    }

    public BigDecimal getDia1() 
    {
        return dia1;
    }
    public void setDia2(BigDecimal dia2) 
    {
        this.dia2 = dia2;
    }

    public BigDecimal getDia2() 
    {
        return dia2;
    }
    public void setDia3(BigDecimal dia3) 
    {
        this.dia3 = dia3;
    }

    public BigDecimal getDia3() 
    {
        return dia3;
    }
    public void setCoe3(BigDecimal coe3) 
    {
        this.coe3 = coe3;
    }

    public BigDecimal getCoe3() 
    {
        return coe3;
    }
    public void setLength2(BigDecimal length2) 
    {
        this.length2 = length2;
    }

    public BigDecimal getLength2() 
    {
        return length2;
    }
    public void setLength3(BigDecimal length3) 
    {
        this.length3 = length3;
    }

    public BigDecimal getLength3() 
    {
        return length3;
    }
    public void setHeight1(BigDecimal height1) 
    {
        this.height1 = height1;
    }

    public BigDecimal getHeight1() 
    {
        return height1;
    }
    public void setLength4(BigDecimal length4) 
    {
        this.length4 = length4;
    }

    public BigDecimal getLength4() 
    {
        return length4;
    }
    public void setRadius1(BigDecimal radius1) 
    {
        this.radius1 = radius1;
    }

    public BigDecimal getRadius1() 
    {
        return radius1;
    }
    public void setMat1(String mat1) 
    {
        this.mat1 = mat1;
    }

    public String getMat1() 
    {
        return mat1;
    }
    public void setTorsion1(BigDecimal torsion1) 
    {
        this.torsion1 = torsion1;
    }

    public BigDecimal getTorsion1() 
    {
        return torsion1;
    }
    public void setStress1(BigDecimal stress1) 
    {
        this.stress1 = stress1;
    }

    public BigDecimal getStress1() 
    {
        return stress1;
    }
    public void setStress2(BigDecimal stress2) 
    {
        this.stress2 = stress2;
    }

    public BigDecimal getStress2() 
    {
        return stress2;
    }
    public void setStress3(BigDecimal stress3) 
    {
        this.stress3 = stress3;
    }

    public BigDecimal getStress3() 
    {
        return stress3;
    }
    public void setStress4(BigDecimal stress4) 
    {
        this.stress4 = stress4;
    }

    public BigDecimal getStress4() 
    {
        return stress4;
    }
    public void setStress5(BigDecimal stress5) 
    {
        this.stress5 = stress5;
    }

    public BigDecimal getStress5() 
    {
        return stress5;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("frid", getFrid())
            .append("dzh", getDzh())
            .append("fname", getFname())
            .append("disp1", getDisp1())
            .append("disp2", getDisp2())
            .append("length1", getLength1())
            .append("dia1", getDia1())
            .append("dia2", getDia2())
            .append("dia3", getDia3())
            .append("coe3", getCoe3())
            .append("length2", getLength2())
            .append("length3", getLength3())
            .append("height1", getHeight1())
            .append("length4", getLength4())
            .append("radius1", getRadius1())
            .append("mat1", getMat1())
            .append("torsion1", getTorsion1())
            .append("stress1", getStress1())
            .append("stress2", getStress2())
            .append("stress3", getStress3())
            .append("stress4", getStress4())
            .append("stress5", getStress5())
            .toString();
    }
}
