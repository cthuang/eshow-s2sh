package com.logo.eshow.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.logo.eshow.common.dao.CriteriaQuery;
import com.logo.eshow.common.dao.DAOException;
import com.logo.eshow.common.dao.EnhancedRule;
import com.logo.eshow.common.page.Page;

/**
 * Generic DAO (Data Access Object) with common methods to CRUD POJOs.
 * <p>
 * Extend this interface if you want typesafe (no casting necessary) DAO's for your domain objects.
 * 
 * @param <T> a type variable
 * @param <PK> the primary key for that type
 */
public interface GenericDao<T, PK extends Serializable> {

	/**
	 * Generic method used to get all objects of a particular type. This is the same as lookup up all rows in a table.
	 * 
	 * @return List of populated objects
	 */
	List<T> getAll();

	/**
	 * Generic method to get an object based on class and identifier. An ObjectRetrievalFailureException Runtime
	 * Exception is thrown if nothing is found.
	 * 
	 * @param id the identifier (primary key) of the object to get
	 * @return a populated object
	 * @see org.springframework.orm.ObjectRetrievalFailureException
	 */
	T get(PK id);

	/**
	 * Checks for existence of an object of type T using the id arg.
	 * 
	 * @param id the id of the entity
	 * @return - true if it exists, false if it doesn't
	 */
	boolean exists(PK id);

	/**
	 * Generic method to save an object - handles both update and insert.
	 * 
	 * @param object the object to save
	 * @return the persisted object
	 */
	T save(T object);

	/**
	 * Generic method to save an object - handles both update and insert.
	 * 
	 * @param objects the object to save
	 */
	void save(List<T> objects);

	/**
	 * Generic method to delete an object based on class and id
	 * 
	 * @param id the identifier (primary key) of the object to remove
	 */
	void remove(PK id);

	/**
	 * 删除一个域对象
	 * 
	 * @param object
	 * @return T
	 * @throws DAOException
	 */
	T delete(T object) throws DAOException;

	/**
	 * 根据域对象类和条件查询对象查询一组域对象
	 * 
	 * @param enhanceRule
	 * @return List<T>
	 * @throws DAOException
	 */
	List<T> list(EnhancedRule enhanceRule) throws DAOException;

	/**
	 * 根据域对象类和条件查询对象查询单个域对象
	 * 
	 * @param enhanceRule
	 * @return T
	 * @throws DAOException
	 */
	T uniqueResult(EnhancedRule enhanceRule) throws DAOException;

	/**
	 * 根据域对象类和条件查询对象查询数量
	 * 
	 * @param clazz
	 * @param enhanceRule
	 * @return long
	 * @throws DAOException
	 */
	long count(Class<T> clazz, EnhancedRule enhanceRule) throws DAOException;

	/**
	 * <p>
	 * 根据复杂条件查询对象进行类似数据库SQL的复杂查询.
	 * <p>
	 * 支持子查询,投影操作,聚合函数等
	 * 
	 * @param criteria
	 * @return List<T>
	 * @throws DAOException
	 */
	List<T> find(CriteriaQuery criteria) throws DAOException;

	/**
	 * 获取一个实体类的对象数
	 * 
	 * @param clazz
	 * @return long
	 * @throws DAOException
	 */
	long countAll(Class<T> clazz) throws DAOException;

	/**
	 * 删除一个实体类所有的数据
	 * 
	 * @param clazz
	 * @return long
	 * @throws DAOException
	 */
	long deleteAll(Class<T> clazz) throws DAOException;

	/**
	 * 取得唯一的一个Sequence
	 * 
	 * @return long
	 * @throws DAOException
	 */
	long getSequenceNumber() throws DAOException;

	/**
	 * 根据配置的查询名称进行查询，返回多个对象
	 * 
	 * @param queryName
	 * @param params
	 * @return List<T>
	 * @throws DAOException
	 */
	List<T> listByNamedQuery(String queryName, Object[] params) throws DAOException;

	/**
	 * 根据HQL进行查询，返回多个对象
	 * 
	 * @param hql
	 * @param params
	 * @return List<T>
	 * @throws DAOException
	 */
	List<T> list(String hql, Object[] params) throws DAOException;

	/**
	 * 根据配置的查询名称进行查询，返回单个对象
	 * 
	 * @param queryName
	 * @param params
	 * @return T
	 * @throws DAOException
	 */
	T uniqueResultByNamedQuery(String queryName, Object[] params) throws DAOException;

	/**
	 * 根据HQL进行查询，返回单个对象
	 * 
	 * @param hql
	 * @param params
	 * @return T
	 * @throws DAOException
	 */
	T uniqueResult(String hql, Object[] params) throws DAOException;

	/**
	 * 根据配置的查询名称进行更新操作
	 * 
	 * @param updateQueryName
	 * @param params
	 * @return int
	 * @throws DAOException
	 */
	int executeUpdateByNamedQuery(String updateQueryName, Object[] params) throws DAOException;

