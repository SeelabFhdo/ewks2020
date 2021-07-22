package org.example.lemma_model_processor;

import de.fhdo.lemma.model_processing.annotations.LanguageDescriptionProvider;
import de.fhdo.lemma.model_processing.languages.LanguageDescription;
import de.fhdo.lemma.model_processing.languages.LanguageDescriptionProviderI;

@LanguageDescriptionProvider
public class Languages implements LanguageDescriptionProviderI {
    static final String INTERMEDIATE_DATA_URI
        = de.fhdo.lemma.data.intermediate.IntermediatePackage.eNS_URI;
    static final LanguageDescription INTERMEDIATE_DATA_LANGUAGE_DESCRIPTION
        = new LanguageDescription(de.fhdo.lemma.data.intermediate.IntermediatePackage.eINSTANCE);

    static final String INTERMEDIATE_SERVICE_URI
            = de.fhdo.lemma.service.intermediate.IntermediatePackage.eNS_URI;
    static final LanguageDescription INTERMEDIATE_SERVICE_LANGUAGE_DESCRIPTION
            = new LanguageDescription(
                de.fhdo.lemma.service.intermediate.IntermediatePackage.eINSTANCE
            );

    @Override
    public LanguageDescription getLanguageDescription(String forLanguageNamespace) {
        switch(forLanguageNamespace) {
            case INTERMEDIATE_DATA_URI:
                return INTERMEDIATE_DATA_LANGUAGE_DESCRIPTION;
            case INTERMEDIATE_SERVICE_URI:
                return INTERMEDIATE_SERVICE_LANGUAGE_DESCRIPTION;
            default:
                return null;
        }
    }
}
