package com.clay.system.mapper;

import com.clay.system.model.enity.PurchaseDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/30 20:02
 * @Version 1.0
 */
@Repository
public interface DetailsMapper
{
    int insertDetails(List<PurchaseDetails> details);

    List<PurchaseDetails> queryByCode(int purchaseCode);
}
