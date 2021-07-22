package org.example.eureka_service_registry_genlet.handlers.dependencies;

import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.DependencyType;
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.DependencyFragmentProvider;
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.MavenDependencyFragmentProviderI;
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.dependencies.UtilKt;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.redundent.kotlin.xml.Node;

@DependencyFragmentProvider
public class FragmentProvider implements MavenDependencyFragmentProviderI {
    @NotNull
    @Override
    public Node provideFragmentFor(@NotNull Node node) {
        return UtilKt.elements(n -> {
            n.element("dependencyManagement", dependencyManagement -> {
                dependencyManagement.element("dependencies", dependencies -> {
                    dependencies.element("dependency", dependency -> {
                    dependency.element("groupId", "org.springframework.cloud");
                    dependency.element("artifactId", "spring-cloud-dependencies");
                    dependency.element("version", "Greenwich.SR6");
                    dependency.element("type", "pom");
                    dependency.element("scope", "import");
                    return Unit.INSTANCE;
                    });
                    return Unit.INSTANCE;
                });
                return Unit.INSTANCE;
            });
            return Unit.INSTANCE;
        });
    }

    @NotNull
    @Override
    public DependencyType dependencyType() {
        return DependencyType.MAVEN;
    }
}
