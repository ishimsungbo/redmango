package com.redmango.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * packageName    : com.redmango.mapper
 * fileName       : SqlMapper
 * author         : sungbo
 * date           : 2023-06-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-03        sungbo       최초 생성
 */
@Mapper
public interface SqlMapper {
    List<Map<String, Object>> selectClmHeaderList();

    List<Map<String, Object>> selectClmLineAmt(Map<String, Object> param);

    /***
     * @param param
     * 프로시져는 맵으로 던지면 던진 객체로 받는다.
     */
    void selectMyProcedureCall(Map<String, Object> param);

    /**
     * DECLARE 문을 이용한 프로그래밍
     * @return
     */

    void selectMyDeclare(Map<String, Object> param);


    void selectMyDeclare2(Map<String, Object> param);

    String selectString();


}
