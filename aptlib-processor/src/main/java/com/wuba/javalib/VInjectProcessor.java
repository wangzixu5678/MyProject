package com.wuba.javalib;

import com.google.auto.service.AutoService;
import com.wuba.aptlib_anno.VInjector;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;


@AutoService(Processor.class)
public class VInjectProcessor extends AbstractProcessor {

    private Filer mFiler;
    private Messager mMessager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        //初始化我们需要的基础工具
        mFiler = processingEnv.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

        // 遍历所有注解元素
        for (Element annotatedElement : roundEnvironment.getElementsAnnotatedWith(VInjector.class)) {
            analysisAnnotated(annotatedElement);
        }
        return false;
    }


    private static final String SUFFIX = "AutoClass";

    /**
     * 生成java文件
     *
     * @param classElement 注解
     */
    private void analysisAnnotated(Element classElement) {
        VInjector annotation = classElement.getAnnotation(VInjector.class);
        int id = annotation.id();
        String name = annotation.name();
        String text = annotation.text();
        String newClassName = name + SUFFIX;

        StringBuilder builder = new StringBuilder()
                .append("package com.duodian.myapplication.auto;\n\n")
                .append("public class ")
                .append(newClassName)
                .append(" {\n\n") // open class
                .append("\tpublic String getMessage() {\n") // open method
                .append("\t\treturn \"");

        // this is appending to the return statement
        builder.append(id).append(text).append(newClassName).append(" !\\n");


        builder.append("\";\n") // end returne
                .append("\t}\n") // close method
                .append("}\n"); // close class


        try { // write the file
            JavaFileObject source = mFiler.createSourceFile("com.duodian.myapplication.auto." + newClassName);
            Writer writer = source.openWriter();
            writer.write(builder.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // Note: calling e.printStackTrace() will print IO errors
            // that occur from the file already existing after its first run, this is normal
        }

    }


}

