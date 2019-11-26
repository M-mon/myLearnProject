package design_pattern.command;

/**
 * @Description 命令模式的代码
 * @auther hasee
 * @create 2019-11-25 14:55
 */
public class CommandPattern {
    public static void main(String[] args) {
        Command cmd = new ConcreteCommand();
        Invoker ir = new Invoker(cmd);
        System.out.println("客户访问调用者的call()方法...");
        ir.call();
    }
}

//调用者
class Invoker {

    //保存命令对象，在该类调用这个对象，以实现命令行为。
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        System.out.println("调用者执行命令command...");
        command.execute();
    }
}

//抽象命令
interface Command {
    public abstract void execute();
}

//具体命令
class ConcreteCommand implements Command {

    //命令接收者
    private Receiver receiver;

    ConcreteCommand() {
        receiver = new Receiver();
    }

    //命令接收者接收到该命令，需要执行的行为
    public void execute() {
        receiver.action();
    }
}

//接收者
class Receiver {
    public void action() {
        System.out.println("接收者的action()方法被调用...");
    }
}