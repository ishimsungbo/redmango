package com.redmango.service.impl;

import com.redmango.mapper.SqlMapper;
import com.redmango.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName    : com.redmango.service.impl
 * fileName       : TestServiceImpl
 * author         : sungbo
 * date           : 2023-06-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-03        sungbo       최초 생성
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Resource(name="sqlMapper")
    SqlMapper sqlMapper;

    @Override
    public List<Map<String, Object>> selectClmHeaderList() {
        return sqlMapper.selectClmHeaderList();
    }

    @Override
    public List<Map<String, Object>> selectClmLineAmt(Map<String, Object> param) {
        return sqlMapper.selectClmLineAmt(param);
    }

    @Override
    public String selectMyProcedureCall(Map<String, Object> param) {

        sqlMapper.selectMyProcedureCall(param);
        log.info("프로시져 호출 결과 : " + param.get("OUT_AMT").toString());
        return param.toString();
    }

    @Override
    public String selectMyDeclare(Map<String, Object> param) {
        sqlMapper.selectMyDeclare(param);
        return param.toString();
    }

    @Override
    public String selectMyDeclare2(Map<String, Object> param) {
        sqlMapper.selectMyDeclare2(param);
        return param.toString();
    }

    @Override
    public String selectString(Map<String, Object> param) {
        return sqlMapper.selectString();
    }
}
