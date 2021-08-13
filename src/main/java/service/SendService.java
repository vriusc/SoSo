package service;

import entity.MobileCard;

/**
 * @author aero
 */
public interface SendService{
    /**
     * 短信接口
     * @param count
     * @param card
     * @return
     * @throws Exception
     */
    public int send(int count, MobileCard card) throws Exception;
}
