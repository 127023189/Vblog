package org.yixi.vblogserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.yixi.vblogserver.bean.Role;

import java.util.List;

@Mapper
public interface RolesMapper {

    List<Role> getRolesByUid(@Param("id") Long id);
}
