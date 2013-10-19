package com.guide.city;


import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.*;

public class Runner {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        Server server = new Server(port);

        String warDir = "target/city-guide-1.0-SNAPSHOT";

        WebAppContext context = new WebAppContext();
        context.setResourceBase(warDir);
        context.setDescriptor(warDir + "WEB-INF/web.xml");
        context.setConfigurations(new Configuration[] {
                new AnnotationConfiguration(), new WebXmlConfiguration(),
                new WebInfConfiguration(), new TagLibConfiguration(),
                new PlusConfiguration(), new MetaInfConfiguration(),
                new FragmentConfiguration(), new EnvConfiguration() });

        context.setContextPath("/");
        context.setParentLoaderPriority(true);
        server.setHandler(context);
        server.start();
        server.join();
    }
}
