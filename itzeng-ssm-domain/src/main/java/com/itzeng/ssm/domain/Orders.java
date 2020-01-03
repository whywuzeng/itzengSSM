package com.itzeng.ssm.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/1/2.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.domain
 */

public class Orders {
    private String id;
    private String orderNum;//出游人数
    private Date orderTime;
    private String orderTimeStr;
    private Integer peoplecount;
    private String orderDesc; //其他信息
    private Integer payType; //支付方式
    private String payTypeStr;
    private Integer orderStatus;//支付状态
    private String orderStatusStr;
    private Product product;
    private Member member;
    private List<Traveller> travellers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );
        return sdf.format(orderTime);
    }

    public void setOrderTimeStr() {
        if (orderTime!=null)
        {
            this.orderTimeStr = orderTime.toString();
        }
    }

    public Integer getPeoplecount() {
        return peoplecount;
    }

    public void setPeoplecount(Integer peoplecount) {
        this.peoplecount = peoplecount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {

        if (payType!=null)
        {
            if (payType == 0) {
                payTypeStr = "支付宝";
            }
            else if (payType == 1) {
                payTypeStr = "微信";
            }
            else {
                payTypeStr = "其他";
            }
        }
        return payTypeStr;
    }

    public String getOrderStatusStr() {
        if (orderStatus!=null)
        {
            if (orderStatus == 0)
            {
                orderStatusStr ="未支付";
            }else if (orderStatus == 1){
                orderStatusStr = "已支付";
            }
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }
}
