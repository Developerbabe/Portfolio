package tech.portfolo.portfolo.common.api.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * @apiNote
 * API 결과 호출에 사용할 VO 클래스
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

@Builder
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResultVo {
    private String chkYn;
    private Object data;
    private String error;
    private int httpStatus;
    private int count;
}
