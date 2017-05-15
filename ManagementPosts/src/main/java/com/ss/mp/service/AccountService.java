package com.ss.mp.service;

import java.util.Optional;

import com.ss.mp.common.model.ListResponse;
import com.ss.mp.entity.Account;
import com.ss.mp.vo.request.AccountRequestVo;
import com.ss.mp.vo.response.AccountResponse;

public interface AccountService {
	
	Optional<Account> getAccountByLoginId(String loginId);
	
	ListResponse<AccountResponse> getUsers(int pageNum, int pageSize, String sortBy, String sortOrder, Boolean isShowInactive,
			String searchText);
	
	Integer addAccount(AccountRequestVo accountRequest);

}
