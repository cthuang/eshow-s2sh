package com.logo.eshow.webapp.action;

import magick.MagickException;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.security.access.AccessDeniedException;

import com.logo.eshow.Constants;
import com.logo.eshow.bean.query.ThumbQueryBean;
import com.logo.eshow.bean.query.UserQueryBean;
import com.logo.eshow.common.page.Page;
import com.logo.eshow.model.Role;
import com.logo.eshow.model.Thumb;
import com.logo.eshow.model.User;
import com.logo.eshow.service.ThumbManager;
import com.logo.eshow.service.UserExistsException;
import com.logo.eshow.util.DateUtil;
import com.logo.eshow.util.ImageUtil;
import com.logo.eshow.util.PageUtil;
import com.logo.eshow.webapp.util.RequestUtil;

import org.springframework.mail.MailException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Results( { @Result(name = "input", location = "add"),
		@Result(name = "list", type = "redirect", location = ""),
		@Result(name = "success", type = "redirect", location = "view/${id}"),
		@Result(name = "redirect", type = "redirect", location = "${redirect}") })
public class UserAction extends BaseFileUploadAction {
	private static final long serialVersionUID = 6776558938712115191L;
	private List<User> users;
	private ThumbManager thumbManager;
	private User user;
	private UserQueryBean queryBean;

	/**
	 * Constant for photo result String
	 */
	public static final String PHOTO = "photo";

	/**
	 * 查询用户
	 * 
	 * @return String
	 */
	public String search() {
		Page<User> page = userManager.search(queryBean, getOffset(), pagesize);
		users = page.getDataList();
		saveRequest("page", PageUtil.conversion(page));
		return LIST;
	}

	/**
	 * @return String
	 */
	public String view() {
		if (id == null) {
			if (getRequest().getRemoteUser() != null) {
				user = userManager.getUserByUsername(getRequest()
						.getRemoteUser());
			} else {
				return INPUT;
			}
		} else {
			user = userManager.getUser(id);
		}
		return NONE;

	}

	/**
	 * 更新用户照片
	 * 
	 * @return success
	 * @throws MagickException
	 * @throws IOException
	 * @throws UserExistsException
	 */
	public String photo() throws MagickException, IOException,
			UserExistsException {
		user = userManager.getUser(id);
		String path = "upload/user/"
				+ DateUtil.getDateTime("yyyyMMdd", user.getAddTime()) + "/";
		user.setPhoto(user.getId() + ".jpg");

		userManager.saveUser(user);

		// 获得裁剪和缩略的参数
		Integer x = Integer.valueOf(getRequest().getParameter("left"));
		Integer y = Integer.valueOf(getRequest().getParameter("top"));
		Integer w = Integer.valueOf(getRequest().getParameter("width"));
		Integer h = Integer.valueOf(getRequest().getParameter("height"));

		// 裁剪头像
		ImageUtil.cropImage(path + "view/" + user.getId() + "-" + w + "-" + h
				+ ".jpg", path + "crop/" + user.getId() + "-450-450.jpg", x, y,
				w, h);

		ThumbQueryBean thumbQueryBean = new ThumbQueryBean();
		thumbQueryBean.setModel("user");
		List<Thumb> list = thumbManager.list(thumbQueryBean);
		// 根据缩略图规则进行缩略图生成
		for (Thumb thumb : list) {
			if (!thumb.getWidth().equals(w) && !thumb.getHeight().equals(h)) {
				ImageUtil.resizeImage(path + "view/" + user.getId() + "-"
						+ thumb.getWidth() + "-" + thumb.getWidth() + ".jpg",
						path + "view/" + user.getId() + "-" + w + "-" + h
								+ ".jpg", thumb.getWidth(), thumb.getHeight(),
						thumb.getType());
			}
		}
		return PHOTO;
	}

	/**
	 * Delete the user passed in.
	 * 
	 * @return success
	 */
	public String delete() {
		userManager.removeUser(id);
		saveMessage("用户" + user.getUsername() + "删除成功");

		return SUCCESS;
	}

	/**
	 * 修改密码
	 * 
	 * @return String
	 * @throws UserExistsException
	 */
	public String password() throws UserExistsException {
		User old = userManager.getUser(id);
		String oldPassword = getRequest().getParameter("oldPassword");
		if (userManager.password(oldPassword, user.getPassword(), old)) {
			saveMessage("密码修改成功");
		} else {
			saveMessage("旧密码输入错误");
		}
		return REDIRECT;
	}

