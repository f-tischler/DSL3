/*
 * generated by Xtext 2.13.0
 */
package uibk.ac.at.qe.dsl.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import uibk.ac.at.qe.dsl.game.Description;
import uibk.ac.at.qe.dsl.game.Game;
import uibk.ac.at.qe.dsl.game.GamePackage;
import uibk.ac.at.qe.dsl.game.LevelDeclaration;
import uibk.ac.at.qe.dsl.game.LevelDefinition;
import uibk.ac.at.qe.dsl.game.Person;
import uibk.ac.at.qe.dsl.game.Scene;
import uibk.ac.at.qe.dsl.services.GameGrammarAccess;

@SuppressWarnings("all")
public class GameSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private GameGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == GamePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case GamePackage.DESCRIPTION:
				sequence_Description(context, (Description) semanticObject); 
				return; 
			case GamePackage.GAME:
				sequence_Game(context, (Game) semanticObject); 
				return; 
			case GamePackage.LEVEL_DECLARATION:
				sequence_LevelDeclaration(context, (LevelDeclaration) semanticObject); 
				return; 
			case GamePackage.LEVEL_DEFINITION:
				sequence_LevelDefinition(context, (LevelDefinition) semanticObject); 
				return; 
			case GamePackage.OBJECT:
				sequence_Object(context, (uibk.ac.at.qe.dsl.game.Object) semanticObject); 
				return; 
			case GamePackage.PERSON:
				sequence_Person(context, (Person) semanticObject); 
				return; 
			case GamePackage.SCENE:
				sequence_Scene(context, (Scene) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Description returns Description
	 *
	 * Constraint:
	 *     name=STRING
	 */
	protected void sequence_Description(ISerializationContext context, Description semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamePackage.Literals.DESCRIPTION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamePackage.Literals.DESCRIPTION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDescriptionAccess().getNameSTRINGTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Game returns Game
	 *
	 * Constraint:
	 *     scenes+=Scene+
	 */
	protected void sequence_Game(ISerializationContext context, Game semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LevelDeclaration returns LevelDeclaration
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_LevelDeclaration(ISerializationContext context, LevelDeclaration semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamePackage.Literals.LEVEL_DECLARATION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamePackage.Literals.LEVEL_DECLARATION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLevelDeclarationAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     LevelDefinition returns LevelDefinition
	 *
	 * Constraint:
	 *     (
	 *         name=[LevelDeclaration|ID] 
	 *         description=Description 
	 *         persons+=Person* 
	 *         objects+=Object* 
	 *         actions+=Action_GLOBAL* 
	 *         goal=ID 
	 *         next=[LevelDeclaration|ID]?
	 *     )
	 */
	protected void sequence_LevelDefinition(ISerializationContext context, LevelDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Object returns Object
	 *
	 * Constraint:
	 *     (name=ID type=ID position=STRING action=Action_O)
	 */
	protected void sequence_Object(ISerializationContext context, uibk.ac.at.qe.dsl.game.Object semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamePackage.Literals.OBJECT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamePackage.Literals.OBJECT__NAME));
			if (transientValues.isValueTransient(semanticObject, GamePackage.Literals.OBJECT__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamePackage.Literals.OBJECT__TYPE));
			if (transientValues.isValueTransient(semanticObject, GamePackage.Literals.OBJECT__POSITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamePackage.Literals.OBJECT__POSITION));
			if (transientValues.isValueTransient(semanticObject, GamePackage.Literals.OBJECT__ACTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamePackage.Literals.OBJECT__ACTION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getObjectAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getObjectAccess().getTypeIDTerminalRuleCall_5_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getObjectAccess().getPositionSTRINGTerminalRuleCall_9_0(), semanticObject.getPosition());
		feeder.accept(grammarAccess.getObjectAccess().getActionAction_OEnumRuleCall_13_0(), semanticObject.getAction());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Person returns Person
	 *
	 * Constraint:
	 *     (name=ID type=ID response=STRING position=STRING action=Action_P)
	 */
	protected void sequence_Person(ISerializationContext context, Person semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, GamePackage.Literals.PERSON__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamePackage.Literals.PERSON__NAME));
			if (transientValues.isValueTransient(semanticObject, GamePackage.Literals.PERSON__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamePackage.Literals.PERSON__TYPE));
			if (transientValues.isValueTransient(semanticObject, GamePackage.Literals.PERSON__RESPONSE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamePackage.Literals.PERSON__RESPONSE));
			if (transientValues.isValueTransient(semanticObject, GamePackage.Literals.PERSON__POSITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamePackage.Literals.PERSON__POSITION));
			if (transientValues.isValueTransient(semanticObject, GamePackage.Literals.PERSON__ACTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, GamePackage.Literals.PERSON__ACTION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPersonAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getPersonAccess().getTypeIDTerminalRuleCall_5_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getPersonAccess().getResponseSTRINGTerminalRuleCall_9_0(), semanticObject.getResponse());
		feeder.accept(grammarAccess.getPersonAccess().getPositionSTRINGTerminalRuleCall_13_0(), semanticObject.getPosition());
		feeder.accept(grammarAccess.getPersonAccess().getActionAction_PEnumRuleCall_17_0(), semanticObject.getAction());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Scene returns Scene
	 *
	 * Constraint:
	 *     (name=ID declartions+=LevelDeclaration* definitions+=LevelDefinition* startLevel=[LevelDeclaration|ID] finalLevel=[LevelDeclaration|ID])
	 */
	protected void sequence_Scene(ISerializationContext context, Scene semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
