package org.example.eureka_service_registry_genlet;

import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.AbstractGenlet;
import org.jetbrains.annotations.NotNull;

public class EurekaServiceRegistryGenletGenerator extends AbstractGenlet {
    private static final String BASE_PACKAGE = "org.example.eureka_service_registry_genlet";

    public EurekaServiceRegistryGenletGenerator() {
        super(BASE_PACKAGE);
    }

    @NotNull
    @Override
    public String nameOfCodeGenerationHandlerPackage() {
        return BASE_PACKAGE + ".handlers";
    }

    @NotNull
    @Override
    public String nameOfAspectHandlerPackage() {
        return BASE_PACKAGE + ".handlers.aspects";
    }

    @NotNull
    @Override
    public String nameOfDependencyFragmentProviderPackage() {
        return BASE_PACKAGE + ".handlers.dependencies";
    }
}
