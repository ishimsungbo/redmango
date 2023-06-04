package com.redmango.controller;

import com.redmango.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * packageName    : com.redmango
 * fileName       : Controller
 * author         : sungbo
 * date           : 2023-06-03
 * description    : 프로시져와 자바를 쪼개서 실행했을 때의 속도 차이를 확인해보고 싶다.
 *                  스트림...두개를 돌릴때도...
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-03        sungbo       최초 생성
 */
@RestController
@Slf4j
public class ClmController {

    @Autowired
    private TestService testService;


    @RequestMapping("/declare02")
    public String declareExample02(){

        Map<String, Object> map = new HashMap<>();

        testService.selectMyDeclare2(map);

        return map.toString();
    }
    @RequestMapping("/declare")
    public String declareExample(){
        Map<String, Object> map = new HashMap<>();

        map.put("IN_PARAM_VALUE","inVariable");
        map.put("OUT_BALANCE_AMT","0");
        map.put("OUT_SUMMARY_AMT","0");

        testService.selectMyDeclare(map);

        return map.toString();
    }

    @RequestMapping("/procedureCall")
    public String procedureCall(){
        long beforeTime = System.currentTimeMillis();

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산

        Map<String, Object> map = new HashMap<>();
        map.put("INPUT_PARAM","inVariable");
        map.put("OUT_AMT","outVariable");

        String result = testService.selectMyProcedureCall(map);
        log.info("수행 결과 ===>" + result.toString());

        return "성공 시간 차이 : " + secDiffTime;
    }

    @RequestMapping("/case01")
    public String case01(){
        List<Map<String, Object>>  headerList = testService.selectClmHeaderList()
                .stream()
                .map(map ->{
                    Map<String, Object> param = new HashMap<>();
                    param.put("CLM_ID",map.get("CLM_ID"));
                    List<Map<String, Object>> linelist = testService.selectClmLineAmt(param);
                    if(linelist.size() > 0){
                        log.info(" 라인 정보가 있음 ===========================================");
                        map.put("NEW_AMT",map.get("NEW_AMT"));
                    }else{
                        log.info(" 라인 정보가 없음 xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    }
                    return map;
                })
                .collect(Collectors.toList());
        return "성공";
    }

    @RequestMapping("/case02")
    public String case02(){

        //List<Map<String, Object>>  headerList = testService.selectClmHeaderList();

        long beforeTime = System.currentTimeMillis();

        List<Map<String, Object>> list = testService.selectClmHeaderList().stream()
                .map(map ->{
                    log.info(" 로그 시작");
                    Map<String, Object> param = new HashMap<>();
                    param.put("CLM_ID",map.get("CLM_ID"));

                    List<Map<String, Object>> linelist = testService.selectClmLineAmt(param);

                    if(linelist.size() > 0){
                        log.info(" 라인 정보가 있음 ===========================================");
                        map.put("NEW_AMT",map.get("NEW_AMT"));
                    }else{
                        log.info(" 라인 정보가 없음 xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    }
                    log.info("헤더로그....." + map.toString());
                    return map;
                })
                .collect(Collectors.toList());

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        //System.out.println("시간차이(m) : "+secDiffTime);

        return "성공 시간 차이 : " + secDiffTime;
    }

    @RequestMapping("/case03")
    public String case03(){
        long beforeTime = System.currentTimeMillis();

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        //System.out.println("시간차이(m) : "+secDiffTime);
        return "성공 시간 차이 : " + secDiffTime;
    }

    @RequestMapping("/getString")
    public String selectString(){
        Map<String, Object> param = new HashMap<>();
        return testService.selectString(param);
    }
}
