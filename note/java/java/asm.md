### 为什么要学ASM



### 目的

● 程序分析，既可能只是简单的语法分析(syntaxic parsing)，也可能是完整的语义分析 (sematic analysis)，可用于查找应用程序中的潜在 bug、检测未被用到的代码、对代码 实施逆向工程，等等。 
 						
● 程序生成，在编译器中使用。这些编译器不仅包括传统编译器，还包括用于分布式程序 设计的 stub 编译器或 skeleton 编译器，以及 JIT(即时)编译器，等等。 
 						
● 程序转换可，用于优化或混淆(obfuscate)程序、向应用程序中插入调试或性能监视代 码，用于面向方面的程序设计，等等。 
###  ASM能够做什么
从应用的角度来说，Java ASM可以进行Class Generation、Class Transformation和Class Analysis三个类型的操作。

```text
                                   ┌─── find potential bugs
                                   │
            ┌─── analysis ─────────┼─── detect unused code
            │                      │
            │                      └─── reverse engineer code
            │
Java ASM ───┼─── generation
            │
            │                      ┌─── optimize programs
            │                      │
            └─── transformation ───┼─── obfuscate programs
                                   │
                                   └─── insert performance monitoring code
```


### 优点
这个库的设计使其尽可能保持快速和小型化。对于那些在运行时使用 ASM 进行动态 类生成或转换的应用程序来说，尽可能􏰀高库的运行速度是非常重要的，这样可以保证这些应用 程序的速度不致下降过多。
与其它的操作Java字节码的类库相比，ASM有哪些与众不同的地方呢？
在实现相同的功能前提下，使用ASM，运行速度更快（运行时间短，属于“时间维度”），占用的内存空间更小（内存空间，属于“空间维度”）。



### 常见项目中哪里用到了ASM
举例
● spring aop -> cglib -> asm
● JDK -> lambda 表达式 (jdk 1.8 lamda表达式实现原理是使用asm)




### ASM 库包结构

ASM分两个核心部分
核心API及树
 核心API 即asm、asm-util 和 asm-commons 文件。
 树API，即 asm-tree 和 asm-analysis


```text
                                   ┌─── asm.jar
                                   │
            ┌─── Core API ─────────┼─── asm-util.jar
            │                      │
            │                      └─── asm-commons.jar
Java ASM ───┤
            │
            │                      ┌─── asm-tree.jar
            └─── Tree API ─────────┤
                                   └─── asm-analysis.jar
```

ASM与classfile

- java -> javac -> .class


```
ClassFile {
    u4             magic;
    u2             minor_version;
    u2             major_version;
    u2             constant_pool_count;
    cp_info        constant_pool[constant_pool_count-1];
    u2             access_flags;
    u2             this_class;
    u2             super_class;
    u2             interfaces_count;
    u2             interfaces[interfaces_count];
    u2             fields_count;
    field_info     fields[fields_count];
    u2             methods_count;
    method_info    methods[methods_count];
    u2             attributes_count;
    attribute_info attributes[attributes_count];
}
```


● org.objectweb.asm 和 org.objectweb.asm.signature 包定义了基于事件的API，并􏰀供了类分析器和写入器组件。它们包含在 asm.jar 存档文件中。
● org.objectweb.asm.util 包，位于 asm-util.jar 存档文件中，􏰀供各种基于 核心 API 的工具，可以在开发和调试 ASM 应用程序时使用
● org.objectweb.asm.commons 包􏰀供了几个很有用的预定义类转换器，它们大多 是基于核心 API 的。这个包包含在 asm-commons.jar 存档文件中。
● org.objectweb.asm.tree 包，位于 asm-tree.jar 存档文件中，定义了基于对 象的 API，并􏰀供了一些工具，用于在基于事件和基于对象的表示方法之间进行转换。
● org.objectweb.asm.tree.analysis 包􏰀供了一个类分析框架和几个预定义的 类分析器，它们以树 API 为基础。这个包包含在 asm-analysis.jar 存档文件中。



下面用asm生成一个最简单的hello world
用gradle 生成

```
plugins {
    id 'java'
}

group 'com.testagetn'
version '1.0.0'

repositories {
    mavenCentral()
}

dependencies {
        implementation 'org.ow2.asm:asm:9.3'
    // https://mvnrepository.com/artifact/org.ow2.asm/asm-commons
    implementation 'org.ow2.asm:asm-commons:9.3'

    // https://mvnrepository.com/artifact/org.ow2.asm/asm-util
    implementation 'org.ow2.asm:asm-util:9.3'

    // https://mvnrepository.com/artifact/org.ow2.asm/asm-tree
    implementation 'org.ow2.asm:asm-tree:9.3'


// https://mvnrepository.com/artifact/org.ow2.asm/asm-analysis
    implementation 'org.ow2.asm:asm-analysis:9.3'


    implementation 'commons-io:commons-io:2.11.0'

}

test {
    useJUnitPlatform()
}

jar {
    from {
        configurations.runtimeClasspath.collect { it.isDirectory() ? it : zipTree(it) }
    }

    manifest {
        attributes("Premain-Class": "com.pg.agent.PreMain")
    }
}
```
ASMPrint
```

public class ASMPrint {
    public static void main(String[] args) throws IOException {
        // (1) 设置参数
        String className = "sample.HelloWorld";
        int parsingOptions = Cla***eader.SKIP_FRAMES | Cla***eader.SKIP_DEBUG;
        boolean asmCode = true;

        // (2) 打印结果
        Printer printer = asmCode ? new ASMifier() : new Textifier();
        PrintWriter printWriter = new PrintWriter(System.out, true);
        TraceClassVisitor traceClassVisitor = new TraceClassVisitor(null, printer, printWriter);
        new Cla***eader(className).accept(traceClassVisitor, parsingOptions);
    }
}

```


修改已有的代码

```
public class HelloWorld {
    public void test() {
        System.out.println("this is a test method.");
    }
}
```

在方法执行前加入一个打印
```
public class HelloWorld {
    public void test() {
        System.out.println("Method Enter...");
        System.out.println("this is a test method.");
    }
}
```

代码实现
```
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MethodEnterVisitor extends ClassVisitor {
    public MethodEnterVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
        if (mv != null && !"<init>".equals(name)) {
            mv = new MethodEnterAdapter(api, mv);
        }
        return mv;
    }

    private static class MethodEnterAdapter extends MethodVisitor {
        public MethodEnterAdapter(int api, MethodVisitor methodVisitor) {
            super(api, methodVisitor);
        }

        @Override
        public void visitCode() {
            // 首先，处理自己的代码逻辑
            super.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            super.visitLdcInsn("Method Enter...");
            super.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            // 其次，调用父类的方法实现
            super.visitCode();
        }
    }
}

```

转换类
```
String relative_path = "sample/HelloWorld.class";
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes1 = FileUtils.readBytes(filepath);

        //（1）构建Cla***eader
        Cla***eader cr = new Cla***eader(bytes1);

        //（2）构建ClassWriter
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

        //（3）串连ClassVisitor
        int api = Opcodes.ASM9;
        ClassVisitor cv = new MethodEnterVisitor(api, cw);

        //（4）结合Cla***eader和ClassVisitor
        int parsingOptions = Cla***eader.SKIP_DEBUG | Cla***eader.SKIP_FRAMES;
        cr.accept(cv, parsingOptions);

        //（5）生成byte[]
        byte[] bytes2 = cw.toByteArray();

        FileUtils.writeBytes(filepath, bytes2);

```