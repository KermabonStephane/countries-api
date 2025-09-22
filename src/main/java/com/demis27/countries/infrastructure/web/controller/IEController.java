package com.demis27.countries.infrastructure.web.controller;

import com.demis27.countries.business.service.ImportExportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/import-export")
@RequiredArgsConstructor
public class IEController {

    private final ImportExportService importExportService;

    @PostMapping("/csv")
    public Mono<ResponseEntity<Void>> importCsv(@RequestParam("file") MultipartFile file) {
        return importExportService.importCsv(Mono.just(file))
                .then(Mono.just(ResponseEntity.ok().<Void>build()));
    }
}
