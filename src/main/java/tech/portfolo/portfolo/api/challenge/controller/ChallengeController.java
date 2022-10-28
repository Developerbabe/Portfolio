package tech.portfolo.portfolo.api.challenge.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.portfolo.portfolo.api.challenge.service.ChallengeService;
import tech.portfolo.portfolo.api.challenge.vo.ScenarioParamVo;
import tech.portfolo.portfolo.common.api.controller.BaseController;
import tech.portfolo.portfolo.common.api.vo.ResultVo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 김기현
 * @since 2022.10.28
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  수정일       수정자                    수정내용
 * @ ---------   ---------   -------------------------------
 * @ 22022.10.28  김기현        최초 작성
 */

@Slf4j
@RestController
@RequestMapping("/api/challenge")
public class ChallengeController extends BaseController {

    @Autowired
    ChallengeService challengeService;

    @ApiOperation(value = "챌린지 시나리오 등록 API",notes = "@RequestBody ScenarioParamVo")
    @ApiResponses({@ApiResponse(code = 200, message = "서버 정상작동")
            ,@ApiResponse(code = 500, message = "서버 오류")})
    @PostMapping("/insert/scenario")
    public ResponseEntity<ResultVo> insertChallengeScenario(@RequestBody ScenarioParamVo scenarioParamVo)throws Exception{

        if ( scenarioParamVo == null ) return getFailResponseEntity("ERROR : ScenarioParamVo has null values");

        Long msn = challengeService.insertChallengeScenario(scenarioParamVo);

        Map<String,Object> result = new HashMap<>();
        result.put("userSn",scenarioParamVo.getUserSn());
        result.put("msnNo",msn);
        result.put("snroNo",scenarioParamVo.getSnroNo());

        return getSuccessResponseEntity(result);
    }
}
