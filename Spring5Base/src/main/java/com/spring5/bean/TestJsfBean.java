package com.spring5.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring5.service.MsgService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@Component
@RequestScoped
@ManagedBean
public class TestJsfBean {
    @Autowired
    private MsgService msgService;

    public String getMsg() {
        return msgService.getMsg();
    }
}
