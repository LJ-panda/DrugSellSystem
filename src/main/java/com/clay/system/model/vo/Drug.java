package com.clay.system.model.vo;

import com.clay.system.model.enity.DrugSuppliersInfo;
import com.clay.system.utils.StaticUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/30 13:19
 * @Version 1.0
 *
 * 还应该封装供应商等信息
 */
@Data
@AllArgsConstructor
public class Drug
{
    private int id; //药品库id

    private int drugCode;

    @NotBlank(message = "药物名不可为空")
    private String drugName;

    @Positive(message = "采购数量必须大于0")
    private int drugNum;

    @Positive(message = "单价不可小于等于0")
    private float singlePrice;

    private int typeCode;   //通过增添页下拉选取

    @Valid
    private DrugSuppliersInfo suppliersInfo;  //供应商

    @Size(max = 150,message = "药物描述不可超过150字")
    private String description;

    @DateTimeFormat(pattern = StaticUtils.DATE_PATTERN)
    private Date createTime;            //添加时间

    public Drug()
    {
        this.createTime=new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drug drug = (Drug) o;
        return id == drug.id &&
                drugCode == drug.drugCode &&
                drugNum == drug.drugNum &&
                Float.compare(drug.singlePrice, singlePrice) == 0 &&
                typeCode == drug.typeCode &&
                Objects.equals(drugName, drug.drugName) &&
                Objects.equals(suppliersInfo, drug.suppliersInfo) &&
                Objects.equals(description, drug.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, drugCode, drugName, drugNum, singlePrice, typeCode, suppliersInfo, description);
    }
}
