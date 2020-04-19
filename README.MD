# Synopsis

When using org.apache.wicket.markup.html.media.video.Video it can happen that a
NotSerializableException is thrown.

The problem exists at least since 12/2017:
https://stackoverflow.com/questions/47700614/error-serializing-object-in-wicket

I have tested the code with Wicket 8.2.0, 8.7.0 and 9.0.0-M5

# The Exception

```
[Wicket-AsyncPageStore-PageSavingThread] ERROR org.apache.wicket.serialize.java.JavaSerializer - Error serializing object class com.wicket.video.demo.IndexPage [object=[Page class = com.wicket.video.demo.IndexPage, id = 0, render count = 1]]
org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream$ObjectCheckException: The object type is not Serializable!
A problem occurred while checking object with type: sun.nio.fs.UnixPath
Field hierarchy is:
  0 [class=com.wicket.video.demo.IndexPage, path=0]
    private java.lang.Object org.apache.wicket.MarkupContainer.children [class=java.util.ArrayList]
      private java.lang.Object org.apache.wicket.MarkupContainer.children[write:1] [class=com.wicket.video.demo.VideoCard, path=0:videoCard]
        private java.lang.Object org.apache.wicket.MarkupContainer.children [class=java.util.ArrayList]
          private java.lang.Object org.apache.wicket.MarkupContainer.children[write:1] [class=org.apache.wicket.markup.html.WebMarkupContainer, path=0:videoCard:wmc]
            private java.lang.Object org.apache.wicket.MarkupContainer.children [class=org.apache.wicket.markup.html.media.video.Video, path=0:videoCard:wmc:video]
              private final org.apache.wicket.request.resource.ResourceReference org.apache.wicket.markup.html.media.MediaComponent.resourceReference [class=org.apache.wicket.resource.FileSystemResourceReference]
                private java.nio.file.Path org.apache.wicket.resource.FileSystemResourceReference.path [class=sun.nio.fs.UnixPath] <----- field that is causing the problem
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.internalCheck(CheckingObjectOutputStream.java:371)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.check(CheckingObjectOutputStream.java:354)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.checkFields(CheckingObjectOutputStream.java:607)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.internalCheck(CheckingObjectOutputStream.java:545)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.check(CheckingObjectOutputStream.java:354)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.checkFields(CheckingObjectOutputStream.java:607)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.internalCheck(CheckingObjectOutputStream.java:545)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.check(CheckingObjectOutputStream.java:354)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.checkFields(CheckingObjectOutputStream.java:607)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.internalCheck(CheckingObjectOutputStream.java:545)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.check(CheckingObjectOutputStream.java:354)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream$1InterceptingObjectOutputStream.replaceObject(CheckingObjectOutputStream.java:501)
	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1145)
	at java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:349)
	at java.base/java.util.ArrayList.writeObject(ArrayList.java:896)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at java.base/java.io.ObjectStreamClass.invokeWriteObject(ObjectStreamClass.java:1130)
	at java.base/java.io.ObjectOutputStream.writeSerialData(ObjectOutputStream.java:1497)
	at java.base/java.io.ObjectOutputStream.writeOrdinaryObject(ObjectOutputStream.java:1433)
	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1179)
	at java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:349)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.internalCheck(CheckingObjectOutputStream.java:509)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.check(CheckingObjectOutputStream.java:354)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.checkFields(CheckingObjectOutputStream.java:607)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.internalCheck(CheckingObjectOutputStream.java:545)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.check(CheckingObjectOutputStream.java:354)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream$1InterceptingObjectOutputStream.replaceObject(CheckingObjectOutputStream.java:501)
	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1145)
	at java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:349)
	at java.base/java.util.ArrayList.writeObject(ArrayList.java:896)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at java.base/java.io.ObjectStreamClass.invokeWriteObject(ObjectStreamClass.java:1130)
	at java.base/java.io.ObjectOutputStream.writeSerialData(ObjectOutputStream.java:1497)
	at java.base/java.io.ObjectOutputStream.writeOrdinaryObject(ObjectOutputStream.java:1433)
	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1179)
	at java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:349)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.internalCheck(CheckingObjectOutputStream.java:509)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.check(CheckingObjectOutputStream.java:354)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.checkFields(CheckingObjectOutputStream.java:607)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.internalCheck(CheckingObjectOutputStream.java:545)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.check(CheckingObjectOutputStream.java:354)
	at org.apache.wicket.core.util.objects.checker.CheckingObjectOutputStream.writeObjectOverride(CheckingObjectOutputStream.java:711)
	at java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:345)
	at org.apache.wicket.serialize.java.JavaSerializer$SerializationCheckerObjectOutputStream.writeObjectOverride(JavaSerializer.java:382)
	at java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:345)
	at org.apache.wicket.serialize.java.JavaSerializer.serialize(JavaSerializer.java:83)
	at org.apache.wicket.pageStore.SerializingPageStore.addPage(SerializingPageStore.java:80)
	at org.apache.wicket.pageStore.AsynchronousPageStore$PageAddingRunnable.run(AsynchronousPageStore.java:278)
	at java.base/java.lang.Thread.run(Thread.java:834)
Caused by: java.io.NotSerializableException: sun.nio.fs.UnixPath
	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1185)
	at java.base/java.io.ObjectOutputStream.defaultWriteFields(ObjectOutputStream.java:1553)
	at java.base/java.io.ObjectOutputStream.writeSerialData(ObjectOutputStream.java:1510)
	at java.base/java.io.ObjectOutputStream.writeOrdinaryObject(ObjectOutputStream.java:1433)
	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1179)
	at java.base/java.io.ObjectOutputStream.defaultWriteFields(ObjectOutputStream.java:1553)
	at java.base/java.io.ObjectOutputStream.writeSerialData(ObjectOutputStream.java:1510)
	at java.base/java.io.ObjectOutputStream.writeOrdinaryObject(ObjectOutputStream.java:1433)
	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1179)
	at java.base/java.io.ObjectOutputStream.defaultWriteFields(ObjectOutputStream.java:1553)
	at java.base/java.io.ObjectOutputStream.writeSerialData(ObjectOutputStream.java:1510)
	at java.base/java.io.ObjectOutputStream.writeOrdinaryObject(ObjectOutputStream.java:1433)
	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1179)
	at java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:349)
	at java.base/java.util.ArrayList.writeObject(ArrayList.java:896)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at java.base/java.io.ObjectStreamClass.invokeWriteObject(ObjectStreamClass.java:1130)
	at java.base/java.io.ObjectOutputStream.writeSerialData(ObjectOutputStream.java:1497)
	at java.base/java.io.ObjectOutputStream.writeOrdinaryObject(ObjectOutputStream.java:1433)
	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1179)
	at java.base/java.io.ObjectOutputStream.defaultWriteFields(ObjectOutputStream.java:1553)
	at java.base/java.io.ObjectOutputStream.writeSerialData(ObjectOutputStream.java:1510)
	at java.base/java.io.ObjectOutputStream.writeOrdinaryObject(ObjectOutputStream.java:1433)
	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1179)
	at java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:349)
	at java.base/java.util.ArrayList.writeObject(ArrayList.java:896)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at java.base/java.io.ObjectStreamClass.invokeWriteObject(ObjectStreamClass.java:1130)
	at java.base/java.io.ObjectOutputStream.writeSerialData(ObjectOutputStream.java:1497)
	at java.base/java.io.ObjectOutputStream.writeOrdinaryObject(ObjectOutputStream.java:1433)
	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1179)
	at java.base/java.io.ObjectOutputStream.defaultWriteFields(ObjectOutputStream.java:1553)
	at java.base/java.io.ObjectOutputStream.writeSerialData(ObjectOutputStream.java:1510)
	at java.base/java.io.ObjectOutputStream.writeOrdinaryObject(ObjectOutputStream.java:1433)
	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1179)
	at java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:349)
	at org.apache.wicket.serialize.java.JavaSerializer$SerializationCheckerObjectOutputStream.writeObjectOverride(JavaSerializer.java:371)
	... 5 more
```


# Demonstration code

To reproduce the exception you need to do the following:

1. You need an MP4 video on your harddisc (download one e.g. from http://techslides.com/demos/sample-videos/small.mp4)
2. Change the path to the MP4 file in VideoCard#onInitialize()
3. Compile project
4. Run DemoServer#main() to start a Jetty
5. Open http://localhost:1024/
6. See the exception in the log


# What is the cause?

There is only the video and an AjaxLink added to the page. If the AjaxLink
is removed, the exception won't occur. I also tried it with other links and
they all trigger the exception. The onClick method can be completely empty just
the mere presence of the link is sufficient.

I have no clue why this effects the serialization code. 