package com.funi.demo.authority.service;

import com.funi.demo.authority.domain.User;
import org.springframework.stereotype.Component;

/**
 * @author zhihuan.niu on 2016/11/1.
 */
public interface IUserService {
    /**
     * �����û�
     * @param record         ������¼
     * @param currentUser   ��ǰ������Ա
     */
    void createRecord(User record,User currentUser);
}
