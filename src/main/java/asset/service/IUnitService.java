package asset.service;

import asset.pojo.Unit;

/**
 * Author:QuincySu
 * Date:Created in 2018/3/22
 */
public interface IUnitService {
    //查询单位号
    public Unit getUnitId(Unit unit);
    //查询单位名
    public Unit getUnitName(Unit unit);
}