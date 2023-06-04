package com.redmango.service.impl;

import com.redmango.mapper.SqlMapper;
import com.redmango.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class TestServiceImpl implements TestService {

    @Resource(name="sqlMapper")
    SqlMapper sqlMapper;

    @Override
    public List<Map<String, Object>> selectClmHeaderList() {
        return sqlMapper.selectClmHeaderList();
    }
}
