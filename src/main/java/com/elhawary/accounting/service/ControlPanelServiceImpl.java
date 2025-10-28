package com.elhawary.accounting.service;

import com.elhawary.accounting.domain.ArchivedRequestResponseDTO;
import com.elhawary.accounting.domain.DashboardRequestFilterDTO;
import com.elhawary.accounting.exception.InvalidRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of ControlPanelService
 */
@Service
@Transactional
public class ControlPanelServiceImpl implements ControlPanelService {

    private static final Logger log = LoggerFactory.getLogger(ControlPanelServiceImpl.class);

    @Override
    public Page<ArchivedRequestResponseDTO> getArchivedDashboardRequests(DashboardRequestFilterDTO requestFilter) {
        log.debug("Fetching archived requests with filter: {}", requestFilter);

        // Validate filter parameters
        validateRequestFilter(requestFilter);

        // Create pageable object
        Sort.Direction direction = Sort.Direction.fromString(requestFilter.getSortDirection());
        Pageable pageable = PageRequest.of(
                requestFilter.getPage(),
                requestFilter.getSize(),
                Sort.by(direction, requestFilter.getSortBy())
        );

        // TODO: Implement actual database query
        // For now, returning empty page as example
        // Replace this with actual repository call:
        // return archivedRequestRepository.findByDateRangePaginated(
        //     requestFilter.getFrom(),
        //     requestFilter.getTo(),
        //     requestFilter.getStatus(),
        //     requestFilter.getRequestType(),
        //     pageable
        // );

        List<ArchivedRequestResponseDTO> content = new ArrayList<>();
        return new PageImpl<>(content, pageable, 0);
    }

    /**
     * Validate request filter parameters
     */
    private void validateRequestFilter(DashboardRequestFilterDTO filter) {
        if (filter == null) {
            throw new InvalidRequestException("Request filter cannot be null");
        }

        if (filter.getFrom() == null) {
            throw new InvalidRequestException("From date is required");
        }

        if (filter.getTo() == null) {
            throw new InvalidRequestException("To date is required");
        }

        if (filter.getFrom().after(filter.getTo())) {
            throw new InvalidRequestException("From date must be before or equal to To date");
        }

        if (filter.getSize() <= 0 || filter.getSize() > 100) {
            throw new InvalidRequestException("Page size must be between 1 and 100");
        }

        if (filter.getPage() < 0) {
            throw new InvalidRequestException("Page number cannot be negative");
        }
    }
}
