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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ImportExportServiceImpl implements ImportExportService {

    private final CountryRepository countryRepository;
    private final RegionRepository regionRepository;
    private final SubRegionRepository subRegionRepository;

    @Override
    public void importCsv(MultipartFile file) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setIgnoreHeaderCase(true)
                    .setTrim(true)
                    .setIgnoreEmptyLines(true)
                    .build();
            CSVParser csvParser = CSVParser.parse(fileReader, csvFormat);

            List<Country> countries = new ArrayList<>();
            Set<Region> regions = new HashSet<>();
            Set<SubRegion> subRegions = new HashSet<>();

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
                    regions.add(regionBuilder.build());
                }

                if (subRegionName != null && !subRegionName.isEmpty()) {
                    SubRegion.SubRegionBuilder subRegionBuilder = SubRegion.builder().name(subRegionName).region(regionName);
                    try {
                        if (subRegionCodeStr != null && !subRegionCodeStr.isEmpty()) {
                            subRegionBuilder.code(Integer.parseInt(subRegionCodeStr));
                        }
                    } catch (NumberFormatException e) {
                        // Ignore invalid sub-region code
                    }
                    subRegions.add(subRegionBuilder.build());
                }

                try {
                    Country country = Country.builder()
                            .name(csvRecord.get("name"))
                            .alpha2Code(csvRecord.get("alpha-2"))
                            .alpha3Code(csvRecord.get("alpha-3"))
                            .code(Integer.parseInt(csvRecord.get("country-code")))
                            .region(regionName)
                            .subregion(subRegionName)
                            .build();
                    countries.add(country);
                } catch (NumberFormatException e) {
                    // Ignore invalid country code
                }
            }
            regionRepository.saveAll(regions).subscribe();
            subRegionRepository.saveAll(subRegions).subscribe();
            countryRepository.saveAll(countries).subscribe();
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
