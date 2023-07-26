package sky.coding.loader.modules;

import sky.coding.loader.interfaces.Module;
import sky.coding.loader.config.SkyCodingConfig;

public class AntiFuck implements Module {
    public String name() {return "AntiFuck";}
    public boolean toggled() {return SkyCodingConfig.antifuck;}
    }
