package com.logo.eshow.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.logo.eshow.bean.query.TopicQuery;
import com.logo.eshow.common.dao.EnhancedRule;
import com.logo.eshow.common.page.Page;
import com.logo.eshow.dao.TopicDao;
import com.logo.eshow.dao.hibernate.GenericDaoHibernate;
import com.logo.eshow.model.Topic;

/**
 * 
 * @author leida
 *
 */
@Repository("topicDao")
public class TopicDaoHibernate extends GenericDaoHibernate<Topic, Integer>
		implements TopicDao {

	public TopicDaoHibernate() {
		super(Topic.class);
	}

	public List<Topic> list(TopicQuery query) {
		EnhancedRule rule = new EnhancedRule();
		setRule(rule, query);
		return list(rule);
	}

	public Page<Topic> search(TopicQuery query) {
		EnhancedRule rule = new EnhancedRule();
		setRule(rule, query);
		if (query != null) {
			rule.setOffset(query.getOffset());
			rule.setPageSize(query.pagesize);
		}
		return page(rule);
	}

	public EnhancedRule setRule(EnhancedRule rule, TopicQuery query) {
		if (query != null) {
			if (query.addTime != null) {
				rule.add(Restrictions.eq("addTime", query.addTime));
			}
			if (query.updateTime != null) {
				rule.add(Restrictions.eq("updateTime", query.updateTime));
			}
			if (query.title != null) {
				rule.add(Restrictions.eq("title", query.title));
			}
			if (query.content != null) {
				rule.add(Restrictions.eq("content", query.content));
			}
			if (query.state != null) {
				rule.add(Restrictions.eq("state", query.state));
			}
			if (query.tip != null) {
				rule.add(Restrictions.eq("tip", query.tip));
			}
			if (query.boardId != null) {
				rule.add(Restrictions.eq("board.id", query.boardId));
			}
			if (query.userId != null) {
				rule.add(Restrictions.eq("user.id", query.userId));
			}
			if (query.getOrder() != null) {
				rule.addOrder(query.getDesc() ? Order.desc(query
						.getOrder()) : Order.asc(query.getOrder()));
			}
		}
		return rule;
	}
}
