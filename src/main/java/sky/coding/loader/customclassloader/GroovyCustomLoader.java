package sky.coding.loader.customclassloader;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class GroovyCustomLoader extends ClassLoader {
    public void GroovyParseClass(String path, String method) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        Class<?> groovyClass = groovyClassLoader.parseClass(new File(path));
        GroovyObject groovyObject = (GroovyObject) groovyClass.getDeclaredConstructor().newInstance();
        groovyObject.invokeMethod(method, null);
    }
}

