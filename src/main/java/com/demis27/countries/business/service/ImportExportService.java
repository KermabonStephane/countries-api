package com.demis27.countries.business.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImportExportService {
    void importCsv(MultipartFile file);
}
