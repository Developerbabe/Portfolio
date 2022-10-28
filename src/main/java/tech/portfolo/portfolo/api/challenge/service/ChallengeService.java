package tech.portfolo.portfolo.api.challenge.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.portfolo.portfolo.api.challenge.mapper.ChallengeMapper;
import tech.portfolo.portfolo.api.challenge.vo.ScenarioParamVo;

@Slf4j
@Service
@Transactional
public class ChallengeService {

    @Autowired
    ChallengeMapper challengeMapper;

    public Long insertChallengeScenario(ScenarioParamVo scenarioParamVo)throws Exception{
        return 1L;
    }
}
