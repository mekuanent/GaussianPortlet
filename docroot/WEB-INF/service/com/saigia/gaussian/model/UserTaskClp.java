/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.saigia.gaussian.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.saigia.gaussian.service.UserTaskLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mekuanent
 */
public class UserTaskClp extends BaseModelImpl<UserTask> implements UserTask {
	public UserTaskClp() {
	}

	public Class<?> getModelClass() {
		return UserTask.class;
	}

	public String getModelClassName() {
		return UserTask.class.getName();
	}

	public long getPrimaryKey() {
		return _taskId;
	}

	public void setPrimaryKey(long primaryKey) {
		setTaskId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_taskId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskId", getTaskId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public BaseModel<?> getUserTaskRemoteModel() {
		return _userTaskRemoteModel;
	}

	public void setUserTaskRemoteModel(BaseModel<?> userTaskRemoteModel) {
		_userTaskRemoteModel = userTaskRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			UserTaskLocalServiceUtil.addUserTask(this);
		}
		else {
			UserTaskLocalServiceUtil.updateUserTask(this);
		}
	}

	@Override
	public UserTask toEscapedModel() {
		return (UserTask)Proxy.newProxyInstance(UserTask.class.getClassLoader(),
			new Class[] { UserTask.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserTaskClp clone = new UserTaskClp();

		clone.setTaskId(getTaskId());
		clone.setUserId(getUserId());

		return clone;
	}

	public int compareTo(UserTask userTask) {
		int value = 0;

		if (getTaskId() < userTask.getTaskId()) {
			value = -1;
		}
		else if (getTaskId() > userTask.getTaskId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		UserTaskClp userTask = null;

		try {
			userTask = (UserTaskClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = userTask.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{taskId=");
		sb.append(getTaskId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.saigia.gaussian.model.UserTask");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>taskId</column-name><column-value><![CDATA[");
		sb.append(getTaskId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _taskId;
	private long _userId;
	private String _userUuid;
	private BaseModel<?> _userTaskRemoteModel;
}