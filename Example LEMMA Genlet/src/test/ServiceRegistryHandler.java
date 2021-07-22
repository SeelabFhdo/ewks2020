package org.example.eureka_service_registry_genlet.handlers.aspects;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType;
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic;
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.UtilKt;
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler;
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI;
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.EObjectNodeCombinations;
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice;
import org.eclipse.emf.ecore.EObject;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

@AspectHandler
public class ServiceRegistryHandler implements AspectHandlerI {
    @NotNull
    @Override
    public Set<String> handlesAspects() {
        Set<String> aspects = new HashSet<>();
        aspects.add("eureka.EnableEurekaClient");
        return aspects;
    }

    @NotNull
    @Override
    public EObjectNodeCombinations handlesEObjectNodeCombinations() {
        EObjectNodeCombinations combinations = new EObjectNodeCombinations();
        combinations.with(IntermediateMicroservice.class, ClassOrInterfaceDeclaration.class);
        return combinations;
    }

    @NotNull
    @Override
    public Node execute(@NotNull EObject eObject, @NotNull Node node, @NotNull IntermediateImportedAspect aspect) {
        ClassOrInterfaceDeclaration clazz = (ClassOrInterfaceDeclaration) node;
        UtilKt.addImport(clazz, "org.springframework.cloud.netflix.eureka.EnableEurekaClient",
            ImportTargetElementType.ANNOTATION, new SerializationCharacteristic[]{}, true);
        UtilKt.addAnnotation(clazz, "EnableEurekaClient");
        UtilKt.addDependency(clazz, "org.springframework.cloud:spring-cloud-starter-netflix-eureka-client");
        return clazz;
    }
}
