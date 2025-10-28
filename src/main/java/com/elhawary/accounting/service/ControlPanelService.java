package com.elhawary.accounting.service;

import com.elhawary.accounting.domain.ArchivedRequestResponseDTO;
import com.elhawary.accounting.domain.DashboardRequestFilterDTO;
import org.springframework.data.domain.Page;

/**
 * Service interface for control panel operations
 */
public interface ControlPanelService {

    /**
     * Get archived dashboard requests with pagination
     * @param requestFilter Filter criteria for requests
     * @return Paginated archived requests
     * @throws IllegalArgumentException if filter parameters are invalid
     */
    Page<ArchivedRequestResponseDTO> getArchivedDashboardRequests(DashboardRequestFilterDTO requestFilter);
}
