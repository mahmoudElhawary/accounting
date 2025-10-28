package com.elhawary.accounting.controller.admin;

import com.elhawary.accounting.domain.AppResponse;
import com.elhawary.accounting.domain.ArchivedRequestResponseDTO;
import com.elhawary.accounting.domain.DashboardRequestFilterDTO;
import com.elhawary.accounting.domain.ResponseCode;
import com.elhawary.accounting.service.ControlPanelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller for control panel operations
 */
@RestController
@RequestMapping("/api")
public class ControlPanelController {

    private static final Logger log = LoggerFactory.getLogger(ControlPanelController.class);

    @Autowired
    private ControlPanelService controlPanelService;

    /**
     * Get paginated control panel requests details
     *
     * BEFORE REFACTORING:
     * - Had try-catch blocks in controller (anti-pattern)
     * - Manual response building (verbose)
     * - Mixed concerns (exception handling + business logic)
     * - Repeated logging patterns
     *
     * AFTER REFACTORING:
     * - Thin controller - delegates to service
     * - Exceptions handled by GlobalExceptionHandler
     * - Clean, readable code
     * - Service layer handles validation
     * - Proper separation of concerns
     *
     * @param requestFilter Filter criteria for control panel requests
     * @return Paginated control panel requests
     */
    @PreAuthorize("hasAuthority('CONTROL_PANEL_PRIVILEGE')")
    @PostMapping("/control-panel/requests")
    public ResponseEntity<AppResponse<Page<ArchivedRequestResponseDTO>>> getControlPanelRequests(
            @Valid @RequestBody DashboardRequestFilterDTO requestFilter) {

        log.info("Fetching control panel requests - dateRange: {} to {}, page: {}, size: {}",
                requestFilter.getFrom(),
                requestFilter.getTo(),
                requestFilter.getPage(),
                requestFilter.getSize());

        // Service handles validation and throws appropriate exceptions
        // GlobalExceptionHandler catches and converts to proper responses
        Page<ArchivedRequestResponseDTO> archivedRequests =
                controlPanelService.getArchivedDashboardRequests(requestFilter);

        log.info("Successfully retrieved control panel requests - totalElements: {}, totalPages: {}, currentPage: {}",
                archivedRequests.getTotalElements(),
                archivedRequests.getTotalPages(),
                archivedRequests.getNumber());

        return AppResponse.<Page<ArchivedRequestResponseDTO>>builder()
                .status(ResponseCode.SUCCESS)
                .message("Control panel requests retrieved successfully")
                .data(archivedRequests)
                .buildEntity();
    }
}
