package skycoding.dev.ultralight.opengl.js;

import com.labymedia.ultralight.UltralightView;
import com.labymedia.ultralight.databind.Databind;
import com.labymedia.ultralight.databind.DatabindConfiguration;
import com.labymedia.ultralight.javascript.JavascriptContext;
import com.labymedia.ultralight.javascript.JavascriptGlobalContext;
import com.labymedia.ultralight.javascript.JavascriptObject;
import org.apache.commons.io.FileUtils;
import skycoding.dev.ultralight.opengl.util.ViewContextProvider;

import java.io.File;
import java.util.Collection;
import java.util.List;

import static skycoding.dev.utils.ResourceManager.ultraLightDir;

public class JavaScriptBridge {
    private Databind databind;

    public JavaScriptBridge(UltralightView view) {

        databind = new Databind(DatabindConfiguration
                .builder()
                .contextProviderFactory(new ViewContextProvider.Factory(view))
                .build()
        );


    }

    public void setContext(Object object, String name, JavascriptContext context) {
        JavascriptGlobalContext globalContext = context.getGlobalContext();
        JavascriptObject globalObject = globalContext.getGlobalObject();
        globalObject.setProperty(name, databind.getConversionUtils().toJavascript(context, object), 0 );

    }
    public void print(String str) {
        System.out.println(str);
    }

    public static Collection<File> getPages() {
         Collection<File> libs = FileUtils.listFiles(new File(ultraLightDir+"/public/pages"),null,false);
        return libs;
    }

}
