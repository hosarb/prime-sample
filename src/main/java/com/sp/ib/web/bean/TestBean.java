package com.sp.ib.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Date;

@ManagedBean(name = "testBean", eager = true)
@RequestScoped
public class TestBean {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void doTest(){
        System.out.println("TestBean.doTest");
        System.out.println("date = " + date);
        System.out.println("TestBean.doTest");
    }
}
