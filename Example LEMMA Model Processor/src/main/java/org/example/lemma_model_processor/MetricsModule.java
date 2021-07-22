package org.example.lemma_model_processor;

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule;
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule;
import de.fhdo.lemma.model_processing.languages.LanguageDescription;
import de.fhdo.lemma.service.intermediate.IntermediateInterface;
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice;
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CodeGenerationModule(name = "metrics")
public class MetricsModule extends AbstractCodeGenerationModule {
    @Override
    public LanguageDescription getLanguageDescription() {
        return Languages.INTERMEDIATE_SERVICE_LANGUAGE_DESCRIPTION;
    }

    @NotNull
    @Override
    public Map<String, Pair<String, Charset>> execute(@NotNull String[] phaseArguments,
        @NotNull String[] moduleArguments) {
        String resultFileContents = "";
        IntermediateServiceModel serviceModel =
            (IntermediateServiceModel) getIntermediateModelResource().getContents().get(0);
        for (IntermediateMicroservice m : serviceModel.getMicroservices()) {
            int syncCount = 0;
            int asyncCount = 0;

            for (IntermediateInterface i : m.getInterfaces()) {
                List<String> paramTypes = i.getOperations()
                    .stream()
                    .map(o -> o.getParameters())
                    .flatMap(Collection::stream)
                    .map(p -> p.getCommunicationType())
                    .collect(Collectors.toList());

                if (paramTypes.isEmpty() ||
                    !paramTypes.stream().anyMatch(t -> t.equals("ASYNCHRONOUS")))
                    syncCount++;
                else if (!paramTypes.stream().anyMatch(t -> t.equals("SYNCHRONOUS")))
                    asyncCount++;
            }

            resultFileContents += String.format(
                "Interface count for microservice %s: %d\n" +
                "\tSynchronous interface count: %d\n" +
                "\tAsynchronous interface count: %d\n",
                m.getQualifiedName(), m.getInterfaces().size(), syncCount, asyncCount);
        }
        String resultFilePath = getTargetFolder() + File.separator + "results.txt";

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put(resultFilePath , resultFileContents);
        return withCharset(resultMap, "UTF-8");
    }
}
