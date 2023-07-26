package sky.coding.loader.modules;

import sky.coding.loader.config.SkyCodingConfig;
import sky.coding.loader.interfaces.Module;

public class AntiFuck implements Module {
    public String name() {return "AntiFuck";}
    public boolean toggled() {return SkyCodingConfig.antifuck;}
    }
