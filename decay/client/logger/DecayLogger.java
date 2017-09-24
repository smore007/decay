package decay.client.logger;

import decay.client.Decay;

public class DecayLogger {

    public static final DecayLogger INSTANCE = new DecayLogger();

    public void init(){
        print("=========================");
        print(Decay.INSTANCE.name + " HACKED CLIENT " + Decay.INSTANCE.version);
        print("      by " + Decay.INSTANCE.author);
        print("=========================");
    }

    public void print(String text){
        System.out.println("[DECAY] " + text);
    }
}
