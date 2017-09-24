package decay.client.module;

import decay.client.event.IEventHandler;
import decay.client.logger.DecayLogger;
import decay.client.module.mods.ArrowDodger;
import decay.client.module.mods.Flight;

import java.util.ArrayList;

public class ModuleManager {

    public static ModuleManager INSTANCE = new ModuleManager();

    private ArrayList<Module> modules;

    public void init() {
        modules = new ArrayList<>();

        registerModule(new Flight(false));
        registerModule(new ArrowDodger(false));
    }

    public void registerModule(Module m){
        modules.add(m);
        m.onRegister();

        DecayLogger.INSTANCE.print("Registered module " + m.name);
    }

    public void unregisterModule(Module m){
        modules.remove(m);
        m.onUnregister();

        DecayLogger.INSTANCE.print("Unregistered module " + m.name);
    }

    /**
     * Getters
     */

    public ArrayList<Module> getModules() {
        return modules;
    }

    public Module getModule(Class m){
        for(Module m1 : modules){
            if(m1.getClass() == m)
                return m1;
        }
        DecayLogger.INSTANCE.print("Couldn't find module specified! (" + m.toString() + ")");
        return null;
}

    public Module getModule(String moduleName){
        for(Module m : modules){
            String cmName = m.getName();
            if(moduleName.equalsIgnoreCase(cmName))
                return m;
        }
        DecayLogger.INSTANCE.print("Couldn't find module specified! (" + moduleName + ")");
        return null;
    }
}
