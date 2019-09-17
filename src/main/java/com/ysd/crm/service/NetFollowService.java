package com.ysd.crm.service;

import com.ysd.crm.entity.NetFollow;
import com.ysd.crm.entity.Pagination;

public interface NetFollowService {
	/**
	 * ��ҳ��ѯ���ټ�¼
	 * @param pagin
	 * @return
	 */
	Pagination<NetFollow> selectNetFollow(Pagination<NetFollow> pagin);
	
	/**
	 * ��ѯ���ټ�¼����
	 * @param pagin
	 * @return
	 */
	Integer selectAllNetFollowCount(Pagination<NetFollow> pagin);
	
	/**
	 * ��Ӹ��ټ�¼
	 * @param NetFollow
	 * @return
	 */
	Integer insertNetFollow(NetFollow netfollow);
}
