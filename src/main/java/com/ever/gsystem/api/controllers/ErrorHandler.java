package com.ever.gsystem.api.controllers;

import com.ever.gsystem.api.controllers.msg.responses.ErrorResponse;
import com.ever.gsystem.api.domain.entities.MstBanner;
import com.ever.gsystem.constants.ErrorCdMsg;
import com.ever.gsystem.constants.properties.SpringbootSetting;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * ERROR HANDLER.
 * <p>
 * Execute when the error occurs in the API.
 * </p>
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@RequiredArgsConstructor    // Lombok automatically generates a constructor with arguments to set values in required fields (final fields) (to inject final fields without @Autowired)
@ToString                   // Automatically generate toString with Lombok
@RestControllerAdvice       // Perform cross-cutting processing across multiple controllers (to use as an exception handler class for Rest API)
@ Slf4j                     // Automatically generate code that defines a logger in Lombok. Classes with this annotation can access the logger with a variable called "log"
public class ErrorHandler extends ResponseEntityExceptionHandler {
    /** Spring Boot独自設定. */
    private SpringbootSetting springbootSetting;

    /**
     * 店舗マスタ取得エラーリクエストエラーレスポンス作成.
     *
     * @param  csvRow 登録に失敗したCSVファイルの行数
     * @param  shopNo 店舗番号
     * @return        エラーレスポンス
     */
    @SuppressWarnings("serial")
    public static ErrorResponse createFileUpdGetShopErrorResponse(final Long csvRow,
                                                                  final String shopNo) {
        // エラーレスポンスメッセージを作成
        return ErrorResponse.builder()
                            .errCd(ErrorCdMsg.FILE_UPD_GET_SHOP_ERR_CD)
                            .errMsg(ErrorCdMsg.FILE_UPD_GET_SHOP_ERR_MSG)
                            .errMap(new LinkedHashMap<String, List<String>>() {
                                {
                                    this.put(MstBanner.Fields.bannerId,
                                             Collections.singletonList(String.valueOf(csvRow)
                                                                       + ErrorCdMsg.CSV_LINE_NAME
                                                                       + "店舗番号「"
                                                                       + shopNo
                                                                       + "」が存在しませんでした。店舗マスタのCSVファイルを先に登録してください。"));
                                }
                            }).build();
    }

    /**
     * 検証失敗例外作成.
     *
     * @param  varidation            検証情報
     * @param  clazz                 呼び出し元のクラス
     * @param  parameterTypes        呼び出し元のメソッドパラメータをクラスで渡す（可変項目）
     * @return                       検証失敗例外
     * @throws NoSuchMethodException 検証エラー時のException生成の書き方に問題がある（指定したメソッドが見つからなかった）
     */
    public static MethodArgumentNotValidException createValidException(final BindingResult varidation,
                                                                       final Class<?> clazz,
                                                                       final Class<?>... parameterTypes) throws NoSuchMethodException {
        final MethodParameter parameter = new MethodParameter(clazz.getDeclaredMethod(Thread.currentThread()
                        .getStackTrace()[2].getMethodName(),
                parameterTypes),
                0);
        return new MethodArgumentNotValidException(parameter, varidation);
    }
    // =======================================================================================================================
}
