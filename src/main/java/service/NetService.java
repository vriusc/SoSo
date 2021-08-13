package service;

import entity.MobileCard;

/**
 * @author aero
 */
public interface NetService {
    /**
     * 上网接口
     * @param flow
     * @param card
     * @return
     * @throws Exception
     */
    public int net(int flow, MobileCard card) throws Exception;
}
