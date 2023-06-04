package com.redmango;

import com.redmango.mapper.SqlMapper;
import com.redmango.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
public class Controller {

    @Autowired
    private TestService testService;

    @RequestMapping("/")
    public String index(){
        return "hi";
    }

    @RequestMapping("/test")
    public List<Map<String, Object>> test(){


        return testService.selectClmHeaderList();
    }

    //스트리밍 연산 한번
    @RequestMapping("/streamcase01")
    public List<String> streamcase01(){
        long beforeTime = System.currentTimeMillis();
        List<String> strings = new ArrayList<>();
        for(Long i =0L; i < 100000 ;i++){
            String str = "ABCDEFGHIJ//ABCDEFGHIJ//ABCDEFGHIJ//ABCDEFGHIJ//ABCDEFGHIJ//ABCDEFGHIJ//ABCDEFGHIJ//ABCDEFGHIJ//ABCDEFGHIJ"+i;
            strings.add(str);
        }
        List<String> list = strings.stream().map(s-> {
            s = s.toString() + "asd";
            return s;
        }).collect(Collectors.toList());

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);

        return list;
    }

    //스트리밍 연산 두번
    @RequestMapping("/streamcase02")
    public List<String> streamcase02(){
        long beforeTime = System.currentTimeMillis();
        List<String> strings = new ArrayList<>();
        for(Long i =0L; i < 100000 ;i++){
            String str = "ABCDEFGHIJ//ABCDEFGHIJ//ABCDEFGHIJ//ABCDEFGHIJ//ABCDEFGHIJ//ABCDEFGHIJ//ABCDEFGHIJ//ABCDEFGHIJ//ABCDEFGHIJ"+i;
            strings.add(str);
        }


        List<String> list = strings.stream().map(s-> {
            s = s + "asd";
            return s;
        }).collect(Collectors.toList());

        List<String> listi01 = list.stream().map(s->{
              s =  s + "a";
                return s;}
                ).collect(Collectors.toList());

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
        return list;
    }

}
