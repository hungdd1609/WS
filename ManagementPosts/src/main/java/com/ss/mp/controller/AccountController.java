package com.ss.mp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ss.mp.common.constant.Constants;
import com.ss.mp.common.exception.BadRequestException;
import com.ss.mp.common.model.CommonResponse;
import com.ss.mp.common.model.ListResponse;
import com.ss.mp.service.AccountService;
import com.ss.mp.vo.request.AccountRequestVo;
import com.ss.mp.vo.response.AccountResponse;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping("/api/admin/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public CommonResponse<ListResponse<AccountResponse>> getUsers(
			@RequestParam(value = "pageNum", required = false, defaultValue = Constants.PAGE_DEFAULT_START) int pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = Constants.PAGE_DEFAULT_LIMIT) int pageSize,
			@RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
			@RequestParam(value = "sortOrder", required = false, defaultValue = Constants.DESCENDING) String sortOrder,
			@RequestParam(value = "isShowInactive", required = false, defaultValue = "false") Boolean isShowInactive,
			@RequestParam(value = "searchText", required = false) String searchText
			) {
//		log.debug("Received request to list users");
		ListResponse<AccountResponse> results = accountService.getUsers(pageNum, pageSize, sortBy, 
				sortOrder, isShowInactive, searchText);
		CommonResponse<ListResponse<AccountResponse>> response = new CommonResponse<ListResponse<AccountResponse>>();
		response.successfulRespone(results);
		
		return response;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public CommonResponse<Integer> createrUsers(@RequestBody @Valid final AccountRequestVo accountRequest) {
//		log.info("Received request to create the {}", accountRequest);
		if (accountRequest.getRoleId() == null
				|| accountRequest.getRoleId() <= 0) {
			throw new BadRequestException("Role is null or invalid!");
		}
		Integer result = accountService.addAccount(accountRequest);
		CommonResponse<Integer> response = new CommonResponse<>();
		response.successfulRespone(result);
		return response;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json", consumes = "*/*")
	public CommonResponse<String> test() {
		CommonResponse<String> response = new CommonResponse<String>();
		response.successfulRespone("OK");
		return response;
	}

}
