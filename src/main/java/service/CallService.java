package service;

import entity.MobileCard;

/**
 * @author aero
 */
public interface CallService {
    /**
     * 通话接口
     * @param minCount
     * @param card
     * @return
     * @throws Exception
     */
    public int call(int minCount, MobileCard card) throws Exception;
}
