package org.example.lemma_model_processor;

import de.fhdo.lemma.model_processing.AbstractModelProcessor;

public class Processor extends AbstractModelProcessor {
    public static void main(String[] args) {
        new Processor().run(args);
    }

    public Processor() {
        super("org.example.lemma_model_processor");
    }
}
