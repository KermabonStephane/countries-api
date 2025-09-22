package com.demis27.countries.business.service;

import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

public interface ImportExportService {
    Mono<Void> importCsv(Mono<MultipartFile> file);
}
