package com.demis27.countries.business.service;

import com.demis27.countries.business.repository.CountryRepository;
import com.demis27.countries.business.repository.RegionRepository;
import com.demis27.countries.business.repository.SubRegionRepository;
import com.demis27.countries.domain.model.Country;
import com.demis27.countries.domain.model.Region;
import com.demis27.countries.domain.model.SubRegion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImportExportServiceImplTest {

    @Mock
    private CountryRepository countryRepository;

    @Mock
    private RegionRepository regionRepository;

    @Mock
    private SubRegionRepository subRegionRepository;

    @InjectMocks
    private ImportExportServiceImpl importExportService;

    @Captor
    private ArgumentCaptor<List<Country>> countriesCaptor;

    @Captor
    private ArgumentCaptor<Set<Region>> regionsCaptor;

    @Captor
    private ArgumentCaptor<Set<SubRegion>> subRegionsCaptor;

    @Test
    void testImportCsv() throws IOException {
        // Given
        ClassPathResource resource = new ClassPathResource("countries.csv");
        MockMultipartFile file = new MockMultipartFile("file", resource.getFilename(), "text/csv", resource.getInputStream());
        Mono<MultipartFile> fileMono = Mono.just(file);

        when(countryRepository.saveAll(any(List.class))).thenReturn(Flux.empty());
        when(regionRepository.saveAll(any(Set.class))).thenReturn(Flux.empty());
        when(subRegionRepository.saveAll(any(Set.class))).thenReturn(Flux.empty());

        // When
        Mono<Void> resultMono = importExportService.importCsv(fileMono);

        // Then
        StepVerifier.create(resultMono)
                .verifyComplete();

        verify(countryRepository).saveAll(countriesCaptor.capture());
        verify(regionRepository).saveAll(regionsCaptor.capture());
        verify(subRegionRepository).saveAll(subRegionsCaptor.capture());

        assertEquals(247, countriesCaptor.getValue().size());
        assertEquals(5, regionsCaptor.getValue().size());
        assertEquals(22, subRegionsCaptor.getValue().size());
    }
}
