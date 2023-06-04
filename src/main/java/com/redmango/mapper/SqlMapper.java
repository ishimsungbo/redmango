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

}
