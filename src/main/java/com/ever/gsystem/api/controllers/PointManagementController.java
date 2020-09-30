package com.ever.gsystem.api.controllers;

import com.ever.gsystem.api.controllers.msg.requests.PointManagementFindRequest;
import com.ever.gsystem.api.controllers.msg.requests.PointManagementMultiRequest;
import com.ever.gsystem.api.controllers.msg.requests.PointManagementSingleRequest;
import com.ever.gsystem.api.controllers.msg.responses.ErrorResponse;
import com.ever.gsystem.api.controllers.msg.responses.PointManagementFindResponse;
import com.ever.gsystem.api.controllers.msg.responses.PointManagementSingleResponse;
import com.ever.gsystem.api.domain.services.PointManagementService;
import com.ever.gsystem.constants.api.ApiDocMsg;
import com.ever.gsystem.constants.api.EndpointUri;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * 點數管理Master畫面API.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@RequiredArgsConstructor                            // Lombok automatically generates a constructor with arguments to set values in required fields (final fields) (to inject final fields without @Autowired)
@ToString                                           // Automatically generate toString with Lombok
@RestController                                     // Define this class as a REST controller (controller for WebAPI that returns JSON, Xml, etc.)
@RequestMapping (EndpointUri.TABLE_POINT_MANAGEMENT_API_ROOT) // Map the URL of the request
@Api (description = ApiDocMsg.API_POINT_MANAGEMENT_ROOT_MSG)  // For Swagger API documentation
@ Slf4j                                             // Automatically generate code that defines a logger in Lombok. Classes with this annotation can access the logger with a variable called "log"
public class PointManagementController {
    /** 點數管理Master畫面SERVICE. */
    final private PointManagementService service;

    /** GET REQUEST有無驗證 */
    //@Value(ApplicationValue.VALIDATOR_SWITCH)
    final private boolean GET_VALIDATOR = false;

    /**
     * 檢索API.
     *
     * @param  req                             點數管理Master畫面REQUEST
     * @param  validation                      驗證結果
     * @return                                 點數管理Master畫面RESPONSE
     * @throws MethodArgumentNotValidException CHECK ERROR
     * @throws NoSuchMethodException           Exception generation at the time of validation error (specified method could not be found)
     */
    @GetMapping
    @ApiOperation(value = ApiDocMsg.GET_TITLE_MSG, notes = ApiDocMsg.POINT_MANAGEMENT_NAME +
            ApiDocMsg.GET_NOTES_CMN_TABLE_MSG) // For Swagger API documentation
    @ApiResponses({@ApiResponse(code = 400, message = ApiDocMsg.GET_RES_400_MSG, response = ErrorResponse.class)}) // SwaggerのAPIドキュメント用
    public ResponseEntity<PointManagementFindResponse> getPointManagement(@Validated final PointManagementFindRequest req,
                                                    final BindingResult validation) throws MethodArgumentNotValidException, NoSuchMethodException {
        log.info("→Request：{}", StringUtils.replace(Objects.toString(req, "null"),
                "[\r\n]", ""));
        log.trace("Check Flag：{}、Check Error：{}", Boolean.valueOf(this.GET_VALIDATOR),
                Boolean.valueOf(validation.hasErrors()));

        // Validation of error handling
        if (validation.hasErrors()) {
            if (this.GET_VALIDATOR) {
                //
                // Have to put the class of the argument of this method of the third argument! !! (Easy to forget when changing method arguments)
                throw ErrorHandler.createValidException(validation,
                        this.getClass(),
                        PointManagementFindRequest.class,
                        BindingResult.class);
            }
            log.debug("點數管理Master畫面的Request Message的檢證失敗、因GET Request Validation無效，將照進行原來之檢索。");
        }

        final ResponseEntity<PointManagementFindResponse> res = new ResponseEntity<>(this.service.find(req),
                HttpStatus.OK);
        log.info("←Response：{}", res);
        return res;
    }

    /**
     * 新增API.
     *
     * @param  req 點數管理Master畫面REQUEST
     * @return     點數管理Master畫面RESPONSE
     */
    @PostMapping
    @ApiOperation(value = ApiDocMsg.POST_TITLE_MSG, notes = ApiDocMsg.POINT_MANAGEMENT_NAME +
            ApiDocMsg.POST_NOTES_CMN_MSG) // For Swagger API documentation
    @ApiResponses({@ApiResponse(code = 200, message = ApiDocMsg.POST_RES_200_MSG, response = Object.class),
            @ApiResponse(code = 201, message = ApiDocMsg.POST_RES_201_MSG, response = PointManagementSingleResponse.class),
            @ApiResponse(code = 400, message = ApiDocMsg.POST_RES_400_MSG, response = ErrorResponse.class)}) // For Swagger API documentation
    public ResponseEntity<PointManagementSingleResponse> postPointManagement(@Validated @RequestBody final PointManagementSingleRequest req) {
        log.info("→Request：{}", StringUtils.replace(Objects.toString(req, "null"),
                "[\r\n]", ""));
        final ResponseEntity<PointManagementSingleResponse> res = new ResponseEntity<>(this.service.save(req),
                HttpStatus.CREATED);
        log.info("←Response：{}", res);
        return res;
    }

    /**
     * 更新API.
     *
     * @param  req 點數管理Master畫面REQUEST
     * @return     點數管理Master畫面RESPONSE
     */
    @PutMapping
    @ApiOperation(value = ApiDocMsg.PUT_TITLE_MSG, notes = ApiDocMsg.POINT_MANAGEMENT_NAME +
            ApiDocMsg.PUT_NOTES_CMN_MSG) // For Swagger API documentation
    @ApiResponses({@ApiResponse(code = 200, message = ApiDocMsg.PUT_RES_200_MSG, response = Object.class),
            @ApiResponse(code = 201, message = ApiDocMsg.PUT_RES_201_MSG, response = PointManagementSingleResponse.class),
            @ApiResponse(code = 400, message = ApiDocMsg.PUT_RES_400_MSG, response = ErrorResponse.class)}) // For Swagger API documentation
    public ResponseEntity<PointManagementSingleResponse> putPointManagement(@Validated @RequestBody final PointManagementSingleRequest req) {
        log.info("→Request：{}", StringUtils.replace(Objects.toString(req, "null"),
                "[\r\n]", ""));
        final ResponseEntity<PointManagementSingleResponse> res = new ResponseEntity<>(this.service.save(req),
                HttpStatus.CREATED);
        log.info("←Response：{}", res);
        return res;
    }

    /**
     * 刪除API.
     *
     * @param req 點數管理Master畫面REQUEST
     */
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = ApiDocMsg.DEL_TITLE_MSG, notes = ApiDocMsg.POINT_MANAGEMENT_NAME +
            ApiDocMsg.DEL_NOTES_CMN_MSG) // For Swagger API documentation
    @ApiResponses({@ApiResponse(code = 200, message = ApiDocMsg.DEL_RES_200_MSG, response = Object.class),
            @ApiResponse(code = 204, message = ApiDocMsg.DEL_RES_204_MSG, response = Object.class),
            @ApiResponse(code = 400, message = ApiDocMsg.DEL_RES_400_MSG, response = ErrorResponse.class)}) // For Swagger API documentation
    public void delPointManagement(@Validated @RequestBody final PointManagementMultiRequest req) {
        log.info("→Request：{}", StringUtils.replace(Objects.toString(req, "null"),
                "[\r\n]", ""));
        this.service.delete(req);
        log.info("←Response：null");
    }
}
