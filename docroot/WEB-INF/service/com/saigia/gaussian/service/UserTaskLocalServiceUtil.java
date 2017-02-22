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

package com.saigia.gaussian.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the user task local service. This utility wraps {@link com.saigia.gaussian.service.impl.UserTaskLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mekuanent
 * @see UserTaskLocalService
 * @see com.saigia.gaussian.service.base.UserTaskLocalServiceBaseImpl
 * @see com.saigia.gaussian.service.impl.UserTaskLocalServiceImpl
 * @generated
 */
public class UserTaskLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.saigia.gaussian.service.impl.UserTaskLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user task to the database. Also notifies the appropriate model listeners.
	*
	* @param userTask the user task
	* @return the user task that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.saigia.gaussian.model.UserTask addUserTask(
		com.saigia.gaussian.model.UserTask userTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserTask(userTask);
	}

	/**
	* Creates a new user task with the primary key. Does not add the user task to the database.
	*
	* @param taskId the primary key for the new user task
	* @return the new user task
	*/
	public static com.saigia.gaussian.model.UserTask createUserTask(long taskId) {
		return getService().createUserTask(taskId);
	}

	/**
	* Deletes the user task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskId the primary key of the user task
	* @return the user task that was removed
	* @throws PortalException if a user task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.saigia.gaussian.model.UserTask deleteUserTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserTask(taskId);
	}

	/**
	* Deletes the user task from the database. Also notifies the appropriate model listeners.
	*
	* @param userTask the user task
	* @return the user task that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.saigia.gaussian.model.UserTask deleteUserTask(
		com.saigia.gaussian.model.UserTask userTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserTask(userTask);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.saigia.gaussian.model.UserTask fetchUserTask(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUserTask(taskId);
	}

	/**
	* Returns the user task with the primary key.
	*
	* @param taskId the primary key of the user task
	* @return the user task
	* @throws PortalException if a user task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.saigia.gaussian.model.UserTask getUserTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserTask(taskId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the user tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user tasks
	* @param end the upper bound of the range of user tasks (not inclusive)
	* @return the range of user tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.saigia.gaussian.model.UserTask> getUserTasks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserTasks(start, end);
	}

	/**
	* Returns the number of user tasks.
	*
	* @return the number of user tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserTasksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserTasksCount();
	}

	/**
	* Updates the user task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userTask the user task
	* @return the user task that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.saigia.gaussian.model.UserTask updateUserTask(
		com.saigia.gaussian.model.UserTask userTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserTask(userTask);
	}

	/**
	* Updates the user task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userTask the user task
	* @param merge whether to merge the user task with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user task that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.saigia.gaussian.model.UserTask updateUserTask(
		com.saigia.gaussian.model.UserTask userTask, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserTask(userTask, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserTaskLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserTaskLocalService.class.getName());

			if (invokableLocalService instanceof UserTaskLocalService) {
				_service = (UserTaskLocalService)invokableLocalService;
			}
			else {
				_service = new UserTaskLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UserTaskLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(UserTaskLocalService service) {
	}

	private static UserTaskLocalService _service;
}