/*
 * generated by Xtext 2.21.0
 */
package de.fhdo.ewks.ml_example.xtext.ui.tests;

import com.google.inject.Injector;
import de.fhdo.ewks.ml_example.xtext.ui.internal.XtextActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

public class StructureDslUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return XtextActivator.getInstance().getInjector("de.fhdo.ewks.ml_example.xtext.StructureDsl");
	}

}
