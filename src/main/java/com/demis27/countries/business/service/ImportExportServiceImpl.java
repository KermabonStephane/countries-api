package com.demis27.countries.business.service;

import com.demis27.countries.business.repository.CountryRepository;
import com.demis27.countries.business.repository.RegionRepository;
import com.demis27.countries.business.repository.SubRegionRepository;
import com.demis27.countries.domain.model.Country;
import com.demis27.countries.domain.model.Region;
import com.demis27.countries.domain.model.SubRegion;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ImportExportServiceImpl implements ImportExportService {

    private final CountryRepository countryRepository;
    private final RegionRepository regionRepository;
    private final SubRegionRepository subRegionRepository;

    @Override
    public Mono<Void> importCsv(Mono<MultipartFile> fileMono) {
        return fileMono
                .flatMap(file -> Mono.fromCallable(() -> {
                                    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
                                        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                                                .setHeader()
                                                .setIgnoreHeaderCase(true)
                                                .setTrim(true)
                                                .setIgnoreEmptyLines(true)
                                                .build();
                                        CSVParser csvParser = CSVParser.parse(fileReader, csvFormat);

                                        ParsedCsvData parsedData = new ParsedCsvData();
                                        for (CSVRecord csvRecord : csvParser) {
                                            if (csvRecord.size() != 10) {
                                                continue;
                                            }
                                            String regionName = csvRecord.get("region");
                                            String subRegionName = csvRecord.get("sub-region");
                                            String regionCodeStr = csvRecord.get("region-code");
                                            String subRegionCodeStr = csvRecord.get("sub-region-code");

                                            if (regionName != null && !regionName.isEmpty()) {
                                                Region.RegionBuilder regionBuilder = Region.builder().name(regionName);
                                                try {
                                                    if (regionCodeStr != null && !regionCodeStr.isEmpty()) {
                                                        regionBuilder.code(Integer.parseInt(regionCodeStr));
                                                    }
                                                } catch (NumberFormatException e) {
                                                    // Ignore invalid region code
                                                }
                                                parsedData.regions.put(Integer.parseInt(regionCodeStr), regionBuilder.build());
                                            }

                                            if (subRegionName != null && !subRegionName.isEmpty()) {
                                                Region region = parsedData.regions.get(Integer.parseInt(regionCodeStr));
                                                SubRegion.SubRegionBuilder subRegionBuilder = SubRegion.builder().name(subRegionName).region(SubRegion.Region.builder().code(region.getCode()).name(region.getName()).build());
                                                try {
                                                    if (subRegionCodeStr != null && !subRegionCodeStr.isEmpty()) {
                                                        subRegionBuilder.code(Integer.parseInt(subRegionCodeStr));
                                                    }
                                                } catch (NumberFormatException e) {
                                                    // Ignore invalid sub-region code
                                                }
                                                parsedData.subRegions.put(Integer.parseInt(subRegionCodeStr), subRegionBuilder.build());
                                            }

                                            try {
                                                Region region = parsedData.regions.get(Integer.parseInt(csvRecord.get("region-code")));
                                                SubRegion subRegion = parsedData.subRegions.get(Integer.parseInt(csvRecord.get("sub-region-code")));
                                                Country country = Country.builder()
                                                        .name(csvRecord.get("name"))
                                                        .alpha2Code(csvRecord.get("alpha-2"))
                                                        .alpha3Code(csvRecord.get("alpha-3"))
                                                        .code(Integer.parseInt(csvRecord.get("country-code")))
                                                        .region(Country.Region.builder().code(region.getCode()).name(region.getName()).build())
                                                        .subregion(Country.SubRegion.builder().code(subRegion.getCode()).name(subRegion.getName()).build())
                                                        .build();
                                                parsedData.countries.add(country);
                                            } catch (NumberFormatException e) {
                                                // Ignore invalid country code
                                            }
                                        }
                                        return parsedData;
                                    } catch (IOException e) {
                                        throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
                                    }
                                })
                                .subscribeOn(Schedulers.boundedElastic())
                )
                .flatMap(parsedData ->
                        Mono.when(
                                countryRepository.saveAll(parsedData.countries).then(),
                                regionRepository.saveAll(parsedData.regions.values()).then(),
                                subRegionRepository.saveAll(parsedData.subRegions.values()).then()
                        )
                ).then();
    }

    private static class ParsedCsvData {
        final List<Country> countries = new ArrayList<>();
        final Map<Integer, Region> regions = new HashMap<>();
        final Map<Integer, SubRegion> subRegions = new HashMap<>();
    }
}
