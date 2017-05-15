package com.ss.mp.common.utils;

import java.util.Calendar;
import java.util.Date;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.ss.mp.common.constant.Constants;
import com.ss.mp.common.model.PageRequestVO;

import lombok.Data;

@Data
public class MPUtils {
	
	public static PageRequest getPageRequest(PageRequestVO pageReq) {

		if (pageReq.getPageNum() < 0 || pageReq.getPageSize() < 0)
			return null;

		Sort sort = null;
		if (null != pageReq.getSortBy() && !"NONE".equalsIgnoreCase(pageReq.getSortBy())) {
			if (Constants.DESCENDING.equalsIgnoreCase(pageReq.getSortOrder())) {
				sort = new Sort(Sort.Direction.DESC, pageReq.getSortBy());
			} else {
				sort = new Sort(Sort.Direction.ASC, pageReq.getSortBy());
			}
		}

		return new PageRequest(pageReq.getPageNum(), pageReq.getPageSize(), sort);

	}

	public static Sort getSortRequest(PageRequestVO pageReq) {

		Sort sort = null;
		if (null != pageReq.getSortBy()) {
			if (Constants.DESCENDING.equalsIgnoreCase(pageReq.getSortOrder())) {
				sort = new Sort(Sort.Direction.DESC, pageReq.getSortBy());
			} else {
				sort = new Sort(Sort.Direction.ASC, pageReq.getSortBy());
			}
		}

		return sort;

	}

	public static PageRequest getPageRequest(int pageNum, int pageSize, String sortBy, String sortOrder) {

		Sort sort = null;

		if (Constants.ASCENDING.equalsIgnoreCase(sortOrder)) {
			sort = new Sort(Sort.Direction.ASC, sortBy);
		} else {
			sort = new Sort(Sort.Direction.DESC, sortBy);
		}

		return new PageRequest(pageNum, pageSize, sort);

	}

	public static Date[] getBeginAndEndOfDay(Date date) {
		Date[] dates = new Date[2];
		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);

		dates[0] = cal.getTime();

		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.HOUR_OF_DAY, 23);

		dates[1] = cal.getTime();

		return dates;
	}

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); // minus number would decrement the days
		return cal.getTime();
	}

}
