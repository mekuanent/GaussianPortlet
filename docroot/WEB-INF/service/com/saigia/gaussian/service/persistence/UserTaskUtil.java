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

package com.saigia.gaussian.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.saigia.gaussian.model.UserTask;

import java.util.List;

/**
 * The persistence utility for the user task service. This utility wraps {@link UserTaskPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mekuanent
 * @see UserTaskPersistence
 * @see UserTaskPersistenceImpl
 * @generated
 */
public class UserTaskUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UserTask userTask) {
		getPersistence().clearCache(userTask);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserTask> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static UserTask update(UserTask userTask, boolean merge)
		throws SystemException {
		return getPersistence().update(userTask, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static UserTask update(UserTask userTask, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userTask, merge, serviceContext);
	}

	/**
	* Caches the user task in the entity cache if it is enabled.
	*
	* @param userTask the user task
	*/
	public static void cacheResult(com.saigia.gaussian.model.UserTask userTask) {
		getPersistence().cacheResult(userTask);
	}

	/**
	* Caches the user tasks in the entity cache if it is enabled.
	*
	* @param userTasks the user tasks
	*/
	public static void cacheResult(
		java.util.List<com.saigia.gaussian.model.UserTask> userTasks) {
		getPersistence().cacheResult(userTasks);
	}

	/**
	* Creates a new user task with the primary key. Does not add the user task to the database.
	*
	* @param taskId the primary key for the new user task
	* @return the new user task
	*/
	public static com.saigia.gaussian.model.UserTask create(long taskId) {
		return getPersistence().create(taskId);
	}

	/**
	* Removes the user task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskId the primary key of the user task
	* @return the user task that was removed
	* @throws com.saigia.gaussian.NoSuchUserTaskException if a user task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.saigia.gaussian.model.UserTask remove(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.saigia.gaussian.NoSuchUserTaskException {
		return getPersistence().remove(taskId);
	}

	public static com.saigia.gaussian.model.UserTask updateImpl(
		com.saigia.gaussian.model.UserTask userTask, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userTask, merge);
	}

	/**
	* Returns the user task with the primary key or throws a {@link com.saigia.gaussian.NoSuchUserTaskException} if it could not be found.
	*
	* @param taskId the primary key of the user task
	* @return the user task
	* @throws com.saigia.gaussian.NoSuchUserTaskException if a user task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.saigia.gaussian.model.UserTask findByPrimaryKey(
		long taskId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.saigia.gaussian.NoSuchUserTaskException {
		return getPersistence().findByPrimaryKey(taskId);
	}

	/**
	* Returns the user task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taskId the primary key of the user task
	* @return the user task, or <code>null</code> if a user task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.saigia.gaussian.model.UserTask fetchByPrimaryKey(
		long taskId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(taskId);
	}

	/**
	* Returns all the user tasks where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.saigia.gaussian.model.UserTask> findBybyUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyUser(userId);
	}

	/**
	* Returns a range of all the user tasks where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user tasks
	* @param end the upper bound of the range of user tasks (not inclusive)
	* @return the range of matching user tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.saigia.gaussian.model.UserTask> findBybyUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyUser(userId, start, end);
	}

	/**
	* Returns an ordered range of all the user tasks where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user tasks
	* @param end the upper bound of the range of user tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.saigia.gaussian.model.UserTask> findBybyUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyUser(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first user task in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user task
	* @throws com.saigia.gaussian.NoSuchUserTaskException if a matching user task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.saigia.gaussian.model.UserTask findBybyUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.saigia.gaussian.NoSuchUserTaskException {
		return getPersistence().findBybyUser_First(userId, orderByComparator);
	}

	/**
	* Returns the first user task in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user task, or <code>null</code> if a matching user task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.saigia.gaussian.model.UserTask fetchBybyUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyUser_First(userId, orderByComparator);
	}

	/**
	* Returns the last user task in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user task
	* @throws com.saigia.gaussian.NoSuchUserTaskException if a matching user task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.saigia.gaussian.model.UserTask findBybyUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.saigia.gaussian.NoSuchUserTaskException {
		return getPersistence().findBybyUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the last user task in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user task, or <code>null</code> if a matching user task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.saigia.gaussian.model.UserTask fetchBybyUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the user tasks before and after the current user task in the ordered set where userId = &#63;.
	*
	* @param taskId the primary key of the current user task
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user task
	* @throws com.saigia.gaussian.NoSuchUserTaskException if a user task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.saigia.gaussian.model.UserTask[] findBybyUser_PrevAndNext(
		long taskId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.saigia.gaussian.NoSuchUserTaskException {
		return getPersistence()
				   .findBybyUser_PrevAndNext(taskId, userId, orderByComparator);
	}

	/**
	* Returns all the user tasks.
	*
	* @return the user tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.saigia.gaussian.model.UserTask> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.saigia.gaussian.model.UserTask> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user tasks
	* @param end the upper bound of the range of user tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.saigia.gaussian.model.UserTask> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user tasks where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyUser(userId);
	}

	/**
	* Removes all the user tasks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user tasks where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyUser(userId);
	}

	/**
	* Returns the number of user tasks.
	*
	* @return the number of user tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserTaskPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserTaskPersistence)PortletBeanLocatorUtil.locate(com.saigia.gaussian.service.ClpSerializer.getServletContextName(),
					UserTaskPersistence.class.getName());

			ReferenceRegistry.registerReference(UserTaskUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(UserTaskPersistence persistence) {
	}

	private static UserTaskPersistence _persistence;
}