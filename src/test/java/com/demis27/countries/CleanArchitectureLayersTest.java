package com.demis27.countries;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "com.demis27.countries", importOptions = {ImportOption.DoNotIncludeTests.class})
class CleanArchitectureLayersTest {

    @ArchTest
    static final ArchRule domain_should_not_depend_on_service_or_infra = ArchRuleDefinition
            .noClasses()
            .that()
            .resideInAPackage("..domain..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..business..", "..infrastructure..");
}
