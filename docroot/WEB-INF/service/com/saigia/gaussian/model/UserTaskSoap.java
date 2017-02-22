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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.saigia.gaussian.service.http.UserTaskServiceSoap}.
 *
 * @author    Mekuanent
 * @see       com.saigia.gaussian.service.http.UserTaskServiceSoap
 * @generated
 */
public class UserTaskSoap implements Serializable {
	public static UserTaskSoap toSoapModel(UserTask model) {
		UserTaskSoap soapModel = new UserTaskSoap();

		soapModel.setTaskId(model.getTaskId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static UserTaskSoap[] toSoapModels(UserTask[] models) {
		UserTaskSoap[] soapModels = new UserTaskSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserTaskSoap[][] toSoapModels(UserTask[][] models) {
		UserTaskSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserTaskSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserTaskSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserTaskSoap[] toSoapModels(List<UserTask> models) {
		List<UserTaskSoap> soapModels = new ArrayList<UserTaskSoap>(models.size());

		for (UserTask model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserTaskSoap[soapModels.size()]);
	}

	public UserTaskSoap() {
	}

	public long getPrimaryKey() {
		return _taskId;
	}

	public void setPrimaryKey(long pk) {
		setTaskId(pk);
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

	private long _taskId;
	private long _userId;
}