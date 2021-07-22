package org.example.lemma_model_processor;

import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator;
import de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_validation.AbstractIntermediateDeclarativeValidator;
import de.fhdo.lemma.service.intermediate.IntermediateOperation;
import de.fhdo.lemma.service.intermediate.IntermediatePackage;
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel;
import org.eclipse.xtext.validation.Check;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@IntermediateModelValidator
public class Validator extends AbstractIntermediateDeclarativeValidator {
    @NotNull
    @Override
    public String getLanguageNamespace() {
        return Languages.INTERMEDIATE_SERVICE_URI;
    }

    @Check
    private void checkModelForInterfaces(IntermediateServiceModel serviceModel) {
        long interfaceCount = serviceModel.getMicroservices()
            .stream()
            .map(m -> m.getInterfaces())
            .mapToInt(List::size)
            .sum();

        if (interfaceCount == 0)
            warning("No interfaces found in model",
                IntermediatePackage.Literals.INTERMEDIATE_MICROSERVICE__INTERFACES);
    }
}
