package com.bp.service;

import java.util.List;

import com.bp.entity.Activity;
import com.bp.entity.RedEnvelope;
import com.bp.entityCondition.RedEnvelopeCondition;

/**
 * 
 * @author current_bp
 * @createTime 20160831
 *
 */
public interface RedEnvelopeService {
	
	/**
	 * 创建一个红包产品
	 * @param redEnvelope
	 * @return
	 */
	public boolean createEnvelope(RedEnvelope redEnvelope);
	
	
	/**
	 * 获取该活动下的所有红包产品
	 * @param activity
	 * @return
	 */
	public List<RedEnvelope> getRedEnvelopeList(Activity activity);
	
	
	/**
	 * 根据条件获取红包产品
	 * @param redEnvelopeCondition : activityId,status
	 * @return
	 */
	public List<RedEnvelope> getRedEnvelopeListByCondition(RedEnvelopeCondition redEnvelopeCondition);

}
