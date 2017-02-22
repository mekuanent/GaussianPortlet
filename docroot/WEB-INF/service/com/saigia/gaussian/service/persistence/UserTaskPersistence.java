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

import com.liferay.portal.service.persistence.BasePersistence;

import com.saigia.gaussian.model.UserTask;

/**
 * The persistence interface for the user task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mekuanent
 * @see UserTaskPersistenceImpl
 * @see UserTaskUtil
 * @generated
 */
public interface UserTaskPersistence extends BasePersistence<UserTask> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserTaskUtil} to access the user task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user task in the entity cache if it is enabled.
	*
	* @param userTask the user task
	*/
	public void cacheResult(com.saigia.gaussian.model.UserTask userTask);

	/**
	* Caches the user tasks in the entity cache if it is enabled.
	*
	* @param userTasks the user tasks
	*/
	public void cacheResult(
		java.util.List<com.saigia.gaussian.model.UserTask> userTasks);

	/**
	* Creates a new user task with the primary key. Does not add the user task to the database.
	*
	* @param taskId the primary key for the new user task
	* @return the new user task
	*/
	public com.saigia.gaussian.model.UserTask create(long taskId);

	/**
	* Removes the user task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskId the primary key of the user task
	* @return the user task that was removed
	* @throws com.saigia.gaussian.NoSuchUserTaskException if a user task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.saigia.gaussian.model.UserTask remove(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.saigia.gaussian.NoSuchUserTaskException;

	public com.saigia.gaussian.model.UserTask updateImpl(
		com.saigia.gaussian.model.UserTask userTask, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user task with the primary key or throws a {@link com.saigia.gaussian.NoSuchUserTaskException} if it could not be found.
	*
	* @param taskId the primary key of the user task
	* @return the user task
	* @throws com.saigia.gaussian.NoSuchUserTaskException if a user task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.saigia.gaussian.model.UserTask findByPrimaryKey(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.saigia.gaussian.NoSuchUserTaskException;

	/**
	* Returns the user task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taskId the primary key of the user task
	* @return the user task, or <code>null</code> if a user task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.saigia.gaussian.model.UserTask fetchByPrimaryKey(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user tasks where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.saigia.gaussian.model.UserTask> findBybyUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.saigia.gaussian.model.UserTask> findBybyUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.saigia.gaussian.model.UserTask> findBybyUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user task in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user task
	* @throws com.saigia.gaussian.NoSuchUserTaskException if a matching user task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.saigia.gaussian.model.UserTask findBybyUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.saigia.gaussian.NoSuchUserTaskException;

	/**
	* Returns the first user task in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user task, or <code>null</code> if a matching user task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.saigia.gaussian.model.UserTask fetchBybyUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user task in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user task
	* @throws com.saigia.gaussian.NoSuchUserTaskException if a matching user task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.saigia.gaussian.model.UserTask findBybyUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.saigia.gaussian.NoSuchUserTaskException;

	/**
	* Returns the last user task in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user task, or <code>null</code> if a matching user task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.saigia.gaussian.model.UserTask fetchBybyUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.saigia.gaussian.model.UserTask[] findBybyUser_PrevAndNext(
		long taskId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.saigia.gaussian.NoSuchUserTaskException;

	/**
	* Returns all the user tasks.
	*
	* @return the user tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.saigia.gaussian.model.UserTask> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.saigia.gaussian.model.UserTask> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.saigia.gaussian.model.UserTask> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user tasks where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybyUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user tasks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user tasks where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user tasks.
	*
	* @return the number of user tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}