package com.redmango.service;

import java.util.List;
import java.util.Map;

/**
 * packageName    : com.redmango.service.impl
 * fileName       : TestService
 * author         : sungbo
 * date           : 2023-06-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-03        sungbo       최초 생성
 */


public interface TestService {

    List<Map<String, Object>> selectClmHeaderList();

    List<Map<String, Object>> selectClmLineAmt(Map<String, Object> param);

    String selectMyProcedureCall(Map<String, Object> param);

    String selectString(Map<String, Object> param);

    String selectMyDeclare(Map<String, Object> param);

    String selectMyDeclare2(Map<String, Object> param);
}
