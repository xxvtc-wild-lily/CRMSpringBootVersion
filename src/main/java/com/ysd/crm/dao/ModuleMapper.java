package com.ysd.crm.dao;

import java.util.List;

import com.ysd.crm.entity.Modules;
import com.ysd.crm.entity.RoleModules;

public interface ModuleMapper {
	/**
	 * 查询所有模块数据
	 * @return
	 */
	List<Modules> selectModulesAll();
	/**
	 * 角色模块连表查询
	 * @param id
	 * @return
	 */
	List<Modules> selectmodulerole(Integer id);
	/**
	 * 根据查询父模块
	 * @return
	 */
	List<Modules> selectModuleByparentId();
	/**
	 * 添加模块
	 * @return
	 */
	Integer addModule(Modules modules);
	/**
	 * 根据角色id查询模块id
	 * @param id
	 * @return
	 */
	List<RoleModules> selectByRoleId(Integer id);
	/**
	 * 根据模块id查询拥有该模块的角色个数
	 * @param id
	 * @return
	 */
	Integer selectrolemodule(Integer id);
	/**
	 * 根据id删除模块
	 * @param id
	 * @return
	 */
	Integer deleteModuleById(Integer id);
	/**
	 * 根据父id删除模块
	 * @param id
	 * @return
	 */
	Integer deleteMoByFuId(Integer id);
	/**
	 * 根据id查询模块
	 * @param id
	 * @return
	 */
	Modules selectModuleById(Integer id);
	/**
	 * 根据模块ID修改模块
	 * @param modules
	 * @return
	 */
	Integer updateModuleById(Modules modules);
	/**
	 * 添加父模块
	 * @param name
	 * @return
	 */
	Integer addModuleFu(Modules modules);
}
