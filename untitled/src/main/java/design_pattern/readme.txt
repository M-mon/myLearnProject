参考：http://c.biancheng.net/design_pattern/


JAVA 23种经典设计模式
单例（Singleton）模式：某个类只能生成一个实例，该类提供了一个全局访问点供外部获取该实例，其拓展是有限多例模式。
原型（Prototype）模式：将一个对象作为原型，通过对其进行复制而克隆出多个和原型类似的新实例。
工厂方法（Factory Method）模式：定义一个用于创建产品的接口，由子类决定生产什么产品。
抽象工厂（AbstractFactory）模式：提供一个创建产品族的接口，其每个子类可以生产一系列相关的产品。
建造者（Builder）模式：将一个复杂对象分解成多个相对简单的部分，然后根据不同需要分别创建它们，最后构建成该复杂对象。
代理（Proxy）模式：为某对象提供一种代理以控制对该对象的访问。即客户端通过代理间接地访问该对象，从而限制、增强或修改该对象的一些特性。
适配器（Adapter）模式：将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。
桥接（Bridge）模式：将抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。
装饰（Decorator）模式：动态的给对象增加一些职责，即增加其额外的功能。
外观（Facade）模式：为多个复杂的子系统提供一个一致的接口，使这些子系统更加容易被访问。
享元（Flyweight）模式：运用共享技术来有效地支持大量细粒度对象的复用。
组合（Composite）模式：将对象组合成树状层次结构，使用户对单个对象和组合对象具有一致的访问性。
模板方法（TemplateMethod）模式：定义一个操作中的算法骨架，而将算法的一些步骤延迟到子类中，使得子类可以不改变该算法结构的情况下重定义该算法的某些特定步骤。
策略（Strategy）模式：定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的改变不会影响使用算法的客户。
命令（Command）模式：将一个请求封装为一个对象，使发出请求的责任和执行请求的责任分割开。
职责链（Chain of Responsibility）模式：把请求从链中的一个对象传到下一个对象，直到请求被响应为止。通过这种方式去除对象之间的耦合。
状态（State）模式：允许一个对象在其内部状态发生改变时改变其行为能力。
观察者（Observer）模式：多个对象间存在一对多关系，当一个对象发生改变时，把这种改变通知给其他多个对象，从而影响其他对象的行为。
中介者（Mediator）模式：定义一个中介对象来简化原有对象之间的交互关系，降低系统中对象间的耦合度，使原有对象之间不必相互了解。
迭代器（Iterator）模式：提供一种方法来顺序访问聚合对象中的一系列数据，而不暴露聚合对象的内部表示。
访问者（Visitor）模式：在不改变集合元素的前提下，为一个集合中的每个元素提供多种访问方式，即每个元素有多个访问者对象访问。
备忘录（Memento）模式：在不破坏封装性的前提下，获取并保存一个对象的内部状态，以便以后恢复它。
解释器（Interpreter）模式：提供如何定义语言的文法，以及对语言句子的解释方法，即解释器。


+-------------+-------------+---------------+-----------------+
| 范围/目的    | 创建型模式  | 结构型模式    |  行为型模式      |
+-------------+-------------+---------------+-----------------+
| 类模式       | 工厂方法    | (类）适配器   | 模板方法、解释器 |
+-------------+-------------+---------------+-----------------+
|             | 单例        |   代理        |     策略        |
|             | 原型         | (对象）适配器 |     命令        |
|             | 抽象工厂     | 桥接          |  职责链         |
|             | 建造者       | 装饰          |  状态           |
|   对象模式  |              | 外观          |  观察者         |
|             |             | 享元          |  中介者         |
|             |             | 组合          |  迭代器         |
|             |             |               |    访问者       |
|             |             |               |  备忘录         |
+-------------+-------------+---------------+-----------------+

创建型模式的主要关注点是“怎样创建对象？”。
它的主要特点是“将对象的创建与使用分离”。
这样可以降低系统的耦合度，使用者不需要关注对象的创建细节，对象的创建由相关的工厂来完成。
就像我们去商场购买商品时，不需要知道商品是怎么生产出来一样，因为它们由专门的厂商生产。


结构型模式描述如何将类或对象按某种布局组成更大的结构。
它分为类结构型模式和对象结构型模式，前者采用继承机制来组织接口和类，后者釆用组合或聚合来组合对象。
由于组合关系或聚合关系比继承关系耦合度低，满足“合成复用原则”，所以对象结构型模式比类结构型模式具有更大的灵活性。



小记：值传递、重新封装、统合者


个人总结：
当前23种设计模式离不开一个理念和三种做法。
一个理念：抽象化。
    抽象，在java中就是接口、抽象类、父类，即多态，其好处就是可以用最抽象的类去获取更多的类。
    设计模式的作用，实际上就是提高系统的可用性、可扩展性和代码的易维护性。
    抽象的实现是提升最明显的做法，正如上述所说，可以用最抽象的类去获取更多的类；
    这意味着，只要子类或实现类满足抽象类的定义，整个系统就应该是正常运作；
    整个系统的可用性、可扩展性不仅得到确保，而且代码的书写就有了范例，维护也方便跟踪问题所在了（尽管查找子类、实现类比较麻烦，但是问题的出现范围就被局限了）。

三种做法：重复利用、行为重新封装、统一管理。

重复利用：这是最简单易懂的，单例、原型、工厂、抽象工厂等都是重复使用一个具体对象；
        享元也是重复利用，状态和策略也可以看待成重复利用一个对象去判断和变化，只是这个对象本身是有一定变化的。

行为重新封装：这是设计模式中最容易出现的，简单看，就是在某类的方法前后进行再处理，可以说就是aop思想。
    代理、建造者等，都是把需要的类的方法进行加工和包装，就像是白糖变冰糖，本质上还是糖，但是更大块更聚合。

统一管理：数据（对象也是数据）的流动理论上是自由的，但是我们对数据流动的理想是，一个方法能随时获取需要的数据，不需要的数据不获取。
    为了管理数据，大多的设计模式都有一个统筹者，其要做的事情就只有存储数据和传递数据。
    感觉上就像是一个流水线工厂，原材料的传递是设定好的，这个设定就是由统筹者负责，但是原材料是否有瑕疵，对产品的最终影响等事，统筹者是不会关心的，其只关心原材料类型。
    例如：观察者模式中的发布者，获取到的数据，可以过滤后传递给订阅者（观察者），也可以直接传递，但观察者的行为，发布者不会关心；
    还有，访问者模式中的对象结构角色，其保存元素内容，传递给特定的访问者。

记住这几个特点，个人觉得就算不会设计模式，多多少少都能写出比较好的代码。
