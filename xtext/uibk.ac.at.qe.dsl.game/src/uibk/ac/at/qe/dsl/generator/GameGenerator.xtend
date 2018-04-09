/*
 * generated by Xtext 2.13.0
 */
package uibk.ac.at.qe.dsl.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import uibk.ac.at.qe.dsl.game.Scene
import uibk.ac.at.qe.dsl.game.Person
import uibk.ac.at.qe.dsl.game.Action_P
import uibk.ac.at.qe.dsl.game.Action_O
import uibk.ac.at.qe.dsl.game.Action_GLOBAL
import uibk.ac.at.qe.dsl.game.LevelDefinition

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class GameGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		
		for (scene : resource.allContents.toIterable.filter(Scene)) {
			generateScene(resource, fsa, context, scene)
		}
	}
	
	def generateScene (Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context, Scene scene) {
		for (definition : scene.definitions) {
			fsa.generateFile(definition.name + '.java', generateFiles(resource, fsa, context, definition))
		}
	}
	
	def generateFiles(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context, LevelDefinition level) {
		return '''
		package test.textadventure;
		
		import com.company.*;
		
		import java.io.PrintStream;
		import java.util.LinkedList;
		import java.util.List;
		import java.util.stream.Collectors;
		
		�generateCommonPerson�
		
		�FOR person : level.persons�
			�IF person.action.equals(Action_P::TALK)�
				�generateActionTalk(person)�
			�ENDIF�
		�ENDFOR�
		
		�FOR object : level.objects�
			�IF object.action.equals(Action_O::PICK)�
			
			�ELSEIF object.action.equals(Action_O::USE)�
			
			�ENDIF�
		�ENDFOR�
		
		�FOR action : level.actions�
			�IF action.equals(Action_GLOBAL::LEAVE)�
				�generateActionLeave()�
			�ENDIF�
		�ENDFOR�
		
		�generateLevel(level)�
		'''
	}
	
	def generateActionTalk(Person person) {
		return '''
		class TalkTo�person.name�Action implements IAction
		{
		    private IPerson �person.name�;
		
		    TalkTo�person.name�Action(IPerson �person.name�) {
		        this.�person.name� = �person.name�;
		    }
		
		    @Override
		    public String getDescription() {
		        return String.format("Talk to %s", �person.name�.getName());
		    }
		
		    @Override
		    public void perform(IContext context) {
		        //String name = (String)context.getState().getData(Player.class.getName(), "name");
		        //ivan.say(context.getOut(), String.format("Hi %s, nice to see you!", name));
		       	�person.name�.say(context.getOut(), �person.response�);
		    }
		
		    @Override
		    public boolean isAvailable(IState state) {
		        return true;
		    }
		
		    public boolean isExplicitAction() {
		        return false;
		    }
		}
		'''
	}
	
	def generateActionLeave() {
		return '''
		class LeaveAction implements IAction
		{
		    @Override
		    public String getDescription() {
		        return "Leave";
		    }
		
		    @Override
		    public void perform(IContext context) {
		        //context.player().say(context.getOut(), "I gotta go, see you!");
		        context.getState().setGameState(GameState.Finished);
		    }
		
		    @Override
		    public boolean isAvailable(IState state) {
		        return true;
		    }
		
		    @Override
		    public boolean isExplicitAction() {
		        return true;
		    }
		}
		'''
	}
	
	def generateCommonPerson() {
		return '''
		class Person implements IPerson
		{
		
		    private String name;
		    private String position;
		
		    Person(String name, String position) {
		        this.name = name;
		        this.position = position;
		    }
		
		    @Override
		    public String getName() {
		        return name;
		    }
		
		    @Override
		    public String getPosition() {
		        return position;
		    }
		
		    @Override
		    public void say(PrintStream stream, String string) {
		        stream.println(String.format("%s: %s", getName(), string));
		    }
		
		    @Override
		    public void onDiscovered(IContext context) {
		
		    }
		}
		'''
	}
	
	def generateLevel (LevelDefinition level) {
		return '''
		public class �level.name� extends TextAdventureLevel {
		    private List<IAction> actions = new LinkedList<>();
		    private List<IPerson> persons = new LinkedList<>();
		
		    public void initialize(IContext context)
		    {
		    	�var i = 0�
		    	�FOR person : level.persons�
		    		 persons.add(new Person(�person.name�, "�person.position�"));
		    		 �IF person.action.equals(Action_P::TALK)�
		    		 	actions.add(new TalkTo�person.name�Action(persons.get(�i++�)));
		    		 �ENDIF�
		    	�ENDFOR�
		
				�FOR object : level.objects�
					
				�ENDFOR�
				
				�FOR action : level.actions�
					�IF action.equals(Action_GLOBAL::LEAVE)�
						actions.add(new LeaveAction());
					�ENDIF�
				�ENDFOR�
		        
		
		        super.initialize(context);
		    }
		
		    @Override
		    protected String getDescription(IContext context) {
		        return "�level.description�";
		    }
		
		    @Override
		    protected List<IPerson> getPersons(IContext context) {
		        return persons;
		    }
		
		    @Override
		    protected List<IAction> getAvailableActions(IContext context) {
		        return actions.stream().filter(a -> a.isAvailable(context.getState()))
		                .collect(Collectors.toList());
		    }
		    
		    �IF level.next !== null�
		    @Override
		        public String getNextLevel(IContext context) {
		            return �level.next�.class.getName();
		        }
		    �ENDIF�
		}
		'''
	}
}