	/**
	 * Grab the user from the database based on the "id" passed in.
	 * 
	 * @return success if user found
	 * @throws IOException
	 *             can happen when sending a "forbidden" from
	 *             response.sendError()
	 */
	public String edit() throws IOException {
		HttpServletRequest request = getRequest();

		// if a user's id is passed in
		if (id != null) {
			// lookup the user using that id
			user = userManager.getUser(id);
		} else if (request.getRemoteUser() != null) {
			user = userManager.getUserByUsername(request.getRemoteUser());
		} else {
			user = new User();
			user.addRole(new Role(Constants.USER_ROLE));
		}

		return SUCCESS;
	}

	/**
	 * Default: just returns "success"
	 * 
	 * @return "success"
	 */
	public String execute() {
		System.out.println("execute");
		return SUCCESS;
	}

	/**
	 * Sends users to "mainMenu" when !from.equals("list"). Sends everyone else
	 * to "cancel"
	 * 
	 * @return "mainMenu" or "cancel"
	 */
	public String cancel() {
		if (!"list".equals(from)) {
			return LIST;
		}
		return LIST;
	}

	/**
	 * 修改用户
	 * 
	 * @return String
	 * @throws UserExistsException
	 */
	public String update() throws UserExistsException {
		// only attempt to change roles if user is admin
		// for other users, prepare() method will handle populating
		User old = userManager.getUser(id);
		old.setNickname(user.getNickname());
		old.setRealname(user.getRealname());
		old.setAge(user.getAge());
		old.setMale(user.getMale());
		old.setBirthday(user.getBirthday());
		old.setConstellation(user.getConstellation());
		old.setBloodType(user.getBloodType());
		old.setBirthAttrib(user.getBirthAttrib());
		old.setMarital(user.getMarital());
		old.setIntro(user.getIntro());
		old.setHobby(user.getHobby());
		userManager.saveUser(old);
		saveMessage("资料修改成功");
		return LIST;
	}

	/**
	 * Save user
	 * 
	 * @return success if everything worked, otherwise input
	 * @throws IOException
	 *             when setting "access denied" fails on response
	 */
	public String save() throws Exception {

		Integer originalVersion = user.getVersion();

		boolean isNew = ("".equals(getRequest().getParameter("user.version")));
		// only attempt to change roles if user is admin
		// for other users, prepare() method will handle populating
		if (getRequest().isUserInRole(Constants.ADMIN_ROLE)) {
			user.getRoles().clear(); // APF-788: Removing roles from user
										// doesn't work
			String[] userRoles = getRequest().getParameterValues("userRoles");

			for (int i = 0; userRoles != null && i < userRoles.length; i++) {
				String roleName = userRoles[i];
				user.addRole(roleManager.getRole(roleName));
			}
		}

		try {
			userManager.saveUser(user);
		} catch (AccessDeniedException ade) {
			// thrown by UserSecurityAdvice configured in aop:advisor
			// userManagerSecurity
			log.warn(ade.getMessage());
			getResponse().sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		} catch (UserExistsException e) {
			List<Object> args = new ArrayList<Object>();
			args.add(user.getNickname());
			args.add(user.getUsername());
			addActionError(getText("errors.existing.user", args));

			// reset the version # to what was passed in
			user.setVersion(originalVersion);
			// redisplay the unencrypted passwords
			user.setPassword(user.getConfirmPassword());
			return INPUT;
		}

		if (!"list".equals(from)) {
			// add success messages
			saveMessage(getText("user.saved"));
			return "mainMenu";
		} else {
			// add success messages
			List<Object> args = new ArrayList<Object>();
			args.add(user.getNickname());
			if (isNew) {
				saveMessage(getText("user.added", args));
				// Send an account information e-mail
				mailMessage.setSubject(getText("signup.email.subject"));
				try {
					sendUserMessage(user,
							getText("newuser.email.message", args), RequestUtil
									.getAppURL(getRequest()));
				} catch (MailException me) {
					addActionError(me.getCause().getLocalizedMessage());
				}
				return SUCCESS;
			} else {
				saveMessage(getText("user.updated.byAdmin", args));
				return INPUT;
			}
		}
	}

	/**
	 * Fetch all users from database and put into local "users" variable for
	 * retrieval in the UI.
	 * 
	 * @return "success" if no exceptions thrown
	 */
	public String list() {
		users = userManager.getUsers();
		return SUCCESS;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public ThumbManager getThumbManager() {
		return thumbManager;
	}

	public void setThumbManager(ThumbManager thumbManager) {
		this.thumbManager = thumbManager;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserQueryBean getQueryBean() {
		return queryBean;
	}

	public void setQueryBean(UserQueryBean queryBean) {
		this.queryBean = queryBean;
	}

}
