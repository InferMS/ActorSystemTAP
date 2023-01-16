package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import actors.ActorProxy;
import extra.AddInsultMessage;
import extra.GetAllInsultsMessage;
import extra.GetInsultMessage;
import extra.Message;

public class DynamicProxy implements InvocationHandler {

    private Object target;
    private ActorProxy actor;

    public static Object intercept(Object target, ActorProxy actor) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new DynamicProxy(target, actor));
    }

    private DynamicProxy(Object target, ActorProxy actor) {
        this.target=target;
        this.actor=actor;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invocationResult = null;
        Message mensaje = null;
        if (method.getName().equalsIgnoreCase("addinsult")) {
            mensaje = new AddInsultMessage(actor, (String) args[0]);

        }
        else if(method.getName().equalsIgnoreCase("getinsult")) {
            mensaje = new GetInsultMessage(actor, null);
        }
        else if(method.getName().equalsIgnoreCase("getallinsults")) {
            mensaje = new GetAllInsultsMessage(actor, null);
        }
        actor.send(mensaje);
        invocationResult = method.invoke(this.target, args);
        return invocationResult;

    }

}