	/**
	 * 根据HQL进行更新操作
	 * 
	 * @param hql
	 * @param params
	 * @return int
	 * @throws DAOException
	 */
	int executeUpdate(String hql, Object[] params) throws DAOException;

	/**
	 * 根据配置的查询名称进行Hibernate方式的命名查询，返回多个对象
	 * 
	 * @param queryName
	 * @param name
	 * @param params
	 * @return List<T>
	 * @throws DAOException
	 */
	List<T> listByNamedQuery(String queryName, String[] name, Object[] params) throws DAOException;

	/**
	 * 根据HQL进行Hibernate方式的命名查询，返回多个对象
	 * 
	 * @param hql
	 * @param name
	 * @param params
	 * @return List<T>
	 * @throws DAOException
	 */
	List<T> list(String hql, String[] name, Object[] params) throws DAOException;

	/**
	 * 根据排序字段和数量返回一个列表
	 * 
	 * @param order
	 * @param count
	 * @return List
	 * @throws DAOException
	 */
	List<T> list(String order, int count) throws DAOException;

	/**
	 * 根据配置的查询名称进行Hibernate方式的命名查询，返回单个对象
	 * 
	 * @param queryName
	 * @param name
	 * @param params
	 * @return T
	 * @throws DAOException
	 */
	T uniqueResultByNamedQuery(String queryName, String[] name, Object[] params)
			throws DAOException;

	/**
	 * 根据HQL进行Hibernate方式的命名查询，返回单个对象
	 * 
	 * @param hql
	 * @param name
	 * @param params
	 * @return T
	 * @throws DAOException
	 */
	T uniqueResult(String hql, String[] name, Object[] params) throws DAOException;

	/**
	 * 根据配置的查询名称进行Hibernate方式的命名更新操作
	 * 
	 * @param updateQueryName
	 * @param name
	 * @param params
	 * @return int
	 * @throws DAOException
	 */
	int executeUpdateByNamedQuery(String updateQueryName, String[] name, Object[] params)
			throws DAOException;

	/**
	 * 根据HQL进行Hibernate方式的命名更新操作
	 * 
	 * @param hql
	 * @param name
	 * @param params
	 * @return int
	 * @throws DAOException
	 */
	int executeUpdate(String hql, String[] name, Object[] params) throws DAOException;

	/**
	 * 根据规则删除对象
	 * 
	 * @param clazz
	 * @param rule
	 * @return int
	 * @throws DAOException
	 */
	int delete(Class<T> clazz, EnhancedRule rule) throws DAOException;

	/**
	 * 根据EnhancedRule返回分页Page对象，EnhancedRule应该要设置firstResult和MaxResult
	 * 
	 * @param rule
	 * @return Page<T>
	 * @throws DAOException
	 */
	Page<T> page(EnhancedRule rule) throws DAOException;

	/**
	 * 根据配置好的HQL语句(JDBC占位符形式)，进行分页查询
	 * 
	 * @param queryName
	 * @param params
	 * @param offset
	 * @param pageSize
	 * @return Page<T>
	 * @throws DAOException
	 */
	Page<T> page(String queryName, Object[] params, int offset, int pageSize) throws DAOException;

	/**
	 * 根据配置好的HQL语句(命名查询形式)，进行分页查询
	 * 
	 * @param queryName
	 * @param name
	 * @param params
	 * @param offset
	 * @param pageSize
	 * @return Page<T>
	 * @throws DAOException
	 */
	Page<T> page(String queryName, String[] name, Object[] params, int offset, int pageSize)
			throws DAOException;

	/**
	 * 根据传入的HQL语句(JDBC占位符形式)，进行分页查询
	 * 
	 * @param hql
	 * @param params
	 * @param offset
	 * @param pageSize
	 * @return Page<T>
	 * @throws DAOException
	 */
	Page<T> pageByHQL(String hql, Object[] params, int offset, int pageSize) throws DAOException;

	/**
	 * 根据传入的HQL语句(命名查询形式)，进行分页查询
	 * 
	 * @param hql
	 * @param name
	 * @param params
	 * @param offset
	 * @param pageSize
	 * @return Page<T>
	 * @throws DAOException
	 */
	Page<T> pageByHQL(String hql, String[] name, Object[] params, int offset, int pageSize)
			throws DAOException;

	/**
	 * 判断对象某列的值在数据库中不存在重复
	 * 
	 * @param entity
	 * @param names 在POJO里相对应的属性名,列组合时以逗号分割<br>
	 *        如"name,loginid,password"
	 * @return boolean
	 * @throws DAOException
	 */
	boolean isNotUnique(Object entity, String names) throws DAOException;

	/**
	 * 获得Hibernate的Session对象
	 * 
	 * @return Session
	 * @throws DAOException
	 */
	Session getNewSession() throws DAOException;
}