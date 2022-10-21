package tech.portfolo.portfolo.common.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import tech.portfolo.portfolo.common.api.vo.ResultVo;

/**
 * @apiNote
 * Api 결과 호출에 따른 HttpStatus 컨트롤러 클래스
 *
 * @author 김기현
 * @since 2022.03.23
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  수정일       수정자                    수정내용
 * @ ---------   ---------   -------------------------------
 * @ 22022.05.23  김기현        최초 작성
 */

@Slf4j
public class BaseController {

    @Autowired protected MessageSourceAccessor messageSourceAccessor;

    public ResultVo wrapSuccesData(HttpStatus httpStatus, @Nullable Object voData, @Nullable int count){
        if(httpStatus == HttpStatus.OK){
            return ResultVo.builder().chkYn("Y").httpStatus(httpStatus.value()).data(voData).count(count).build();
        }
        return ResultVo.builder().chkYn("N").httpStatus(httpStatus.value()).data(voData).build();
    }

    public ResultVo wrapFailData(HttpStatus httpStatus, @Nullable String msg, @Nullable Object voData){
        return ResultVo.builder().chkYn("N").httpStatus(httpStatus.value()).error(msg).data(voData).build();
    }

    public ResultVo wrapFailData(HttpStatus httpStatus, @Nullable Object voData){
        return ResultVo.builder().chkYn("N").httpStatus(httpStatus.value()).data(voData).build();
    }

    public ResponseEntity<ResultVo> getSuccessResponseEntity(@Nullable Object voData){
        return ResponseEntity.status(HttpStatus.OK).body(wrapSuccesData(HttpStatus.OK,voData,0));
    }

    public ResponseEntity<ResultVo> getSuccessResponseEntity(@Nullable Object voData, @Nullable int count){
        return ResponseEntity.status(HttpStatus.OK).body(wrapSuccesData(HttpStatus.OK, voData, count));
    }

    public ResponseEntity<ResultVo> getFailResponseEntity(@Nullable Object voData){
        return ResponseEntity.status(HttpStatus.OK).body(wrapFailData(HttpStatus.OK, voData));
    }

    public ResponseEntity<ResultVo> getFailResponseEntity(@Nullable String msg, @Nullable Object voData){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(wrapFailData(HttpStatus.INTERNAL_SERVER_ERROR, msg, voData));
    }

    public ResponseEntity<ResultVo> getFailResponseEntity(@Nullable String msg){
        return getFailResponseEntity(msg,null);
    }
}
