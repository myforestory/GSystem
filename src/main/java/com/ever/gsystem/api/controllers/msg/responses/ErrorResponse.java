package com.ever.gsystem.api.controllers.msg.responses;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Value;

/**
 * ERROR RESPONSE MESSAGE.
 * <p>
 * 此處設定的ErrorCode,ErrorMessage被以下的Class所定義。<br>
 * {@link com.ever.gsystem.constants.ErrorCdMsg →ErrorCode,ErrorMessage之Class}<br>
 * </p>
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@Value                      // Lombok automatically generates a constructor with arguments to set getter / equals / hashCode / toString for all fields and values for all fields
@Builder (toBuilder = true) // Automatically generate builder pattern with Lombok
@ApiModel(description = "エラーレスポンスメッセージ") //For Swagger API documentation
public class ErrorResponse implements Serializable {
    /** Serial version UID (change value if this class changes). */
    private static final long serialVersionUID = 8710325264609833281L;

    /** ErrorCode. */
    @ApiModelProperty(value = "ErrorCode", position = 1)
    private final String errCd;

    /** ErrorMessage. */
    @ApiModelProperty(value = "ErrorMessage", position = 2)
    private final String errMsg;

    /**
     * ErrorMap.<br>
     * <p>
     * Key：Error Name<br>
     * Value：Error Content。<br>
     * </p>
     * ex）
     * <ol>
     * <li>Key = mailAddress</li>
     * <li>Value[0] = 請輸入5到100個文字。輸入值：123</li>
     * <li>Value[1] = 無效的信箱格式。入力値：123</li>
     * </ol>
     */
    @ApiModelProperty(value = "ErrorMap", position = 3)
    private Map<String, List<String>> errMap;
}
