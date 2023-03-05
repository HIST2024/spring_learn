package com.itheima.ioc.dao.impl;

import com.itheima.ioc.dao.RoleDao;

public class RoleDaoImpl implements RoleDao {
    @Override
    public void addRole() {
        System.out.println("添加角色");
    }

    @Override
    public void deleteRole() {
        System.out.println("删除角色");
    }

    @Override
    public void updateRole() {
        System.out.println("修改角色");
    }

    @Override
    public void queryRole() {
        System.out.println("查询角色");
    }
}
