package com.logo.eshow.dao.hibernate;

import com.logo.eshow.bean.query.UserQueryBean;
import com.logo.eshow.common.dao.EnhancedRule;
import com.logo.eshow.common.page.Page;
import com.logo.eshow.dao.UserDao;
import com.logo.eshow.model.User;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Table;
import java.util.List;

/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve User objects.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Modified by
 *         <a href="mailto:dan@getrolling.com">Dan Kibler</a> Extended to
 *         implement Acegi UserDetailsService interface by David Carter
 *         david@carter.net Modified by <a href="mailto:bwnoll@gmail.com">Bryan
 *         Noll</a> to work with the new BaseDaoHibernate implementation that
 *         uses generics.
 */
@Repository("userDao")
public class UserDaoHibernate extends GenericDaoHibernate<User, Integer>
		implements UserDao, UserDetailsService {

	/**
	 * Constructor that sets the entity to User.class.
	 */
	public UserDaoHibernate() {
		super(User.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getHibernateTemplate().find(
				"from User u order by upper(u.username)");
	}

	/**
	 * {@inheritDoc}
	 */
	public Page<User> search(UserQueryBean queryBean, int offset, int pagesize) {
		EnhancedRule rule = new EnhancedRule();
		if (queryBean != null) {
			if (queryBean.nikename != null) {
				rule.add(Restrictions.like("nikename", queryBean.nikename,
						MatchMode.ANYWHERE));
			}
			if (queryBean.getOrder() != null) {
				rule.addOrder(queryBean.getDesc() ? Order.desc(queryBean
						.getOrder()) : Order.asc(queryBean.getOrder()));
			}
		}
		rule.setOffset(offset);
		rule.setPageSize(pagesize);
		return page(rule);
	}

	public User saveUser(User user) {
		log.debug("user's id: " + user.getId());
		getHibernateTemplate().saveOrUpdate(user);
		// necessary to throw a DataIntegrityViolation and catch it in
		// UserManager
		getHibernateTemplate().flush();
		return user;
	}

	/**
	 * Overridden simply to call the saveUser method. This is happenening
	 * because saveUser flushes the session and saveObject of BaseDaoHibernate
	 * does not.
	 * 
	 * @param user
	 *            the user to save
	 * @return the modified user (with a primary key set if they're new)
	 */
	@Override
	public User save(User user) {
		return this.saveUser(user);
	}

	/**
	 * {@inheritDoc}
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		List<?> users = getHibernateTemplate().find(
				"from User where username=?", username);
		if (users == null || users.isEmpty()) {
			throw new UsernameNotFoundException("user '" + username
					+ "' not found...");
		} else {
			return (UserDetails) users.get(0);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getUserPassword(String username) {
		SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(
				SessionFactoryUtils.getDataSource(getSessionFactory()));
		Table table = AnnotationUtils.findAnnotation(User.class, Table.class);
		return jdbcTemplate.queryForObject("select password from "
				+ table.name() + " where username=?", String.class, username);

	}

}
