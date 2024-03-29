package test.textadventure;

import com.company.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class EnterNameAction implements IAction
{
    @Override
    public String getDescription() {
        return "Enter Name";
    }

    @Override
    public void perform(IContext context) {

        context.getOut().println("Daniel: So, who are you?");

        String name = "";
        while(name.trim().isEmpty())
        {
            context.getOut().print("You: ");

            try {
                name = context.getIn().readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(name.trim().isEmpty())
            {
                context.getOut().println("Daniel: ???");
            }
        }

        context.player().setName(name);
        context.getOut().println(String.format("Daniel: Alright %s, come right in", name));
    }

    @Override
    public boolean isAvailable(IContext context) {
        return context.player().getName() == null;
    }

    public boolean isExplicitAction() {
        return false;
    }
}

public class EnterName extends TextAdventureLevel {

    private List<IAction> actions = new LinkedList<>();

    public void initialize(IContext context)
    {
        super.initialize(context);

        actions.add(new EnterNameAction());
    }

    @Override
    protected List<IAction> getActions(IContext context) {
        return actions;
    }

    @Override
    public String getNextLevel(IContext context) {
        return FirstLevel.class.getName();
    }

    @Override
    protected String getDescription(IContext context) {
        return "in front of Daniel's House";
    }

    @Override
    protected List<IPerson> getPersons(IContext context) {
        return new LinkedList<>();
    }
}
