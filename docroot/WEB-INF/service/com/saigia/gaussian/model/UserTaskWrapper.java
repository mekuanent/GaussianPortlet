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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserTask}.
 * </p>
 *
 * @author    Mekuanent
 * @see       UserTask
 * @generated
 */
public class UserTaskWrapper implements UserTask, ModelWrapper<UserTask> {
	public UserTaskWrapper(UserTask userTask) {
		_userTask = userTask;
	}

	public Class<?> getModelClass() {
		return UserTask.class;
	}

	public String getModelClassName() {
		return UserTask.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskId", getTaskId());
		attributes.put("userId", getUserId());

		return attributes;
	}

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

	/**
	* Returns the primary key of this user task.
	*
	* @return the primary key of this user task
	*/
	public long getPrimaryKey() {
		return _userTask.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user task.
	*
	* @param primaryKey the primary key of this user task
	*/
	public void setPrimaryKey(long primaryKey) {
		_userTask.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the task ID of this user task.
	*
	* @return the task ID of this user task
	*/
	public long getTaskId() {
		return _userTask.getTaskId();
	}

	/**
	* Sets the task ID of this user task.
	*
	* @param taskId the task ID of this user task
	*/
	public void setTaskId(long taskId) {
		_userTask.setTaskId(taskId);
	}

	/**
	* Returns the user ID of this user task.
	*
	* @return the user ID of this user task
	*/
	public long getUserId() {
		return _userTask.getUserId();
	}

	/**
	* Sets the user ID of this user task.
	*
	* @param userId the user ID of this user task
	*/
	public void setUserId(long userId) {
		_userTask.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user task.
	*
	* @return the user uuid of this user task
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTask.getUserUuid();
	}

	/**
	* Sets the user uuid of this user task.
	*
	* @param userUuid the user uuid of this user task
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_userTask.setUserUuid(userUuid);
	}

	public boolean isNew() {
		return _userTask.isNew();
	}

	public void setNew(boolean n) {
		_userTask.setNew(n);
	}

	public boolean isCachedModel() {
		return _userTask.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_userTask.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _userTask.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _userTask.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userTask.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userTask.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userTask.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserTaskWrapper((UserTask)_userTask.clone());
	}

	public int compareTo(UserTask userTask) {
		return _userTask.compareTo(userTask);
	}

	@Override
	public int hashCode() {
		return _userTask.hashCode();
	}

	public com.liferay.portal.model.CacheModel<UserTask> toCacheModel() {
		return _userTask.toCacheModel();
	}

	public UserTask toEscapedModel() {
		return new UserTaskWrapper(_userTask.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userTask.toString();
	}

	public java.lang.String toXmlString() {
		return _userTask.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userTask.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public UserTask getWrappedUserTask() {
		return _userTask;
	}

	public UserTask getWrappedModel() {
		return _userTask;
	}

	public void resetOriginalValues() {
		_userTask.resetOriginalValues();
	}

	private UserTask _userTask;
}