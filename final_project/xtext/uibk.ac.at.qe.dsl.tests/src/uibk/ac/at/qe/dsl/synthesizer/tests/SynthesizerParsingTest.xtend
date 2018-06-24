/*
 * generated by Xtext 2.14.0
 */
package uibk.ac.at.qe.dsl.synthesizer.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import uibk.ac.at.qe.dsl.synthesizer.synthesizer.Top

@RunWith(XtextRunner)
@InjectWith(SynthesizerInjectorProvider)
class SynthesizerParsingTest {
	@Inject
	ParseHelper<Top> parseHelper
	
	@Test
	def void loadModel() {
		val result = parseHelper.parse('''
			Hello Xtext!
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
	}
}